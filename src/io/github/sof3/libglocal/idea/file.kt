package io.github.sof3.libglocal.idea

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import com.intellij.psi.util.PsiTreeUtil
import io.github.sof3.libglocal.idea.psi.*

class LibglocalFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, LibglocalLanguage), LibglocalBlockElement {
	override val childBlocks: List<LibglocalBlockElement>
		get() = listOfNotNull(messagesBlock)

	val langBlock: LibglocalBlockLang?
		get() = PsiTreeUtil.getChildOfType(this, LibglocalBlockLang::class.java)
	val authorBlocks: List<LibglocalBlockAuthor>
		get() = PsiTreeUtil.getChildrenOfTypeAsList(this, LibglocalBlockAuthor::class.java)
	val versionBlock: LibglocalBlockVersion?
		get() = PsiTreeUtil.getChildOfType(this, LibglocalBlockVersion::class.java)
	val requireBlocks: List<LibglocalBlockRequire>
		get() = PsiTreeUtil.getChildrenOfTypeAsList(this, LibglocalBlockRequire::class.java)
	val messagesBlock: LibglocalBlockMessages?
		get() = PsiTreeUtil.getChildOfType(this, LibglocalBlockMessages::class.java)

	override fun getFileType(): FileType = LibglocalFileType
}
