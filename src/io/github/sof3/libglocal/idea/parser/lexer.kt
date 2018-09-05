package io.github.sof3.libglocal.idea.parser

import com.intellij.lexer.LexerBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import io.github.sof3.libglocal.idea.psi.LibglocalElements

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

internal data class FutureToken(val type: IElementType, val length: Int)

class LibglocalLexer(val highlighting: Boolean) : LexerBase() {
	data class WhitespaceResult(val whitespace: CharSequence, val trimmed: CharSequence)

	companion object {
		internal fun readWhitespace(string: CharSequence, charSet: CharArray = charArrayOf(' ', '\t')): WhitespaceResult {
			var whiteSize = string.indexOfFirst { !charSet.contains(it) }
			if (whiteSize == -1) whiteSize = string.length
			return WhitespaceResult(string.subSequence(0, whiteSize), string.subSequence(whiteSize, string.length))
		}

		internal fun badToken() = listOf(FutureToken(TokenType.BAD_CHARACTER, 1))

		internal data class IdentifierRead(val list: List<FutureToken>, val read: Boolean, val error: Boolean)

		internal fun readIdentifier(buffer: CharSequence, tokenType: IElementType = LibglocalElements.T_IDENTIFIER): IdentifierRead {
			val match = LexerPatterns.IDENTIFIER.find(buffer) ?: return IdentifierRead(badToken(), false, true)
			if (buffer.length > match.value.length && buffer[match.value.length] == ':') {
				return IdentifierRead(listOf(FutureToken(LibglocalElements.T_FLAG, match.value.length + 1)), false, false)
			}
			return IdentifierRead(listOf(FutureToken(tokenType, match.value.length)), true, false)
		}
	}

	private var myState = LexerState.LINE_START
	private var myTokenType: IElementType? = null
	private var myTokenStart = 0
	private var myTokenEnd = 0
	private var myBuffer: CharSequence? = null
	private var myBufferEnd = 0

	internal var nextState = LexerState.LINE_START

	internal var reachedMessages = false

	internal var expectedIdentifiers = 0
	internal var optionalSeparator = false
	internal var instructionMode = false
	// the T_CLOSE_BRACE behind a literal can mean "close a span" or "close an arg-list string literal", so we need to distinguish it here
	internal var literalBraceStack = mutableListOf<LexerState>()

	val indentStack = mutableListOf<CharSequence>()
	private val futureTokens = mutableListOf<FutureToken>()

	private var hadError = false

	private fun realAdvance(): List<FutureToken> {
		val buffer = myBuffer!!.subSequence(myTokenStart, myBufferEnd)

		return nextState.advance(this, buffer)
	}

	override fun start(buffer: CharSequence, startOffset: Int, endOffset: Int, initialState: Int) {
//		println("Called start(buffer=[$buffer], startOffset=[$startOffset], endOffset=[$endOffset], initialState=[$initialState]")

		myTokenStart = startOffset
		myTokenEnd = startOffset
		myBufferEnd = endOffset

		myState = LexerState.values()[initialState]
		myBuffer = buffer
		myTokenType = null

		nextState = myState
		reachedMessages = false
		expectedIdentifiers = 0
		futureTokens.clear()
		hadError = false
	}

	override fun advance() {
		locateTokenLazy()
		myTokenType = null
	}

	private fun locateTokenLazy() {
		if (myTokenType != null) return
		locateTokenImpl()
//		println("isHighlightingLexer: $highlighting, myTokenType = $myTokenType \"${myBuffer?.substring(myTokenStart, myTokenEnd)?.replace(Regex("\n"), "\\\\n")}\", nextState = ${nextState.name}, reachedMessages = $reachedMessages, expectedIdentifiers = $expectedIdentifiers, futureTokens.size = ${futureTokens.size}")
	}

	private fun locateTokenImpl() {
		myTokenStart = myTokenEnd
		if (hadError) return

		myState = nextState

		if (futureTokens.size > 0) {
			val (type, length) = futureTokens.removeAt(0)
			myTokenType = type
			myTokenEnd = myTokenStart + length
			return
		}

		if (myTokenStart == myBufferEnd) {
			return
		}

		var tokens: List<FutureToken>
		do {
			tokens = realAdvance()
			if (highlighting) {
				tokens = tokens.filter { it.length > 0 }
			}
		} while (tokens.isEmpty()) // retry if no tokens are found; state might have been changed


		futureTokens.addAll(tokens)
		if (futureTokens.size > 0) {
			val (type, length) = futureTokens.removeAt(0)
			myTokenType = type
			myTokenEnd = myTokenStart + length
		}
	}

	override fun getState(): Int {
		locateTokenLazy()
		return myState.ordinal
	}

	override fun getTokenStart(): Int {
		locateTokenLazy()
		return myTokenStart
	}

	override fun getTokenEnd(): Int {
		locateTokenLazy()
		return myTokenEnd
	}

	override fun getBufferEnd(): Int = myBufferEnd

	override fun getBufferSequence(): CharSequence = myBuffer!!

	override fun getTokenType(): IElementType? {
		locateTokenLazy()
		return myTokenType
	}
}
