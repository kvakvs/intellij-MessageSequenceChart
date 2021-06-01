package se.clau.intellij_msc.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import se.clau.intellij_msc.MscTypes;
import se.clau.intellij_msc.psi.MscString;import se.clau.intellij_msc.psi.impl.MscStringImpl;

%%

%{
    public int yyline;
    StringBuffer inString = new StringBuffer();

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

StringLiteral = [\"] [^\"]* [\"]
//Identifier  = [_a-z][_a-zA-Z0-9]*
Identifier  = \p{Alpha}\w*

%function advance
%unicode
%line
%type IElementType
//%column

%state ATTR_STRING
%state STRING
%state MSC_SECTION
%state ATTR

%%

//------------------------------------------------------------------------------
<YYINITIAL> {
//  {ShebangLine}    { return getTokenStart() == 0
//                        ? MscTypes.SHEBANG
//                        : com.intellij.psi.TokenType.ERROR_ELEMENT; }
  "msc"         { return MscTypes.MSC_KEYWORD; }
  "{"           { yybegin(MSC_SECTION); yypushback(1); }
  "}"           { return MscTypes.CLOSE_CURLY; }
  {LineComment}    { /*return MscTypes.COMMENT;*/ }
  {Whitespace}     { return TokenType.WHITE_SPACE; }
}

//------------------------------------------------------------------------------
<MSC_SECTION> {
    ";"           { return MscTypes.SEMICOLON; }
    ","           { return MscTypes.COMMA; }

    "{"           { return MscTypes.OPEN_CURLY; }
    "}"           { yybegin(YYINITIAL); yypushback(1); }

//    "["           { yybegin(ATTR); yypushback(1); }
    "["           { return MscTypes.OPEN_SQUARE; }
    "]"           { return MscTypes.CLOSE_SQUARE; }
    "="           { return MscTypes.EQUALS; }

    // Vertical Separators
    "..."         { return MscTypes.ELLIPSIS; }
    "|||"         { return MscTypes.TRIPLE_BAR; }
    "---"         { return MscTypes.TRIPLE_DASH; }

    '->'        { return MscTypes.ARROW_R; }
    '=>'        { return MscTypes.DARROW_R; }
    '-x'        { return MscTypes.XARROW_R; }
    '>>'        { return MscTypes.ARROW_RR; }
    ':>'        { return MscTypes.EMPHASIZED_ARROW_R; }
    '->\*'      { return MscTypes.BROADCAST_ARROW_R; }

    '<-'        { return MscTypes.ARROW_L; }
    '<='        { return MscTypes.DARROW_L; }
    'x-'        { return MscTypes.XARROW_L; }
    '<<'        { return MscTypes.ARROW_LL; }
    '<:'        { return MscTypes.EMPHASIZED_ARROW_L; }
    '\*<-'      { return MscTypes.BROADCAST_ARROW_L; }

    'box'       { return MscTypes.BOX; }
    'abox'      { return MscTypes.ANGLE_BOX; }
    'rbox'      { return MscTypes.ROUNDED_BOX; }
    'note'      { return MscTypes.NOTE_BOX; }

    \"             { inString.setLength(0); yybegin(STRING); }
    {Identifier}  { return MscTypes.IDENTIFIER; }

    {LineComment}    { /*return MscTypes.COMMENT;*/ }
    {Whitespace}     { return TokenType.WHITE_SPACE; }
}

//------------------------------------------------------------------------------
//<ATTR> {
//  "["           { return MscTypes.OPEN_SQUARE; }
//  "]"           { yybegin(MSC_SECTION); yypushback(1); }
//  "="           { return MscTypes.EQUALS; }
//  ","           { return MscTypes.COMMA; }
//
//  \"             { inString.setLength(0); yybegin(ATTR_STRING); }
//  {Identifier}     { return MscTypes.IDENTIFIER; }
////  {StringLiteral}  { return MscTypes.STRING; }
//
//  {LineComment}    { /*return MscTypes.COMMENT;*/ }
//  {Whitespace}     { return TokenType.WHITE_SPACE; }
//}

//------------------------------------------------------------------------------
<ATTR_STRING> {
    \"            { yybegin(ATTR); return MscTypes.STRING_LIT;
                  // return new MscStringImpl(inString.toString());
                  }
    [^\n\r\"\\]+  { inString.append( yytext() ); }
    \\t           { inString.append('\t'); }
    \\n           { inString.append('\n'); }
    \\r           { inString.append('\r'); }
    \\\"          { inString.append('\"'); }
    \\            { inString.append('\\'); }
}

<STRING> {
    \"            { yybegin(MSC_SECTION); return MscTypes.STRING_LIT;
                  }
    [^\n\r\"\\]+  { inString.append( yytext() ); }
    \\t           { inString.append('\t'); }
    \\n           { inString.append('\n'); }
    \\r           { inString.append('\r'); }
    \\\"          { inString.append('\"'); }
    \\            { inString.append('\\'); }
}

//------------------------------------------------------------------------------
// Catch All
[^]       { yybegin(YYINITIAL); return TokenType.BAD_CHARACTER; }
