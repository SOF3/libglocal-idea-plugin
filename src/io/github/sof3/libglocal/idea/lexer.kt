package io.github.sof3.libglocal.idea

import com.intellij.lexer.LexerBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import io.github.sof3.libglocal.idea.LibglocalLexer.Companion.badToken
import io.github.sof3.libglocal.idea.psi.LibglocalElements

class LibglocalLexer : LexerBase() {
	data class WhitespaceResult(val whitespace: CharSequence, val trimmed: CharSequence)

	companion object {
		internal fun readWhitespace(string: CharSequence, charSet: CharArray = charArrayOf(' ', '\t')): WhitespaceResult {
			val whiteSize = string.indexOfFirst { c -> !charSet.contains(c) }
			try{
				return WhitespaceResult(string.subSequence(0, whiteSize), string.subSequence(whiteSize, string.length))
			}catch(e: IndexOutOfBoundsException){
				println("whiteSize=$whiteSize, string.length=${string.length}")
				throw e
			}
		}

		internal fun badToken() = listOf(FutureToken(TokenType.BAD_CHARACTER, 1))
	}

	private var myState = LexerState.LINE_START
	private var myTokenType: IElementType? = null
	private var myTokenStart = 0
	private var myTokenEnd = 0
	private var myBuffer: CharSequence? = null
	private var myBufferEnd = 0

	internal var nextState = LexerState.LINE_START

	var reachedMessages = false

	var expectedIdentifiers = 0

	val indentStack = mutableListOf<CharSequence>()
	private val futureTokens = mutableListOf<FutureToken>()

	private var hadError = false
	private var complete = false

	private fun realAdvance(): List<FutureToken> {
		val buffer = myBuffer!!.subSequence(myTokenStart, myBufferEnd)

		return nextState.advance(this, buffer)
	}

	override fun start(buffer: CharSequence, startOffset: Int, endOffset: Int, initialState: Int) {
		myTokenStart = startOffset
		myTokenEnd = startOffset
		myBufferEnd = endOffset

		myState = LexerState.values()[initialState]
		myBuffer = buffer
		reset()

		myTokenType = null
	}

	override fun advance() {
		locateToken()
		myTokenType = null
	}

	private fun reset() {
		myTokenType = TokenType.BAD_CHARACTER
	}

	private fun locateToken() {
		if (myTokenType != null) return
		myTokenStart = myTokenEnd
		if (hadError) return

		myState = nextState
		if (complete) return

		if (futureTokens.size > 0) {
			val (type, length) = futureTokens.removeAt(0)
			myTokenType = type
			myTokenEnd = myTokenStart + length
			return
		}

		if (myTokenStart == myBufferEnd) {
			complete = true
			return
		}

		var tokens: List<FutureToken>
		do {
			tokens = realAdvance()
		} while (tokens.isEmpty()) // empty return value implies retry
		futureTokens.addAll(tokens)
		if (futureTokens.size > 0) {
			val (type, length) = futureTokens.removeAt(0)
			myTokenType = type
			myTokenEnd = myTokenStart + length
		}
	}

	override fun getState(): Int {
		locateToken()
		return myState.ordinal
	}

	override fun getTokenStart(): Int {
		locateToken()
		return myTokenStart
	}

	override fun getTokenEnd(): Int {
		locateToken()
		return myTokenEnd
	}

	override fun getBufferEnd(): Int = myBufferEnd

	override fun getBufferSequence(): CharSequence = myBuffer!!

	override fun getTokenType(): IElementType? {
		locateToken()
		println("myTokenType = $myTokenType \"${tokenSequence.replace(Regex("\n"), "\\\\n")}\"")
		return myTokenType
	}
}

