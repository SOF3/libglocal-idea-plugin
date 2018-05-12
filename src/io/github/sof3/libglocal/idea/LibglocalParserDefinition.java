package io.github.sof3.libglocal.idea;

import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import io.github.sof3.libglocal.idea.lang.LibglocalFile;
import org.jetbrains.annotations.NotNull;

public class LibglocalParserDefinition implements ParserDefinition{
	public final static TokenSet COMMENTS = TokenSet.create(LibglocalTokens.BLOCK_COMMENT, LibglocalTokens.LINE_COMMENT);
	public final static TokenSet LITERAL = TokenSet.create(LibglocalTokens.LITERAL);

	@NotNull
	@Override
	public Lexer createLexer(Project project){
		return new LibglocalFlexAdapter();
	}

	@Override
	public PsiParser createParser(Project project){
		return new LibglocalParser();
	}

	@Override
	public IFileElementType getFileNodeType(){
		return LibglocalFile.FILE_ELEMENT_TYPE;
	}

	@NotNull
	@Override
	public TokenSet getCommentTokens(){
		return COMMENTS;
	}

	@NotNull
	@Override
	public TokenSet getStringLiteralElements(){
		return LITERAL;
	}

	@NotNull
	@Override
	public PsiElement createElement(ASTNode node){
		return LibglocalTokens.Factory.createElement(node);
	}

	@Override
	public PsiFile createFile(FileViewProvider viewProvider){
		return new LibglocalFile(viewProvider);
	}

	@Override
	public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode left, ASTNode right){
		return SpaceRequirements.MAY;
	}
}
