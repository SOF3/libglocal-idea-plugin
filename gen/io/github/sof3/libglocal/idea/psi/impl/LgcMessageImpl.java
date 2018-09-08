// This is a generated file. Not intended for manual editing.
package io.github.sof3.libglocal.idea.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static io.github.sof3.libglocal.idea.parser.LgcElements.*;
import com.intellij.extapi.psi.StubBasedPsiElementBase;
import io.github.sof3.libglocal.idea.psi.LgcMessageStub;
import io.github.sof3.libglocal.idea.psi.*;
import com.intellij.navigation.ItemPresentation;
import io.github.sof3.libglocal.idea.libglocal.MessageVisibility;
import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.tree.IElementType;

public class LgcMessageImpl extends StubBasedPsiElementBase<LgcMessageStub> implements LgcMessage {

  public LgcMessageImpl(@NotNull LgcMessageStub stub, @NotNull IStubElementType type) {
    super(stub, type);
  }

  public LgcMessageImpl(@NotNull ASTNode node) {
    super(node);
  }

  public LgcMessageImpl(LgcMessageStub stub, IElementType type, ASTNode node) {
    super(stub, type, node);
  }

  public void accept(@NotNull LgcVisitor visitor) {
    visitor.visitMessage(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LgcVisitor) accept((LgcVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<LgcArgModifier> getArgModifierList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LgcArgModifier.class);
  }

  @Override
  @NotNull
  public List<LgcDocModifier> getDocModifierList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LgcDocModifier.class);
  }

  @Override
  @NotNull
  public LgcLiteral getLiteral() {
    return notNullChild(PsiTreeUtil.getChildOfType(this, LgcLiteral.class));
  }

  @Override
  @NotNull
  public List<LgcMessageFlag> getMessageFlagList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LgcMessageFlag.class);
  }

  @Override
  @NotNull
  public LgcMessageId getMessageId() {
    return notNullChild(PsiTreeUtil.getChildOfType(this, LgcMessageId.class));
  }

  @Override
  @NotNull
  public List<LgcVersionModifier> getVersionModifierList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LgcVersionModifier.class);
  }

  @NotNull
  public LgcFile getFile() {
    return Utils.getFile(this);
  }

  @NotNull
  public List<LgcModifierBlock> getModifiers() {
    return Utils.getModifiers(this);
  }

  @NotNull
  public List<LgcBlockElement> getChildBlocks() {
    return Utils.getChildBlocks(this);
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
  public MessageVisibility getVisibility() {
    return Utils.getVisibility(this);
  }

  @NotNull
  public ItemPresentation getPresentation() {
    return Utils.getPresentation(this);
  }

}
