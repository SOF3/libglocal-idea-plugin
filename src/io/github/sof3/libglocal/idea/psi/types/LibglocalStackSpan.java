package io.github.sof3.libglocal.idea.psi.types;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;

public class LibglocalStackSpan extends LibglocalElement{
	public LibglocalStackSpan(ASTNode node){
		super(node);
	}

	public String getStackName(){
		PsiElement child = findChildByType(SPAN_NAME);
		return child != null ? child.getText().toLowerCase() : null;
	}

	public LibglocalMessageValue getMessageValue(){
		return findChildByType(MESSAGE_VALUE);
	}
}
