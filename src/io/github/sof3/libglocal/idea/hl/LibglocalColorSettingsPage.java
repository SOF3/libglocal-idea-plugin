package io.github.sof3.libglocal.idea.hl;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import io.github.sof3.libglocal.idea.LibglocalIcon;
import io.github.sof3.libglocal.idea.annotator.SpanAttributes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.Icon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Map;

public class LibglocalColorSettingsPage implements ColorSettingsPage, AttributesKeys, SpanAttributes{
	private static final AttributesDescriptor[] ATTRIBUTE_DESCRIPTORS = new AttributesDescriptor[]{
			new AttributesDescriptor("Line comment", ATT_LINE_COMMENT),
			new AttributesDescriptor("Block comment", ATT_BLOCK_COMMENT),
			new AttributesDescriptor("Keyword", ATT_KEYWORD),
			new AttributesDescriptor("Language code", ATT_LANG_NAME),
			new AttributesDescriptor("Language local name", ATT_LANG_LOCAL),
			new AttributesDescriptor("Author name", ATT_AUTHOR_NAME),
			new AttributesDescriptor("Version", ATT_VERSION_VALUE),
			new AttributesDescriptor("Message ID", ATT_MESSAGE_ID),
			new AttributesDescriptor("String literal", ATT_LITERAL),
			new AttributesDescriptor("String escape", ATT_LITERAL_ESCAPE),
			new AttributesDescriptor("Argument interpolation braces", ATT_DOLLAR_BRACES),
			new AttributesDescriptor("Message interpolation braces", ATT_HASH_BRACES),
			new AttributesDescriptor("Span braces", ATT_PERCENT_BRACES),
			new AttributesDescriptor("Stack span name", ATT_SPAN_NAME),
			new AttributesDescriptor("Style span name", ATT_SPAN_STYLE),
			new AttributesDescriptor("Argument name", ATT_ARG_NAME),
			new AttributesDescriptor("Argument type prefix", ATT_ARG_TYPE_MODIFIER),
			new AttributesDescriptor("Argument type", ATT_ARG_TYPE),
			new AttributesDescriptor("Argument list assignment", ATT_ARG_EQUALS),
			new AttributesDescriptor("Number literal", ATT_NUMBER_LITERAL),
			new AttributesDescriptor("Documentation text", ATT_DOC_VALUE),
			new AttributesDescriptor("Parentheses", ATT_PARENTHESES),
			new AttributesDescriptor("Comma", ATT_COMMA),
			new AttributesDescriptor("Style (only affects editor display): info", STYLE_INFO),
			new AttributesDescriptor("Style (only affects editor display): success", STYLE_SUCCESS),
			new AttributesDescriptor("Style (only affects editor display): notice", STYLE_NOTICE),
			new AttributesDescriptor("Style (only affects editor display): warn", STYLE_WARN),
			new AttributesDescriptor("Style (only affects editor display): error", STYLE_ERROR),
			new AttributesDescriptor("Stack span (only affects editor display): highlight 1", STACK_HL1),
			new AttributesDescriptor("Stack span (only affects editor display): highlight 2", STACK_HL2),
			new AttributesDescriptor("Stack span (only affects editor display): highlight 2", STACK_HL2_ALT),
			new AttributesDescriptor("Stack span (only affects editor display): highlight 3", STACK_HL3),
			new AttributesDescriptor("Stack span (only affects editor display): highlight 3", STACK_HL3_ALT),
			new AttributesDescriptor("Stack span (only affects editor display): highlight 4", STACK_HL4),
			new AttributesDescriptor("Stack span (only affects editor display): highlight 4", STACK_HL4_ALT),
			new AttributesDescriptor("Stack span (only affects editor display): bold", STACK_BOLD),
			new AttributesDescriptor("Stack span (only affects editor display): italic", STACK_ITALIC),
			new AttributesDescriptor("Stack span (only affects editor display): underlined", STACK_UNDERLINED),
			new AttributesDescriptor("Stack span (only affects editor display): strikethrough", STACK_STRIKETHROUGH),
	};

	private final static String DEMO_TEXT;

	static{
		URL url = LibglocalColorSettingsPage.class.getClassLoader().getResource("demo/en_US.lang");
		assert url != null;
		try(InputStream in = url.openStream();
		    BufferedReader reader = new BufferedReader(new InputStreamReader(in))){
			StringBuilder demo = new StringBuilder(in.available());
			reader.lines().forEach(line -> demo.append(line).append('\n'));
			DEMO_TEXT = demo.toString();
		}catch(IOException e){
			throw new RuntimeException(e);
		}
	}

	@Nullable
	@Override
	public Icon getIcon(){
		return LibglocalIcon.LIBGLOCAL_16;
	}

	@NotNull
	@Override
	public SyntaxHighlighter getHighlighter(){
		return new LibglocalSyntaxHighlighter();
	}

	@NotNull
	@Override
	public String getDemoText(){
		return DEMO_TEXT;
	}

	@Nullable
	@Override
	public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap(){
		return null;
	}

	@NotNull
	@Override
	public AttributesDescriptor[] getAttributeDescriptors(){
		return ATTRIBUTE_DESCRIPTORS;
	}

	@NotNull
	@Override
	public ColorDescriptor[] getColorDescriptors(){
		return new ColorDescriptor[0];
	}

	@NotNull
	@Override
	public String getDisplayName(){
		return "Libglocal Language File";
	}
}
