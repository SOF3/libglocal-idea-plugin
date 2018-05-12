package io.github.sof3.libglocal.idea;

import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

public class LibglocalElementType extends IElementType{
	public LibglocalElementType(@NotNull String debugName){
		super(debugName, LibglocalLanguage.getInstance());
	}
}
