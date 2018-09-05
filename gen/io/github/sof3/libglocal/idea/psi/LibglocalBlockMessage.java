// This is a generated file. Not intended for manual editing.
package io.github.sof3.libglocal.idea.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.navigation.ItemPresentation;

public interface LibglocalBlockMessage extends LibglocalBlockElement {

  @NotNull
  LibglocalElementLiteral getElementLiteral();

  @NotNull
  LibglocalElementMessageId getElementMessageId();

  @NotNull
  List<LibglocalModifierArg> getModifierArgList();

  @NotNull
  List<LibglocalModifierDoc> getModifierDocList();

  @NotNull
  List<LibglocalModifierVersion> getModifierVersionList();

  @NotNull
  List<LibglocalModifierBlock> getModifiers();

  @NotNull
  List<LibglocalBlockElement> getChildBlocks();

  @NotNull
  String getName();

  @NotNull
  String getFullName();

  @NotNull
  ItemPresentation getPresentation();

}
