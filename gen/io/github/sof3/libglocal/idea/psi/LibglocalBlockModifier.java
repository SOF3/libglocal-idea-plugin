// This is a generated file. Not intended for manual editing.
package io.github.sof3.libglocal.idea.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface LibglocalBlockModifier extends LibglocalBlockElement {

  @NotNull
  List<LibglocalBlockConstraint> getBlockConstraintList();

  @Nullable
  LibglocalElementModifierArg getElementModifierArg();

  @Nullable
  LibglocalElementModifierDoc getElementModifierDoc();

  @Nullable
  LibglocalElementModifierVersion getElementModifierVersion();

  @NotNull
  List<LibglocalBlockElement> getChildBlocks();

  @NotNull
  List<LibglocalBlockConstraint> getConstraints();

}
