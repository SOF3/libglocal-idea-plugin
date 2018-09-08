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

public class LgcLangImpl extends ASTWrapperPsiElement implements LgcLang {

  public LgcLangImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull LgcVisitor visitor) {
    visitor.visitLang(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LgcVisitor) accept((LgcVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public LgcLangId getLangId() {
    return findNotNullChildByClass(LgcLangId.class);
  }

  @Override
  @NotNull
  public LgcLangName getLangName() {
    return findNotNullChildByClass(LgcLangName.class);
  }

  @NotNull
  public List<LgcBlockElement> getChildBlocks() {
    return Utils.getChildBlocks(this);
  }

  @NotNull
  public String getName() {
    return Utils.getName(this);
  }

}
