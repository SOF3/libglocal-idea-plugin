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
import com.intellij.navigation.ItemPresentation;

public class LgcArgModifierImpl extends ASTWrapperPsiElement implements LgcArgModifier {

  public LgcArgModifierImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull LgcVisitor visitor) {
    visitor.visitArgModifier(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LgcVisitor) accept((LgcVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public LgcArgDefault getArgDefault() {
    return PsiTreeUtil.getChildOfType(this, LgcArgDefault.class);
  }

  @Override
  @NotNull
  public LgcArgName getArgName() {
    return notNullChild(PsiTreeUtil.getChildOfType(this, LgcArgName.class));
  }

  @Override
  @Nullable
  public LgcArgType getArgType() {
    return PsiTreeUtil.getChildOfType(this, LgcArgType.class);
  }

  @Override
  @NotNull
  public List<LgcDelimConstraint> getDelimConstraintList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LgcDelimConstraint.class);
  }

  @Override
  @NotNull
  public List<LgcDocConstraint> getDocConstraintList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LgcDocConstraint.class);
  }

  @Override
  @NotNull
  public List<LgcFieldConstraint> getFieldConstraintList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LgcFieldConstraint.class);
  }

  @NotNull
  public LgcFile getFile() {
    return Utils.getFile(this);
  }

  @NotNull
  public List<LgcConstraintBlock> getConstraints() {
    return Utils.getConstraints(this);
  }

  @NotNull
  public List<LgcBlockElement> getChildBlocks() {
    return Utils.getChildBlocks(this);
  }

  public String getName() {
    return Utils.getName(this);
  }

  @NotNull
  public String getType() {
    return Utils.getType(this);
  }

  @NotNull
  public ItemPresentation getPresentation() {
    return Utils.getPresentation(this);
  }

}
