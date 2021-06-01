package se.clau.intellij_msc.psi

import com.intellij.psi.tree.IElementType
import se.clau.intellij_msc.MscLanguage

open class MscElementType(s: String) : IElementType(s, MscLanguage)
