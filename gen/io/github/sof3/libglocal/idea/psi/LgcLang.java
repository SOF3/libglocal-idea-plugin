// This is a generated file. Not intended for manual editing.
package io.github.sof3.libglocal.idea.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface LgcLang extends LgcBlockElement {

  @NotNull
  LgcLangId getLangId();

  @NotNull
  LgcLangName getLangName();

  @NotNull
  LgcFile getFile();

  @NotNull
  List<LgcBlockElement> getChildBlocks();

  @NotNull
  String getName();

}
