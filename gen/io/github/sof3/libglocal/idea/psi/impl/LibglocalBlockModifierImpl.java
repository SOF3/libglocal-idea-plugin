// This is a generated file. Not intended for manual editing.
package io.github.sof3.libglocal.idea.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static io.github.sof3.libglocal.idea.psi.LibglocalElements.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import io.github.sof3.libglocal.idea.psi.*;

public class LibglocalBlockModifierImpl extends ASTWrapperPsiElement implements LibglocalBlockModifier {

  public LibglocalBlockModifierImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull LibglocalVisitor visitor) {
    visitor.visitBlockModifier(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LibglocalVisitor) accept((LibglocalVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<LibglocalBlockConstraint> getBlockConstraintList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LibglocalBlockConstraint.class);
  }

  @Override
  @Nullable
  public LibglocalElementModifierArg getElementModifierArg() {
    return findChildByClass(LibglocalElementModifierArg.class);
  }

  @Override
  @Nullable
  public LibglocalElementModifierDoc getElementModifierDoc() {
    return findChildByClass(LibglocalElementModifierDoc.class);
  }

  @Override
  @Nullable
  public LibglocalElementModifierVersion getElementModifierVersion() {
    return findChildByClass(LibglocalElementModifierVersion.class);
  }

}
