package se.clau.intellij_msc.psi

import com.intellij.lexer.FlexAdapter
import se.clau.intellij_msc.lexer._MscLexer

class MscLexerAdapter : FlexAdapter(_MscLexer())
