// This is a generated file. Not intended for manual editing.
package io.github.sof3.libglocal.idea.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.StubBasedPsiElement;
import com.intellij.navigation.ItemPresentation;
import io.github.sof3.libglocal.idea.libglocal.MessageVisibility;

public interface LgcMessage extends LgcBlockElement, StubBasedPsiElement<LgcMessageStub> {

  @NotNull
  List<LgcArgModifier> getArgModifierList();

  @NotNull
  List<LgcDocModifier> getDocModifierList();

  @NotNull
  LgcLiteral getLiteral();

  @NotNull
  List<LgcMessageFlag> getMessageFlagList();

  @NotNull
  LgcMessageId getMessageId();

  @NotNull
  List<LgcVersionModifier> getVersionModifierList();

  @NotNull
  LgcFile getFile();

  @NotNull
  List<LgcModifierBlock> getModifiers();

  @NotNull
  List<LgcBlockElement> getChildBlocks();

  @NotNull
  String getName();

  @NotNull
  String getFullName();

  @NotNull
  MessageVisibility getVisibility();

  @NotNull
  ItemPresentation getPresentation();

}
