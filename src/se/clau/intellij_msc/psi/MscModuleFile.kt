package se.clau.intellij_msc.psi

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import se.clau.intellij_msc.filetypes.MscFileType
import se.clau.intellij_msc.MscLanguage

class MscModuleFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, MscLanguage) {
  override fun getFileType(): FileType = MscFileType

  override fun toString(): String = "Message Sequence Chart"
}
