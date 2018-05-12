// This is a generated file. Not intended for manual editing.
package io.github.sof3.libglocal.idea.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static io.github.sof3.libglocal.idea.LibglocalTokens.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import io.github.sof3.libglocal.idea.psi.*;

public class LibglocalEntryModifierImpl extends ASTWrapperPsiElement implements LibglocalEntryModifier {

  public LibglocalEntryModifierImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull LibglocalVisitor visitor) {
    visitor.visitEntryModifier(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LibglocalVisitor) accept((LibglocalVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public LibglocalArgModifier getArgModifier() {
    return findChildByClass(LibglocalArgModifier.class);
  }

  @Override
  @Nullable
  public LibglocalDocModifier getDocModifier() {
    return findChildByClass(LibglocalDocModifier.class);
  }

  @Override
  @Nullable
  public LibglocalSinceModifier getSinceModifier() {
    return findChildByClass(LibglocalSinceModifier.class);
  }

  @Override
  @Nullable
  public LibglocalUpdatedModifier getUpdatedModifier() {
    return findChildByClass(LibglocalUpdatedModifier.class);
  }

}
