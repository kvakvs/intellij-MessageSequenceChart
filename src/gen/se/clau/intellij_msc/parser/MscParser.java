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

  public ASTNode parse(IElementType root_, PsiBuilder builder_) {
    parseLight(root_, builder_);
    return builder_.getTreeBuilt();
  }

  public void parseLight(IElementType root_, PsiBuilder builder_) {
    boolean result_;
    builder_ = adapt_builder_(root_, builder_, this, null);
    Marker marker_ = enter_section_(builder_, 0, _COLLAPSE_, null);
    result_ = parse_root_(root_, builder_);
    exit_section_(builder_, 0, marker_, root_, result_, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType root_, PsiBuilder builder_) {
    return parse_root_(root_, builder_, 0);
  }

  static boolean parse_root_(IElementType root_, PsiBuilder builder_, int level_) {
    return file(builder_, level_ + 1);
  }

  /* ********************************************************** */
  // | '<=>' | '<->' | '<<>>' | '<<=>>' | '<.>' | '<:>'
  //     | '->' | '=>' | '-x' | '>>' | '=>>' | ':>' | '->*'
  //     | '<=' | '<-' | 'x-' | '<<' | '<<=' | '<:' | '*<-'
  //     | '--' | '==' | '..' | '::'
  //     | 'box' | 'abox' | 'rbox' | 'note'
  static boolean arrow_token(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "arrow_token")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, ARROW_TOKEN_0_0);
    if (!result_) result_ = consumeToken(builder_, BIDI_DARROW);
    if (!result_) result_ = consumeToken(builder_, BIDI_ARROW);
    if (!result_) result_ = consumeToken(builder_, BIDI_ARROW2A);
    if (!result_) result_ = consumeToken(builder_, BIDI_ARROW2B);
    if (!result_) result_ = consumeToken(builder_, BIDI_DOTARROW);
    if (!result_) result_ = consumeToken(builder_, BIDI_COLARROW);
    if (!result_) result_ = consumeToken(builder_, ARROW_R);
    if (!result_) result_ = consumeToken(builder_, DARROW_R);
    if (!result_) result_ = consumeToken(builder_, XARROW_R);
    if (!result_) result_ = consumeToken(builder_, ARROW_RRA);
    if (!result_) result_ = consumeToken(builder_, ARROW_RRB);
    if (!result_) result_ = consumeToken(builder_, EMPHASIZED_ARROW_R);
    if (!result_) result_ = consumeToken(builder_, BROADCAST_ARROW_R);
    if (!result_) result_ = consumeToken(builder_, DARROW_L);
    if (!result_) result_ = consumeToken(builder_, ARROW_L);
    if (!result_) result_ = consumeToken(builder_, XARROW_L);
    if (!result_) result_ = consumeToken(builder_, ARROW_LLA);
    if (!result_) result_ = consumeToken(builder_, ARROW_LLB);
    if (!result_) result_ = consumeToken(builder_, EMPHASIZED_ARROW_L);
    if (!result_) result_ = consumeToken(builder_, BROADCAST_ARROW_L);
    if (!result_) result_ = consumeToken(builder_, LINE_DASH);
    if (!result_) result_ = consumeToken(builder_, LINE_DOUBLE);
    if (!result_) result_ = consumeToken(builder_, LINE_DOT);
    if (!result_) result_ = consumeToken(builder_, LINE_DDOT);
    if (!result_) result_ = consumeToken(builder_, BOX);
    if (!result_) result_ = consumeToken(builder_, ANGLE_BOX);
    if (!result_) result_ = consumeToken(builder_, ROUNDED_BOX);
    if (!result_) result_ = consumeToken(builder_, NOTE_BOX);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // IDENTIFIER '=' column_name
  public static boolean attr(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "attr")) return false;
    if (!nextTokenIs(builder_, IDENTIFIER)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, IDENTIFIER, EQUALS);
    result_ = result_ && column_name(builder_, level_ + 1);
    exit_section_(builder_, marker_, ATTR, result_);
    return result_;
  }

  /* ********************************************************** */
  // '[' attr_list? ']'
  public static boolean attr_block(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "attr_block")) return false;
    if (!nextTokenIs(builder_, OPEN_SQUARE)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, OPEN_SQUARE);
    result_ = result_ && attr_block_1(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, CLOSE_SQUARE);
    exit_section_(builder_, marker_, ATTR_BLOCK, result_);
    return result_;
  }

  // attr_list?
  private static boolean attr_block_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "attr_block_1")) return false;
    attr_list(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // attr (',' attr)*
  public static boolean attr_list(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "attr_list")) return false;
    if (!nextTokenIs(builder_, IDENTIFIER)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = attr(builder_, level_ + 1);
    result_ = result_ && attr_list_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, ATTR_LIST, result_);
    return result_;
  }

  // (',' attr)*
  private static boolean attr_list_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "attr_list_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!attr_list_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "attr_list_1", pos_)) break;
    }
    return true;
  }

  // ',' attr
  private static boolean attr_list_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "attr_list_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COMMA);
    result_ = result_ && attr(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // IDENTIFIER | string
  static boolean column_name(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "column_name")) return false;
    if (!nextTokenIs(builder_, "", IDENTIFIER, STRING_LIT)) return false;
    boolean result_;
    result_ = consumeToken(builder_, IDENTIFIER);
    if (!result_) result_ = string(builder_, level_ + 1);
    return result_;
  }

  /* ********************************************************** */
  // option_line | entity_list | skip | message
  public static boolean element(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "element")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, ELEMENT, "<element>");
    result_ = option_line(builder_, level_ + 1);
    if (!result_) result_ = entity_list(builder_, level_ + 1);
    if (!result_) result_ = skip(builder_, level_ + 1);
    if (!result_) result_ = message(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // column_name attr_block?
  public static boolean entity(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "entity")) return false;
    if (!nextTokenIs(builder_, "<entity>", IDENTIFIER, STRING_LIT)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, ENTITY, "<entity>");
    result_ = column_name(builder_, level_ + 1);
    result_ = result_ && entity_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // attr_block?
  private static boolean entity_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "entity_1")) return false;
    attr_block(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // entity (',' entity)* ';'
  public static boolean entity_list(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "entity_list")) return false;
    if (!nextTokenIs(builder_, "<entity list>", IDENTIFIER, STRING_LIT)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, ENTITY_LIST, "<entity list>");
    result_ = entity(builder_, level_ + 1);
    result_ = result_ && entity_list_1(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, SEMICOLON);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // (',' entity)*
  private static boolean entity_list_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "entity_list_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!entity_list_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "entity_list_1", pos_)) break;
    }
    return true;
  }

  // ',' entity
  private static boolean entity_list_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "entity_list_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COMMA);
    result_ = result_ && entity(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // (MSC_KEYWORD | IDENTIFIER) '{' element* '}'
  static boolean file(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "file")) return false;
    if (!nextTokenIs(builder_, "", IDENTIFIER, MSC_KEYWORD)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = file_0(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, OPEN_CURLY);
    result_ = result_ && file_2(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, CLOSE_CURLY);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // MSC_KEYWORD | IDENTIFIER
  private static boolean file_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "file_0")) return false;
    boolean result_;
    result_ = consumeToken(builder_, MSC_KEYWORD);
    if (!result_) result_ = consumeToken(builder_, IDENTIFIER);
    return result_;
  }

  // element*
  private static boolean file_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "file_2")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!element(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "file_2", pos_)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // column_name arrow_token column_name attr_block? ';'
  public static boolean message(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "message")) return false;
    if (!nextTokenIs(builder_, "<message>", IDENTIFIER, STRING_LIT)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, MESSAGE, "<message>");
    result_ = column_name(builder_, level_ + 1);
    result_ = result_ && arrow_token(builder_, level_ + 1);
    result_ = result_ && column_name(builder_, level_ + 1);
    result_ = result_ && message_3(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, SEMICOLON);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // attr_block?
  private static boolean message_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "message_3")) return false;
    attr_block(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER '=' column_name
  public static boolean option(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "option")) return false;
    if (!nextTokenIs(builder_, IDENTIFIER)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, IDENTIFIER, EQUALS);
    result_ = result_ && column_name(builder_, level_ + 1);
    exit_section_(builder_, marker_, OPTION, result_);
    return result_;
  }

  /* ********************************************************** */
  // option_list ';'
  public static boolean option_line(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "option_line")) return false;
    if (!nextTokenIs(builder_, IDENTIFIER)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = option_list(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, SEMICOLON);
    exit_section_(builder_, marker_, OPTION_LINE, result_);
    return result_;
  }

  /* ********************************************************** */
  // option (',' option)*
  public static boolean option_list(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "option_list")) return false;
    if (!nextTokenIs(builder_, IDENTIFIER)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = option(builder_, level_ + 1);
    result_ = result_ && option_list_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, OPTION_LIST, result_);
    return result_;
  }

  // (',' option)*
  private static boolean option_list_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "option_list_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!option_list_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "option_list_1", pos_)) break;
    }
    return true;
  }

  // ',' option
  private static boolean option_list_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "option_list_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COMMA);
    result_ = result_ && option(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // skip_command attr_block? ';'
  public static boolean skip(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "skip")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, SKIP, "<skip>");
    result_ = skip_command(builder_, level_ + 1);
    result_ = result_ && skip_1(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, SEMICOLON);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // attr_block?
  private static boolean skip_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "skip_1")) return false;
    attr_block(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // ELLIPSIS | TRIPLE_BAR | TRIPLE_DASH
  public static boolean skip_command(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "skip_command")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, SKIP_COMMAND, "<skip command>");
    result_ = consumeToken(builder_, ELLIPSIS);
    if (!result_) result_ = consumeToken(builder_, TRIPLE_BAR);
    if (!result_) result_ = consumeToken(builder_, TRIPLE_DASH);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // STRING_LIT
  public static boolean string(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "string")) return false;
    if (!nextTokenIs(builder_, STRING_LIT)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, STRING_LIT);
    exit_section_(builder_, marker_, STRING, result_);
    return result_;
  }

}
