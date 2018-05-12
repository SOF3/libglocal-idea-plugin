package io.github.sof3.libglocal.idea;

import com.intellij.lexer.FlexAdapter;

public class LibglocalFlexAdapter extends FlexAdapter{
	public LibglocalFlexAdapter(){
		super(new LibglocalLexer());
	}
}
