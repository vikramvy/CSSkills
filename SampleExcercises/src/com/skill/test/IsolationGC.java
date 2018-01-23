package com.skill.test;

public class IsolationGC {

	IsolationGC i;
	public static void main(String[] args) {
		
		IsolationGC t1 = new IsolationGC();
		IsolationGC t2 = new IsolationGC();
		t1.i = t2;
		t2.i = t1;
		t1 = null;
		t2 =null;
		System.gc();
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("Finalize call");
		super.finalize();
	}
}
