// This is a generated file. Not intended for manual editing.
package io.github.sof3.libglocal.idea.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface LgcRequire extends LgcBlockElement {

  @NotNull
  LgcRequireTarget getRequireTarget();

  @NotNull
  LgcFile getFile();

  @NotNull
  List<LgcBlockElement> getChildBlocks();

  String getName();

}
