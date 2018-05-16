package io.github.sof3.libglocal.idea.psi.types;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import io.github.sof3.libglocal.idea.psi.LibglocalTypes;
import org.jetbrains.annotations.NotNull;

public abstract class LibglocalElement extends ASTWrapperPsiElement implements PsiElement, LibglocalTypes{
	public LibglocalElement(@NotNull ASTNode node){
		super(node);
	}
}
