// This is a generated file. Not intended for manual editing.
package io.github.sof3.libglocal.idea.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.ide.projectView.PresentationData;

public interface LgcMessages extends LgcBlockElement, LgcMessageParentElement {

  @NotNull
  List<LgcMessage> getMessageList();

  @NotNull
  List<LgcMessageGroup> getMessageGroupList();

  @NotNull
  LgcMessageId getMessageId();

  @NotNull
  List<LgcBlockElement> getChildBlocks();

  @NotNull
  List<LgcMessage> getMessages();

  @NotNull
  String getName();

  @NotNull
  PresentationData getPresentation();

}
