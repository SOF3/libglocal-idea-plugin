package io.github.sof3.libglocal.idea.psi;

import com.intellij.psi.tree.IElementType;
import io.github.sof3.libglocal.idea.LibglocalElementType;

public interface LibglocalElements{
	// [base] lang langName langLocal
	IElementType LANG_DECL = new LibglocalElementType("LANG_DECL");

	// author author1[, author2[, ...]]
	IElementType AUTHOR_LIST = new LibglocalElementType("AUTHOR_LIST");
	// version versionValue
	IElementType VERSION_DECL = new LibglocalElementType("VERSION_DECL");

	IElementType MESSAGE_TREE = new LibglocalElementType("MESSAGE_TREE");
	IElementType MESSAGE_GROUP = new LibglocalElementType("MESSAGE_GROUP");
	IElementType MESSAGE_ENTRY = new LibglocalElementType("MESSAGE_ENTRY");
	IElementType MESSAGE_VALUE = new LibglocalElementType("MESSAGE_VALUE");

	// #{lorem.ipsum(arg = value)}
	IElementType MESSAGE_REF = new LibglocalElementType("MESSAGE_REF");
	IElementType MESSAGE_REF_ARGS = new LibglocalElementType("MESSAGE_REF_ARGS");
	IElementType MESSAGE_REF_ARG = new LibglocalElementType("MESSAGE_REF_ARG");
	// ARG_VALUE defined below
	// ${arg}
	IElementType ARG_REF = new LibglocalElementType("ARG_REF");
	// %{span}
	IElementType STYLE_SPAN = new LibglocalElementType("STYLE_SPAN");
	// %{span xxx}
	IElementType STACK_SPAN = new LibglocalElementType("STACK_SPAN");

	// arg argName [argType] [= argValue]
	IElementType ARG_MODIFIER = new LibglocalElementType("ARG_MODIFIER");
	IElementType ARG_FULL_TYPE = new LibglocalElementType("ARG_FULL_TYPE");
	IElementType ARG_DEFAULT = new LibglocalElementType("ARG_DEFAULT");
	IElementType ARG_VALUE = new LibglocalElementType("ARG_VALUE");
	IElementType STRING_LITERAL = new LibglocalElementType("STRING_LITERAL");

	// doc docValue
	IElementType DOC_MODIFIER = new LibglocalElementType("DOC_MODIFIER");
	// since versionValue (maybe deprecate?)
	IElementType SINCE_MODIFIER = new LibglocalElementType("SINCE_MODIFIER");
	// updated versionValue
	IElementType UPDATED_MODIFIER = new LibglocalElementType("UPDATED_MODIFIER");
}
