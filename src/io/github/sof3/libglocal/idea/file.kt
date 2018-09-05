package io.github.sof3.libglocal.idea

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import com.intellij.psi.util.PsiTreeUtil
import io.github.sof3.libglocal.idea.psi.*

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
