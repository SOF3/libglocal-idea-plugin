package io.github.sof3.libglocal.idea.parser

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import io.github.sof3.libglocal.idea.LibglocalFile
import io.github.sof3.libglocal.idea.LibglocalLanguage
import io.github.sof3.libglocal.idea.psi.LibglocalElements
import io.github.sof3.libglocal.idea.psi.LibglocalParser

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
			LibglocalElements.T_EMPTY_LINE,
			TokenType.WHITE_SPACE,
			LibglocalElements.T_INDENT_INHERIT
	)
	private val myCommentTokens = TokenSet.create(LibglocalElements.T_COMMENT)
	private val myLiteralElements = TokenSet.create(LibglocalElements.ELEMENT_LITERAL)
	private val myFileNodeType = IFileElementType(LibglocalLanguage)

	override fun createLexer(project: Project?): Lexer = LibglocalLexer(false)

	override fun getWhitespaceTokens() = myWhitespaceTokens

	override fun getCommentTokens() = myCommentTokens

	override fun getStringLiteralElements() = myLiteralElements

	override fun createParser(project: Project?) = LibglocalParser()

	override fun getFileNodeType() = myFileNodeType

	override fun createFile(viewProvider: FileViewProvider?) = LibglocalFile(viewProvider!!)

	override fun spaceExistenceTypeBetweenTokens(left: ASTNode?, right: ASTNode?) = ParserDefinition.SpaceRequirements.MUST_NOT

	override fun createElement(node: ASTNode?): PsiElement = LibglocalElements.Factory.createElement(node)
}
