@file:JvmName("Utils")
@file:Suppress("UNUSED_PARAMETER")

package io.github.sof3.libglocal.idea.psi

import com.intellij.ide.projectView.PresentationData
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.util.PsiTreeUtil

internal fun getMessages(e: LibglocalBlockMessages): List<LibglocalBlockMessage> = PsiTreeUtil.getChildrenOfTypeAsList(e, LibglocalBlockMessage::class.java)

internal fun getMessages(e: LibglocalBlockMessageGroup): List<LibglocalBlockMessage> = PsiTreeUtil.getChildrenOfTypeAsList(e, LibglocalBlockMessage::class.java)

internal fun getModifiers(e: LibglocalBlockMessage): List<LibglocalModifierBlock> = PsiTreeUtil.getChildrenOfTypeAsList(e, LibglocalModifierBlock::class.java)

internal fun getConstraints(e: LibglocalModifierBlock): List<LibglocalConstraintBlock> = PsiTreeUtil.getChildrenOfTypeAsList(e, LibglocalConstraintBlock::class.java)


internal fun getChildBlocks(e: LibglocalLangBlock): List<LibglocalBlockElement> = emptyList()
internal fun getChildBlocks(e: LibglocalAuthorBlock): List<LibglocalBlockElement> = emptyList()
internal fun getChildBlocks(e: LibglocalVersionBlock): List<LibglocalBlockElement> = emptyList()
internal fun getChildBlocks(e: LibglocalRequireBlock): List<LibglocalBlockElement> = emptyList()

internal fun getChildBlocks(e: LibglocalBlockMessages): List<LibglocalBlockElement> = getChildBlocksMessageParentImpl(e)
internal fun getChildBlocks(e: LibglocalBlockMessageGroup): List<LibglocalBlockElement> = getChildBlocksMessageParentImpl(e)
private fun getChildBlocksMessageParentImpl(e: LibglocalMessageParentElement): List<LibglocalBlockElement> {
	val ret = mutableListOf<LibglocalBlockElement>()
	for (child in e.children) {
		if (child is LibglocalBlockMessageGroup) {
			ret.add(child)
		} else if (child is LibglocalBlockMessage) {
			ret.add(child)
		}
	}
	return ret
}

internal fun getChildBlocks(e: LibglocalBlockMessage): List<LibglocalBlockElement> = e.modifiers

internal fun getChildBlocks(e: LibglocalModifierBlock): List<LibglocalBlockElement> = e.constraints

internal fun getChildBlocks(e: LibglocalConstraintBlock): List<LibglocalBlockElement> = emptyList()


internal fun getName(e: LibglocalLangBlock) = e.elementLangId.text!!
internal fun getName(e: LibglocalAuthorBlock) = e.elementLiteralStatic.text!!
internal fun getName(e: LibglocalVersionBlock) = e.elementVersionValue.text!!
internal fun getName(e: LibglocalRequireBlock) = e.elementRequireTarget.text!!

internal fun getName(e: LibglocalBlockMessages) = e.elementMessageId.text!!
internal fun getName(e: LibglocalBlockMessageGroup) = e.elementMessageId.text!!
internal fun getName(e: LibglocalBlockMessage) = e.elementMessageId.text!!

internal fun getFullName(e: LibglocalBlockElement): String {
	val names = mutableListOf(e.name ?: "???")
	var element = e.parent
	while (element is LibglocalBlockMessageGroup || element is LibglocalBlockMessages) {
		if (element is LibglocalBlockMessageGroup) {
			names.add(element.name)
		} else {
			names.add((element as LibglocalBlockMessages).name)
		}
		element = element.parent
	}
	return names.reversed().joinToString(separator = ".")
}

internal fun getName(e: LibglocalModifierArg) = e.elementArgName.text
internal fun getType(e: LibglocalModifierArg) = e.elementArgType?.text ?: "string"

internal fun getName(e: LibglocalConstraintField) = e.elementArgName.text
internal fun getType(e: LibglocalConstraintField) = e.elementArgType?.text ?: "string"

internal fun getPresentation(e: LibglocalBlockMessages) = PresentationData(e.name, e.name, null, null)
internal fun getPresentation(e: LibglocalBlockMessageGroup) = PresentationData(e.name, e.fullName, null, null)
internal fun getPresentation(e: LibglocalBlockMessage): ItemPresentation = PresentationData(e.name, e.fullName, null, null)
internal fun getPresentation(e: LibglocalModifierArg): ItemPresentation = PresentationData(e.name, e.type, null, null)
