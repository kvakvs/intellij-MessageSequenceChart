// This is a generated file. Not intended for manual editing.
package se.clau.intellij_msc.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface MscMessage extends PsiElement {

  @Nullable
  MscAttrBlock getAttrBlock();

  @NotNull
  List<MscString> getStringList();

  @Nullable
  PsiElement getAngleBox();

  @Nullable
  PsiElement getArrowL();

  @Nullable
  PsiElement getArrowLl();

  @Nullable
  PsiElement getArrowR();

  @Nullable
  PsiElement getArrowRr();

  @Nullable
  PsiElement getBox();

  @Nullable
  PsiElement getBroadcastArrowL();

  @Nullable
  PsiElement getBroadcastArrowR();

  @Nullable
  PsiElement getDarrowL();

  @Nullable
  PsiElement getDarrowR();

  @Nullable
  PsiElement getEmphasizedArrowL();

  @Nullable
  PsiElement getEmphasizedArrowR();

  @Nullable
  PsiElement getNoteBox();

  @Nullable
  PsiElement getRoundedBox();

  @NotNull
  PsiElement getSemicolon();

  @Nullable
  PsiElement getXarrowL();

  @Nullable
  PsiElement getXarrowR();

}
