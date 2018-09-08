// This is a generated file. Not intended for manual editing.
package io.github.sof3.libglocal.idea.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static io.github.sof3.libglocal.idea.parser.LgcElements.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import io.github.sof3.libglocal.idea.psi.*;

public class LgcLiteralImpl extends ASTWrapperPsiElement implements LgcLiteral {

  public LgcLiteralImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull LgcVisitor visitor) {
    visitor.visitLiteral(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LgcVisitor) accept((LgcVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<LgcArgRef> getArgRefList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LgcArgRef.class);
  }

  @Override
  @NotNull
  public List<LgcMessageRef> getMessageRefList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LgcMessageRef.class);
  }

  @Override
  @NotNull
  public List<LgcSpan> getSpanList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LgcSpan.class);
  }

}
