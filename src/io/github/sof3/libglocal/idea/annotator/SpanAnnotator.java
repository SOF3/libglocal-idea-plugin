package io.github.sof3.libglocal.idea.annotator;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import io.github.sof3.libglocal.idea.psi.LibglocalElements;
import io.github.sof3.libglocal.idea.psi.types.LibglocalMessageValue;
import io.github.sof3.libglocal.idea.psi.types.LibglocalStackSpan;
import io.github.sof3.libglocal.idea.psi.types.LibglocalStyleSpan;
import org.jetbrains.annotations.NotNull;

public class SpanAnnotator implements Annotator, LibglocalElements, SpanAttributes{
	@Override
	public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder){
		if(element instanceof LibglocalMessageValue){
			formatMessage((LibglocalMessageValue) element, holder);
		}
	}

	private void formatMessage(LibglocalMessageValue element, AnnotationHolder holder){
		int styleStart = element.getFirstChild().getTextRange().getStartOffset();
		TextAttributesKey styleSpan = null;
		for(PsiElement child : element.getChildren()){
			if(child instanceof LibglocalStyleSpan){
				if(styleSpan != null){
					holder.createInfoAnnotation(new TextRange(styleStart, child.getTextRange().getStartOffset()), null).setTextAttributes(styleSpan);
				}
				String style = ((LibglocalStyleSpan) child).getStyle();
				styleSpan = null;
				if("info".equals(style)){
					styleSpan = STYLE_INFO;
				}else if("success".equals(style)){
					styleSpan = STYLE_SUCCESS;
				}else if("notice".equals(style)){
					styleSpan = STYLE_NOTICE;
				}else if("warn".equals(style)){
					styleSpan = STYLE_WARN;
				}else if("error".equals(style)){
					styleSpan = STYLE_ERROR;
				}
				if(styleSpan != null){
					styleStart = child.getTextRange().getEndOffset();
				}
			}else if(child instanceof LibglocalStackSpan){
				String name = ((LibglocalStackSpan) child).getStackName();
				TextAttributesKey attribute = null;
				if("hl1".equals(name)){
					attribute = STACK_HL1;
				}else if("hl2".equals(name)){
					attribute = styleSpan == STYLE_WARN ? STACK_HL2_ALT : STACK_HL2;
				}else if("hl3".equals(name)){
					attribute = styleSpan == STYLE_NOTICE ? STACK_HL3_ALT : STACK_HL3;
				}else if("hl4".equals(name)){
					attribute = styleSpan == STYLE_SUCCESS ? STACK_HL4_ALT : STACK_HL4;
				}else if("b".equals(name)){
					attribute = STACK_BOLD;
				}else if("i".equals(name)){
					attribute = STACK_ITALIC;
				}else if("u".equals(name)){
					attribute = STACK_UNDERLINED;
				}else if("s".equals(name)){
					attribute = STACK_STRIKETHROUGH;
				}
				if(attribute != null){
					holder.createInfoAnnotation(((LibglocalStackSpan) child).getMessageValue(), null).setTextAttributes(attribute);
				}
				formatMessage(((LibglocalStackSpan) child).getMessageValue(), holder);
			}
		}
		if(styleSpan != null){
			holder.createInfoAnnotation(new TextRange(styleStart, element.getLastChild().getTextRange().getEndOffset()), null).setTextAttributes(styleSpan);
		}
	}
}
