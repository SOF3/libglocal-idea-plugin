package io.github.sof3.libglocal.idea.psi.types;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

public abstract class LibglocalElement extends ASTWrapperPsiElement implements PsiElement{
	public LibglocalElement(@NotNull ASTNode node){
		super(node);
	}
}
