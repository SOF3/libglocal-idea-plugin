package io.github.sof3.libglocal.idea.lang;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.tree.IFileElementType;
import org.jetbrains.annotations.NotNull;

public class LibglocalFile extends PsiFileBase{
	public final static IFileElementType FILE_ELEMENT_TYPE = new IFileElementType(LibglocalLanguage.getInstance());

	public LibglocalFile(@NotNull FileViewProvider viewProvider){
		super(viewProvider, LibglocalLanguage.getInstance());
	}

	@NotNull
	@Override
	public FileType getFileType(){
		return LibglocalFileType.getInstance();
	}
}
