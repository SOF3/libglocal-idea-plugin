// This is a generated file. Not intended for manual editing.
package io.github.sof3.libglocal.idea.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface LibglocalEntryModifiers extends PsiElement {

  @NotNull
  List<LibglocalArgModifier> getArgModifierList();

  @NotNull
  List<LibglocalDocModifier> getDocModifierList();

  @NotNull
  List<LibglocalSinceModifier> getSinceModifierList();

  @NotNull
  List<LibglocalTerminator> getTerminatorList();

  @NotNull
  List<LibglocalUpdatedModifier> getUpdatedModifierList();

}
