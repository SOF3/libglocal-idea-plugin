// This is a generated file. Not intended for manual editing.
package io.github.sof3.libglocal.idea.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface LibglocalRequireBlock extends LibglocalBlockElement {

  @NotNull
  LibglocalElementRequireTarget getElementRequireTarget();

  @NotNull
  List<LibglocalBlockElement> getChildBlocks();

  @NotNull
  String getName();

}