package se.clau.intellij_msc

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import se.clau.intellij_msc.psi.MscLexerAdapter

class MscSyntaxHighlighter : SyntaxHighlighterBase() {
    override fun getHighlightingLexer(): Lexer {
        return MscLexerAdapter()
    }

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
        return when (tokenType) {
            MscTypes.COMMENT -> COMMENT_KEYS
            MscTypes.IDENTIFIER -> IDENT_KEYS
            MscTypes.STRING -> STRING_KEYS
            TokenType.BAD_CHARACTER -> BAD_CHAR_KEYS
            else -> EMPTY_KEYS
        }
    }

    companion object {
        private val COMMENT = TextAttributesKey.createTextAttributesKey(
                "MSC_COMMENT",
                DefaultLanguageHighlighterColors.LINE_COMMENT
        )
        private val STRING = TextAttributesKey.createTextAttributesKey(
                "MSC_STRING",
                DefaultLanguageHighlighterColors.STRING
        )
        private val BAD_CHARACTER = TextAttributesKey.createTextAttributesKey(
                "MSC_BAD_CHARACTER",
                HighlighterColors.BAD_CHARACTER
        )
        private val KEYWORD = TextAttributesKey.createTextAttributesKey(
                "MSC_KEYWORD",
                DefaultLanguageHighlighterColors.KEYWORD
        )
        private val CLASS_NAME = TextAttributesKey.createTextAttributesKey(
                "MSC_CLASS",
                DefaultLanguageHighlighterColors.CLASS_NAME
        )
        private val IDENT = TextAttributesKey.createTextAttributesKey(
                "MSC_IDENT",
                DefaultLanguageHighlighterColors.IDENTIFIER
        )

        private val BAD_CHAR_KEYS = arrayOf(BAD_CHARACTER)
        private val COMMENT_KEYS = arrayOf(COMMENT)
        private val STRING_KEYS = arrayOf(STRING)

        //private val LINE_CONTENT_KEYS = arrayOf(LINE_CONTENT)
        //private val KEYWORD_KEYS = arrayOf(KEYWORD)
        //private val CLASS_KEYS = arrayOf(CLASS_NAME)
        private val IDENT_KEYS = arrayOf(IDENT)
        private val EMPTY_KEYS = arrayOf<TextAttributesKey>()
    }
}