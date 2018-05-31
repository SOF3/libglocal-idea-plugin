package io.github.sof3.libglocal.idea.ref;

import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import io.github.sof3.libglocal.idea.util.LibglocalFinder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LibglocalMessageReference extends PsiReferenceBase<PsiElement> implements PsiPolyVariantReference{
	public LibglocalMessageReference(@NotNull PsiElement element, TextRange rangeInElement){
		super(element, rangeInElement);
	}

	public String getReferencedId(){
		return getRangeInElement().substring(myElement.getText());
	}

	@NotNull
	@Override
	public ResolveResult[] multiResolve(boolean incompleteCode){
		return LibglocalFinder.findPublicMessageDeclarationsByName(myElement.getProject(), getReferencedId())
				.map(PsiElementResolveResult::new)
				.toArray(ResolveResult[]::new)
				;
	}

	@Override
	@Nullable
	public PsiElement resolve(){
		return multiResolve(false)[0].getElement();
	}

	@NotNull
	@Override
	public Object[] getVariants(){
		return new Object[0];
	}
}
