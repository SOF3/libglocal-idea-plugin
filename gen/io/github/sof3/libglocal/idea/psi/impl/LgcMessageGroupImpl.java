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
import com.intellij.ide.projectView.PresentationData;

public class LgcMessageGroupImpl extends ASTWrapperPsiElement implements LgcMessageGroup {

  public LgcMessageGroupImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull LgcVisitor visitor) {
    visitor.visitMessageGroup(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LgcVisitor) accept((LgcVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<LgcMessage> getMessageList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LgcMessage.class);
  }

  @Override
  @NotNull
  public List<LgcMessageGroup> getMessageGroupList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LgcMessageGroup.class);
  }

  @Override
  @NotNull
  public LgcMessageId getMessageId() {
    return notNullChild(PsiTreeUtil.getChildOfType(this, LgcMessageId.class));
  }

  @NotNull
  public LgcFile getFile() {
    return Utils.getFile(this);
  }

  @NotNull
  public List<LgcBlockElement> getChildBlocks() {
    return Utils.getChildBlocks(this);
  }

  @NotNull
  public List<LgcMessage> getMessages() {
    return Utils.getMessages(this);
  }

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
