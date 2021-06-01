// This is a generated file. Not intended for manual editing.
package se.clau.intellij_msc;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import se.clau.intellij_msc.psi.MscElementType;
import se.clau.intellij_msc.psi.MscTokenType;
import se.clau.intellij_msc.psi.impl.*;

public interface MscTypes {

  IElementType ATTR_BLOCK = new MscElementType("ATTR_BLOCK");
  IElementType ELEMENT = new MscElementType("ELEMENT");
  IElementType ENTITY_LIST = new MscElementType("ENTITY_LIST");
  IElementType OPTION = new MscElementType("OPTION");
  IElementType OPTION_LINE = new MscElementType("OPTION_LINE");

  IElementType CLOSE_CURLY = new MscTokenType("}");
  IElementType CLOSE_SQUARE = new MscTokenType("]");
  IElementType COMMA = new MscTokenType(",");
  IElementType COMMENT = new MscTokenType("<comment>");
  IElementType ELLIPSIS = new MscTokenType("...");
  IElementType ENTITY_NAME = new MscTokenType("ENTITY_NAME");
  IElementType ID = new MscTokenType("id");
  IElementType MSC_KEYWORD = new MscTokenType("MSC_KEYWORD");
  IElementType NUMBER = new MscTokenType("number");
  IElementType OPEN_CURLY = new MscTokenType("{");
  IElementType OPEN_SQUARE = new MscTokenType("[");
  IElementType OPTION_NAME = new MscTokenType("OPTION_NAME");
  IElementType SEMICOLON = new MscTokenType(";");
  IElementType STRING = new MscTokenType("STRING");
  IElementType TRIPLE_BAR = new MscTokenType("|||");
  IElementType TRIPLE_DASH = new MscTokenType("---");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ATTR_BLOCK) {
        return new MscAttrBlockImpl(node);
      }
      else if (type == ELEMENT) {
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
