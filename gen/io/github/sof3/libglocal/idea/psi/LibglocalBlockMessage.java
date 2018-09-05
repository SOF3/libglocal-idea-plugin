// This is a generated file. Not intended for manual editing.
package io.github.sof3.libglocal.idea.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.StubBasedPsiElement;
import com.intellij.navigation.ItemPresentation;
import io.github.sof3.libglocal.idea.MessageVisibility;

public interface LibglocalBlockMessage extends LibglocalBlockElement, StubBasedPsiElement<MessageStub> {

  @NotNull
  LibglocalElementLiteral getElementLiteral();

  @NotNull
  LibglocalElementMessageId getElementMessageId();

  @NotNull
  List<LibglocalModifierArg> getModifierArgList();

  @NotNull
  List<LibglocalModifierDoc> getModifierDocList();

  @NotNull
  List<LibglocalModifierVersion> getModifierVersionList();

  @NotNull
  List<LibglocalModifierBlock> getModifiers();

  @NotNull
  List<LibglocalBlockElement> getChildBlocks();

  @NotNull
  String getName();

  @NotNull
  String getFullName();

  @NotNull
  MessageVisibility getVisibility();

  @NotNull
  ItemPresentation getPresentation();

}
