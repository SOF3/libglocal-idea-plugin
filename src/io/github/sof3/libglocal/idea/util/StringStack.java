package io.github.sof3.libglocal.idea.util;

import java.util.Deque;
import java.util.LinkedList;

public class StringStack{
	private StringBuffer buffer = new StringBuffer();
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
}
