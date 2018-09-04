// This is a generated file. Not intended for manual editing.
package io.github.sof3.libglocal.idea.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class LibglocalVisitor extends PsiElementVisitor {

  public void visitBlockAuthor(@NotNull LibglocalBlockAuthor o) {
    visitBlockElement(o);
  }

  public void visitBlockConstraint(@NotNull LibglocalBlockConstraint o) {
    visitBlockElement(o);
  }

  public void visitBlockLang(@NotNull LibglocalBlockLang o) {
    visitBlockElement(o);
  }

  public void visitBlockMessage(@NotNull LibglocalBlockMessage o) {
    visitNamedBlockElement(o);
  }

  public void visitBlockMessageGroup(@NotNull LibglocalBlockMessageGroup o) {
    visitNamedBlockElement(o);
    // visitMessageParentElement(o);
  }

  public void visitBlockMessages(@NotNull LibglocalBlockMessages o) {
    visitNamedBlockElement(o);
    // visitMessageParentElement(o);
  }

  public void visitBlockRequire(@NotNull LibglocalBlockRequire o) {
    visitBlockElement(o);
  }

  public void visitBlockVersion(@NotNull LibglocalBlockVersion o) {
    visitBlockElement(o);
  }

  public void visitElementArgRef(@NotNull LibglocalElementArgRef o) {
    visitPsiElement(o);
  }

  public void visitElementArgsEntry(@NotNull LibglocalElementArgsEntry o) {
    visitPsiElement(o);
  }

  public void visitElementArgsSupplier(@NotNull LibglocalElementArgsSupplier o) {
    visitPsiElement(o);
  }

  public void visitElementArgsValue(@NotNull LibglocalElementArgsValue o) {
    visitPsiElement(o);
  }

  public void visitElementArgsValueString(@NotNull LibglocalElementArgsValueString o) {
    visitPsiElement(o);
  }

  public void visitElementLangId(@NotNull LibglocalElementLangId o) {
    visitPsiElement(o);
  }

  public void visitElementLangName(@NotNull LibglocalElementLangName o) {
    visitPsiElement(o);
  }

  public void visitElementLiteral(@NotNull LibglocalElementLiteral o) {
    visitPsiElement(o);
  }

  public void visitElementLiteralStatic(@NotNull LibglocalElementLiteralStatic o) {
    visitPsiElement(o);
  }

  public void visitElementMessageId(@NotNull LibglocalElementMessageId o) {
    visitPsiElement(o);
  }

  public void visitElementMessageRef(@NotNull LibglocalElementMessageRef o) {
    visitPsiElement(o);
  }

  public void visitElementModifierArg(@NotNull LibglocalElementModifierArg o) {
    visitModifierBlock(o);
  }

  public void visitElementModifierDoc(@NotNull LibglocalElementModifierDoc o) {
    visitModifierBlock(o);
  }

  public void visitElementModifierVersion(@NotNull LibglocalElementModifierVersion o) {
    visitModifierBlock(o);
  }

  public void visitElementSpan(@NotNull LibglocalElementSpan o) {
    visitPsiElement(o);
  }

  public void visitBlockElement(@NotNull LibglocalBlockElement o) {
    visitPsiElement(o);
  }

  public void visitModifierBlock(@NotNull LibglocalModifierBlock o) {
    visitPsiElement(o);
  }

  public void visitNamedBlockElement(@NotNull LibglocalNamedBlockElement o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
