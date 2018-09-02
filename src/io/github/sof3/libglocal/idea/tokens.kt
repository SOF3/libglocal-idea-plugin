package io.github.sof3.libglocal.idea

import com.intellij.psi.tree.IElementType

class LibglocalTokenType(name: String) : IElementType(
		if (name.startsWith("K_"))
			"\"${name.substring(2).toLowerCase().replace("_", " ")}\""
		else
			name,
		LibglocalLanguage)

class LibglocalElementType(name: String) : IElementType(name, LibglocalLanguage)
