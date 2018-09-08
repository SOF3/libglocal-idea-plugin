// This is a generated file. Not intended for manual editing.
package io.github.sof3.libglocal.idea.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static io.github.sof3.libglocal.idea.parser.LibglocalElements.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import io.github.sof3.libglocal.idea.psi.*;

public class LibglocalBlockMessageImpl extends ASTWrapperPsiElement implements LibglocalBlockMessage {

  public LibglocalBlockMessageImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull LibglocalVisitor visitor) {
    visitor.visitBlockMessage(this);
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

  @Override
  @NotNull
  public LibglocalElementMessageId getElementMessageId() {
    return findNotNullChildByClass(LibglocalElementMessageId.class);
  }

  @Override
  @NotNull
  public List<LibglocalModifierArg> getModifierArgList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LibglocalModifierArg.class);
  }

  @Override
  @NotNull
  public List<LibglocalModifierDoc> getModifierDocList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LibglocalModifierDoc.class);
  }

  @Override
  @NotNull
  public List<LibglocalModifierVersion> getModifierVersionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LibglocalModifierVersion.class);
  }

}
