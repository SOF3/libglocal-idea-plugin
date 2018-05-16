package io.github.sof3.libglocal.idea.psi;

import com.intellij.psi.tree.IElementType;
import io.github.sof3.libglocal.idea.lang.LibglocalLanguage;
import org.jetbrains.annotations.NotNull;

public class LibglocalElementType extends IElementType{
	public LibglocalElementType(@NotNull String debugName){
		super(debugName, LibglocalLanguage.getInstance());
	}
}
