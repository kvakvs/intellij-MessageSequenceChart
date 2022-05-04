// This is a generated file. Not intended for manual editing.
package se.clau.intellij_msc.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static se.clau.intellij_msc.MscTypes.*;
import static se.clau.intellij_msc.parser.MscParserUtil.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class MscParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return file(b, l + 1);
  }

  /* ********************************************************** */
  // | '<=>' | '<->' | '<<>>' | '<<=>>' | '<.>' | '<:>'
  //     | '->' | '=>' | '-x' | '>>' | '=>>' | ':>' | '->*'
  //     | '<=' | '<-' | 'x-' | '<<' | '<<=' | '<:' | '*<-'
  //     | '--' | '==' | '..' | '::'
  //     | 'box' | 'abox' | 'rbox' | 'note'
  static boolean arrow_token(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrow_token")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ARROW_TOKEN_0_0);
    if (!r) r = consumeToken(b, BIDI_DARROW);
    if (!r) r = consumeToken(b, BIDI_ARROW);
    if (!r) r = consumeToken(b, BIDI_ARROW2A);
    if (!r) r = consumeToken(b, BIDI_ARROW2B);
    if (!r) r = consumeToken(b, BIDI_DOTARROW);
    if (!r) r = consumeToken(b, BIDI_COLARROW);
    if (!r) r = consumeToken(b, ARROW_R);
    if (!r) r = consumeToken(b, DARROW_R);
    if (!r) r = consumeToken(b, XARROW_R);
    if (!r) r = consumeToken(b, ARROW_RRA);
    if (!r) r = consumeToken(b, ARROW_RRB);
    if (!r) r = consumeToken(b, EMPHASIZED_ARROW_R);
    if (!r) r = consumeToken(b, BROADCAST_ARROW_R);
    if (!r) r = consumeToken(b, DARROW_L);
    if (!r) r = consumeToken(b, ARROW_L);
    if (!r) r = consumeToken(b, XARROW_L);
    if (!r) r = consumeToken(b, ARROW_LLA);
    if (!r) r = consumeToken(b, ARROW_LLB);
    if (!r) r = consumeToken(b, EMPHASIZED_ARROW_L);
    if (!r) r = consumeToken(b, BROADCAST_ARROW_L);
    if (!r) r = consumeToken(b, LINE_DASH);
    if (!r) r = consumeToken(b, LINE_DOUBLE);
    if (!r) r = consumeToken(b, LINE_DOT);
    if (!r) r = consumeToken(b, LINE_DDOT);
    if (!r) r = consumeToken(b, BOX);
    if (!r) r = consumeToken(b, ANGLE_BOX);
    if (!r) r = consumeToken(b, ROUNDED_BOX);
    if (!r) r = consumeToken(b, NOTE_BOX);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER '=' column_name
  public static boolean attr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attr")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENTIFIER, EQUALS);
    r = r && column_name(b, l + 1);
    exit_section_(b, m, ATTR, r);
    return r;
  }

  /* ********************************************************** */
  // '[' attr_list? ']'
  public static boolean attr_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attr_block")) return false;
    if (!nextTokenIs(b, OPEN_SQUARE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OPEN_SQUARE);
    r = r && attr_block_1(b, l + 1);
    r = r && consumeToken(b, CLOSE_SQUARE);
    exit_section_(b, m, ATTR_BLOCK, r);
    return r;
  }

  // attr_list?
  private static boolean attr_block_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attr_block_1")) return false;
    attr_list(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // attr (',' attr)*
  public static boolean attr_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attr_list")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = attr(b, l + 1);
    r = r && attr_list_1(b, l + 1);
    exit_section_(b, m, ATTR_LIST, r);
    return r;
  }

  // (',' attr)*
  private static boolean attr_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attr_list_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!attr_list_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "attr_list_1", c)) break;
    }
    return true;
  }

  // ',' attr
  private static boolean attr_list_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attr_list_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && attr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER | string
  static boolean column_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "column_name")) return false;
    if (!nextTokenIs(b, "", IDENTIFIER, STRING_LIT)) return false;
    boolean r;
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = string(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // option_line | entity_list | skip | message
  public static boolean element(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "element")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ELEMENT, "<element>");
    r = option_line(b, l + 1);
    if (!r) r = entity_list(b, l + 1);
    if (!r) r = skip(b, l + 1);
    if (!r) r = message(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // column_name attr_block?
  public static boolean entity(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entity")) return false;
    if (!nextTokenIs(b, "<entity>", IDENTIFIER, STRING_LIT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ENTITY, "<entity>");
    r = column_name(b, l + 1);
    r = r && entity_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // attr_block?
  private static boolean entity_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entity_1")) return false;
    attr_block(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // entity (',' entity)* ';'
  public static boolean entity_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entity_list")) return false;
    if (!nextTokenIs(b, "<entity list>", IDENTIFIER, STRING_LIT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ENTITY_LIST, "<entity list>");
    r = entity(b, l + 1);
    r = r && entity_list_1(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (',' entity)*
  private static boolean entity_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entity_list_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!entity_list_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "entity_list_1", c)) break;
    }
    return true;
  }

  // ',' entity
  private static boolean entity_list_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entity_list_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && entity(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (MSC_KEYWORD | IDENTIFIER) '{' element* '}'
  static boolean file(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "file")) return false;
    if (!nextTokenIs(b, "", IDENTIFIER, MSC_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = file_0(b, l + 1);
    r = r && consumeToken(b, OPEN_CURLY);
    r = r && file_2(b, l + 1);
    r = r && consumeToken(b, CLOSE_CURLY);
    exit_section_(b, m, null, r);
    return r;
  }

  // MSC_KEYWORD | IDENTIFIER
  private static boolean file_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "file_0")) return false;
    boolean r;
    r = consumeToken(b, MSC_KEYWORD);
    if (!r) r = consumeToken(b, IDENTIFIER);
    return r;
  }

  // element*
  private static boolean file_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "file_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!element(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "file_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // column_name arrow_token column_name attr_block? ';'
  public static boolean message(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "message")) return false;
    if (!nextTokenIs(b, "<message>", IDENTIFIER, STRING_LIT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MESSAGE, "<message>");
    r = column_name(b, l + 1);
    r = r && arrow_token(b, l + 1);
    r = r && column_name(b, l + 1);
    r = r && message_3(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // attr_block?
  private static boolean message_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "message_3")) return false;
    attr_block(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER '=' column_name
  public static boolean option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "option")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENTIFIER, EQUALS);
    r = r && column_name(b, l + 1);
    exit_section_(b, m, OPTION, r);
    return r;
  }

  /* ********************************************************** */
  // option_list ';'
  public static boolean option_line(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "option_line")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = option_list(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, OPTION_LINE, r);
    return r;
  }

  /* ********************************************************** */
  // option (',' option)*
  public static boolean option_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "option_list")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = option(b, l + 1);
    r = r && option_list_1(b, l + 1);
    exit_section_(b, m, OPTION_LIST, r);
    return r;
  }

  // (',' option)*
  private static boolean option_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "option_list_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!option_list_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "option_list_1", c)) break;
    }
    return true;
  }

  // ',' option
  private static boolean option_list_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "option_list_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && option(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // skip_command attr_block? ';'
  public static boolean skip(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "skip")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SKIP, "<skip>");
    r = skip_command(b, l + 1);
    r = r && skip_1(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // attr_block?
  private static boolean skip_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "skip_1")) return false;
    attr_block(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ELLIPSIS | TRIPLE_BAR | TRIPLE_DASH
  public static boolean skip_command(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "skip_command")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SKIP_COMMAND, "<skip command>");
    r = consumeToken(b, ELLIPSIS);
    if (!r) r = consumeToken(b, TRIPLE_BAR);
    if (!r) r = consumeToken(b, TRIPLE_DASH);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // STRING_LIT
  public static boolean string(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string")) return false;
    if (!nextTokenIs(b, STRING_LIT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STRING_LIT);
    exit_section_(b, m, STRING, r);
    return r;
  }

}
