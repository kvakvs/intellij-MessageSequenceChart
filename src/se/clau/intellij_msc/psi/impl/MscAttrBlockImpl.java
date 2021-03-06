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

public class MscAttrBlockImpl extends ASTWrapperPsiElement implements MscAttrBlock {

  public MscAttrBlockImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull MscVisitor visitor) {
    visitor.visitAttrBlock(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MscVisitor) accept((MscVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public MscAttrList getAttrList() {
    return findChildByClass(MscAttrList.class);
  }

  @Override
  @NotNull
  public PsiElement getCloseSquare() {
    return findNotNullChildByType(CLOSE_SQUARE);
  }

  @Override
  @NotNull
  public PsiElement getOpenSquare() {
    return findNotNullChildByType(OPEN_SQUARE);
  }

}
