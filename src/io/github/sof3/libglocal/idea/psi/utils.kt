@file:JvmName("Utils")
@file:Suppress("UNUSED_PARAMETER")

package io.github.sof3.libglocal.idea.psi

import com.intellij.ide.projectView.PresentationData
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import io.github.sof3.libglocal.idea.Icons
import io.github.sof3.libglocal.idea.libglocal.MessageVisibility
import io.github.sof3.libglocal.idea.parser.LgcElements

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

internal fun getFile(e: PsiElement): LgcFile = e.containingFile as LgcFile

internal fun getMessages(e: LgcMessages): List<LgcMessage> = PsiTreeUtil.getChildrenOfTypeAsList(e, LgcMessage::class.java)

internal fun getMessages(e: LgcMessageGroup): List<LgcMessage> = PsiTreeUtil.getChildrenOfTypeAsList(e, LgcMessage::class.java)

internal fun getModifiers(e: LgcMessage): List<LgcModifierBlock> = PsiTreeUtil.getChildrenOfTypeAsList(e, LgcModifierBlock::class.java)

internal fun getConstraints(e: LgcModifierBlock): List<LgcConstraintBlock> = PsiTreeUtil.getChildrenOfTypeAsList(e, LgcConstraintBlock::class.java)


internal fun getChildBlocks(e: LgcLang): List<LgcBlockElement> = emptyList()
internal fun getChildBlocks(e: LgcAuthor): List<LgcBlockElement> = emptyList()
internal fun getChildBlocks(e: LgcVersion): List<LgcBlockElement> = emptyList()
internal fun getChildBlocks(e: LgcRequire): List<LgcBlockElement> = emptyList()

internal fun getChildBlocks(e: LgcMessages): List<LgcBlockElement> = getChildBlocksMessageParentImpl(e)
internal fun getChildBlocks(e: LgcMessageGroup): List<LgcBlockElement> = getChildBlocksMessageParentImpl(e)
private fun getChildBlocksMessageParentImpl(e: LgcMessageParentElement): List<LgcBlockElement> {
	val ret = mutableListOf<LgcBlockElement>()
	for (child in e.children) {
		if (child is LgcMessageGroup) {
			ret.add(child)
		} else if (child is LgcMessage) {
			ret.add(child)
		}
	}
	return ret
}

internal fun getChildBlocks(e: LgcMessage): List<LgcBlockElement> = e.argModifierList

internal fun getChildBlocks(e: LgcModifierBlock): List<LgcBlockElement> = e.constraints

internal fun getChildBlocks(e: LgcConstraintBlock): List<LgcBlockElement> = emptyList()


internal fun getName(e: LgcLang) = e.langId.text
internal fun getName(e: LgcAuthor) = e.authorName.text
internal fun getName(e: LgcVersion) = e.versionValue.text
internal fun getName(e: LgcRequire) = e.requireTarget.text

internal fun getName(e: LgcMessages) = e.messageId.text
internal fun getName(e: LgcMessageGroup) = e.messageId.text
internal fun getName(e: LgcMessage) = e.messageId.text

internal fun getFullName(e: LgcBlockElement): String {
	val names = mutableListOf(e.name ?: "???")
	var element = e.parent
	while (element is LgcMessageGroup || element is LgcMessages) {
		if (element is LgcMessageGroup) {
			names.add(element.messageId.text)
		} else {
			names.add((element as LgcMessages).messageId.text)
		}
		element = element.parent
	}
	return names.reversed().joinToString(separator = ".")
}

internal fun getName(e: LgcArgModifier) = e.argName.text
internal fun getType(e: LgcArgModifier) = e.argType?.text ?: "string"

internal fun getName(e: LgcFieldConstraint) = e.argName.text
internal fun getType(e: LgcFieldConstraint) = e.argType?.text ?: "string"

internal fun getPresentation(e: LgcMessages) = PresentationData(e.name, e.name, Icons.MODULE.px16, null)
internal fun getPresentation(e: LgcMessageGroup) = PresentationData(e.name, e.fullName, Icons.GROUP.px16, null)
internal fun getPresentation(e: LgcMessage): ItemPresentation = PresentationData(e.name, e.fullName, Icons.MESSAGE.px16, null)
internal fun getPresentation(e: LgcArgModifier): ItemPresentation = PresentationData(e.name, e.type, Icons.ARG.px16, null)
internal fun getPresentation(e: LgcFieldConstraint): ItemPresentation = PresentationData(e.name, e.type, Icons.ARG.px16, null)

internal fun getVisibility(e: LgcMessage): MessageVisibility {
	val stub = e.stub
	if (stub != null) {
		return stub.visibility
	}

	val flag = e.messageId.messageFlag ?: return MessageVisibility.DEFAULT

	return when (flag.node.firstChildNode.elementType) {
		LgcElements.T_FLAG_PUBLIC -> MessageVisibility.PUBLIC
		LgcElements.T_FLAG_LIB -> MessageVisibility.LIB
		LgcElements.T_FLAG_LOCAL -> MessageVisibility.LOCAL
		else -> MessageVisibility.DEFAULT
	}
}
