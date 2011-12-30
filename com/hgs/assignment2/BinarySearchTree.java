package com.hgs.assignment2;

import java.util.AbstractCollection;
import java.util.DuplicateFormatFlagsException;
import java.util.Iterator;

public class BinarySearchTree<E extends Comparable<E>> extends AbstractCollection<E> {
	public E m_Data = null;
	public AbstractCollection<E> m_leftNode = new NullBinarySearchTree<E>();
	public AbstractCollection<E> m_rightNode = new NullBinarySearchTree<E>();
	private int m_Size = 0;
	
	public BinarySearchTree(){		
	}
	
	public BinarySearchTree(E p_Data){
		this.m_Data = p_Data;
	}
	
	public boolean add(E p_Data){
		if(null == m_Data){
			this.m_Data = p_Data;			
		}else{
			BinarySearchTree<E> l_childNode = searchNodePosition(this,p_Data);
			int l_intCompareValue = l_childNode.m_Data.compareTo(p_Data);
			if(l_intCompareValue == 0){				
				throw new DuplicateFormatFlagsException(p_Data + " value already present");				
			}else if(l_intCompareValue < 0){
				
				BinarySearchTree<E> l_objRightNode = new BinarySearchTree<E>(p_Data);
				l_childNode.m_rightNode = l_objRightNode;
				
			}else{
				
				BinarySearchTree<E> l_objLeftNode = new BinarySearchTree<E>(p_Data);
				l_childNode.m_leftNode = l_objLeftNode;				
				
			}
		}
		this.m_Size++;
		return true;
	}
	
	private BinarySearchTree<E> searchNodePosition(BinarySearchTree<E> p_Node,E p_Data){
		int l_intCompareValue = p_Node.m_Data.compareTo(p_Data);
		if(l_intCompareValue == 0){				
			throw new DuplicateFormatFlagsException(p_Data + " value already present");				
		}else if(l_intCompareValue < 0){			
			if(p_Node.m_rightNode instanceof BinarySearchTree<?>){					
				return searchNodePosition((BinarySearchTree<E>) p_Node.m_rightNode,p_Data);				
			}			
		} else {			
			if(p_Node.m_leftNode instanceof BinarySearchTree<?>){				
				return searchNodePosition((BinarySearchTree<E>) p_Node.m_leftNode,p_Data);				
			}			
		}
	
		return p_Node;
	}
	
	public Iterator<E> iterator() {		
		return new PreOrderIterator<E>(this);
	}
	
	public Iterator<String> endsInIterator(Iterator<String> p_objIterator,char[] p_endings) {
		return new EndsInIterator(p_objIterator,p_endings);
	}

	public int size() {
		return m_Size;
	}

}
