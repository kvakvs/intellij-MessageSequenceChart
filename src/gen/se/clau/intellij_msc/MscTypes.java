// This is a generated file. Not intended for manual editing.
package se.clau.intellij_msc;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import se.clau.intellij_msc.psi.MscElementType;
import se.clau.intellij_msc.psi.MscTokenType;
import se.clau.intellij_msc.psi.impl.*;

public interface MscTypes {

  IElementType ELEMENT = new MscElementType("ELEMENT");
  IElementType ENTITY_LIST = new MscElementType("ENTITY_LIST");
  IElementType OPTION = new MscElementType("OPTION");
  IElementType OPTION_LINE = new MscElementType("OPTION_LINE");

  IElementType CLOSE_CURLY = new MscTokenType("CLOSE_CURLY");
  IElementType COMMA = new MscTokenType("COMMA");
  IElementType COMMENT = new MscTokenType("COMMENT");
  IElementType ELLIPSIS = new MscTokenType("ELLIPSIS");
  IElementType ENTITY_NAME = new MscTokenType("ENTITY_NAME");
  IElementType MSC_TAG = new MscTokenType("MSC_TAG");
  IElementType OPEN_CURLY = new MscTokenType("OPEN_CURLY");
  IElementType OPTION_NAME = new MscTokenType("OPTION_NAME");
  IElementType SEMICOLON = new MscTokenType("SEMICOLON");
  IElementType SHEBANG = new MscTokenType("SHEBANG");
  IElementType STRING = new MscTokenType("STRING");
  IElementType TRIPLE_BAR = new MscTokenType("TRIPLE_BAR");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ELEMENT) {
        return new MscElementImpl(node);
      }
      else if (type == ENTITY_LIST) {
        return new MscEntityListImpl(node);
      }
      else if (type == OPTION) {
        return new MscOptionImpl(node);
      }
      else if (type == OPTION_LINE) {
        return new MscOptionLineImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
