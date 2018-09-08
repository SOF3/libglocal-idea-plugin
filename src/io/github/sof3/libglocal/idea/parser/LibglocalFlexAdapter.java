package io.github.sof3.libglocal.idea.parser;

import com.intellij.ide.plugins.PluginManager;
import com.intellij.lexer.FlexAdapter;
import com.intellij.psi.tree.IElementType;
import io.github.sof3.libglocal.idea.LibglocalLexer;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class LibglocalFlexAdapter extends FlexAdapter{
	private static Map<Integer, String> states = new HashMap<>();

	static{
		for(Field field : LibglocalLexer.class.getDeclaredFields()){
			if(field.getType() == int.class && field.getName().startsWith("S_")){
				try{
					states.put(field.getInt(null), field.getName());
				}catch(IllegalAccessException e){
					throw new RuntimeException(e);
				}
			}
		}
	}

	public LibglocalFlexAdapter(){
		super(new LibglocalLexer(){
			@Override
			public IElementType advance(){
				int oldState = yystate();
				try{
					IElementType token = super.advance();
					System.out.println("Lexer.advance() text " + yytext() + ", state: " + states.get(oldState) + " => " + states.get(yystate()) + ", token = " + token);
					return token;
				}catch(Exception e){
					System.err.println("Lexer.advance() text " + yytext() + ", state: " + states.get(oldState) + " => " + states.get(yystate()) + ", exception: " + e.getMessage());
					throw new RuntimeException(e);
				}
			}
		});
	}
}
