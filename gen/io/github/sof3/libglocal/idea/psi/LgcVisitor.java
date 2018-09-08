// This is a generated file. Not intended for manual editing.
package io.github.sof3.libglocal.idea.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class LgcVisitor extends PsiElementVisitor {

  public void visitArgDefault(@NotNull LgcArgDefault o) {
    visitPsiElement(o);
  }

  public void visitArgModifier(@NotNull LgcArgModifier o) {
    visitModifierBlock(o);
  }

  public void visitArgName(@NotNull LgcArgName o) {
    visitPsiElement(o);
  }

  public void visitArgRef(@NotNull LgcArgRef o) {
    visitPsiElement(o);
  }

  public void visitArgType(@NotNull LgcArgType o) {
    visitPsiElement(o);
  }

  public void visitArgsEntry(@NotNull LgcArgsEntry o) {
    visitPsiElement(o);
  }

  public void visitArgsSupplier(@NotNull LgcArgsSupplier o) {
    visitPsiElement(o);
  }

  public void visitArgsValue(@NotNull LgcArgsValue o) {
    visitPsiElement(o);
  }

  public void visitArgsValueString(@NotNull LgcArgsValueString o) {
    visitPsiElement(o);
  }

  public void visitAuthor(@NotNull LgcAuthor o) {
    visitBlockElement(o);
  }

  public void visitAuthorName(@NotNull LgcAuthorName o) {
    visitPsiElement(o);
  }

  public void visitDelimConstraint(@NotNull LgcDelimConstraint o) {
    visitPsiElement(o);
  }

  public void visitDocConstraint(@NotNull LgcDocConstraint o) {
    visitPsiElement(o);
  }

  public void visitDocContent(@NotNull LgcDocContent o) {
    visitPsiElement(o);
  }

  public void visitDocModifier(@NotNull LgcDocModifier o) {
    visitModifierBlock(o);
  }

  public void visitFieldConstraint(@NotNull LgcFieldConstraint o) {
    visitConstraintBlock(o);
  }

  public void visitLang(@NotNull LgcLang o) {
    visitBlockElement(o);
  }

  public void visitLangId(@NotNull LgcLangId o) {
    visitPsiElement(o);
  }

  public void visitLangName(@NotNull LgcLangName o) {
    visitPsiElement(o);
  }

  public void visitLiteral(@NotNull LgcLiteral o) {
    visitPsiElement(o);
  }

  public void visitLiteralStatic(@NotNull LgcLiteralStatic o) {
    visitPsiElement(o);
  }

  public void visitMessage(@NotNull LgcMessage o) {
    visitBlockElement(o);
  }

  public void visitMessageFlag(@NotNull LgcMessageFlag o) {
    visitPsiElement(o);
  }

  public void visitMessageGroup(@NotNull LgcMessageGroup o) {
    visitBlockElement(o);
    // visitMessageParentElement(o);
  }

  public void visitMessageId(@NotNull LgcMessageId o) {
    visitPsiElement(o);
  }

  public void visitMessageRef(@NotNull LgcMessageRef o) {
    visitPsiElement(o);
  }

  public void visitMessages(@NotNull LgcMessages o) {
    visitBlockElement(o);
    // visitMessageParentElement(o);
  }

  public void visitRequire(@NotNull LgcRequire o) {
    visitBlockElement(o);
  }

  public void visitRequireTarget(@NotNull LgcRequireTarget o) {
    visitPsiElement(o);
  }

  public void visitSpan(@NotNull LgcSpan o) {
    visitPsiElement(o);
  }

  public void visitVersion(@NotNull LgcVersion o) {
    visitBlockElement(o);
  }

  public void visitVersionModifier(@NotNull LgcVersionModifier o) {
    visitModifierBlock(o);
  }

  public void visitVersionValue(@NotNull LgcVersionValue o) {
    visitPsiElement(o);
  }

  public void visitBlockElement(@NotNull LgcBlockElement o) {
    visitPsiElement(o);
  }

  public void visitConstraintBlock(@NotNull LgcConstraintBlock o) {
    visitPsiElement(o);
  }

  public void visitModifierBlock(@NotNull LgcModifierBlock o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
