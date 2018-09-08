package io.github.sof3.libglocal.idea.hl;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import io.github.sof3.libglocal.idea.parser.LibglocalFlexAdapter;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class LibglocalSyntaxHighlighter extends SyntaxHighlighterBase implements LibglocalTokens, AttributesKeys{

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
			return new TextAttributesKey[]{ATT_COMMA};
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
		if(tokenType == ARG_TYPE_MODIFIER){
			return new TextAttributesKey[]{ATT_ARG_TYPE_MODIFIER};
		}
		if(tokenType == AUTHOR_KEYWORD){
			return new TextAttributesKey[]{ATT_KEYWORD};
		}
		if(tokenType == AUTHOR_NAME){
			return new TextAttributesKey[]{ATT_AUTHOR_NAME};
		}
		if(tokenType == AUTHOR_SEPARATOR){
			return new TextAttributesKey[]{ATT_COMMA};
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
		if(tokenType == SPAN_STYLE){
			return new TextAttributesKey[]{ATT_SPAN_STYLE};
		}
		if(tokenType == UPDATED_KEYWORD){
			return new TextAttributesKey[]{ATT_KEYWORD};
		}
		if(tokenType == VERSION_KEYWORD){
			return new TextAttributesKey[]{ATT_KEYWORD};
		}
		if(tokenType == VERSION_VALUE){
			return new TextAttributesKey[]{ATT_VERSION_VALUE};
		}
//		if(tokenType == WHITE_SPACE) return new TextAttributesKey[]{};

		return ATT_ARR_EMPTY;
	}
}
