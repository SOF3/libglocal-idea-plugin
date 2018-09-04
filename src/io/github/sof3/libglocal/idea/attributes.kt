package io.github.sof3.libglocal.idea

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.psi.tree.IElementType
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors as D
import io.github.sof3.libglocal.idea.psi.LibglocalElements as E


object Attributes {
	private fun create(name: String, fallback: TextAttributesKey?) = TextAttributesKey.createTextAttributesKey(name, fallback)

	val COMMENT = create("LIBGLOCAL_COMMENT", D.LINE_COMMENT)
	val KEYWORD = create("LIBGLOCAL_KEYWORD", D.KEYWORD)
	val FLAG = create("LIBGLOCAL_FLAG", D.LABEL)
	val IDENTIFIER = create("LIBGLOCAL_IDENTIFIER", D.IDENTIFIER)
	val NUMBER = create("LIBGLOCAL_NUMBER", D.NUMBER)
	val CONT = create("LIBGLOCAL_CONT", D.OPERATION_SIGN)
	val EQUALS = create("LIBGLOCAL_EQUALS", D.OPERATION_SIGN)
	val INTERPOLATION = create("LIBGLOCAL_INTERPOLATION", D.BRACES)
	val ESCAPE = create("LIBGLOCAL_ESCAPE", D.VALID_STRING_ESCAPE)
	val ESCAPE_INVALID = create("LIBGLOCAL_ESCAPE_INVALID", D.INVALID_STRING_ESCAPE)
	val LITERAL = create("LIBGLOCAL_LITERAL", D.STRING)
	val MODIFIER = create("LIBGLOCAL_MODIFIER", D.OPERATION_SIGN)
	val SPAN_NAME = create("LIBGLOCAL_SPAN_NAME", D.PREDEFINED_SYMBOL)

	val DESCRIPTORS = arrayOf(
			AttributesDescriptor("Comment", COMMENT),
			AttributesDescriptor("Keyword", KEYWORD),
			AttributesDescriptor("Identifier", IDENTIFIER),
			AttributesDescriptor("Number", NUMBER),
			AttributesDescriptor("Continuation", CONT),
			AttributesDescriptor("Equals", EQUALS),
			AttributesDescriptor("Interpolation braces", INTERPOLATION),
			AttributesDescriptor("Escape", ESCAPE),
			AttributesDescriptor("Invalid escape", ESCAPE_INVALID),
			AttributesDescriptor("Literal", LITERAL),
			AttributesDescriptor("Modifier", MODIFIER),
			AttributesDescriptor("Span name", SPAN_NAME)

	)

	fun tokenMap(tokenType: IElementType?): TextAttributesKey? = when (tokenType) {
		E.T_COMMENT -> COMMENT

		E.K_BASE_LANG -> KEYWORD
		E.K_LANG -> KEYWORD
		E.K_AUTHOR -> KEYWORD
		E.K_VERSION -> KEYWORD
		E.K_REQUIRE -> KEYWORD
		E.K_MESSAGES -> KEYWORD

		E.T_FLAG -> FLAG
		E.T_IDENTIFIER -> IDENTIFIER
		E.T_NUMBER -> NUMBER

		E.T_CONT_CONCAT -> CONT
		E.T_CONT_NEWLINE -> CONT
		E.T_CONT_SPACE -> CONT

		E.T_EQUALS -> EQUALS

		E.T_ARG_REF_START -> INTERPOLATION
		E.T_MESSAGE_REF_START -> INTERPOLATION
		E.T_SPAN_START -> INTERPOLATION
		E.T_OPEN_BRACE -> INTERPOLATION
		E.T_CLOSE_BRACE -> INTERPOLATION

		E.T_LITERAL_ESCAPE -> ESCAPE
		E.T_LITERAL_INVALID_ESCAPE -> ESCAPE_INVALID
		E.T_LITERAL_STRING -> LITERAL
		E.T_MODIFIER_ARG -> MODIFIER
		E.T_MODIFIER_DOC -> MODIFIER
		E.T_MODIFIER_VERSION -> MODIFIER

		E.T_SPAN_TYPE -> SPAN_NAME

		else -> null
	}
}
