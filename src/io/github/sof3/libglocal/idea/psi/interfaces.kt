package io.github.sof3.libglocal.idea.psi

import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiElement

interface LibglocalBlockElement : NavigatablePsiElement {
	val childBlocks: List<LibglocalBlockElement>
}

interface LibglocalMessageParentElement : PsiElement {
	val messages: List<LibglocalBlockMessage>
}

interface LibglocalModifierBlock : LibglocalBlockElement {
	val constraints: List<LibglocalConstraintBlock>
}

interface LibglocalConstraintBlock : LibglocalBlockElement
