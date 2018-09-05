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

public class LibglocalConstraintFieldImpl extends ASTWrapperPsiElement implements LibglocalConstraintField {

  public LibglocalConstraintFieldImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull LibglocalVisitor visitor) {
    visitor.visitConstraintField(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LibglocalVisitor) accept((LibglocalVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<LibglocalConstraintDelim> getConstraintDelimList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LibglocalConstraintDelim.class);
  }

  @Override
  @NotNull
  public List<LibglocalConstraintDoc> getConstraintDocList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LibglocalConstraintDoc.class);
  }

  @Override
  @NotNull
  public List<LibglocalConstraintField> getConstraintFieldList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LibglocalConstraintField.class);
  }

  @Override
  @Nullable
  public LibglocalElementArgDefault getElementArgDefault() {
    return findChildByClass(LibglocalElementArgDefault.class);
  }

  @Override
  @NotNull
  public LibglocalElementArgName getElementArgName() {
    return findNotNullChildByClass(LibglocalElementArgName.class);
  }

  @Override
  @Nullable
  public LibglocalElementArgType getElementArgType() {
    return findChildByClass(LibglocalElementArgType.class);
  }

  @NotNull
  public List<LibglocalBlockElement> getChildBlocks() {
    return Utils.getChildBlocks(this);
  }

  public String getName() {
    return Utils.getName(this);
  }

  @NotNull
  public String getType() {
    return Utils.getType(this);
  }

}
