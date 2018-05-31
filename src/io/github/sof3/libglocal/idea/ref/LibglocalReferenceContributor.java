package io.github.sof3.libglocal.idea.ref;

import com.intellij.lang.ASTNode;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.*;
import com.intellij.util.ProcessingContext;
import io.github.sof3.libglocal.idea.psi.LibglocalTokens;
import io.github.sof3.libglocal.idea.psi.types.LibglocalMessageRef;
import org.jetbrains.annotations.NotNull;

public class LibglocalReferenceContributor extends PsiReferenceContributor{
	@Override
	public void registerReferenceProviders(@NotNull PsiReferenceRegistrar registrar){
		System.out.println("Registered referenceProvider");
		registrar.registerReferenceProvider(PlatformPatterns.psiElement(), new PsiReferenceProvider(){
			@NotNull
			@Override
			public PsiReference[] getReferencesByElement(@NotNull PsiElement element, @NotNull ProcessingContext context){
				System.out.println("Finding references of " + element + ": " + element.getText());
				if(!(element.getParent() instanceof LibglocalMessageRef)){
					return PsiReference.EMPTY_ARRAY;
				}
				ASTNode id = element.getNode().findChildByType(LibglocalTokens.MESSAGE_ID);
				if(id != null){
					return new PsiReference[]{
							new LibglocalMessageReference(element, id.getTextRange()),
					};
				}
				return PsiReference.EMPTY_ARRAY;
			}
		});
	}
}
