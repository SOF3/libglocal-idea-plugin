// This is a generated file. Not intended for manual editing.
package io.github.sof3.libglocal.idea.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static io.github.sof3.libglocal.idea.LibglocalTokens.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import io.github.sof3.libglocal.idea.psi.*;

public class LibglocalMessageValueImpl extends ASTWrapperPsiElement implements LibglocalMessageValue {

  public LibglocalMessageValueImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull LibglocalVisitor visitor) {
    visitor.visitMessageValue(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LibglocalVisitor) accept((LibglocalVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public LibglocalArgRef getArgRef() {
    return findChildByClass(LibglocalArgRef.class);
  }

  @Override
  @Nullable
  public LibglocalMessageRef getMessageRef() {
    return findChildByClass(LibglocalMessageRef.class);
  }

  @Override
  @Nullable
  public LibglocalSpan getSpan() {
    return findChildByClass(LibglocalSpan.class);
  }

}