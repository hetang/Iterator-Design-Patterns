package com.hgs.assignment2;
 
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class EndsInIterator implements Iterator<String> {
	private Stack<String> m_obj = new Stack<String>();
	private Iterator<String> m_Iterate = null;
	private char[] m_endings = null;
	
	public EndsInIterator(Iterator<String> p_input, char[] p_endings){
		m_Iterate = p_input;
		m_endings = p_endings;
		traverseTree();
	}
	
	public boolean hasNext() {
		return !m_obj.isEmpty();
	}

	public String next() {
		if(!hasNext()){
			throw new NoSuchElementException();
		}
		
		String l_returnValue = m_obj.pop();
		traverseTree();
		return l_returnValue;
	}
	
	private void traverseTree(){
		while(m_Iterate.hasNext()){
			String l_value = m_Iterate.next();
			for(int i=0;i<m_endings.length;i++){
				if(l_value.endsWith(String.valueOf(m_endings[i]))){
					m_obj.push(l_value);
					return;
				}
			}
		}
	}

	public void remove() {
	}

}
