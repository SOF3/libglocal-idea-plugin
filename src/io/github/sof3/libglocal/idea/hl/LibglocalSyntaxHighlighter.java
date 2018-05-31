package io.github.sof3.libglocal.idea.hl;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import io.github.sof3.libglocal.idea.parser.LibglocalFlexAdapter;
import io.github.sof3.libglocal.idea.psi.LibglocalTokens;
import io.github.sof3.libglocal.idea.psi.LibglocalTypes;
import org.jetbrains.annotations.NotNull;

public class LibglocalSyntaxHighlighter extends SyntaxHighlighterBase implements LibglocalTypes, AttributesKeys{

	public final static TextAttributesKey[] ATT_ARR_EMPTY = new TextAttributesKey[0];

	@NotNull
	@Override
	public Lexer getHighlightingLexer(){
		return new LibglocalFlexAdapter();
	}

	@NotNull
	@Override
	public TextAttributesKey[] getTokenHighlights(IElementType tokenType){
		if(tokenType == LibglocalTokens.ARGS_SEPARATOR){
			return new TextAttributesKey[]{ATT_COMMA};
		}
		if(tokenType == LibglocalTokens.ARG_EQUALS){
			return new TextAttributesKey[]{ATT_ARG_EQUALS};
		}
		if(tokenType == LibglocalTokens.ARG_KEYWORD){
			return new TextAttributesKey[]{ATT_KEYWORD};
		}
		if(tokenType == LibglocalTokens.ARG_NAME){
			return new TextAttributesKey[]{ATT_ARG_NAME};
		}
		if(tokenType == LibglocalTokens.ARG_TYPE){
			return new TextAttributesKey[]{ATT_ARG_TYPE};
		}
		if(tokenType == LibglocalTokens.ARG_TYPE_MODIFIER){
			return new TextAttributesKey[]{ATT_ARG_TYPE_MODIFIER};
		}
		if(tokenType == LibglocalTokens.AUTHOR_KEYWORD){
			return new TextAttributesKey[]{ATT_KEYWORD};
		}
		if(tokenType == LibglocalTokens.AUTHOR_NAME){
			return new TextAttributesKey[]{ATT_AUTHOR_NAME};
		}
		if(tokenType == LibglocalTokens.AUTHOR_SEPARATOR){
			return new TextAttributesKey[]{ATT_COMMA};
		}
		if(tokenType == LibglocalTokens.BASE_KEYWORD){
			return new TextAttributesKey[]{ATT_KEYWORD};
		}
		if(tokenType == LibglocalTokens.BLOCK_COMMENT){
			return new TextAttributesKey[]{ATT_BLOCK_COMMENT};
		}
		if(tokenType == LibglocalTokens.CLOSE_PAREN){
			return new TextAttributesKey[]{ATT_PARENTHESES};
		}
		if(tokenType == LibglocalTokens.CLOSE_QUOTE){
			return new TextAttributesKey[]{ATT_LITERAL};
		}
		if(tokenType == LibglocalTokens.DOC_KEYWORD){
			return new TextAttributesKey[]{ATT_KEYWORD};
		}
		if(tokenType == LibglocalTokens.DOC_VALUE){
			return new TextAttributesKey[]{ATT_DOC_VALUE};
		}
		if(tokenType == LibglocalTokens.DOLLAR_CLOSE){
			return new TextAttributesKey[]{ATT_DOLLAR_BRACES};
		}
		if(tokenType == LibglocalTokens.DOLLAR_OPEN){
			return new TextAttributesKey[]{ATT_DOLLAR_BRACES};
		}
//		if(tokenType == EOL) return new TextAttributesKey[]{};
		if(tokenType == LibglocalTokens.ESCAPE){
			return new TextAttributesKey[]{ATT_LITERAL_ESCAPE};
		}
		if(tokenType == LibglocalTokens.ESCAPE_ILLEGAL){
			return new TextAttributesKey[]{ATT_LITERAL_ESCAPE_ILLEGAL};
		}
		if(tokenType == LibglocalTokens.HASH_CLOSE){
			return new TextAttributesKey[]{ATT_HASH_BRACES};
		}
		if(tokenType == LibglocalTokens.HASH_OPEN){
			return new TextAttributesKey[]{ATT_HASH_BRACES};
		}
//		if(tokenType == INDENT) return new TextAttributesKey[]{};
		if(tokenType == LibglocalTokens.LANG_KEYWORD){
			return new TextAttributesKey[]{ATT_KEYWORD};
		}
		if(tokenType == LibglocalTokens.LANG_LOCAL){
			return new TextAttributesKey[]{ATT_LANG_LOCAL};
		}
		if(tokenType == LibglocalTokens.LANG_NAME){
			return new TextAttributesKey[]{ATT_LANG_NAME};
		}
		if(tokenType == LibglocalTokens.LINE_COMMENT){
			return new TextAttributesKey[]{ATT_LINE_COMMENT};
		}
		if(tokenType == LibglocalTokens.LITERAL){
			return new TextAttributesKey[]{ATT_LITERAL};
		}
		if(tokenType == LibglocalTokens.MESSAGES_KEYWORD){
			return new TextAttributesKey[]{ATT_KEYWORD};
		}
		if(tokenType == LibglocalTokens.MESSAGE_ID){
			return new TextAttributesKey[]{ATT_MESSAGE_ID};
		}
		if(tokenType == LibglocalTokens.NUMBER_LITERAL){
			return new TextAttributesKey[]{ATT_NUMBER_LITERAL};
		}
		if(tokenType == LibglocalTokens.OPEN_PAREN){
			return new TextAttributesKey[]{ATT_PARENTHESES};
		}
		if(tokenType == LibglocalTokens.OPEN_QUOTE){
			return new TextAttributesKey[]{ATT_LITERAL};
		}
		if(tokenType == LibglocalTokens.PERCENT_CLOSE){
			return new TextAttributesKey[]{ATT_PERCENT_BRACES};
		}
		if(tokenType == LibglocalTokens.PERCENT_OPEN){
			return new TextAttributesKey[]{ATT_PERCENT_BRACES};
		}
		if(tokenType == LibglocalTokens.PRIVATE_KEYWORD){
			return new TextAttributesKey[]{ATT_KEYWORD};
		}
		if(tokenType == LibglocalTokens.SINCE_KEYWORD){
			return new TextAttributesKey[]{ATT_KEYWORD};
		}
		if(tokenType == LibglocalTokens.SPAN_NAME){
			return new TextAttributesKey[]{ATT_SPAN_NAME};
		}
		if(tokenType == LibglocalTokens.SPAN_STYLE){
			return new TextAttributesKey[]{ATT_SPAN_STYLE};
		}
		if(tokenType == LibglocalTokens.UPDATED_KEYWORD){
			return new TextAttributesKey[]{ATT_KEYWORD};
		}
		if(tokenType == LibglocalTokens.VERSION_KEYWORD){
			return new TextAttributesKey[]{ATT_KEYWORD};
		}
		if(tokenType == LibglocalTokens.VERSION_VALUE){
			return new TextAttributesKey[]{ATT_VERSION_VALUE};
		}
//		if(tokenType == WHITE_SPACE) return new TextAttributesKey[]{};

		return ATT_ARR_EMPTY;
	}
}
