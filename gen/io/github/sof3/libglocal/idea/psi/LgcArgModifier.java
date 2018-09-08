// This is a generated file. Not intended for manual editing.
package io.github.sof3.libglocal.idea.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.StubBasedPsiElement;
import com.intellij.navigation.ItemPresentation;

public interface LgcArgModifier extends LgcModifierBlock, LgcArgLike, StubBasedPsiElement<LgcArgStub> {

  @Nullable
  LgcArgDefault getArgDefault();

  @NotNull
  LgcArgName getArgName();

  @Nullable
  LgcArgType getArgType();

  @NotNull
  List<LgcDelimConstraint> getDelimConstraintList();

  @NotNull
  List<LgcDocConstraint> getDocConstraintList();

  @NotNull
  List<LgcFieldConstraint> getFieldConstraintList();

  @NotNull
  LgcFile getFile();

  @NotNull
  List<LgcConstraintBlock> getConstraints();

  @NotNull
  List<LgcBlockElement> getChildBlocks();

  String getName();

  @NotNull
  String getType();

  @NotNull
  ItemPresentation getPresentation();

}
