// This is a generated file. Not intended for manual editing.
package io.github.sof3.libglocal.idea.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface LibglocalBlockMessageGroup extends LibglocalBlockElement, LibglocalMessageParentElement {

  @NotNull
  List<LibglocalBlockMessage> getBlockMessageList();

  @NotNull
  List<LibglocalBlockMessageGroup> getBlockMessageGroupList();

  @NotNull
  LibglocalElementMessageId getElementMessageId();

  //WARNING: getChildBlocks(...) is skipped
  //matching getChildBlocks(LibglocalBlockMessageGroup, ...)
  //methods are not found in Utils

  //WARNING: getMessages(...) is skipped
  //matching getMessages(LibglocalBlockMessageGroup, ...)
  //methods are not found in Utils

  //WARNING: getName(...) is skipped
  //matching getName(LibglocalBlockMessageGroup, ...)
  //methods are not found in Utils

  //WARNING: getFullName(...) is skipped
  //matching getFullName(LibglocalBlockMessageGroup, ...)
  //methods are not found in Utils

  //WARNING: getPresentation(...) is skipped
  //matching getPresentation(LibglocalBlockMessageGroup, ...)
  //methods are not found in Utils

}
