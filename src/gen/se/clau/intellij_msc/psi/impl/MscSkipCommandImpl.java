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

public class MscSkipCommandImpl extends ASTWrapperPsiElement implements MscSkipCommand {

  public MscSkipCommandImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull MscVisitor visitor) {
    visitor.visitSkipCommand(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MscVisitor) accept((MscVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiElement getEllipsis() {
    return findChildByType(ELLIPSIS);
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
