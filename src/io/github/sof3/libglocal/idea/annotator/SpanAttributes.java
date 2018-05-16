package io.github.sof3.libglocal.idea.annotator;

import com.intellij.openapi.editor.colors.TextAttributesKey;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public interface SpanAttributes{
	TextAttributesKey STYLE_INFO = createTextAttributesKey("LIBGLOCAL_STYLE_INFO");
	TextAttributesKey STYLE_SUCCESS = createTextAttributesKey("LIBGLOCAL_STYLE_SUCCESS");
	TextAttributesKey STYLE_NOTICE = createTextAttributesKey("LIBGLOCAL_STYLE_NOTICE");
	TextAttributesKey STYLE_WARN = createTextAttributesKey("LIBGLOCAL_STYLE_WARN");
	TextAttributesKey STYLE_ERROR = createTextAttributesKey("LIBGLOCAL_STYLE_ERROR");

	TextAttributesKey STACK_BOLD = createTextAttributesKey("LIBGLOCAL_STACK_BOLD");
	TextAttributesKey STACK_ITALIC = createTextAttributesKey("LIBGLOCAL_STACK_ITALIC");
	TextAttributesKey STACK_UNDERLINED = createTextAttributesKey("LIBGLOCAL_STACK_UNDERLINED");
	TextAttributesKey STACK_STRIKETHROUGH = createTextAttributesKey("LIBGLOCAL_STACK_STRIKETHROUGH");

	TextAttributesKey STACK_HL1 = createTextAttributesKey("LIBGLOCAL_STACK_HL1");
	TextAttributesKey STACK_HL2 = createTextAttributesKey("LIBGLOCAL_STACK_HL2");
	TextAttributesKey STACK_HL2_ALT = createTextAttributesKey("LIBGLOCAL_STACK_HL2_ALT");
	TextAttributesKey STACK_HL3 = createTextAttributesKey("LIBGLOCAL_STACK_HL3");
	TextAttributesKey STACK_HL3_ALT = createTextAttributesKey("LIBGLOCAL_STACK_HL3_ALT");
	TextAttributesKey STACK_HL4 = createTextAttributesKey("LIBGLOCAL_STACK_HL4");
	TextAttributesKey STACK_HL4_ALT = createTextAttributesKey("LIBGLOCAL_STACK_HL4_ALT");
}
