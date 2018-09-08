// This is a generated file. Not intended for manual editing.
package io.github.sof3.libglocal.idea.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface LgcLiteral extends PsiElement {

  @NotNull
  List<LgcArgRef> getArgRefList();

  @NotNull
  List<LgcMessageRef> getMessageRefList();

  @NotNull
  List<LgcSpan> getSpanList();

}
