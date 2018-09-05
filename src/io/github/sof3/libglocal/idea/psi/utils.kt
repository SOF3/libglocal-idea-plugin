@file:JvmName("Utils")
@file:Suppress("UNUSED_PARAMETER")

package io.github.sof3.libglocal.idea.psi

import com.intellij.ide.projectView.PresentationData
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.util.PsiTreeUtil
import io.github.sof3.libglocal.idea.Icons
import io.github.sof3.libglocal.idea.MessageVisibility

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

internal fun getMessages(e: LibglocalBlockMessages): List<LibglocalBlockMessage> = PsiTreeUtil.getChildrenOfTypeAsList(e, LibglocalBlockMessage::class.java)

internal fun getMessages(e: LibglocalBlockMessageGroup): List<LibglocalBlockMessage> = PsiTreeUtil.getChildrenOfTypeAsList(e, LibglocalBlockMessage::class.java)

internal fun getModifiers(e: LibglocalBlockMessage): List<LibglocalModifierBlock> = PsiTreeUtil.getChildrenOfTypeAsList(e, LibglocalModifierBlock::class.java) // TODO switch to stubs

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

internal fun getChildBlocks(e: LibglocalBlockMessage): List<LibglocalBlockElement> = e.modifierArgList

internal fun getChildBlocks(e: LibglocalModifierBlock): List<LibglocalBlockElement> = e.constraints

internal fun getChildBlocks(e: LibglocalConstraintBlock): List<LibglocalBlockElement> = emptyList()


internal fun getName(e: LibglocalLangBlock) = e.elementLangId.text!!
internal fun getName(e: LibglocalAuthorBlock) = e.elementLiteralStatic.text!!
internal fun getName(e: LibglocalVersionBlock) = e.elementVersionValue.text!!
internal fun getName(e: LibglocalRequireBlock) = e.elementRequireTarget.text!!

internal fun getName(e: LibglocalBlockMessages) = e.elementMessageId.messageName.text!!
internal fun getName(e: LibglocalBlockMessageGroup) = e.elementMessageId.messageName.text!!
internal fun getName(e: LibglocalBlockMessage) = e.stub?.fullName ?: e.elementMessageId.messageName.text!!

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

internal fun getVisibility(e: LibglocalBlockMessage): MessageVisibility {
	val stub = e.stub ?: null
	if (stub != null) {
		return stub.visibility
	}

	for (flag in e.elementMessageId.messageFlagList) {
		when(flag.text){
			"local:" -> return MessageVisibility.LOCAL
			"lib:" -> return MessageVisibility.LIB
		}
	}
	return MessageVisibility.PUBLIC
}

internal fun getName(e: LibglocalModifierArg) = e.elementArgName.text
internal fun getType(e: LibglocalModifierArg) = e.elementArgType?.text ?: "string"

internal fun getName(e: LibglocalConstraintField) = e.elementArgName.text
internal fun getType(e: LibglocalConstraintField) = e.elementArgType?.text ?: "string"

internal fun getPresentation(e: LibglocalBlockMessages) = PresentationData(e.name, e.name, Icons.MODULE.px16, null)
internal fun getPresentation(e: LibglocalBlockMessageGroup) = PresentationData(e.name, e.fullName, Icons.GROUP.px16, null)
internal fun getPresentation(e: LibglocalBlockMessage): ItemPresentation = PresentationData(e.name, e.fullName, Icons.MESSAGE.px16, null)
internal fun getPresentation(e: LibglocalModifierArg): ItemPresentation = PresentationData(e.name, e.type, Icons.ARG.px16, null)
