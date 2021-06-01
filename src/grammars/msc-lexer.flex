package se.clau.intellij_msc.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.intellij.openapi.diagnostic.Logger;

import se.clau.intellij_msc.MscTypes;
import se.clau.intellij_msc.psi.MscString;
import se.clau.intellij_msc.psi.impl.MscStringImpl;

%%

%{
    public int yyline;
    StringBuffer inString = new StringBuffer();
    final static Logger LOG = Logger.getInstance(_MscLexer.class);

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

Newline             = \n | \r | \r\n
WhitespaceSameline  = [\s\t]
WhitespaceChar      = {Newline} | {WhitespaceSameline}
Whitespace          = {WhitespaceChar}+

LineComment  = ("//" | '#') .*

OptionName = "hscale" | "width" | "arcgradient" | "wordwraparcs"

//StringLiteral = [\"] [^\"]* [\"]

Identifier  = [a-z][a-zA-Z]*
//Identifier  = \p{Alpha}\w*

%function advance
%unicode
%line
%type IElementType
//%column

%state STRING
%state IN_BLOCK_COMMENT

%%

//------------------------------------------------------------------------------
<YYINITIAL> {
//  {ShebangLine}    { return getTokenStart() == 0
//                        ? MscTypes.SHEBANG
//                        : com.intellij.psi.TokenType.ERROR_ELEMENT; }
    "msc"         { return MscTypes.MSC_KEYWORD; }
    "/*"          { yybegin(IN_BLOCK_COMMENT); yypushback(2); }

    ";"         { return MscTypes.SEMICOLON; }
    ","         { return MscTypes.COMMA; }

    "{"         { return MscTypes.OPEN_CURLY; }
    "}"         { return MscTypes.CLOSE_CURLY; }

    "["         { return MscTypes.OPEN_SQUARE; }
    "]"         { return MscTypes.CLOSE_SQUARE; }

    "->"        { return MscTypes.ARROW_R; }
    "=>"        { return MscTypes.DARROW_R; }
    "-x"        { return MscTypes.XARROW_R; }
    ">>"        { return MscTypes.ARROW_RR; }
    ":>"        { return MscTypes.EMPHASIZED_ARROW_R; }
    "->*"       { return MscTypes.BROADCAST_ARROW_R; }

    "<-"        { return MscTypes.ARROW_L; }
    "<="        { return MscTypes.DARROW_L; }
    "x-"        { return MscTypes.XARROW_L; }
    "<<"        { return MscTypes.ARROW_LL; }
    "<:"        { return MscTypes.EMPHASIZED_ARROW_L; }
    "*<-"       { return MscTypes.BROADCAST_ARROW_L; }

    "box"       { return MscTypes.BOX; }
    "abox"      { return MscTypes.ANGLE_BOX; }
    "rbox"      { return MscTypes.ROUNDED_BOX; }
    "note"      { return MscTypes.NOTE_BOX; }

    // Vertical Separators
    "..."         { return MscTypes.ELLIPSIS; }
    "|||"         { return MscTypes.TRIPLE_BAR; }
    "---"         { return MscTypes.TRIPLE_DASH; }
    "="           { return MscTypes.EQUALS; }

    \"            { inString.setLength(0); yybegin(STRING); }
    {Identifier}  {
//          LOG.info("ident:" + yytext());
          return MscTypes.IDENTIFIER;
      }

    {LineComment}    { /*return MscTypes.COMMENT;*/ }
    {Whitespace}     { /*return TokenType.WHITE_SPACE;*/ }
}

//------------------------------------------------------------------------------
<STRING> {
    \"            { yybegin(YYINITIAL); return MscTypes.STRING_LIT; }
    [^\n\r\"\\]+  { inString.append( yytext() ); }
    \\t           { inString.append('\t'); }
    \\n           { inString.append('\n'); }
    \\r           { inString.append('\r'); }
    \\\"          { inString.append('\"'); }
    \\            { inString.append('\\'); }
}

//------------------------------------------------------------------------------
<IN_BLOCK_COMMENT> {
  "*/"    { yybegin(YYINITIAL); return MscTypes.COMMENT; }
  <<EOF>> { yybegin(YYINITIAL); return MscTypes.COMMENT; }
  [^]     { }
}

//------------------------------------------------------------------------------
// Catch All
[^]       { yybegin(YYINITIAL); return TokenType.BAD_CHARACTER; }
