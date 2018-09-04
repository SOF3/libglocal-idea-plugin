// This is a generated file. Not intended for manual editing.
package io.github.sof3.libglocal.idea.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.navigation.ItemPresentation;

public interface LibglocalBlockMessage extends LibglocalNamedBlockElement {

  @NotNull
  List<LibglocalBlockConstraint> getBlockConstraintList();

  @NotNull
  LibglocalElementLiteral getElementLiteral();

  @NotNull
  LibglocalElementMessageId getElementMessageId();

  @NotNull
  List<LibglocalElementModifierArg> getElementModifierArgList();

  @NotNull
  List<LibglocalElementModifierDoc> getElementModifierDocList();

  @NotNull
  List<LibglocalElementModifierVersion> getElementModifierVersionList();

  @NotNull
  List<LibglocalModifierBlock> getModifiers();

  @NotNull
  List<LibglocalBlockElement> getChildBlocks();

  @Nullable
  String getName();

  @NotNull
  String getFullName();

  @NotNull
  ItemPresentation getPresentation();

}
