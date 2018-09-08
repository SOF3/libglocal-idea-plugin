// This is a generated file. Not intended for manual editing.
package io.github.sof3.libglocal.idea.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface LgcDocModifier extends LgcModifierBlock {

  @Nullable
  LgcDocContent getDocContent();

  @NotNull
  List<LgcConstraintBlock> getConstraints();

  @NotNull
  List<LgcBlockElement> getChildBlocks();

}
