package com.junit.testcases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class FinalReferenceChange {

	@Test
	void test() {
		final int i =42;
		//i =43; // this will result in Compilation Error
		final List<String> list = new ArrayList<String>(20);
		assertEquals(0,list.size());
		list.add("Hello");
		assertEquals(1,list.size());
		list.clear();
		assertEquals(0,list.size());
		assertEquals(42, i);
	}
	@Test
	public void stringCreation() {
		String helloString1 = new String("Hello World!");
		String helloString2 = "Hello World!";
		assertEquals(helloString1, helloString2);
		}
	@Test
	public void exceptNullPointerException()
	{
		final String s = null;
		//final int len = s.length();
		assertThrows(NullPointerException.class, ()->{
			final int len = s.length();
		});
	}
}
