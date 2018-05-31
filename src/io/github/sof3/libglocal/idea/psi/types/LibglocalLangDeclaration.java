package io.github.sof3.libglocal.idea.psi.types;

import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;

public class LibglocalLangDeclaration extends LibglocalElement{
	public LibglocalLangDeclaration(@NotNull ASTNode node){
		super(node);
	}

	public boolean isBase(){
		return getNode().findChildByType(BASE_KEYWORD) != null;
	}
}
