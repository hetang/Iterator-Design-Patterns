package com.hgs.assignment2;

import java.util.Iterator;
import org.junit.Test;
import junit.framework.TestCase;

public class Assignment2JUnitTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	@Test
	public void testAdd() throws Exception {
		BinarySearchTree<String> l_obj = new BinarySearchTree<String>();
		boolean l_bool = l_obj.add("s");		
		assertTrue(l_bool);
	}
	
	@Test
	public void testLeftAdd() throws Exception {
		BinarySearchTree<String> l_obj = new BinarySearchTree<String>();
		l_obj.add("s");
		l_obj.add("bgs");
		assertTrue(null != l_obj.m_leftNode);
	}
	
	@Test
	public void testRightAdd() throws Exception {
		BinarySearchTree<String> l_obj = new BinarySearchTree<String>();
		l_obj.add("hgs");
		l_obj.add("s");
		assertTrue(null != l_obj.m_rightNode);		
	}
	
	@Test
	public void testDuplicateAdd() {
		try{
			BinarySearchTree<String> l_obj = new BinarySearchTree<String>();
			l_obj.add("s");
			l_obj.add("s");
			assertTrue(false);
		}catch(Exception e){
			assertTrue(true);
		}
		
	}
	
	@Test
	public void testDisplayNameInReverseOrder() throws Exception {
		BinarySearchTree<String> l_obj = new BinarySearchTree<String>();
		StringBuffer l_strResult = new StringBuffer();
		l_obj.add("s");
		l_obj.add("bgs");
		l_obj.add("abn");
		l_obj.add("n");
		l_obj.add("abc");
		l_obj.add("pqr");
		l_obj.add("xyz");
		
		Iterator<String> l_objIterate = l_obj.iterator();
		while(l_objIterate.hasNext()){
			l_strResult.append(l_objIterate.next()).append(",");
		}
		assertEquals("s,bgs,abn,abc,n,pqr,xyz,", l_strResult.toString());
	}

	@Test
	public void testDisplaySelectiveNameInOrder() throws Exception {
		char[] l_charValue = {'n','s'};
		BinarySearchTree<String> l_obj = new BinarySearchTree<String>();
		StringBuffer l_strResult = new StringBuffer();
		l_obj.add("s");
		l_obj.add("bgs");
		l_obj.add("abn");
		l_obj.add("n");
		l_obj.add("abc");
		l_obj.add("pqr");
		l_obj.add("xyz");
		
		Iterator<String> l_objIterate = l_obj.endsInIterator(l_obj.iterator(),l_charValue);
		while(l_objIterate.hasNext()){
			l_strResult.append(l_objIterate.next()).append(",");
		}
		assertEquals("s,bgs,abn,n,", l_strResult.toString());
	}
	
	@Test
	public void testDisplaySelectiveNameInOrder_BoundaryCond() throws Exception {
		BinarySearchTree<String> l_obj3 = new BinarySearchTree<String>();
		char[] l_charValue = {'n','s'};
		StringBuffer l_strResult = new StringBuffer();
		l_obj3.add("s");
		l_obj3.add("ss");
		l_obj3.add("sss");
		l_obj3.add("ssss");
		l_obj3.add("sssss");
		l_obj3.add("ssssss");
		l_obj3.add("sssssss");
		
		Iterator<String> l_objIterate = l_obj3.endsInIterator(l_obj3.iterator(),l_charValue);
		while(l_objIterate.hasNext()){
			l_strResult.append(l_objIterate.next()).append(",");
		}
		
		assertEquals("s,ss,sss,ssss,sssss,ssssss,sssssss,", l_strResult.toString());
	}	
	
	@Test
	public void testDisplaySelectiveNameInOrder_BlankData() throws Exception {
		BinarySearchTree<String> m_Obj = new BinarySearchTree<String>();
		StringBuffer l_strResult = new StringBuffer();
		m_Obj.add("s");
		m_Obj.add("");
		m_Obj.add("abn");
		
		Iterator<String> l_obj = m_Obj.iterator();
		while(l_obj.hasNext()){
			l_strResult.append(l_obj.next()).append(",");
		}		
		assertEquals("s,,abn,", l_strResult.toString());		
	}	
}
