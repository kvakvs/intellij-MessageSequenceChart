// This is a generated file. Not intended for manual editing.
package se.clau.intellij_msc;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import se.clau.intellij_msc.psi.MscElementType;
import se.clau.intellij_msc.psi.MscTokenType;
import se.clau.intellij_msc.psi.impl.*;

public interface MscTypes {

  IElementType ATTR = new MscElementType("ATTR");
  IElementType ATTR_BLOCK = new MscElementType("ATTR_BLOCK");
  IElementType ATTR_LIST = new MscElementType("ATTR_LIST");
  IElementType ELEMENT = new MscElementType("ELEMENT");
  IElementType ENTITY = new MscElementType("ENTITY");
  IElementType ENTITY_LIST = new MscElementType("ENTITY_LIST");
  IElementType MESSAGE = new MscElementType("MESSAGE");
  IElementType OPTION = new MscElementType("OPTION");
  IElementType OPTION_LINE = new MscElementType("OPTION_LINE");
  IElementType OPTION_LIST = new MscElementType("OPTION_LIST");
  IElementType SKIP = new MscElementType("SKIP");
  IElementType SKIP_COMMAND = new MscElementType("SKIP_COMMAND");
  IElementType STRING = new MscElementType("STRING");

  IElementType ANGLE_BOX = new MscTokenType("abox");
  IElementType ARROW_L = new MscTokenType("<-");
  IElementType ARROW_LL = new MscTokenType("<<");
  IElementType ARROW_R = new MscTokenType("->");
  IElementType ARROW_RR = new MscTokenType(">>");
  IElementType BOX = new MscTokenType("box");
  IElementType BROADCAST_ARROW_L = new MscTokenType("*<-");
  IElementType BROADCAST_ARROW_R = new MscTokenType("->*");
  IElementType CLOSE_CURLY = new MscTokenType("}");
  IElementType CLOSE_SQUARE = new MscTokenType("]");
  IElementType COMMA = new MscTokenType(",");
  IElementType COMMENT = new MscTokenType("<comment>");
  IElementType DARROW_L = new MscTokenType("<=");
  IElementType DARROW_R = new MscTokenType("=>");
  IElementType ELLIPSIS = new MscTokenType("...");
  IElementType EMPHASIZED_ARROW_L = new MscTokenType("<:");
  IElementType EMPHASIZED_ARROW_R = new MscTokenType(":>");
  IElementType EQUALS = new MscTokenType("=");
  IElementType IDENTIFIER = new MscTokenType("<identifier>");
  IElementType MSC_KEYWORD = new MscTokenType("MSC_KEYWORD");
  IElementType NOTE_BOX = new MscTokenType("note");
  IElementType OPEN_CURLY = new MscTokenType("{");
  IElementType OPEN_SQUARE = new MscTokenType("[");
  IElementType ROUNDED_BOX = new MscTokenType("rbox");
  IElementType SEMICOLON = new MscTokenType(";");
  IElementType STRING_LIT = new MscTokenType("<string>");
  IElementType TRIPLE_BAR = new MscTokenType("|||");
  IElementType TRIPLE_DASH = new MscTokenType("---");
  IElementType XARROW_L = new MscTokenType("x-");
  IElementType XARROW_R = new MscTokenType("-x");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ATTR) {
        return new MscAttrImpl(node);
      }
      else if (type == ATTR_BLOCK) {
        return new MscAttrBlockImpl(node);
      }
      else if (type == ATTR_LIST) {
        return new MscAttrListImpl(node);
      }
      else if (type == ELEMENT) {
        return new MscElementImpl(node);
      }
      else if (type == ENTITY) {
        return new MscEntityImpl(node);
      }
      else if (type == ENTITY_LIST) {
        return new MscEntityListImpl(node);
      }
      else if (type == MESSAGE) {
        return new MscMessageImpl(node);
      }
      else if (type == OPTION) {
        return new MscOptionImpl(node);
      }
      else if (type == OPTION_LINE) {
        return new MscOptionLineImpl(node);
      }
      else if (type == OPTION_LIST) {
        return new MscOptionListImpl(node);
      }
      else if (type == SKIP) {
        return new MscSkipImpl(node);
      }
      else if (type == SKIP_COMMAND) {
        return new MscSkipCommandImpl(node);
      }
      else if (type == STRING) {
        return new MscStringImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
