// This is a generated file. Not intended for manual editing.
package io.github.sof3.libglocal.idea.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.navigation.ItemPresentation;

public interface LgcMessage extends LgcBlockElement {

  @NotNull
  List<LgcArgModifier> getArgModifierList();

  @NotNull
  List<LgcDocModifier> getDocModifierList();

  @NotNull
  LgcLiteral getLiteral();

  @NotNull
  LgcMessageId getMessageId();

  @NotNull
  List<LgcVersionModifier> getVersionModifierList();

  @NotNull
  List<LgcModifierBlock> getModifiers();

  @NotNull
  List<LgcBlockElement> getChildBlocks();

  @NotNull
  String getName();

  @NotNull
  String getFullName();

  @NotNull
  ItemPresentation getPresentation();

}
