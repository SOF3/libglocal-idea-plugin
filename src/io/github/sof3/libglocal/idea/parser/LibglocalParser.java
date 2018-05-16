package io.github.sof3.libglocal.idea.parser;

import com.intellij.lang.ASTNode;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiParser;
import com.intellij.psi.tree.IElementType;
import io.github.sof3.libglocal.idea.psi.LibglocalTypes;
import io.github.sof3.libglocal.idea.util.StringStack;
import org.jetbrains.annotations.NotNull;

import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class LibglocalParser implements PsiParser, LibglocalTypes{
	private PsiBuilder builder;

	private Deque<PsiBuilder.Marker> markers = new LinkedList<>();

	private StringStack indentStack = new StringStack();

	@NotNull
	@Override
	public ASTNode parse(@NotNull IElementType root, @NotNull PsiBuilder builder){
		this.builder = builder;

		PsiBuilder.Marker mark = builder.mark();

		file_loop:
		while(!builder.eof()){
			while(current() == EOL){
				next();
				if(builder.eof()){
					break file_loop;
				}
			}
			readRootElement();
		}

		mark.done(root);

		return builder.getTreeBuilt();
	}


	private void readRootElement(){
		try{
			if(readLangDecl() || readAuthorList() || readVersionDecl() || readMessageTree()){
				return;
			}
		}catch(LineLocalException ex){
			while(!markers.isEmpty()){
				markers.removeLast().done(ERROR_ELEMENT);
			}
			advanceThroughEol();

			return;
		}

		errExpect("lang", "author", "version", "messages");
	}

	private boolean readLangDecl() throws LineLocalException{
		PsiBuilder.Marker langMarker;
		if(current() == BASE_KEYWORD){
			if(peekNext() != LANG_KEYWORD){
				return false;
			}

			langMarker = startMarker("base lang");
			next();
			next();
		}else{
			if(current() != LANG_KEYWORD){
				return false;
			}

			langMarker = startMarker("lang");
			next();
		}

		consumeCurrent(LANG_NAME);
		consumeCurrent(LANG_LOCAL);
		consumeCurrent(EOL);
		endMarker(langMarker, LANG_DECL);

		return true;
	}

	private boolean readAuthorList() throws LineLocalException{
		if(current() != AUTHOR_KEYWORD){
			return false;
		}

		PsiBuilder.Marker marker = startMarker("author");
		next();

		//noinspection StatementWithEmptyBody
		while(consumeCurrent(AUTHOR_NAME, AUTHOR_SEPARATOR, EOL) != EOL){
		}
		endMarker(marker, AUTHOR_LIST);

		return true;
	}

	private boolean readVersionDecl() throws LineLocalException{
		if(current() != VERSION_KEYWORD){
			return false;
		}

		PsiBuilder.Marker marker = startMarker("version");
		next();

		consumeCurrent(VERSION_VALUE);
		consumeEol();
		endMarker(marker, VERSION_DECL);
		return true;
	}

	private boolean readMessageTree() throws LineLocalException{
		if(current() != MESSAGES_KEYWORD){
			return false;
		}

		PsiBuilder.Marker messagesMarker = startMarker("messages");
		consumeCurrent(MESSAGES_KEYWORD);
		consumeEol();

		IElementType current;
		while((current = current()) == EOL || current == INDENT){
			if(current == EOL || peekNext() == EOL){
				next();
				continue;
			}

			tryReadMessage();
		}
		endMarker(messagesMarker, MESSAGE_TREE);
		return true;
	}

	private void readMessage() throws LineLocalException{
		String indentText = currentText();
		consumeCurrent(INDENT);

		if(current() == EOL){
			next();
			return;
		}
		String text = currentText();
		PsiBuilder.Marker marker = startMarker("message (group|entry): " + text);
		consumeCurrent(MESSAGE_ID);

		indentStack.fill(indentText);

		try{
			if(current() == EOL){
				// MESSAGE_GROUP
				next(); // skip EOL

				while(current() == INDENT && indentStack.isStrictlyPrefixOf(currentText())){
					tryReadMessage();
				}

				endMarker(marker, MESSAGE_GROUP, "messageGroup: " + text);
			}else{
				// MESSAGE_ENTRY
				readMessageValue(false); // EOL consumed

				while(true){
					if(current() == EOL){
						next();
						continue;
					}

					if(current() == INDENT && indentStack.isStrictlyPrefixOf(currentText())){
						String indent = currentText();
						next();
						if(readArgMod(indent) || readDocMod(indent) || readVersionMod(indent)){
							continue;
						}

						errExpect("arg", "doc", "since", "updated");
						continue;
					}
					break;
				}
				endMarker(marker, MESSAGE_ENTRY, "messageEntry: " + text);
			}
		}finally{
			indentStack.pop();
		}
	}

	private void tryReadMessage(){
		int markerStackSize = markers.size();
		try{
			readMessage();
		}catch(LineLocalException e){
			while(markers.size() > markerStackSize){
				markers.removeLast().done(ERROR_ELEMENT);
			}
			advanceThroughEol();
		}
	}

	private void readMessageValue(boolean stacked) throws LineLocalException{
		PsiBuilder.Marker marker = startMarker("messageValue");

		IElementType messageToken;
		while((messageToken = expectCurrent(EOL, LITERAL, ESCAPE, ESCAPE_ILLEGAL, DOLLAR_OPEN, PERCENT_OPEN, HASH_OPEN, PERCENT_CLOSE)) != EOL){
			if(messageToken == PERCENT_CLOSE){
				if(!stacked){
					throw new LineLocalException("Unexpected closing brace: not in a span");
					// TODO: probably parse it as a literal?
				}

				endMarker(marker, MESSAGE_VALUE);
				next();
				return;
			}

			if(messageToken == DOLLAR_OPEN){
				readArgRef();
			}else if(messageToken == PERCENT_OPEN){
				readSpan();
			}else if(messageToken == HASH_OPEN){
				readMessageRef();
			}else{
				assert messageToken == LITERAL || messageToken == ESCAPE || messageToken == ESCAPE_ILLEGAL;
				next();
			}
		}

		endMarker(marker, MESSAGE_VALUE);
	}

	private void readArgRef() throws LineLocalException{
		PsiBuilder.Marker argMarker = startMarker("argRef");
		next();
		consumeCurrent(ARG_NAME);
		consumeCurrent(DOLLAR_CLOSE);
		endMarker(argMarker, ARG_REF);
	}

	private void readSpan() throws LineLocalException{
		PsiBuilder.Marker spanMarker = startMarker("spanRef");
		next();
		IElementType spanType = consumeCurrent(SPAN_NAME, SPAN_STYLE);
		if(spanType == SPAN_STYLE){
			consumeCurrent(PERCENT_CLOSE);
			endMarker(spanMarker, STYLE_SPAN);
		}else{
			assert spanType == SPAN_NAME;
			readMessageValue(true); // PERCENT_CLOSE consumed
			endMarker(spanMarker, STACK_SPAN);
		}
	}

	private void readMessageRef() throws LineLocalException{
		PsiBuilder.Marker messageRefMarker = startMarker("messageRef");
		next();

		consumeCurrent(MESSAGE_ID);
		if(current() != HASH_CLOSE){
			PsiBuilder.Marker argListMarker = startMarker("messageRef.argList");
			while(current() != HASH_CLOSE){
				if(current() == ARGS_SEPARATOR){
					continue;
				}

				PsiBuilder.Marker argMarker = startMarker("messageRef.arg");
				consumeCurrent(ARG_NAME);
				consumeCurrent(ARG_EQUALS);
				readArgValue();
				endMarker(argMarker, MESSAGE_REF_ARG);
			}
			endMarker(argListMarker, MESSAGE_REF_ARGS);
		}
		consumeCurrent(HASH_CLOSE);

		endMarker(messageRefMarker, MESSAGE_REF);
	}

	private boolean readArgMod(@SuppressWarnings("unused") String indent) throws LineLocalException{
		if(current() != ARG_KEYWORD){
			return false;
		}

		PsiBuilder.Marker arg = startMarker("arg");
		next();
		consumeCurrent(ARG_NAME);

		IElementType current = expectCurrent(ARG_TYPE_MODIFIER, ARG_TYPE, ARG_EQUALS, EOL);

		PsiBuilder.Marker typeMarker = null;
		if(current == ARG_TYPE_MODIFIER){
			typeMarker = startMarker("modified argType");
			next();
			current = expectCurrent(ARG_TYPE);
		}
		if(current == ARG_TYPE){
			if(typeMarker == null){
				typeMarker = startMarker("argType");
			}
			next();
			endMarker(typeMarker, ARG_FULL_TYPE);
			current = expectCurrent(ARG_EQUALS, EOL);
		}

		if(current == ARG_EQUALS){
			PsiBuilder.Marker defaultMarker = startMarker("argDefault");
			next();
			readArgValue();
			endMarker(defaultMarker, ARG_DEFAULT);
		}

		consumeEol();

		endMarker(arg, ARG_MODIFIER);
		return true;
	}

	private void readArgValue() throws LineLocalException{
		PsiBuilder.Marker marker = startMarker("argValue " + current());
		IElementType valueType = consumeCurrent(OPEN_QUOTE, NUMBER_LITERAL, ARG_NAME);
		if(valueType == NUMBER_LITERAL || valueType == ARG_NAME){
			endMarker(marker, ARG_VALUE);
			return;
		}

		assert valueType == OPEN_QUOTE;
		//noinspection StatementWithEmptyBody
		while(consumeCurrent(LITERAL, ESCAPE, ESCAPE_ILLEGAL, CLOSE_QUOTE) != CLOSE_QUOTE){
		}
		endMarker(marker, ARG_VALUE);
	}

	private boolean readDocMod(@SuppressWarnings("unused") String indent) throws LineLocalException{
		if(current() != DOC_KEYWORD){
			return false;
		}

		PsiBuilder.Marker doc = startMarker("doc");
		next();
		consumeCurrent(DOC_VALUE);
		consumeEol();
		endMarker(doc, DOC_MODIFIER);
		return true;
	}

	private boolean readVersionMod(@SuppressWarnings("unused") String indent) throws LineLocalException{
		if(current() == SINCE_KEYWORD || current() == UPDATED_KEYWORD){
			boolean since = current() == SINCE_KEYWORD;
			PsiBuilder.Marker marker = startMarker(since ? "since" : "updated");
			next();
			consumeCurrent(VERSION_VALUE);
			consumeEol();
			endMarker(marker, since ? SINCE_MODIFIER : UPDATED_MODIFIER);
			return true;
		}

		return false;
	}


	private IElementType consumeCurrent(IElementType... types) throws LineLocalException{
		IElementType type = expectCurrent(types);
		next();
		return type;
	}

	private IElementType expectCurrent(IElementType... types) throws LineLocalException{
		IElementType current = current();
		for(IElementType type : types){
			if(type == current){
				return type;
			}
		}
		throw new LineLocalException(Stream.of(types).map(IElementType::toString).collect(Collectors.joining(", ")) + " expected, got " + current);
	}

	private void consumeEol() throws LineLocalException{
		if(current() != EOL){
			throw new LineLocalException("End of line expected, got " + current());
		}
		next();
	}

	private IElementType current(){
		return builder.getTokenType();
	}

	private String currentText(){
		return builder.getTokenText();
	}

	private void next(){
		builder.advanceLexer();

		while(builder.getTokenType() == WHITE_SPACE || builder.getTokenType() == LINE_COMMENT || builder.getTokenType() == BLOCK_COMMENT){
			builder.advanceLexer();
		}
	}

	private IElementType peekNext(){
		return peekNext(false);
	}

	private IElementType peekNext(boolean skipEol){
		IElementType result = null;
		for(int i = 1; result == null || result == WHITE_SPACE || (skipEol && result == EOL); ++i){
			result = builder.lookAhead(i);
		}

		return result;
	}

	private void errExpect(String... tokens){
		builder.error(String.join(", ", tokens) + " expected, got " + current());
		advanceThroughEol();
	}

	private void advanceThroughEol(){
		while(!builder.eof() && builder.getTokenType() != EOL){
			builder.advanceLexer();
		}
		if(current() == EOL){
			builder.advanceLexer();
		}
	}


	private PsiBuilder.Marker startMarker(@SuppressWarnings("unused") String debugName){
//		System.out.println("startMarker " + debugName);
		PsiBuilder.Marker marker = builder.mark();
		markers.addLast(marker);
		return marker;
	}

	private void endMarker(PsiBuilder.Marker marker, IElementType type){
		endMarker(marker, type, type.toString());
	}

	private void endMarker(PsiBuilder.Marker marker, IElementType type, String debugName){
//		System.out.println("endMarker   " + debugName);
		PsiBuilder.Marker pop = markers.pollLast();
		assert marker == pop : "Attempt to end " + debugName + " when the stack top is something else";
		marker.done(type);
	}

	private class LineLocalException extends Exception{
		public LineLocalException(String message){
			super();
			builder.error(message);
//			System.err.println("Constructed LineLocalException: " + message);
		}
	}
}
