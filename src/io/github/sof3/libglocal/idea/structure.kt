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

class LibglocalSVFactory : PsiStructureViewFactory {
	override fun getStructureViewBuilder(file: PsiFile): StructureViewBuilder? = object : TreeBasedStructureViewBuilder() {
		override fun createStructureViewModel(editor: Editor?): StructureViewModel = LibglocalSVModel(file)
	}
}

class LibglocalSVModel(file: PsiFile) : StructureViewModelBase(file, LibglocalSVElement(file)), StructureViewModel.ElementInfoProvider {
	override fun isAlwaysShowsPlus(element: StructureViewTreeElement?) = false

	override fun isAlwaysLeaf(element: StructureViewTreeElement?) = false
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
