package io.github.sof3.libglocal.idea.parser

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IStubFileElementType
import com.intellij.psi.tree.TokenSet
import io.github.sof3.libglocal.idea.LibglocalLanguage
import io.github.sof3.libglocal.idea.psi.LgcFile
import io.github.sof3.libglocal.idea.psi.LgcFileStub

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

class LibglocalParserDefinition : ParserDefinition {
	private val myWhitespaceTokens = TokenSet.create(
			LgcElements.T_EMPTY_LINE,
			TokenType.WHITE_SPACE,
			LgcElements.T_INDENT_INHERIT
	)
	private val myCommentTokens = TokenSet.create(LgcElements.T_COMMENT)
	private val myLiteralElements = TokenSet.create(LgcElements.LITERAL, LgcElements.LITERAL_STATIC)
	private val myFileNodeType = LgcFileElementType()

	override fun createLexer(project: Project?): Lexer = LibglocalLexer(false)

	override fun getWhitespaceTokens() = myWhitespaceTokens

	override fun getCommentTokens() = myCommentTokens

	override fun getStringLiteralElements() = myLiteralElements

	override fun createParser(project: Project?) = LgcParser()

	override fun getFileNodeType() = myFileNodeType

	override fun createFile(viewProvider: FileViewProvider?) = LgcFile(viewProvider!!)

	override fun spaceExistenceTypeBetweenTokens(left: ASTNode?, right: ASTNode?) = ParserDefinition.SpaceRequirements.MUST_NOT

	override fun createElement(node: ASTNode?): PsiElement = LgcElements.Factory.createElement(node)
}

class LgcFileElementType : IStubFileElementType<LgcFileStub>(LibglocalLanguage)
