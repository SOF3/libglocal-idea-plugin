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

public class LibglocalElementLiteralImpl extends ASTWrapperPsiElement implements LibglocalElementLiteral {

  public LibglocalElementLiteralImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull LibglocalVisitor visitor) {
    visitor.visitElementLiteral(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LibglocalVisitor) accept((LibglocalVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<LibglocalElementArgRef> getElementArgRefList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LibglocalElementArgRef.class);
  }

  @Override
  @NotNull
  public List<LibglocalElementMessageRef> getElementMessageRefList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LibglocalElementMessageRef.class);
  }

  @Override
  @NotNull
  public List<LibglocalElementSpan> getElementSpanList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LibglocalElementSpan.class);
  }

}
