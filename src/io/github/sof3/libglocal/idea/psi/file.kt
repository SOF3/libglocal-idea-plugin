package io.github.sof3.libglocal.idea.psi

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import com.intellij.psi.stubs.PsiFileStubImpl
import com.intellij.psi.util.PsiTreeUtil
import io.github.sof3.libglocal.idea.LibglocalFileType
import io.github.sof3.libglocal.idea.LibglocalLanguage

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

class LgcFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, LibglocalLanguage), LgcBlockElement {
	override val childBlocks: List<LgcBlockElement>
		get() = listOfNotNull(messages)

	val lang: LgcLang?
		get() = PsiTreeUtil.getChildOfType(this, LgcLang::class.java)
	val authors: List<LgcAuthor>
		get() = PsiTreeUtil.getChildrenOfTypeAsList(this, LgcAuthor::class.java)
	val version: LgcVersion?
		get() = PsiTreeUtil.getChildOfType(this, LgcVersion::class.java)
	val requires: List<LgcRequire>
		get() = PsiTreeUtil.getChildrenOfTypeAsList(this, LgcRequire::class.java)
	val messages: LgcMessages?
		get() = PsiTreeUtil.getChildOfType(this, LgcMessages::class.java)

	override fun getFileType(): FileType = LibglocalFileType
}

class LgcFileStub(file: LgcFile): PsiFileStubImpl<LgcFile>(file)
