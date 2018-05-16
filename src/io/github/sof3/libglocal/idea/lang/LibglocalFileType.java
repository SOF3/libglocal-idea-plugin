package io.github.sof3.libglocal.idea.lang;

import com.intellij.openapi.fileTypes.LanguageFileType;
import io.github.sof3.libglocal.idea.LibglocalIcon;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.Icon;

public class LibglocalFileType extends LanguageFileType{
	private final static LibglocalFileType instance = new LibglocalFileType();

	public static LibglocalFileType getInstance(){
		return instance;
	}

	private LibglocalFileType(){
		super(LibglocalLanguage.getInstance());
	}

	@NotNull
	@Override
	public String getName(){
		return "libglocal language lang";
	}

	@NotNull
	@Override
	public String getDescription(){
		return "Declaration lang for libglocal files";
	}

	@NotNull
	@Override
	public String getDefaultExtension(){
		return "lang";
	}

	@Nullable
	@Override
	public Icon getIcon(){
		return LibglocalIcon.LIBGLOCAL_16;
	}
}
