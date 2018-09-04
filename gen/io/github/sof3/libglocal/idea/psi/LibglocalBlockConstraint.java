// This is a generated file. Not intended for manual editing.
package io.github.sof3.libglocal.idea.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface LibglocalBlockConstraint extends LibglocalBlockElement {

  @NotNull
  List<LibglocalBlockConstraint> getBlockConstraintList();

  @Nullable
  LibglocalElementLiteralStatic getElementLiteralStatic();

  @NotNull
  List<LibglocalBlockElement> getChildBlocks();

}
