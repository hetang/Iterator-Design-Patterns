package com.hgs.assignment2;

import java.util.AbstractCollection;
import java.util.Iterator;

public class NullBinarySearchTree<E> extends AbstractCollection<E> {
	
	public E m_Data = null;
	public NullBinarySearchTree<E> m_leftNode = null;
	public NullBinarySearchTree<E> m_rightNode = null;
	
	public NullBinarySearchTree(){		
	}
	
	public NullBinarySearchTree(E p_Data){
	}
	
	public boolean add(E p_Data){
		return false;
	}
	
	public Iterator<E> iterator() {
		return null;
	}

	public int size() {
		return 0;
	}

}
