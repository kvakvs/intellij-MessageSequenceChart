package se.clau.intellij_msc

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import se.clau.intellij_msc.icons.MscIcons
import javax.swing.Icon

class MscColorSettingsPage : ColorSettingsPage {
    override fun getIcon(): Icon = MscIcons.MSC_FILE_ICON

    override fun getHighlighter(): SyntaxHighlighter = MscSyntaxHighlighter()

    override fun getDemoText(): String {
        return ")bad character\n" +
                "# MSC for some fictional process\n" +
                "msc {\n" +
                "  hscale = \"2\";\n" +
                "\n" +
                "  a,b,c;\n" +
                "\n" +
                "  a->b [ label = \"ab()\" ] ;\n" +
                "  b->c [ label = \"bc(TRUE)\"];\n" +
                "  c=>c [ label = \"process(1)\" ];\n" +
                "  c=>c [ label = \"process(2)\" ];\n" +
                "  ...;\n" +
                "  c=>c [ label = \"process(n)\" ];\n" +
                "  c=>c [ label = \"process(END)\" ];\n" +
                "  a<<=c [ label = \"callback()\"];\n" +
                "  ---  [ label = \"If more to run\", ID=\"*\" ];\n" +
                "  a->a [ label = \"next()\"];\n" +
                "  a->c [ label = \"ac1()\\nac2()\"];\n" +
                "  b<-c [ label = \"cb(TRUE)\"];\n" +
                "  b->b [ label = \"stalled(...)\"];\n" +
                "  a<-b [ label = \"ab() = FALSE\"];\n" +
                "}"
    }

    override fun getAdditionalHighlightingTagToDescriptorMap(): Map<String, TextAttributesKey>? =
        null

    override fun getAttributeDescriptors(): Array<AttributesDescriptor> =
        DESCRIPTORS

    override fun getColorDescriptors(): Array<ColorDescriptor> =
        ColorDescriptor.EMPTY_ARRAY

    override fun getDisplayName(): String = "MSC Diagram File"

    companion object {
        private val DESCRIPTORS = arrayOf(
            AttributesDescriptor(
                "Comments",
                MscSyntaxHighlighter.COMMENT
            ),
            AttributesDescriptor(
                "String values",
                MscSyntaxHighlighter.STRING
            ),
            AttributesDescriptor(
                "Bad characters",
                MscSyntaxHighlighter.BAD_CHARACTER
            ),
            AttributesDescriptor(
                "Keywords",
                MscSyntaxHighlighter.KEYWORD
            ),
//            AttributesDescriptor(
//                "Class",
//                MscSyntaxHighlighter.CLASS
//            ),
            AttributesDescriptor(
                "Identifiers",
                MscSyntaxHighlighter.IDENT
            )
        )
    }
}