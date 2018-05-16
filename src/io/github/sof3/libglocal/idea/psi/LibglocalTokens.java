package io.github.sof3.libglocal.idea.psi;

import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import io.github.sof3.libglocal.idea.LibglocalTokenType;

public interface LibglocalTokens extends TokenType{
	IElementType ARGS_SEPARATOR = new LibglocalTokenType("ARGS_SEPARATOR");
	IElementType ARG_EQUALS = new LibglocalTokenType("ARG_EQUALS");
	IElementType ARG_KEYWORD = new LibglocalTokenType("ARG_KEYWORD");
	IElementType ARG_NAME = new LibglocalTokenType("ARG_NAME");
	IElementType ARG_TYPE = new LibglocalTokenType("ARG_TYPE");
	IElementType ARG_TYPE_MODIFIER = new LibglocalTokenType("ARG_TYPE_MODIFIER");
	IElementType AUTHOR_KEYWORD = new LibglocalTokenType("AUTHOR_KEYWORD");
	IElementType AUTHOR_NAME = new LibglocalTokenType("AUTHOR_NAME");
	IElementType AUTHOR_SEPARATOR = new LibglocalTokenType("AUTHOR_SEPARATOR");
	IElementType BASE_KEYWORD = new LibglocalTokenType("BASE_KEYWORD");
	IElementType BLOCK_COMMENT = new LibglocalTokenType("BLOCK_COMMENT");
	IElementType CLOSE_PAREN = new LibglocalTokenType("CLOSE_PAREN");
	IElementType CLOSE_QUOTE = new LibglocalTokenType("CLOSE_QUOTE");
	IElementType DOC_KEYWORD = new LibglocalTokenType("DOC_KEYWORD");
	IElementType DOC_VALUE = new LibglocalTokenType("DOC_VALUE");
	IElementType DOLLAR_CLOSE = new LibglocalTokenType("DOLLAR_CLOSE");
	IElementType DOLLAR_OPEN = new LibglocalTokenType("DOLLAR_OPEN");
	IElementType EOL = new LibglocalTokenType("EOL");
	IElementType ESCAPE = new LibglocalTokenType("ESCAPE");
	IElementType ESCAPE_ILLEGAL = new LibglocalTokenType("ESCAPE_ILLEGAL");
	IElementType HASH_CLOSE = new LibglocalTokenType("HASH_CLOSE");
	IElementType HASH_OPEN = new LibglocalTokenType("HASH_OPEN");
	IElementType INDENT = new LibglocalTokenType("INDENT");
	IElementType LANG_KEYWORD = new LibglocalTokenType("LANG_KEYWORD");
	IElementType LANG_LOCAL = new LibglocalTokenType("LANG_LOCAL");
	IElementType LANG_NAME = new LibglocalTokenType("LANG_NAME");
	IElementType LINE_COMMENT = new LibglocalTokenType("LINE_COMMENT");
	IElementType LITERAL = new LibglocalTokenType("LITERAL");
	IElementType MESSAGES_KEYWORD = new LibglocalTokenType("MESSAGES_KEYWORD");
	IElementType MESSAGE_ID = new LibglocalTokenType("MESSAGE_ID");
	IElementType NUMBER_LITERAL = new LibglocalTokenType("NUMBER_LITERAL");
	IElementType OPEN_PAREN = new LibglocalTokenType("OPEN_PAREN");
	IElementType OPEN_QUOTE = new LibglocalTokenType("OPEN_QUOTE");
	IElementType PERCENT_CLOSE = new LibglocalTokenType("PERCENT_CLOSE");
	IElementType PERCENT_OPEN = new LibglocalTokenType("PERCENT_OPEN");
	IElementType SINCE_KEYWORD = new LibglocalTokenType("SINCE_KEYWORD");
	IElementType SPAN_NAME = new LibglocalTokenType("SPAN_NAME");
	IElementType SPAN_STYLE = new LibglocalTokenType("SPAN_STYLE");
	IElementType UPDATED_KEYWORD = new LibglocalTokenType("UPDATED_KEYWORD");
	IElementType VERSION_KEYWORD = new LibglocalTokenType("VERSION_KEYWORD");
	IElementType VERSION_VALUE = new LibglocalTokenType("VERSION_VALUE");
}
