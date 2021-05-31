package se.clau.intellij_msc.psi

import com.intellij.psi.tree.IElementType
import se.clau.intellij_msc.MscLanguage

open class MscTokenType(debugName: String) : IElementType(debugName, MscLanguage)
