// This is a generated file. Not intended for manual editing.
package io.github.sof3.libglocal.idea.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.ide.projectView.PresentationData;

public interface LibglocalBlockMessageGroup extends LibglocalMessageParentElement, LibglocalNamedBlockElement, LibglocalBlockElement {

  @NotNull
  List<LibglocalBlockMessage> getBlockMessageList();

  @NotNull
  List<LibglocalBlockMessageGroup> getBlockMessageGroupList();

  @NotNull
  LibglocalElementMessageId getElementMessageId();

  @NotNull
  List<LibglocalBlockElement> getChildBlocks();

  @NotNull
  List<LibglocalBlockMessage> getMessages();

  @Nullable
  String getName();

  @NotNull
  String getFullName();

  @NotNull
  PresentationData getPresentation();

}
