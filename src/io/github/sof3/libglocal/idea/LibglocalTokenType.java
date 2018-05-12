package io.github.sof3.libglocal.idea;

import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

public class LibglocalTokenType extends IElementType{
	public LibglocalTokenType(@NotNull String debugName){
		super(debugName, LibglocalLanguage.getInstance());
	}
}
