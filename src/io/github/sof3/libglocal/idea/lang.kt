package io.github.sof3.libglocal.idea

import com.intellij.lang.Language
import com.intellij.openapi.fileTypes.FileTypeConsumer
import com.intellij.openapi.fileTypes.FileTypeFactory
import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

/*
 * libglocal-idea-plugin
 *
 * Copyright 2018 SOFe
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

object LibglocalFileType : LanguageFileType(LibglocalLanguage) {
	override fun getName() = "Libglocal lang"

	override fun getDescription() = "Libglocal language file"

	override fun getDefaultExtension() = "lang"

	override fun getIcon(): Icon? = Icons.LIBGLOCAL_16PX
}

class LibglocalFileTypeFactory : FileTypeFactory() {
	override fun createFileTypes(consumer: FileTypeConsumer) {
		consumer.consume(LibglocalFileType, "lang")
	}
}

object LibglocalLanguage : Language("libglocal") {
	override fun getDisplayName() = "libglocal language file"
}
