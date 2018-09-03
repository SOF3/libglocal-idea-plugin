package io.github.sof3.libglocal.idea

import com.intellij.lang.Language
import com.intellij.openapi.fileTypes.FileTypeConsumer
import com.intellij.openapi.fileTypes.FileTypeFactory
import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

object LibglocalFileType : LanguageFileType(LibglocalLanguage) {
	override fun getName(): String {
		return "libglocal lang"
	}

	override fun getDescription(): String {
		return "Language files for libglocal"
	}

	override fun getDefaultExtension(): String {
		return "lang"
	}

	override fun getIcon(): Icon? {
		return Icons.LIBGLOCAL_16PX
	}
}

class LibglocalFileTypeFactory : FileTypeFactory() {
	override fun createFileTypes(consumer: FileTypeConsumer) {
		consumer.consume(LibglocalFileType, "lang")
	}
}

object LibglocalLanguage : Language("libglocal") {
	override fun getDisplayName(): String {
		return "libglocal language file"
	}
}
