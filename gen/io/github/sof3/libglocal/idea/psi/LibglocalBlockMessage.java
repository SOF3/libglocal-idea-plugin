// This is a generated file. Not intended for manual editing.
package io.github.sof3.libglocal.idea.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.navigation.ItemPresentation;

public interface LibglocalBlockMessage extends LibglocalBlockElement {

  @NotNull
  List<LibglocalBlockModifier> getBlockModifierList();

  @NotNull
  LibglocalElementLiteral getElementLiteral();

  @NotNull
  LibglocalElementMessageId getElementMessageId();

  @NotNull
  List<LibglocalBlockElement> getChildBlocks();

  @NotNull
  List<LibglocalBlockModifier> getModifiers();

  @Nullable
  String getName();

  @NotNull
  String getFullName();

  @NotNull
  ItemPresentation getPresentation();

}
