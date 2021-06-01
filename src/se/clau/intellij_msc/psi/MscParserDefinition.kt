package se.clau.intellij_msc.psi

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.ParserDefinition.SpaceRequirements
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import se.clau.intellij_msc.MscLanguage
import se.clau.intellij_msc.MscTypes
import se.clau.intellij_msc.parser.MscParser

class MscParserDefinition : ParserDefinition {
  override fun createLexer(project: Project): Lexer = MscLexerAdapter()
  override fun createParser(project: Project): PsiParser = MscParser()

  override fun getWhitespaceTokens(): TokenSet = TokenSet.create(TokenType.WHITE_SPACE)

  override fun getCommentTokens(): TokenSet = TokenSet.create(MscTypes.COMMENT)

  override fun getStringLiteralElements(): TokenSet = TokenSet.EMPTY

  override fun getFileNodeType(): IFileElementType = IFileElementType(MscLanguage)

  override fun createFile(viewProvider: FileViewProvider): PsiFile = MscModuleFile(viewProvider)

  override fun spaceExistenceTypeBetweenTokens(left: ASTNode, right: ASTNode): SpaceRequirements =
    SpaceRequirements.MAY

  override fun createElement(node: ASTNode): PsiElement = MscTypes.Factory.createElement(node)
}