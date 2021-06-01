package se.clau.intellij_msc.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import se.clau.intellij_msc.MscTypes;
import se.clau.intellij_msc.psi.MscString;
import static se.clau.intellij_msc.psi.MscParserDefinition.*;

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

Remainder = ([^\r\n]*) {Newline}

//ShebangLine = "#!" {Remainder}

Comment1  = "//" {Remainder}
Comment2  = "#" {Remainder}

OptionName = "hscale" | "width" | "arcgradient" | "wordwraparcs"

EntityName = [a-zA-Z_] [a-zA-Z0-9_]*

//%state IN_MSC
%state STRING

%function advance
%unicode
%line
%type IElementType
//%column

%%

//------------------------------------------------------------------------------
<YYINITIAL> {
//  {ShebangLine}    { return getTokenStart() == 0
//                        ? MscTypes.SHEBANG
//                        : com.intellij.psi.TokenType.ERROR_ELEMENT; }
  "msc"         {  return MscTypes.MSC_KEYWORD; }

  ";"           { return MscTypes.SEMICOLON; }
  ","           { return MscTypes.COMMA; }

  "{"           { return MscTypes.OPEN_CURLY; }
  "}"           { yybegin(YYINITIAL); return MscTypes.CLOSE_CURLY; }

  "["           { return MscTypes.OPEN_SQUARE; }
  "]"           { return MscTypes.CLOSE_SQUARE; }

  // Vertical Separators
  "..."         { return MscTypes.ELLIPSIS; }
  "|||"         { return MscTypes.TRIPLE_BAR; }
  "---"         { return MscTypes.TRIPLE_DASH; }

  {OptionName}   { return MscTypes.OPTION_NAME; }
  \"             { inString.setLength(0); yybegin(STRING); }
//  {EntityName}   { return MscTypes.ENTITY_NAME; }

  {Comment1}|{Comment1} { /*return MscTypes.COMMENT;*/ }
  {Whitespace}     { return TokenType.WHITE_SPACE; }
}

//------------------------------------------------------------------------------
<STRING> {
    \"            { yybegin(YYINITIAL);
                    return new MscString(inString.toString()); }
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
