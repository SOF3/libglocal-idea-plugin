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
  public List<LibglocalBlockConstraint> getBlockConstraintList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LibglocalBlockConstraint.class);
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
  public List<LibglocalElementModifierArg> getElementModifierArgList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LibglocalElementModifierArg.class);
  }

  @Override
  @NotNull
  public List<LibglocalElementModifierDoc> getElementModifierDocList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LibglocalElementModifierDoc.class);
  }

  @Override
  @NotNull
  public List<LibglocalElementModifierVersion> getElementModifierVersionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LibglocalElementModifierVersion.class);
  }

  @NotNull
  public List<LibglocalModifierBlock> getModifiers() {
    return Utils.getModifiers(this);
  }

  @NotNull
  public List<LibglocalBlockElement> getChildBlocks() {
    return Utils.getChildBlocks(this);
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
