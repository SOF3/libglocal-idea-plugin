package io.github.sof3.libglocal.idea.psi

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
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

class LibglocalFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, LibglocalLanguage), LibglocalBlockElement {
	override val childBlocks: List<LibglocalBlockElement>
		get() = listOfNotNull(messagesBlock)

	val langBlock: LibglocalLangBlock?
		get() = PsiTreeUtil.getChildOfType(this, LibglocalLangBlock::class.java)
	val authorBlocks: List<LibglocalAuthorBlock>
		get() = PsiTreeUtil.getChildrenOfTypeAsList(this, LibglocalAuthorBlock::class.java)
	val versionBlock: LibglocalVersionBlock?
		get() = PsiTreeUtil.getChildOfType(this, LibglocalVersionBlock::class.java)
	val requireBlocks: List<LibglocalRequireBlock>
		get() = PsiTreeUtil.getChildrenOfTypeAsList(this, LibglocalRequireBlock::class.java)
	val messagesBlock: LibglocalBlockMessages?
		get() = PsiTreeUtil.getChildOfType(this, LibglocalBlockMessages::class.java)

	override fun getFileType(): FileType = LibglocalFileType
}
