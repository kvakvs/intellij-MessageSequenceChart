// This is a generated file. Not intended for manual editing.
package se.clau.intellij_msc.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static se.clau.intellij_msc.MscTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import se.clau.intellij_msc.psi.*;

public class MscMessageImpl extends ASTWrapperPsiElement implements MscMessage {

  public MscMessageImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull MscVisitor visitor) {
    visitor.visitMessage(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MscVisitor) accept((MscVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public MscAttrBlock getAttrBlock() {
    return findChildByClass(MscAttrBlock.class);
  }

  @Override
  @NotNull
  public List<MscString> getStringList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, MscString.class);
  }

  @Override
  @Nullable
  public PsiElement getAngleBox() {
    return findChildByType(ANGLE_BOX);
  }

  @Override
  @Nullable
  public PsiElement getArrowL() {
    return findChildByType(ARROW_L);
  }

  @Override
  @Nullable
  public PsiElement getArrowLla() {
    return findChildByType(ARROW_LLA);
  }

  @Override
  @Nullable
  public PsiElement getArrowLlb() {
    return findChildByType(ARROW_LLB);
  }

  @Override
  @Nullable
  public PsiElement getArrowR() {
    return findChildByType(ARROW_R);
  }

  @Override
  @Nullable
  public PsiElement getArrowRra() {
    return findChildByType(ARROW_RRA);
  }

  @Override
  @Nullable
  public PsiElement getArrowRrb() {
    return findChildByType(ARROW_RRB);
  }

  @Override
  @Nullable
  public PsiElement getBidiArrow() {
    return findChildByType(BIDI_ARROW);
  }

  @Override
  @Nullable
  public PsiElement getBidiArrow2A() {
    return findChildByType(BIDI_ARROW2A);
  }

  @Override
  @Nullable
  public PsiElement getBidiArrow2B() {
    return findChildByType(BIDI_ARROW2B);
  }

  @Override
  @Nullable
  public PsiElement getBidiColarrow() {
    return findChildByType(BIDI_COLARROW);
  }

  @Override
  @Nullable
  public PsiElement getBidiDarrow() {
    return findChildByType(BIDI_DARROW);
  }

  @Override
  @Nullable
  public PsiElement getBidiDotarrow() {
    return findChildByType(BIDI_DOTARROW);
  }

  @Override
  @Nullable
  public PsiElement getBox() {
    return findChildByType(BOX);
  }

  @Override
  @Nullable
  public PsiElement getBroadcastArrowL() {
    return findChildByType(BROADCAST_ARROW_L);
  }

  @Override
  @Nullable
  public PsiElement getBroadcastArrowR() {
    return findChildByType(BROADCAST_ARROW_R);
  }

  @Override
  @Nullable
  public PsiElement getDarrowL() {
    return findChildByType(DARROW_L);
  }

  @Override
  @Nullable
  public PsiElement getDarrowR() {
    return findChildByType(DARROW_R);
  }

  @Override
  @Nullable
  public PsiElement getEmphasizedArrowL() {
    return findChildByType(EMPHASIZED_ARROW_L);
  }

  @Override
  @Nullable
  public PsiElement getEmphasizedArrowR() {
    return findChildByType(EMPHASIZED_ARROW_R);
  }

  @Override
  @Nullable
  public PsiElement getLineDash() {
    return findChildByType(LINE_DASH);
  }

  @Override
  @Nullable
  public PsiElement getLineDdot() {
    return findChildByType(LINE_DDOT);
  }

  @Override
  @Nullable
  public PsiElement getLineDot() {
    return findChildByType(LINE_DOT);
  }

  @Override
  @Nullable
  public PsiElement getLineDouble() {
    return findChildByType(LINE_DOUBLE);
  }

  @Override
  @Nullable
  public PsiElement getNoteBox() {
    return findChildByType(NOTE_BOX);
  }

  @Override
  @Nullable
  public PsiElement getRoundedBox() {
    return findChildByType(ROUNDED_BOX);
  }

  @Override
  @NotNull
  public PsiElement getSemicolon() {
    return findNotNullChildByType(SEMICOLON);
  }

  @Override
  @Nullable
  public PsiElement getXarrowL() {
    return findChildByType(XARROW_L);
  }

  @Override
  @Nullable
  public PsiElement getXarrowR() {
    return findChildByType(XARROW_R);
  }

}
