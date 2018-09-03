package io.github.sof3.libglocal.idea

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.tree.IElementType
import io.github.sof3.libglocal.idea.parser.LibglocalLexer
import java.io.BufferedReader
import java.io.InputStreamReader
import javax.swing.Icon

class LibglocalHlFactory : SyntaxHighlighterFactory() {
	override fun getSyntaxHighlighter(project: Project?, virtualFile: VirtualFile?): SyntaxHighlighter {
		return LibglocalHighlighter()
	}
}

class LibglocalHighlighter : SyntaxHighlighterBase() {
	override fun getHighlightingLexer(): Lexer {
		return LibglocalLexer()
	}

	override fun getTokenHighlights(tokenType: IElementType?): Array<TextAttributesKey> {
		val att = Attributes.tokenMap(tokenType)
		return if (att != null) arrayOf(att) else emptyArray()
	}
}

class LibglocalColorSettingsPage : ColorSettingsPage {
	companion object {
		val DEMO_TEXT: String

		init {
			val url = LibglocalColorSettingsPage::class.java.classLoader.getResource("demo/en_US.lang")!!
			val builder = StringBuilder()
			url.openStream().use {
				val reader = BufferedReader(InputStreamReader(url.openStream()))
				reader.lines().forEachOrdered { line ->
					builder.append(line)
					builder.append('\n')
				}
			}
			assert(builder.isNotEmpty()) { "en_US.lang could not be read" }
			DEMO_TEXT = builder.toString()
		}
	}

	override fun getDisplayName(): String {
		return "Libglocal"
	}

	override fun getIcon(): Icon? {
		return Icons.LIBGLOCAL_16PX
	}

	override fun getHighlighter(): SyntaxHighlighter {
		return LibglocalHighlighter()
	}

	override fun getDemoText(): String {
		return DEMO_TEXT
	}

	override fun getAdditionalHighlightingTagToDescriptorMap(): MutableMap<String, TextAttributesKey>? {
		return null
	}

	override fun getAttributeDescriptors(): Array<AttributesDescriptor> {
		return Attributes.DESCRIPTORS
	}

	override fun getColorDescriptors(): Array<ColorDescriptor> {
		return emptyArray()
	}
}
