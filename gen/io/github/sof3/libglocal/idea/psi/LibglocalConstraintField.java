// This is a generated file. Not intended for manual editing.
package io.github.sof3.libglocal.idea.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface LibglocalConstraintField extends LibglocalConstraintBlock {

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
  List<LibglocalBlockElement> getChildBlocks();

  String getName();

  @NotNull
  String getType();

  //WARNING: getPresentation(...) is skipped
  //matching getPresentation(LibglocalConstraintField, ...)
  //methods are not found in Utils

}
