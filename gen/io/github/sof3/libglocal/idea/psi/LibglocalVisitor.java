// This is a generated file. Not intended for manual editing.
package io.github.sof3.libglocal.idea.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class LibglocalVisitor extends PsiElementVisitor {

  public void visitAuthorBlock(@NotNull LibglocalAuthorBlock o) {
    visitBlockElement(o);
  }

  public void visitBlockMessage(@NotNull LibglocalBlockMessage o) {
    visitBlockElement(o);
  }

  public void visitBlockMessageGroup(@NotNull LibglocalBlockMessageGroup o) {
    visitBlockElement(o);
    // visitMessageParentElement(o);
  }

  public void visitBlockMessages(@NotNull LibglocalBlockMessages o) {
    visitBlockElement(o);
    // visitMessageParentElement(o);
  }

  public void visitConstraintDelim(@NotNull LibglocalConstraintDelim o) {
    visitPsiElement(o);
  }

  public void visitConstraintDoc(@NotNull LibglocalConstraintDoc o) {
    visitPsiElement(o);
  }

  public void visitConstraintField(@NotNull LibglocalConstraintField o) {
    visitConstraintBlock(o);
  }

  public void visitElementArgDefault(@NotNull LibglocalElementArgDefault o) {
    visitPsiElement(o);
  }

  public void visitElementArgName(@NotNull LibglocalElementArgName o) {
    visitPsiElement(o);
  }

  public void visitElementArgRef(@NotNull LibglocalElementArgRef o) {
    visitPsiElement(o);
  }

  public void visitElementArgType(@NotNull LibglocalElementArgType o) {
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

  public void visitElementRequireTarget(@NotNull LibglocalElementRequireTarget o) {
    visitPsiElement(o);
  }

  public void visitElementSpan(@NotNull LibglocalElementSpan o) {
    visitPsiElement(o);
  }

  public void visitElementVersionValue(@NotNull LibglocalElementVersionValue o) {
    visitPsiElement(o);
  }

  public void visitLangBlock(@NotNull LibglocalLangBlock o) {
    visitBlockElement(o);
  }

  public void visitMessageFlag(@NotNull LibglocalMessageFlag o) {
    visitPsiElement(o);
  }

  public void visitMessageName(@NotNull LibglocalMessageName o) {
    visitPsiElement(o);
  }

  public void visitModifierArg(@NotNull LibglocalModifierArg o) {
    visitModifierBlock(o);
  }

  public void visitModifierDoc(@NotNull LibglocalModifierDoc o) {
    visitModifierBlock(o);
  }

  public void visitModifierVersion(@NotNull LibglocalModifierVersion o) {
    visitModifierBlock(o);
  }

  public void visitRequireBlock(@NotNull LibglocalRequireBlock o) {
    visitBlockElement(o);
  }

  public void visitVersionBlock(@NotNull LibglocalVersionBlock o) {
    visitBlockElement(o);
  }

  public void visitBlockElement(@NotNull LibglocalBlockElement o) {
    visitPsiElement(o);
  }

  public void visitConstraintBlock(@NotNull LibglocalConstraintBlock o) {
    visitPsiElement(o);
  }

  public void visitModifierBlock(@NotNull LibglocalModifierBlock o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
