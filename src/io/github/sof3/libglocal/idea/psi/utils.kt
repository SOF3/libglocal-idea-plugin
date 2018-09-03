@file:JvmName("Utils")

package io.github.sof3.libglocal.idea.psi

import com.intellij.ide.projectView.PresentationData
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElement

internal fun getMessages(e: LibglocalBlockMessages): List<LibglocalBlockMessage> {
	return e.children.filterIsInstance(LibglocalBlockMessage::class.java)
}

internal fun getMessages(e: LibglocalBlockMessageGroup): List<LibglocalBlockMessage> {
	return e.children.filterIsInstance(LibglocalBlockMessage::class.java)
}

internal fun getModifiers(e: LibglocalBlockMessage): List<LibglocalBlockModifier> {
	return e.children.filterIsInstance(LibglocalBlockModifier::class.java)
}

internal fun getConstraints(e: LibglocalBlockModifier): List<LibglocalBlockConstraint> {
	return e.children.filterIsInstance(LibglocalBlockConstraint::class.java)
}


internal fun getChildBlocks(e: LibglocalBlockLang): List<LibglocalBlockElement> = emptyList()

internal fun getChildBlocks(e: LibglocalBlockAuthor): List<LibglocalBlockElement> = emptyList()

internal fun getChildBlocks(e: LibglocalBlockVersion): List<LibglocalBlockElement> = emptyList()

internal fun getChildBlocks(e: LibglocalBlockMessages): List<LibglocalBlockElement> = getChildBlocksMessageParentImpl(e)
internal fun getChildBlocks(e: LibglocalBlockMessageGroup): List<LibglocalBlockElement> = getChildBlocksMessageParentImpl(e)
private fun getChildBlocksMessageParentImpl(e: PsiElement): List<LibglocalBlockElement> {
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

internal fun getChildBlocks(e: LibglocalBlockModifier): List<LibglocalBlockElement> = e.constraints

internal fun getChildBlocks(e: LibglocalBlockConstraint): List<LibglocalBlockElement> = emptyList()


internal fun getName(e: LibglocalBlockLang) = "${if (e.node.findChildByType(LibglocalElements.K_BASE_LANG) != null) "base lang" else "lang"} " +
		"${e.node.findChildByType(LibglocalElements.T_IDENTIFIER)}"

internal fun getName(e: LibglocalBlockAuthor) = "Author: ${e.node.findChildByType(LibglocalElements.ELEMENT_LITERAL_STATIC)}"

internal fun getName(e: LibglocalBlockVersion) = e.node.findChildByType(LibglocalElements.T_IDENTIFIER)?.text
		?: "<null>"

internal fun getName(e: LibglocalBlockMessages) = "Messages"

internal fun getName(e: LibglocalBlockMessageGroup) = e.node.findChildByType(LibglocalElements.ELEMENT_MESSAGE_ID)?.text

internal fun getName(e: LibglocalBlockMessage) = e.node.findChildByType(LibglocalElements.ELEMENT_MESSAGE_ID)?.text

internal fun getFullName(e: LibglocalBlockElement): String {
	val names = mutableListOf(e.name!!)
	var element = e.parent
	while (element is LibglocalBlockMessageGroup) {
		names.add(element.name!!)
		element = element.parent
	}
	return names.reversed().joinToString(separator = ".")
}

internal fun getPresentation(e: LibglocalBlockMessages) = PresentationData("messages", null, null, null)

internal fun getPresentation(e: LibglocalBlockMessageGroup) = PresentationData(e.name, e.fullName, null, null)

internal fun getPresentation(e: LibglocalBlockMessage): ItemPresentation = PresentationData(e.name, e.fullName, null, null)
