package se.clau.intellij_msc.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import se.clau.intellij_msc.MscTypes;
import static se.clau.intellij_msc.psi.MscParserDefinition.*;

%%

%{
  public int yyline;
  public _MscLexer() {
    this((java.io.Reader)null);
  }
%}

%class _MscLexer
%implements FlexLexer
%unicode
%public

%function advance
%type IElementType

NewLine = [\r\n]+
ShebangLine = "#!" [^\r\n]*

CommentLine1  = "//" [^\r\n]*
CommentLine2  = "#" [^\r\n]*
Comment       = ({CommentLine1} | {CommentLine2})+

WhitespaceNewline   = \n | \r | \r\n
WhitespaceSameline  = [\ \t]
WhitespaceChar      = {WhitespaceNewline} | {WhitespaceSameline}
Whitespace          = {WhitespaceChar}+

OptionName = "hscale" | "width" | "arcgradient" | "wordwraparcs"

String = "\"" [^\"]* "\""
EntityName = [a-zA-Z_] [a-zA-Z0-9_]*

%state IN_MSC
%unicode
%line
//%column

%%

//------------------------------------------------------------------------------
<YYINITIAL, IN_MSC> {
  {Comment}      { return MscTypes.COMMENT; }

  ";"            { return MscTypes.SEMICOLON; }
  ","            { return MscTypes.COMMA; }

  "{"            { return MscTypes.OPEN_CURLY; }
  "}"            { yybegin(YYINITIAL); return MscTypes.CLOSE_CURLY; }

  "..."          { return MscTypes.ELLIPSIS; }
  "|||"          { return MscTypes.TRIPLE_BAR; }

  {Whitespace}   { return TokenType.WHITE_SPACE; }
}

//------------------------------------------------------------------------------
<YYINITIAL> {
  {ShebangLine}    { return MscTypes.SHEBANG; }
  "msc"            { yybegin(IN_MSC); return MscTypes.MSC_TAG; }
}

//------------------------------------------------------------------------------
<IN_MSC> {
  {OptionName}   { return MscTypes.OPTION_NAME; }
  {String}       { return MscTypes.STRING; }
  {EntityName}   { return MscTypes.ENTITY_NAME; }
}

//------------------------------------------------------------------------------
// Catch All
[^]       { yybegin(YYINITIAL); return TokenType.BAD_CHARACTER; }
