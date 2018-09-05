// This is a generated file. Not intended for manual editing.
package io.github.sof3.libglocal.idea.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.navigation.ItemPresentation;

public interface LibglocalModifierArg extends LibglocalModifierBlock {

  @NotNull
  List<LibglocalConstraintDelim> getConstraintDelimList();

  @NotNull
  List<LibglocalConstraintDoc> getConstraintDocList();

  @NotNull
  List<LibglocalConstraintField> getConstraintFieldList();

  @Nullable
  LibglocalElementArgDefault getElementArgDefault();

  @NotNull
  LibglocalElementArgName getElementArgName();

  @Nullable
  LibglocalElementArgType getElementArgType();

  @NotNull
  List<LibglocalConstraintBlock> getConstraints();

  @NotNull
  List<LibglocalBlockElement> getChildBlocks();

  String getName();

  @NotNull
  String getType();

  @NotNull
  ItemPresentation getPresentation();

}
