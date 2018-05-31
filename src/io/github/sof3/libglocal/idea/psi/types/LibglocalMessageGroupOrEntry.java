package io.github.sof3.libglocal.idea.psi.types;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

public class LibglocalMessageGroupOrEntry extends LibglocalElement{
	public LibglocalMessageGroupOrEntry(@NotNull ASTNode node){
		super(node);
	}

	public boolean isPrivate(){
		for(PsiElement element = this; element instanceof LibglocalMessageGroupOrEntry; element = element.getParent()){
			if(element.getNode().findChildByType(PRIVATE_KEYWORD) != null){
				return true;
			}
		}
		return false;
	}

	@Override
	public String getName(){
		StringBuilder name = new StringBuilder();
		for(PsiElement element = this; element instanceof LibglocalMessageGroupOrEntry; element = element.getParent()){
			ASTNode messageIdNode = element.getNode().findChildByType(MESSAGE_ID);
			if(messageIdNode == null){
				break;
			}
			name.insert(0, messageIdNode.getText());
		}
		return name.toString();
	}
}
