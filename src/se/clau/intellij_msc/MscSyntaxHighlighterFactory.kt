package se.clau.intellij_msc

import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile

class MscSyntaxHighlighterFactory : SingleLazyInstanceSyntaxHighlighterFactory() {
  override fun createHighlighter(): SyntaxHighlighter = MscSyntaxHighlighter()
}