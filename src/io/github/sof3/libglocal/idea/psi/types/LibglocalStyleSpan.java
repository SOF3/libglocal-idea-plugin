package io.github.sof3.libglocal.idea.psi.types;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

public class LibglocalStyleSpan extends LibglocalElement{
	public LibglocalStyleSpan(@NotNull ASTNode node){
		super(node);
	}

	public String getStyle(){
		PsiElement child = findChildByType(SPAN_STYLE);
		return child != null ? child.getText().toLowerCase() : null;
	}
}
