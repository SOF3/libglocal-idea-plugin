package io.github.sof3.libglocal.idea.psi.types;

import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;

public class LibglocalMessageGroup extends LibglocalMessageGroupOrEntry{
	public LibglocalMessageGroup(@NotNull ASTNode node){
		super(node);
	}
}
