package io.github.sof3.libglocal.idea.hl;

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;

import static com.intellij.openapi.editor.DefaultLanguageHighlighterColors.*;
import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public interface AttributesKeys{
	TextAttributesKey ATT_LINE_COMMENT = createTextAttributesKey("LIBGLOCAL_LINE_COMMENT", LINE_COMMENT);
	TextAttributesKey ATT_BLOCK_COMMENT = createTextAttributesKey("LIBGLOCAL_BLOCK_COMMENT", BLOCK_COMMENT);
	TextAttributesKey ATT_DOC_VALUE = createTextAttributesKey("LIBGLOCAL_BLOCK_COMMENT", DOC_COMMENT);
	TextAttributesKey ATT_KEYWORD = createTextAttributesKey("LIBGLOCAL_KEYWORD", KEYWORD);
	TextAttributesKey ATT_LANG_NAME = createTextAttributesKey("LIBGLOCAL_LANG_NAME", MARKUP_ATTRIBUTE);
	TextAttributesKey ATT_MESSAGE_ID = createTextAttributesKey("LIBGLOCAL_MESSAGE_ID", MARKUP_ATTRIBUTE);
	TextAttributesKey ATT_ARG_NAME = createTextAttributesKey("LIBGLOCAL_ARG_NAME", LOCAL_VARIABLE);
	TextAttributesKey ATT_ARG_TYPE = createTextAttributesKey("LIBGLOCAL_ARG_TYPE", CLASS_REFERENCE);
	TextAttributesKey ATT_LITERAL = createTextAttributesKey("LIBGLOCAL_STRING_LITERAL", STRING);
	TextAttributesKey ATT_AUTHOR_NAME = createTextAttributesKey("LIBGLOCAL_AUTHOR_NAME", ATT_LITERAL);
	TextAttributesKey ATT_LANG_LOCAL = createTextAttributesKey("LIBGLOCAL_LANG_LOCAL", ATT_LITERAL);
	TextAttributesKey ATT_NUMBER_LITERAL = createTextAttributesKey("LIBGLOCAL_NUMBER_LITERAL", NUMBER);
	TextAttributesKey ATT_VERSION_VALUE = createTextAttributesKey("LIBGLOCAL_VERSION_VALUE", NUMBER);
	TextAttributesKey ATT_LITERAL_ESCAPE = createTextAttributesKey("LIBGLOCAL_STRING_LITERAL_ESCAPE", VALID_STRING_ESCAPE);
	TextAttributesKey ATT_SPAN_NAME = createTextAttributesKey("LIBGLOCAL_SPAN_NAME", PREDEFINED_SYMBOL);
	TextAttributesKey ATT_SPAN_STYLE = createTextAttributesKey("LIBGLOCAL_SPAN_STYLE", PREDEFINED_SYMBOL);
	TextAttributesKey ATT_ARG_TYPE_MODIFIER = createTextAttributesKey("LIBGLOCAL_ARG_EQUALS", INSTANCE_FIELD);
	TextAttributesKey ATT_DOLLAR_BRACES = createTextAttributesKey("LIBGLOCAL_DOLLAR_BRACES", BRACES);
	TextAttributesKey ATT_HASH_BRACES = createTextAttributesKey("LIBGLOCAL_HASH_BRACES", BRACES);
	TextAttributesKey ATT_PERCENT_BRACES = createTextAttributesKey("LIBGLOCAL_PERCENT_BRACES", BRACES);
	TextAttributesKey ATT_PARENTHESES = createTextAttributesKey("LIBGLOCAL_PARENTHESES", PARENTHESES);
	TextAttributesKey ATT_COMMA = createTextAttributesKey("LIBGLOCAL_COMMA", COMMA);
	TextAttributesKey ATT_ARG_EQUALS = createTextAttributesKey("LIBGLOCAL_ARG_EQUALS", OPERATION_SIGN);
}
