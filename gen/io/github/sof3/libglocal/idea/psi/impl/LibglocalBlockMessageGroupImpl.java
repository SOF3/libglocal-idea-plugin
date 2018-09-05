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
import com.intellij.ide.projectView.PresentationData;

public class LibglocalBlockMessageGroupImpl extends ASTWrapperPsiElement implements LibglocalBlockMessageGroup {

  public LibglocalBlockMessageGroupImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull LibglocalVisitor visitor) {
    visitor.visitBlockMessageGroup(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LibglocalVisitor) accept((LibglocalVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<LibglocalBlockMessage> getBlockMessageList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LibglocalBlockMessage.class);
  }

  @Override
  @NotNull
  public List<LibglocalBlockMessageGroup> getBlockMessageGroupList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LibglocalBlockMessageGroup.class);
  }

  @Override
  @NotNull
  public LibglocalElementMessageId getElementMessageId() {
    return notNullChild(PsiTreeUtil.getChildOfType(this, LibglocalElementMessageId.class));
  }

  @NotNull
  public List<LibglocalBlockElement> getChildBlocks() {
    return Utils.getChildBlocks(this);
  }

  @NotNull
  public List<LibglocalBlockMessage> getMessages() {
    return Utils.getMessages(this);
  }

  @NotNull
  public String getName() {
    return Utils.getName(this);
  }

  @NotNull
  public String getFullName() {
    return Utils.getFullName(this);
  }

  @NotNull
  public PresentationData getPresentation() {
    return Utils.getPresentation(this);
  }

}
