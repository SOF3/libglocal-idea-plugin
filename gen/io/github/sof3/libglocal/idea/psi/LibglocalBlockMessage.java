// This is a generated file. Not intended for manual editing.
package io.github.sof3.libglocal.idea.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface LibglocalBlockMessage extends LibglocalBlockElement {

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

  //WARNING: getModifiers(...) is skipped
  //matching getModifiers(LibglocalBlockMessage, ...)
  //methods are not found in Utils

  //WARNING: getChildBlocks(...) is skipped
  //matching getChildBlocks(LibglocalBlockMessage, ...)
  //methods are not found in Utils

  //WARNING: getName(...) is skipped
  //matching getName(LibglocalBlockMessage, ...)
  //methods are not found in Utils

  //WARNING: getFullName(...) is skipped
  //matching getFullName(LibglocalBlockMessage, ...)
  //methods are not found in Utils

  //WARNING: getPresentation(...) is skipped
  //matching getPresentation(LibglocalBlockMessage, ...)
  //methods are not found in Utils

}
