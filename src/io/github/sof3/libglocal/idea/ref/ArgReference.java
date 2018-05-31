package io.github.sof3.libglocal.idea.ref;

import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiPolyVariantReference;
import com.intellij.psi.PsiReferenceBase;
import com.intellij.psi.ResolveResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ArgReference extends PsiReferenceBase<PsiElement> implements PsiPolyVariantReference{
	public ArgReference(@NotNull PsiElement element, TextRange rangeInElement){
		super(element, rangeInElement);
	}

	@Nullable
	@Override
	public PsiElement resolve(){
		return null;
	}

	@NotNull
	@Override
	public Object[] getVariants(){
		return new Object[0];
	}

	@NotNull
	@Override
	public ResolveResult[] multiResolve(boolean incompleteCode){
		return new ResolveResult[0];
	}
}
