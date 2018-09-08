// This is a generated file. Not intended for manual editing.
package io.github.sof3.libglocal.idea.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

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

  //WARNING: getConstraints(...) is skipped
  //matching getConstraints(LibglocalModifierArg, ...)
  //methods are not found in Utils

  //WARNING: getChildBlocks(...) is skipped
  //matching getChildBlocks(LibglocalModifierArg, ...)
  //methods are not found in Utils

  //WARNING: getName(...) is skipped
  //matching getName(LibglocalModifierArg, ...)
  //methods are not found in Utils

  //WARNING: getType(...) is skipped
  //matching getType(LibglocalModifierArg, ...)
  //methods are not found in Utils

  //WARNING: getPresentation(...) is skipped
  //matching getPresentation(LibglocalModifierArg, ...)
  //methods are not found in Utils

}
