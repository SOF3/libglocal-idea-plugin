package io.github.sof3.libglocal.idea.parser

import com.intellij.psi.TokenType
import io.github.sof3.libglocal.idea.psi.LibglocalElements

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
			if (line.startsWith("\r\n") || line.isNotEmpty() && line[0] == '\n') {
				return listOf(FutureToken(LibglocalElements.T_EMPTY_LINE, indent.length + (if (line[0] == '\r') 2 else 1)))
			}

			// is an indent
			lexer.nextState = COMMAND

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
					return List(dedents) { FutureToken(LibglocalElements.T_INDENT_DEDENT, 0) } +
							listOf(FutureToken(LibglocalElements.T_INDENT_INHERIT, indent.length))
				}
				indentStack.removeAt(indentStack.lastIndex)
				dedents++
			}
			if (indent.isEmpty()) {
				return List(dedents) { FutureToken(LibglocalElements.T_INDENT_DEDENT, 0) } +
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
					lexer.nextState = SEPARATOR
					return listOf(FutureToken(LibglocalElements.K_BASE_LANG, match.value.length))
				}
				match = LexerPatterns.LANG.find(buffer)
				if (match != null) {
					lexer.expectedIdentifiers = 1
					lexer.nextState = SEPARATOR
					return listOf(FutureToken(LibglocalElements.K_LANG, match.value.length))
				}
				match = LexerPatterns.AUTHOR.find(buffer)
				if (match != null) {
					lexer.nextState = SEPARATOR
					return listOf(FutureToken(LibglocalElements.K_AUTHOR, match.value.length))
				}
				match = LexerPatterns.VERSION.find(buffer)
				if (match != null) {
					lexer.expectedIdentifiers = 1
					lexer.nextState = SEPARATOR
					return listOf(FutureToken(LibglocalElements.K_VERSION, match.value.length))
				}
				match = LexerPatterns.REQUIRE.find(buffer)
				if (match != null) {
					lexer.expectedIdentifiers = 1
					lexer.nextState = SEPARATOR
					return listOf(FutureToken(LibglocalElements.K_REQUIRE, match.value.length))
				}
				match = LexerPatterns.MESSAGES.find(buffer)
				if (match != null) {
					lexer.expectedIdentifiers = 1
					lexer.nextState = SEPARATOR
					lexer.reachedMessages = true
					return listOf(FutureToken(LibglocalElements.K_MESSAGES, match.value.length))
				}

				return LibglocalLexer.badToken()
			} else {
				if (buffer[0] == '$') {
					val argToken = FutureToken(LibglocalElements.T_MODIFIER_ARG, 1)
					val (white, _) = LibglocalLexer.readWhitespace(buffer.subSequence(1, buffer.length))
					lexer.expectedIdentifiers = 2
					lexer.nextState = IDENTIFIER
					return if (white.isNotEmpty())
						listOf(argToken, FutureToken(TokenType.WHITE_SPACE, white.length))
					else
						listOf(argToken)
				}
				if (buffer[0] == '*') {
					val argToken = FutureToken(LibglocalElements.T_MODIFIER_DOC, 1)
					val (white, _) = LibglocalLexer.readWhitespace(buffer.subSequence(1, buffer.length))
					lexer.nextState = LITERAL
					return if (white.isNotEmpty())
						listOf(argToken, FutureToken(TokenType.WHITE_SPACE, white.length))
					else
						listOf(argToken)
				}
				if (buffer[0] == '~') {
					val argToken = FutureToken(LibglocalElements.T_MODIFIER_VERSION, 1)
					val (white, _) = LibglocalLexer.readWhitespace(buffer.subSequence(1, buffer.length))
					lexer.expectedIdentifiers = 1
					lexer.nextState = IDENTIFIER
					return if (white.isNotEmpty())
						listOf(argToken, FutureToken(TokenType.WHITE_SPACE, white.length))
					else
						listOf(argToken)
				}

				val (list, read, _) = LibglocalLexer.readIdentifier(buffer)
				if (read) lexer.nextState = SEPARATOR
				return list
			}
		}
	},

	SEPARATOR {
		override fun advance(lexer: LibglocalLexer, buffer: CharSequence): List<FutureToken> {
			val (white, rem) = LibglocalLexer.readWhitespace(buffer)

			if (rem.startsWith("\r\n") || rem[0] == '\n') {
				lexer.nextState = LINE_START
				return listOf(FutureToken(LibglocalElements.T_EOL, white.length + (if (rem[0] == '\r') 2 else 1)))
			}
			if (white.isEmpty()) {
				return LibglocalLexer.badToken()
			}

			lexer.nextState = if (lexer.expectedIdentifiers > 0) IDENTIFIER else LITERAL
			return listOf(FutureToken(TokenType.WHITE_SPACE, white.length))
		}
	},

	IDENTIFIER {
		override fun advance(lexer: LibglocalLexer, buffer: CharSequence): List<FutureToken> {
			val (list, read, _) = LibglocalLexer.readIdentifier(buffer)
			if (read) {
				lexer.expectedIdentifiers--
				lexer.nextState = SEPARATOR
			}
			return list
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
					lexer.nextState = LINE_START
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

					lexer.nextState = ARG_REF_NAME
					return listOf(FutureToken(LibglocalElements.T_ARG_REF_START, 2))
				}

				if (buffer[0] == '#') {
					if (buffer.length == 1 || buffer[1] != '{') {
						return listOf(FutureToken(LibglocalElements.T_LITERAL_STRING, 1))
					}

					lexer.nextState = MESSAGE_REF_NAME
					return listOf(FutureToken(LibglocalElements.T_MESSAGE_REF_START, 2))
				}

				if (buffer[0] == '%') {
					if (buffer.length == 1 || buffer[1] != '{') {
						return listOf(FutureToken(LibglocalElements.T_LITERAL_STRING, 1))
					}

					lexer.nextState = SPAN_NAME
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

			val (list, read, _) = LibglocalLexer.readIdentifier(buffer)
			if (read) lexer.nextState = CLOSE_TO_LITERAL
			return list
		}
	},

	MESSAGE_REF_NAME {
		override fun advance(lexer: LibglocalLexer, buffer: CharSequence): List<FutureToken> {
			val (white, _) = LibglocalLexer.readWhitespace(buffer)
			if (white.isNotEmpty()) return listOf(FutureToken(TokenType.WHITE_SPACE, white.length))

			if (buffer[0] == '$') return listOf(FutureToken(LibglocalElements.T_DYNAMIC, 1))

			val (list, read, _) = LibglocalLexer.readIdentifier(buffer)
			if (read) lexer.nextState = ARG_LIST_RESET
			return list
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

			return LibglocalLexer.readIdentifier(buffer).list
		}
	},
	ARG_LIST_VALUE {
		override fun advance(lexer: LibglocalLexer, buffer: CharSequence): List<FutureToken> {
			val (white, _) = LibglocalLexer.readWhitespace(buffer, charArrayOf(' ', '\t', '\r', '\n'))
			if (white.isNotEmpty()) return listOf(FutureToken(TokenType.WHITE_SPACE, white.length))

			val match = LexerPatterns.NUMBER.find(buffer)
			if (match != null) {
				lexer.nextState = ARG_LIST_RESET
				return listOf(FutureToken(LibglocalElements.T_NUMBER, match.value.length))
			}

			if (true) {
				val (list, read, err) = LibglocalLexer.readIdentifier(buffer)
				if (!err) {
					if (read) lexer.nextState = ARG_LIST_RESET
					return list
				}
			}

			if (buffer[0] == '{') {
				lexer.nextState = LITERAL
				return listOf(FutureToken(LibglocalElements.T_OPEN_BRACE, 1))
			}

			return LibglocalLexer.badToken()
		}
	},

	SPAN_NAME {
		override fun advance(lexer: LibglocalLexer, buffer: CharSequence): List<FutureToken> {
			val (white, _) = LibglocalLexer.readWhitespace(buffer)
			if (white.isNotEmpty()) return listOf(FutureToken(TokenType.WHITE_SPACE, white.length))

			val (list, read, _) = LibglocalLexer.readIdentifier(buffer, LibglocalElements.T_SPAN_TYPE)
			if (read) {
				lexer.expectedIdentifiers = 0
				lexer.nextState = SEPARATOR
			}
			return list
		}
	},

	CLOSE_TO_LITERAL {
		override fun advance(lexer: LibglocalLexer, buffer: CharSequence): List<FutureToken> {
			val (white, _) = LibglocalLexer.readWhitespace(buffer)
			if (white.isNotEmpty()) return listOf(FutureToken(TokenType.WHITE_SPACE, white.length))

			if (buffer[0] != '}') {
				return LibglocalLexer.badToken()
			}

			lexer.nextState = LITERAL
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
	val REQUIRE = Regex("^require\\b")
	val MESSAGES = Regex("^messages\\b")
	val IDENTIFIER = Regex("^[A-Za-z0-9_\\-\\.]+")
	val NUMBER = Regex("^-?[0-9]+(\\.[0-9]+)?")
}
