package io.github.sof3.libglocal.idea.util;

import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.ProjectScope;
import com.intellij.psi.util.PsiTreeUtil;
import io.github.sof3.libglocal.idea.lang.LibglocalFileType;
import io.github.sof3.libglocal.idea.psi.types.LibglocalLangDeclaration;
import io.github.sof3.libglocal.idea.psi.types.LibglocalMessageEntry;

import java.util.Objects;
import java.util.stream.Stream;

public class LibglocalFinder{
	public static Stream<PsiFile> findLangFiles(Project project){
		return FileTypeIndex.getFiles(LibglocalFileType.getInstance(), ProjectScope.getAllScope(project)).stream()
				.map(file -> PsiManager.getInstance(project).findFile(file))
				.filter(file -> file != null && file.getFileType() == LibglocalFileType.getInstance())
				;
	}

	public static Stream<PsiFile> findBaseLangFiles(Project project){
		return findLangFiles(project).filter(file -> {
			LibglocalLangDeclaration lang = PsiTreeUtil.findChildOfType(file, LibglocalLangDeclaration.class);
			if(lang == null){
				return true; // error, but assume it is base
			}
			return lang.isBase();
		});
	}

	public static Stream<LibglocalMessageEntry> findPublicMessageDeclarations(Project project){
		return findBaseLangFiles(project)
				.flatMap(file -> PsiTreeUtil.findChildrenOfType(file, LibglocalMessageEntry.class).stream())
				.filter(message -> !message.isPrivate())
				;
	}

	public static Stream<LibglocalMessageEntry> findPublicMessageDeclarationsByName(Project project, String name){
		return findPublicMessageDeclarations(project).filter(message -> Objects.equals(message.getName(), name));
	}
}
