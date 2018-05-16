package io.github.sof3.libglocal.idea.psi;

import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.IElementType;
import io.github.sof3.libglocal.idea.psi.types.*;

public interface LibglocalTypes extends LibglocalTokens, LibglocalElements{
	static LibglocalElement createElement(ASTNode node){
		IElementType type = node.getElementType();
		if(type == LANG_DECL){
			return new LibglocalLangDeclaration(node);
		}else if(type == AUTHOR_LIST){
			return new LibglocalAuthorList(node);
		}else if(type == VERSION_DECL){
			return new LibglocalVersionDeclaration(node);
		}else if(type == MESSAGE_TREE){
			return new LibglocalMessageTree(node);
		}else if(type == MESSAGE_GROUP){
			return new LibglocalMessageGroup(node);
		}else if(type == MESSAGE_ENTRY){
			return new LibglocalMessageEntry(node);
		}else if(type == MESSAGE_VALUE){
			return new LibglocalMessageValue(node);
		}else if(type == MESSAGE_REF){
			return new LibglocalMessageRef(node);
		}else if(type == MESSAGE_REF_ARGS){
			return new LibglocalMessageRefArgs(node);
		}else if(type == MESSAGE_REF_ARG){
			return new LibglocalMessageRefArg(node);
		}else if(type == ARG_REF){
			return new LibglocalArgRef(node);
		}else if(type == STYLE_SPAN){
			return new LibglocalStyleSpan(node);
		}else if(type == STACK_SPAN){
			return new LibglocalStackSpan(node);
		}else if(type == ARG_MODIFIER){
			return new LibglocalArgModifier(node);
		}else if(type == ARG_FULL_TYPE){
			return new LibglocalArgFullType(node);
		}else if(type == ARG_DEFAULT){
			return new LibglocalArgDefault(node);
		}else if(type == ARG_VALUE){
			return new LibglocalArgValue(node);
		}else if(type == STRING_LITERAL){
			return new LibglocalStringLiteral(node);
		}else if(type == DOC_MODIFIER){
			return new LibglocalDocModifier(node);
		}else if(type == SINCE_MODIFIER){
			return new LibglocalSinceModifier(node);
		}else if(type == UPDATED_MODIFIER){
			return new LibglocalUpdatedModifier(node);
		}
		throw new AssertionError("Unknown element type: " + type);
	}
}
