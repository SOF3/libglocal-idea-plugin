package io.github.sof3.libglocal.idea.lang;

import com.intellij.lang.Language;
import org.jetbrains.annotations.NotNull;

public class LibglocalLanguage extends Language{
	private static LibglocalLanguage ourInstance = new LibglocalLanguage();

	public static LibglocalLanguage getInstance(){
		return ourInstance;
	}

	private LibglocalLanguage(){
		super("libglocal-lang");
	}

	@NotNull
	@Override
	public String getDisplayName(){
		return "libglocal language lang";
	}
}
