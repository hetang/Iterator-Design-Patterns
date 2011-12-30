package com.hgs.assignment2;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class PreOrderIterator<T> implements Iterator<T> {
	private Stack<BinarySearchTree<?>> m_objStack = new Stack<BinarySearchTree<?>>();
	
	public PreOrderIterator(BinarySearchTree<?> p_objRoot){
			m_objStack.push(p_objRoot);
	}
	
	public boolean hasNext() {
		return !m_objStack.isEmpty();
	}

	public T next() {
		if(!hasNext()){
			throw new NoSuchElementException();
		}
		
		BinarySearchTree<?> l_obj = m_objStack.pop();
		T l_Value = (T) l_obj.m_Data;
		if(l_obj.m_rightNode instanceof BinarySearchTree<?>){	
			m_objStack.push((BinarySearchTree<?>) l_obj.m_rightNode);
		}
		if(l_obj.m_leftNode instanceof BinarySearchTree<?>){
			m_objStack.push((BinarySearchTree<?>) l_obj.m_leftNode);
		}
		return l_Value;
	}

	public void remove() {
	}
}