internal enum class LexerState {
	LINE_START {
		override fun advance(lexer: LibglocalLexer, buffer: CharSequence): List<FutureToken> {
			val indentStack = lexer.indentStack

			lexer.expectedIdentifiers = 0

			val (indent, line) = LibglocalLexer.readWhitespace(buffer)

			if (line.startsWith("//")) {
				var until = line.indexOfAny(listOf("\r\n", "\n"))
				if (until == -1) {
					until = line.length
				} else {
					if (line[until] == '\r') until++
					if (line[until] == '\n') until++
				}
				return listOf(FutureToken(LibglocalElements.T_COMMENT, indent.length + until))
			}
			if (line.startsWith("\r\n") || line[0] == '\n') {
				return listOf(FutureToken(LibglocalElements.T_EMPTY_LINE, indent.length + (if (line[0] == '\r') 2 else 1)))
			}

			// is an indent
			lexer.nextState = LexerState.COMMAND

			if (indentStack.isNotEmpty() && indent.toString() == indentStack.last().toString()) {
				return listOf(FutureToken(LibglocalElements.T_INDENT_INHERIT, indent.length))
			}

			if (indentStack.isEmpty() && indent.isEmpty()) {
				return listOf(FutureToken(LibglocalElements.T_INDENT_INHERIT, 0))
			}

			if (indentStack.isEmpty() || indent.startsWith(indentStack.last())) {
				indentStack.add(indent)
				return listOf(FutureToken(LibglocalElements.T_INDENT_INDENT, 0),
						FutureToken(LibglocalElements.T_INDENT_INHERIT, indent.length)
				)
			}

			var dedents = 0
			while (indentStack.isNotEmpty()) {
				if (indent.toString() == indentStack.last().toString()) {
					return List(dedents) { _ -> FutureToken(LibglocalElements.T_INDENT_DEDENT, 0) } +
							listOf(FutureToken(LibglocalElements.T_INDENT_INHERIT, indent.length))
				}
				indentStack.removeAt(indentStack.lastIndex)
				dedents++
			}
			if (indent.isEmpty()) {
				return List(dedents) { _ -> FutureToken(LibglocalElements.T_INDENT_DEDENT, 0) } +
						listOf(FutureToken(LibglocalElements.T_INDENT_INHERIT, indent.length))
			}
			return listOf(FutureToken(LibglocalElements.T_INDENT_INVALID, indent.length))
		}
	},

	COMMAND {
		override fun advance(lexer: LibglocalLexer, buffer: CharSequence): List<FutureToken> {
			if (!lexer.reachedMessages) {
				var match: MatchResult? = LexerPatterns.BASE_LANG.find(buffer)
				if (match != null) {
					lexer.expectedIdentifiers = 1
					lexer.nextState = LexerState.SEPARATOR
					return listOf(FutureToken(LibglocalElements.K_BASE_LANG, match.value.length))
				}
				match = LexerPatterns.LANG.find(buffer)
				if (match != null) {
					lexer.expectedIdentifiers = 1
					lexer.nextState = LexerState.SEPARATOR
					return listOf(FutureToken(LibglocalElements.K_LANG, match.value.length))
				}
				match = LexerPatterns.AUTHOR.find(buffer)
				if (match != null) {
					lexer.nextState = LexerState.SEPARATOR
					return listOf(FutureToken(LibglocalElements.K_AUTHOR, match.value.length))
				}
				match = LexerPatterns.VERSION.find(buffer)
				if (match != null) {
					lexer.expectedIdentifiers = 1
					lexer.nextState = LexerState.SEPARATOR
					return listOf(FutureToken(LibglocalElements.K_VERSION, match.value.length))
				}
				match = LexerPatterns.MESSAGES.find(buffer)
				if (match != null) {
					lexer.nextState = LexerState.SEPARATOR
					lexer.reachedMessages = true
					return listOf(FutureToken(LibglocalElements.K_MESSAGES, match.value.length))
				}

				return badToken()
			} else {
				if (buffer[0] == '$') {
					val argToken = FutureToken(LibglocalElements.T_MODIFIER_ARG, 1)
					val (white, _) = LibglocalLexer.readWhitespace(buffer.subSequence(1, buffer.length))
					lexer.expectedIdentifiers = 2
					lexer.nextState = LexerState.IDENTIFIER
					return if (white.isNotEmpty())
						listOf(argToken, FutureToken(TokenType.WHITE_SPACE, white.length))
					else
						listOf(argToken)
				}
				if (buffer[0] == '*') {
					val argToken = FutureToken(LibglocalElements.T_MODIFIER_DOC, 1)
					val (white, _) = LibglocalLexer.readWhitespace(buffer.subSequence(1, buffer.length))
					lexer.nextState = LexerState.LITERAL
					return if (white.isNotEmpty())
						listOf(argToken, FutureToken(TokenType.WHITE_SPACE, white.length))
					else
						listOf(argToken)
				}
				if (buffer[0] == '~') {
					val argToken = FutureToken(LibglocalElements.T_MODIFIER_VERSION, 1)
					val (white, _) = LibglocalLexer.readWhitespace(buffer.subSequence(1, buffer.length))
					lexer.expectedIdentifiers = 1
					lexer.nextState = LexerState.IDENTIFIER
					return if (white.isNotEmpty())
						listOf(argToken, FutureToken(TokenType.WHITE_SPACE, white.length))
					else
						listOf(argToken)
				}

				val match = LexerPatterns.IDENTIFIER.find(buffer) ?: return badToken()

				lexer.nextState = LexerState.SEPARATOR
				return listOf(FutureToken(LibglocalElements.T_IDENTIFIER, match.value.length))
			}
		}
	},

