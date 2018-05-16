package io.github.sof3.libglocal.idea.psi;

import com.intellij.psi.tree.IElementType;
import io.github.sof3.libglocal.idea.lang.LibglocalLanguage;
import org.jetbrains.annotations.NotNull;

public class LibglocalTokenType extends IElementType{
	public LibglocalTokenType(@NotNull String debugName){
		super(debugName, LibglocalLanguage.getInstance());
	}

	@Override
	public String toString(){
		String s = super.toString();
		if(s.endsWith("_KEYWORD")){
			return '\'' + s.substring(0, s.length() - 8).toLowerCase() + '\'';
		}
		return s;
	}
}
