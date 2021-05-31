package se.clau.intellij_msc.filetypes

import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.openapi.vfs.VirtualFile
import se.clau.intellij_msc.MscLanguage
import se.clau.intellij_msc.icons.MscIcons
import javax.swing.Icon

object MscFileType : LanguageFileType(MscLanguage) {
    override fun getName(): String = "Message Sequence Chart"
    override fun getIcon(): Icon = MscIcons.MSC_FILE_ICON
    override fun getDefaultExtension(): String = "msc"
    override fun getCharset(file: VirtualFile, content: ByteArray): String = "UTF-8"
    override fun getDescription(): String = "Source for Message Sequence Chart to be processed by mscgen"
}
