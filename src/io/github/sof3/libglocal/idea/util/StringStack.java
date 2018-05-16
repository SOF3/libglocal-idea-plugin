package io.github.sof3.libglocal.idea.util;

import java.util.Deque;
import java.util.LinkedList;

public class StringStack{
	private StringBuilder buffer = new StringBuilder();
	private Deque<Integer> positions = new LinkedList<>();

	public void push(String string){
		positions.add(buffer.length());
		buffer.append(string);
	}

	public String pop(){
		int start = positions.removeLast();
		String substring = buffer.substring(start);
		buffer.delete(start, buffer.length());
		return substring;
	}

	public boolean test(String string){
		return buffer.toString().equals(string);
	}

	public boolean isPrefixOf(String string){
		return string.startsWith(buffer.toString());
	}

	public void fill(String string){
		if(!string.startsWith(buffer.toString())){
			throw new IllegalArgumentException("string '" + string + "' does not start with stack '" + buffer + "'");
		}

		push(string.substring(buffer.length()));
	}

	@Override
	public String toString(){
		return buffer.toString();
	}
}
