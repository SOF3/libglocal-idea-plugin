package io.github.sof3.libglocal.idea.psi.types;

import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;

public class LibglocalStringLiteral extends LibglocalElement{
	public LibglocalStringLiteral(@NotNull ASTNode node){
		super(node);
	}
}
