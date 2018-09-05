// This is a generated file. Not intended for manual editing.
package io.github.sof3.libglocal.idea.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static io.github.sof3.libglocal.idea.psi.LibglocalElements.*;
import com.intellij.extapi.psi.StubBasedPsiElementBase;
import io.github.sof3.libglocal.idea.psi.MessageStub;
import io.github.sof3.libglocal.idea.psi.*;
import com.intellij.navigation.ItemPresentation;
import io.github.sof3.libglocal.idea.MessageVisibility;
import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.tree.IElementType;

public class LibglocalBlockMessageImpl extends StubBasedPsiElementBase<MessageStub> implements LibglocalBlockMessage {

  public LibglocalBlockMessageImpl(@NotNull MessageStub stub, @NotNull IStubElementType type) {
    super(stub, type);
  }

  public LibglocalBlockMessageImpl(@NotNull ASTNode node) {
    super(node);
  }

  public LibglocalBlockMessageImpl(MessageStub stub, IElementType type, ASTNode node) {
    super(stub, type, node);
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
    return notNullChild(PsiTreeUtil.getChildOfType(this, LibglocalElementLiteral.class));
  }

  @Override
  @NotNull
  public LibglocalElementMessageId getElementMessageId() {
    return notNullChild(PsiTreeUtil.getChildOfType(this, LibglocalElementMessageId.class));
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

  @NotNull
  public List<LibglocalModifierBlock> getModifiers() {
    return Utils.getModifiers(this);
  }

  @NotNull
  public List<LibglocalBlockElement> getChildBlocks() {
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
