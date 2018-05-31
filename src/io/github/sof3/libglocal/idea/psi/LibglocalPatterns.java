package io.github.sof3.libglocal.idea.psi;

import com.intellij.patterns.PlatformPatterns;
import com.intellij.patterns.PsiElementPattern;
import io.github.sof3.libglocal.idea.psi.types.LibglocalElement;

public class LibglocalPatterns extends PlatformPatterns{
	public static PsiElementPattern mPsiElement(){
		return new LibglocalElementPattern(LibglocalElement.class);
	}

	private static class LibglocalElementPattern extends PsiElementPattern<LibglocalElement, LibglocalElementPattern>{
		public LibglocalElementPattern(Class<LibglocalElement> aClass){
			super(aClass);
		}
	}
}
