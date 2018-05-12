package io.github.sof3.libglocal.idea;

import com.intellij.openapi.fileTypes.LanguageFileType;
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
		return "libglocal language file";
	}

	@NotNull
	@Override
	public String getDescription(){
		return "Declaration file for libglocal files";
	}

	@NotNull
	@Override
	public String getDefaultExtension(){
		return "lang";
	}

	@Nullable
	@Override
	public Icon getIcon(){
		return null;
	}
}
