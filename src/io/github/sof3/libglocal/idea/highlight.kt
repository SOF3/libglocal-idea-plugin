package io.github.sof3.libglocal.idea

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory
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
	override fun getSyntaxHighlighter(project: Project?, virtualFile: VirtualFile?): SyntaxHighlighter = LibglocalHighlighter()
}

class LibglocalHighlighter : SyntaxHighlighterBase() {
	override fun getHighlightingLexer(): Lexer = LibglocalLexer(true)

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

	override fun getDisplayName() = "Libglocal"

	override fun getIcon(): Icon? = Icons.LIBGLOCAL_16PX

	override fun getHighlighter(): SyntaxHighlighter = LibglocalHighlighter()

	override fun getDemoText() = DEMO_TEXT

	override fun getAdditionalHighlightingTagToDescriptorMap(): MutableMap<String, TextAttributesKey>? = null

	override fun getAttributeDescriptors() = Attributes.DESCRIPTORS

	override fun getColorDescriptors(): Array<ColorDescriptor> = emptyArray()
}
