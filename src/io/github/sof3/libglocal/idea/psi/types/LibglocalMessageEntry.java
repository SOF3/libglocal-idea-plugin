package io.github.sof3.libglocal.idea.psi.types;

import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;

public class LibglocalMessageEntry extends LibglocalMessageGroupOrEntry{
	public LibglocalMessageEntry(@NotNull ASTNode node){
		super(node);
	}
}
