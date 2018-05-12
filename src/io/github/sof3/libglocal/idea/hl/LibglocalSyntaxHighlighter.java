package io.github.sof3.libglocal.idea.hl;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import io.github.sof3.libglocal.idea.LibglocalFlexAdapter;
import io.github.sof3.libglocal.idea.LibglocalTokens;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.DefaultLanguageHighlighterColors.*;
import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class LibglocalSyntaxHighlighter extends SyntaxHighlighterBase implements LibglocalTokens{
	public final static TextAttributesKey ATT_LINE_COMMENT = createTextAttributesKey("LIBGLOCAL_LINE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
	public final static TextAttributesKey ATT_BLOCK_COMMENT = createTextAttributesKey("LIBGLOCAL_BLOCK_COMMENT", DefaultLanguageHighlighterColors.BLOCK_COMMENT);
	public final static TextAttributesKey ATT_DOC_VALUE = createTextAttributesKey("LIBGLOCAL_BLOCK_COMMENT", DOC_COMMENT);
	public final static TextAttributesKey ATT_KEYWORD = createTextAttributesKey("LIBGLOCAL_KEYWORD", KEYWORD);
	public final static TextAttributesKey ATT_ARG_TYPE = createTextAttributesKey("LIBGLOCAL_ARG_NAME", CLASS_REFERENCE);
	public final static TextAttributesKey ATT_LANG_NAME = createTextAttributesKey("LIBGLOCAL_LANG_NAME", MARKUP_ATTRIBUTE);
	public final static TextAttributesKey ATT_MESSAGE_ID = createTextAttributesKey("LIBGLOCAL_MESSAGE_ID", MARKUP_ATTRIBUTE);
	public final static TextAttributesKey ATT_ARG_NAME = createTextAttributesKey("LIBGLOCAL_ARG_NAME", LOCAL_VARIABLE);
	public final static TextAttributesKey ATT_LITERAL = createTextAttributesKey("LIBGLOCAL_STRING_LITERAL", STRING);
	public final static TextAttributesKey ATT_LANG_LOCAL = createTextAttributesKey("LIBGLOCAL_LANG_LOCAL", ATT_LITERAL);
	public final static TextAttributesKey ATT_NUMBER_LITERAL = createTextAttributesKey("LIBGLOCAL_NUMBER_LITERAL", NUMBER);
	public final static TextAttributesKey ATT_VERSION_VALUE = createTextAttributesKey("LIBGLOCAL_VERSION_VALUE", NUMBER);
	public final static TextAttributesKey ATT_LITERAL_ESCAPE = createTextAttributesKey("LIBGLOCAL_STRING_LITERAL_ESCAPE", VALID_STRING_ESCAPE);
	public final static TextAttributesKey ATT_SPAN_NAME = createTextAttributesKey("LIBGLOCAL_SPAN_NAME", CONSTANT);
	public final static TextAttributesKey ATT_DOLLAR_BRACES = createTextAttributesKey("LIBGLOCAL_DOLLAR_BRACES", BRACES);
	public final static TextAttributesKey ATT_HASH_BRACES = createTextAttributesKey("LIBGLOCAL_HASH_BRACES", BRACES);
	public final static TextAttributesKey ATT_PERCENT_BRACES = createTextAttributesKey("LIBGLOCAL_PERCENT_BRACES", BRACES);
	public final static TextAttributesKey ATT_PARENTHESES = createTextAttributesKey("LIBGLOCAL_PARENTHESES", PARENTHESES);
	public final static TextAttributesKey ATT_ARG_SEPARATOR = createTextAttributesKey("LIBGLOCAL_ARG_SEPARATOR", COMMA);
	public final static TextAttributesKey ATT_ARG_EQUALS = createTextAttributesKey("LIBGLOCAL_ARG_EQUALS", OPERATION_SIGN);

	public final static TextAttributesKey[] ATT_ARR_EMPTY = new TextAttributesKey[0];

	@NotNull
	@Override
	public Lexer getHighlightingLexer(){
		return new LibglocalFlexAdapter();
	}

	@NotNull
	@Override
	public TextAttributesKey[] getTokenHighlights(IElementType tokenType){
		if(tokenType == ARGS_SEPARATOR){
			return new TextAttributesKey[]{ATT_ARG_SEPARATOR};
		}
		if(tokenType == ARG_EQUALS){
			return new TextAttributesKey[]{ATT_ARG_EQUALS};
		}
		if(tokenType == ARG_KEYWORD){
			return new TextAttributesKey[]{ATT_KEYWORD};
		}
		if(tokenType == ARG_NAME){
			return new TextAttributesKey[]{ATT_ARG_NAME};
		}
		if(tokenType == ARG_TYPE){
			return new TextAttributesKey[]{ATT_ARG_TYPE};
		}
		if(tokenType == BASE_KEYWORD){
			return new TextAttributesKey[]{ATT_KEYWORD};
		}
		if(tokenType == LibglocalTokens.BLOCK_COMMENT){
			return new TextAttributesKey[]{ATT_BLOCK_COMMENT};
		}
		if(tokenType == CLOSE_PAREN){
			return new TextAttributesKey[]{ATT_PARENTHESES};
		}
		if(tokenType == CLOSE_QUOTE){
			return new TextAttributesKey[]{ATT_LITERAL};
		}
		if(tokenType == DOC_KEYWORD){
			return new TextAttributesKey[]{ATT_KEYWORD};
		}
		if(tokenType == DOC_VALUE){
			return new TextAttributesKey[]{ATT_DOC_VALUE};
		}
		if(tokenType == DOLLAR_CLOSE){
			return new TextAttributesKey[]{ATT_DOLLAR_BRACES};
		}
		if(tokenType == DOLLAR_OPEN){
			return new TextAttributesKey[]{ATT_DOLLAR_BRACES};
		}
//		if(tokenType == EOL) return new TextAttributesKey[]{};
		if(tokenType == ESCAPE){
			return new TextAttributesKey[]{ATT_LITERAL_ESCAPE};
		}
		if(tokenType == HASH_CLOSE){
			return new TextAttributesKey[]{ATT_HASH_BRACES};
		}
		if(tokenType == HASH_OPEN){
			return new TextAttributesKey[]{ATT_HASH_BRACES};
		}
//		if(tokenType == INDENT) return new TextAttributesKey[]{};
		if(tokenType == LANG_KEYWORD){
			return new TextAttributesKey[]{ATT_KEYWORD};
		}
		if(tokenType == LANG_LOCAL){
			return new TextAttributesKey[]{ATT_LANG_LOCAL};
		}
		if(tokenType == LANG_NAME){
			return new TextAttributesKey[]{ATT_LANG_NAME};
		}
		if(tokenType == LibglocalTokens.LINE_COMMENT){
			return new TextAttributesKey[]{ATT_LINE_COMMENT};
		}
		if(tokenType == LITERAL){
			return new TextAttributesKey[]{ATT_LITERAL};
		}
		if(tokenType == MESSAGES_KEYWORD){
			return new TextAttributesKey[]{ATT_KEYWORD};
		}
		if(tokenType == MESSAGE_ID){
			return new TextAttributesKey[]{ATT_MESSAGE_ID};
		}
		if(tokenType == NUMBER_LITERAL){
			return new TextAttributesKey[]{ATT_NUMBER_LITERAL};
		}
		if(tokenType == OPEN_PAREN){
			return new TextAttributesKey[]{ATT_PARENTHESES};
		}
		if(tokenType == OPEN_QUOTE){
			return new TextAttributesKey[]{ATT_LITERAL};
		}
		if(tokenType == PERCENT_CLOSE){
			return new TextAttributesKey[]{ATT_PERCENT_BRACES};
		}
		if(tokenType == PERCENT_OPEN){
			return new TextAttributesKey[]{ATT_PERCENT_BRACES};
		}
		if(tokenType == SINCE_KEYWORD){
			return new TextAttributesKey[]{ATT_KEYWORD};
		}
		if(tokenType == SPAN_NAME){
			return new TextAttributesKey[]{ATT_SPAN_NAME};
		}
		if(tokenType == UPDATED_KEYWORD){
			return new TextAttributesKey[]{ATT_KEYWORD};
		}
		if(tokenType == VERSION_VALUE){
			return new TextAttributesKey[]{ATT_VERSION_VALUE};
		}
//		if(tokenType == WHITE_SPACE) return new TextAttributesKey[]{};

		return ATT_ARR_EMPTY;
	}
}
