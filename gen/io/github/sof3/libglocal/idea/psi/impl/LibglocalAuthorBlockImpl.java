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

public class LibglocalAuthorBlockImpl extends ASTWrapperPsiElement implements LibglocalAuthorBlock {

  public LibglocalAuthorBlockImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull LibglocalVisitor visitor) {
    visitor.visitAuthorBlock(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LibglocalVisitor) accept((LibglocalVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public LibglocalElementLiteralStatic getElementLiteralStatic() {
    return notNullChild(PsiTreeUtil.getChildOfType(this, LibglocalElementLiteralStatic.class));
  }

  @NotNull
  public List<LibglocalBlockElement> getChildBlocks() {
    return Utils.getChildBlocks(this);
  }

  @NotNull
  public String getName() {
    return Utils.getName(this);
  }

}