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

public class LibglocalElementArgDefaultImpl extends ASTWrapperPsiElement implements LibglocalElementArgDefault {

  public LibglocalElementArgDefaultImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull LibglocalVisitor visitor) {
    visitor.visitElementArgDefault(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LibglocalVisitor) accept((LibglocalVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public LibglocalElementLiteral getElementLiteral() {
    return findNotNullChildByClass(LibglocalElementLiteral.class);
  }

}
