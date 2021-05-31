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
  // option_line | entity_list | skip | COMMENT
  public static boolean element(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "element")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, ELEMENT, "<element>");
    result_ = option_line(builder_, level_ + 1);
    if (!result_) result_ = entity_list(builder_, level_ + 1);
    if (!result_) result_ = skip(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, COMMENT);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // entity_name (COMMA entity_name)* SEMICOLON
  public static boolean entity_list(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "entity_list")) return false;
    if (!nextTokenIs(builder_, "<entity list>", ENTITY_NAME, STRING)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, ENTITY_LIST, "<entity list>");
    result_ = entity_name(builder_, level_ + 1);
    result_ = result_ && entity_list_1(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, SEMICOLON);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // (COMMA entity_name)*
  private static boolean entity_list_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "entity_list_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!entity_list_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "entity_list_1", pos_)) break;
    }
    return true;
  }

  // COMMA entity_name
  private static boolean entity_list_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "entity_list_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COMMA);
    result_ = result_ && entity_name(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // ENTITY_NAME | STRING
  static boolean entity_name(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "entity_name")) return false;
    if (!nextTokenIs(builder_, "", ENTITY_NAME, STRING)) return false;
    boolean result_;
    result_ = consumeToken(builder_, ENTITY_NAME);
    if (!result_) result_ = consumeToken(builder_, STRING);
    return result_;
  }

  /* ********************************************************** */
  // SHEBANG? MSC_TAG OPEN_CURLY element+ CLOSE_CURLY
  static boolean file(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "file")) return false;
    if (!nextTokenIs(builder_, "", MSC_TAG, SHEBANG)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = file_0(builder_, level_ + 1);
    result_ = result_ && consumeTokens(builder_, 0, MSC_TAG, OPEN_CURLY);
    result_ = result_ && file_3(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, CLOSE_CURLY);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // SHEBANG?
  private static boolean file_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "file_0")) return false;
    consumeToken(builder_, SHEBANG);
    return true;
  }

  // element+
  private static boolean file_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "file_3")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = element(builder_, level_ + 1);
    while (result_) {
      int pos_ = current_position_(builder_);
      if (!element(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "file_3", pos_)) break;
    }
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // OPTION_NAME "=" STRING
  public static boolean option(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "option")) return false;
    if (!nextTokenIs(builder_, OPTION_NAME)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, OPTION_NAME);
    result_ = result_ && consumeToken(builder_, "=");
    result_ = result_ && consumeToken(builder_, STRING);
    exit_section_(builder_, marker_, OPTION, result_);
    return result_;
  }

  /* ********************************************************** */
  // option (COMMA option)* SEMICOLON
  public static boolean option_line(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "option_line")) return false;
    if (!nextTokenIs(builder_, OPTION_NAME)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = option(builder_, level_ + 1);
    result_ = result_ && option_line_1(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, SEMICOLON);
    exit_section_(builder_, marker_, OPTION_LINE, result_);
    return result_;
  }

  // (COMMA option)*
  private static boolean option_line_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "option_line_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!option_line_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "option_line_1", pos_)) break;
    }
    return true;
  }

  // COMMA option
  private static boolean option_line_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "option_line_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COMMA);
    result_ = result_ && option(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // (ELLIPSIS | TRIPLE_BAR) SEMICOLON
  static boolean skip(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "skip")) return false;
    if (!nextTokenIs(builder_, "", ELLIPSIS, TRIPLE_BAR)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = skip_0(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, SEMICOLON);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // ELLIPSIS | TRIPLE_BAR
  private static boolean skip_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "skip_0")) return false;
    boolean result_;
    result_ = consumeToken(builder_, ELLIPSIS);
    if (!result_) result_ = consumeToken(builder_, TRIPLE_BAR);
    return result_;
  }

}