	SEPARATOR {
		override fun advance(lexer: LibglocalLexer, buffer: CharSequence): List<FutureToken> {
			val (white, rem) = LibglocalLexer.readWhitespace(buffer)

			if (rem.startsWith("\r\n") || rem[0] == '\n') {
				lexer.nextState = LexerState.LINE_START
				return listOf(FutureToken(LibglocalElements.T_EOL, white.length + (if (rem[0] == '\r') 2 else 1)))
			}
			if (white.isEmpty()) {
				return badToken()
			}

			lexer.nextState = if (lexer.expectedIdentifiers > 0) LexerState.IDENTIFIER else LexerState.LITERAL
			return listOf(FutureToken(TokenType.WHITE_SPACE, white.length))
		}
	},

	IDENTIFIER {
		override fun advance(lexer: LibglocalLexer, buffer: CharSequence): List<FutureToken> {
			val match = LexerPatterns.IDENTIFIER.find(buffer) ?: return badToken()
			lexer.expectedIdentifiers--
			lexer.nextState = LexerState.SEPARATOR
			return listOf(FutureToken(LibglocalElements.T_IDENTIFIER, match.value.length))
		}
	},

	LITERAL {
		override fun advance(lexer: LibglocalLexer, buffer: CharSequence): List<FutureToken> {
			var strLen = buffer.indexOfAny(charArrayOf(
					'\r',
					'\n',
					'\\',
					'#',
					'$',
					'%',
					'}'
			))
			if (strLen == -1) strLen = buffer.length
			if (strLen == 0) {
				if (buffer[0] == '\r' || buffer[0] == '\n') {
					lexer.nextState = LexerState.LINE_START
					return listOf(FutureToken(LibglocalElements.T_EOL, if (buffer[0] == '\r') 2 else 1))
				}

				if (buffer[0] == '\\') {
					if (buffer.length == 1) {
						return listOf(FutureToken(LibglocalElements.T_LITERAL_INVALID_ESCAPE, 1))
					}
					val valid = charArrayOf(
							'\\',
							'#',
							'$',
							'%',
							'}',
							'n',
							's',
							'0',
							'.'
					).contains(buffer[1])
					return listOf(FutureToken(
							if (valid) LibglocalElements.T_LITERAL_ESCAPE
							else LibglocalElements.T_LITERAL_INVALID_ESCAPE, 2))
				}

				if (buffer[0] == '$') {
					if (buffer.length == 1 || buffer[1] != '{') {
						return listOf(FutureToken(LibglocalElements.T_LITERAL_STRING, 1))
					}

					lexer.nextState = LexerState.ARG_REF_NAME
					return listOf(FutureToken(LibglocalElements.T_ARG_REF_START, 2))
				}

				if (buffer[0] == '#') {
					if (buffer.length == 1 || buffer[1] != '{') {
						return listOf(FutureToken(LibglocalElements.T_LITERAL_STRING, 1))
					}

					lexer.nextState = LexerState.MESSAGE_REF_NAME
					return listOf(FutureToken(LibglocalElements.T_MESSAGE_REF_START, 2))
				}

				if (buffer[0] == '%') {
					if (buffer.length == 1 || buffer[1] != '{') {
						return listOf(FutureToken(LibglocalElements.T_LITERAL_STRING, 1))
					}

					lexer.nextState = LexerState.SPAN_NAME
					return listOf(FutureToken(LibglocalElements.T_SPAN_START, 2))
				}

				if (buffer[0] == '}') {
					return listOf(FutureToken(LibglocalElements.T_CLOSE_BRACE, 1))
				}
			}
			return listOf(FutureToken(LibglocalElements.T_LITERAL_STRING, strLen))
		}
	},

	ARG_REF_NAME {
		override fun advance(lexer: LibglocalLexer, buffer: CharSequence): List<FutureToken> {
			val (white, _) = LibglocalLexer.readWhitespace(buffer)
			if (white.isNotEmpty()) {
				return listOf(FutureToken(TokenType.WHITE_SPACE, white.length))
			}

			val match = LexerPatterns.IDENTIFIER.find(buffer) ?: return badToken()
			lexer.nextState = LexerState.CLOSE_TO_LITERAL
			return listOf(FutureToken(LibglocalElements.T_IDENTIFIER, match.value.length))
		}
	},

