package io.github.sof3.libglocal.idea.psi.types;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiNamedElement;
import org.jetbrains.annotations.NotNull;

public abstract class LibglocalNamedElement extends LibglocalElement implements PsiNamedElement{
	public LibglocalNamedElement(@NotNull ASTNode node){
		super(node);
	}
}
