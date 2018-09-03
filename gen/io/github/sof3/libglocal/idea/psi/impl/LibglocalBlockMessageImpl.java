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
import com.intellij.navigation.ItemPresentation;

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
  public List<LibglocalBlockModifier> getBlockModifierList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LibglocalBlockModifier.class);
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

  @NotNull
  public List<LibglocalBlockElement> getChildBlocks() {
    return Utils.getChildBlocks(this);
  }

  @NotNull
  public List<LibglocalBlockModifier> getModifiers() {
    return Utils.getModifiers(this);
  }

  @Nullable
  public String getName() {
    return Utils.getName(this);
  }

  @NotNull
  public String getFullName() {
    return Utils.getFullName(this);
  }

  @NotNull
  public ItemPresentation getPresentation() {
    return Utils.getPresentation(this);
  }

}