	MESSAGE_REF_NAME {
		override fun advance(lexer: LibglocalLexer, buffer: CharSequence): List<FutureToken> {
			val (white, _) = LibglocalLexer.readWhitespace(buffer)
			if (white.isNotEmpty()) return listOf(FutureToken(TokenType.WHITE_SPACE, white.length))

			val match = LexerPatterns.IDENTIFIER.find(buffer) ?: return badToken()
			lexer.nextState = LexerState.ARG_LIST_RESET
			return listOf(FutureToken(LibglocalElements.T_IDENTIFIER, match.value.length))
		}
	},

	ARG_LIST_RESET {
		override fun advance(lexer: LibglocalLexer, buffer: CharSequence): List<FutureToken> {
			val (white, _) = LibglocalLexer.readWhitespace(buffer, charArrayOf(' ', ',', '\t', '\r', '\n'))
			if (white.isNotEmpty()) return listOf(FutureToken(TokenType.WHITE_SPACE, white.length))

			if (buffer[0] == '}') {
				lexer.nextState = LITERAL
				return listOf(FutureToken(LibglocalElements.T_CLOSE_BRACE, 1))
			}
			if (buffer[0] == '=') {
				lexer.nextState = ARG_LIST_VALUE
				return listOf(FutureToken(LibglocalElements.T_EQUALS, 1))
			}
			val match = LexerPatterns.IDENTIFIER.find(buffer) ?: return badToken()
			return listOf(FutureToken(LibglocalElements.T_IDENTIFIER, match.value.length))
		}
	},
	ARG_LIST_VALUE {
		override fun advance(lexer: LibglocalLexer, buffer: CharSequence): List<FutureToken> {
			val (white, _) = LibglocalLexer.readWhitespace(buffer, charArrayOf(' ', '\t', '\r', '\n'))
			if (white.isNotEmpty()) return listOf(FutureToken(TokenType.WHITE_SPACE, white.length))

			var match = LexerPatterns.NUMBER.find(buffer)
			if (match != null) {
				lexer.nextState = ARG_LIST_RESET
				return listOf(FutureToken(LibglocalElements.T_NUMBER, match.value.length))
			}

			match = LexerPatterns.IDENTIFIER.find(buffer)
			if (match != null) {
				lexer.nextState = ARG_LIST_RESET
				return listOf(FutureToken(LibglocalElements.T_IDENTIFIER, match.value.length))
			}

			if (buffer[0] == '{') {
				lexer.nextState = LITERAL
				return listOf(FutureToken(LibglocalElements.T_OPEN_BRACE, 1))
			}

			return badToken()
		}
	},

	SPAN_NAME {
		override fun advance(lexer: LibglocalLexer, buffer: CharSequence): List<FutureToken> {
			val (white, _) = LibglocalLexer.readWhitespace(buffer)
			if (white.isNotEmpty()) return listOf(FutureToken(TokenType.WHITE_SPACE, white.length))


			val match = LexerPatterns.IDENTIFIER.find(buffer) ?: return badToken()
			lexer.expectedIdentifiers = 0
			lexer.nextState = LexerState.SEPARATOR
			return listOf(FutureToken(LibglocalElements.T_SPAN_TYPE, match.value.length))
		}
	},

	CLOSE_TO_LITERAL {
		override fun advance(lexer: LibglocalLexer, buffer: CharSequence): List<FutureToken> {
			val (white, _) = LibglocalLexer.readWhitespace(buffer)
			if (white.isNotEmpty()) return listOf(FutureToken(TokenType.WHITE_SPACE, white.length))

			if (buffer[0] != '}') {
				return badToken()
			}

			lexer.nextState = LexerState.LITERAL
			return listOf(FutureToken(LibglocalElements.T_CLOSE_BRACE, 1))
		}
	},
	;

	abstract fun advance(lexer: LibglocalLexer, buffer: CharSequence): List<FutureToken>
}

internal object LexerPatterns {
	val BASE_LANG = Regex("^base[ \t]+lang\\b")
	val LANG = Regex("^lang\\b")
	val AUTHOR = Regex("^author\\b")
	val VERSION = Regex("^version\\b")
	val MESSAGES = Regex("^messages\\b")
	val IDENTIFIER = Regex("^[A-Za-z0-9_:\\-\\.]+")
	val NUMBER = Regex("^-?[0-9]+(\\.[0-9]+)?")
}

internal data class FutureToken(val type: IElementType, val length: Int)
