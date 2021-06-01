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

public class MscElementImpl extends ASTWrapperPsiElement implements MscElement {

  public MscElementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull MscVisitor visitor) {
    visitor.visitElement(this);
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
  @Nullable
  public MscEntityList getEntityList() {
    return findChildByClass(MscEntityList.class);
  }

  @Override
  @Nullable
  public MscMessage getMessage() {
    return findChildByClass(MscMessage.class);
  }

  @Override
  @Nullable
  public MscOptionLine getOptionLine() {
    return findChildByClass(MscOptionLine.class);
  }

  @Override
  @Nullable
  public PsiElement getEllipsis() {
    return findChildByType(ELLIPSIS);
  }

  @Override
  @Nullable
  public PsiElement getSemicolon() {
    return findChildByType(SEMICOLON);
  }

  @Override
  @Nullable
  public PsiElement getTripleBar() {
    return findChildByType(TRIPLE_BAR);
  }

  @Override
  @Nullable
  public PsiElement getTripleDash() {
    return findChildByType(TRIPLE_DASH);
  }

}
