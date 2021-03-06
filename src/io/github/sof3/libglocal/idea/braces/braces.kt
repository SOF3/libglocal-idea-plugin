package io.github.sof3.libglocal.idea.braces

import com.intellij.lang.BracePair
import com.intellij.lang.PairedBraceMatcher
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IElementType
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

class LibglocalPairedBraceMatcher : PairedBraceMatcher {
	companion object {
		val PAIRS = arrayOf(
				BracePair(LgcElements.T_OPEN_BRACE, LgcElements.T_CLOSE_BRACE, false),
				BracePair(LgcElements.T_ARG_REF_START, LgcElements.T_CLOSE_BRACE, false),
				BracePair(LgcElements.T_MESSAGE_REF_START, LgcElements.T_CLOSE_BRACE, false),
				BracePair(LgcElements.T_SPAN_START, LgcElements.T_CLOSE_BRACE, false)
		)
	}

	override fun getPairs() = PAIRS

	override fun isPairedBracesAllowedBeforeType(lbrace: IElementType, context: IElementType?) = true

	override fun getCodeConstructStart(file: PsiFile?, braceOffset: Int) = braceOffset
}
