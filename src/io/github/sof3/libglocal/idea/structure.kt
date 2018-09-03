package io.github.sof3.libglocal.idea

import com.intellij.ide.projectView.PresentationData
import com.intellij.ide.structureView.*
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement
import com.intellij.ide.util.treeView.smartTree.TreeElement
import com.intellij.lang.PsiStructureViewFactory
import com.intellij.navigation.ItemPresentation
import com.intellij.openapi.editor.Editor
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiFile
import io.github.sof3.libglocal.idea.psi.LibglocalBlockElement
import java.lang.Integer.min

class LibglocalSVFactory : PsiStructureViewFactory {
	override fun getStructureViewBuilder(file: PsiFile): StructureViewBuilder? {
		return object : TreeBasedStructureViewBuilder() {
			override fun createStructureViewModel(editor: Editor?): StructureViewModel {
				return LibglocalSVModel(file)
			}
		}
	}
}

class LibglocalSVModel(file: PsiFile) : StructureViewModelBase(file, LibglocalSVElement(file)), StructureViewModel.ElementInfoProvider {
	override fun isAlwaysShowsPlus(element: StructureViewTreeElement?): Boolean {
		return false
	}

	override fun isAlwaysLeaf(element: StructureViewTreeElement?): Boolean {
		return false
	}
}

class LibglocalSVElement(private val element: NavigatablePsiElement) : StructureViewTreeElement, SortableTreeElement {
	override fun getValue(): Any = element

	override fun canNavigate() = element.canNavigate()
	override fun canNavigateToSource() = element.canNavigateToSource()
	override fun navigate(requestFocus: Boolean) = element.navigate(requestFocus)

	override fun getAlphaSortKey() = element.name ?: ""

	override fun getPresentation(): ItemPresentation = element.presentation
			?: PresentationData(element.text.substring(0, min(element.text.length, 30)), "", null, null)

	override fun getChildren(): Array<TreeElement> {
		if (element is LibglocalBlockElement) {
			return element.childBlocks.map { LibglocalSVElement(it) }.toTypedArray()
		}
		return emptyArray()
	}
}
