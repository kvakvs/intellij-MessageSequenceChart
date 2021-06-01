// This is a generated file. Not intended for manual editing.
package se.clau.intellij_msc.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class MscVisitor extends PsiElementVisitor {

  public void visitAttr(@NotNull MscAttr o) {
    visitPsiElement(o);
  }

  public void visitAttrBlock(@NotNull MscAttrBlock o) {
    visitPsiElement(o);
  }

  public void visitElement(@NotNull MscElement o) {
    visitPsiElement(o);
  }

  public void visitEntityList(@NotNull MscEntityList o) {
    visitPsiElement(o);
  }

  public void visitMessage(@NotNull MscMessage o) {
    visitPsiElement(o);
  }

  public void visitOption(@NotNull MscOption o) {
    visitPsiElement(o);
  }

  public void visitOptionLine(@NotNull MscOptionLine o) {
    visitPsiElement(o);
  }

  public void visitString(@NotNull MscString o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
