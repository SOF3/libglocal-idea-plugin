package io.github.sof3.libglocal.idea

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import io.github.sof3.libglocal.idea.psi.*

class LibglocalFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, LibglocalLanguage), LibglocalBlockElement {
	override val childBlocks: List<LibglocalBlockElement>
		get() {
//			val list = mutableListOf<LibglocalBlockElement>()
//			for (child in children) {
//				if (child is LibglocalBlockElement) {
//					list.add(child)
//				}
//			}
//			return list
			return listOfNotNull(messagesBlock)
		}

	val langBlock: LibglocalBlockLang?
		get() {
			val blocks = children.filterIsInstance(LibglocalBlockLang::class.java)
			return if (blocks.isNotEmpty()) blocks[0] else null
		}
	val authorBlocks: List<LibglocalBlockAuthor>
		get() = children.filterIsInstance(LibglocalBlockAuthor::class.java)
	val versionBlock: LibglocalBlockVersion?
		get() {
			val blocks = children.filterIsInstance(LibglocalBlockVersion::class.java)
			return if (blocks.isNotEmpty()) blocks[0] else null
		}
	val messagesBlock: LibglocalBlockMessages?
		get() {
			val blocks = children.filterIsInstance(LibglocalBlockMessages::class.java)
			return if (blocks.isNotEmpty()) blocks[0] else null
		}

	override fun getFileType(): FileType {
		return LibglocalFileType
	}
}
