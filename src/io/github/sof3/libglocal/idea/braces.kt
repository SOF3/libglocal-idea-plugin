package io.github.sof3.libglocal.idea

import com.intellij.lang.BracePair
import com.intellij.lang.PairedBraceMatcher
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IElementType
import io.github.sof3.libglocal.idea.psi.LibglocalElements

class LibglocalPairedBraceMatcher: PairedBraceMatcher{
	companion object {
		val PAIRS = arrayOf(
				BracePair(LibglocalElements.T_OPEN_BRACE, LibglocalElements.T_CLOSE_BRACE, false),
				BracePair(LibglocalElements.T_ARG_REF_START, LibglocalElements.T_CLOSE_BRACE, false),
				BracePair(LibglocalElements.T_MESSAGE_REF_START, LibglocalElements.T_CLOSE_BRACE, false),
				BracePair(LibglocalElements.T_SPAN_START, LibglocalElements.T_CLOSE_BRACE, false)
		)
	}

	override fun getPairs(): Array<BracePair> {
		return PAIRS
	}

	override fun isPairedBracesAllowedBeforeType(lbrace: IElementType, context: IElementType?) = true

	override fun getCodeConstructStart(file: PsiFile?, braceOffset: Int): Int {
		return braceOffset
	}
}
