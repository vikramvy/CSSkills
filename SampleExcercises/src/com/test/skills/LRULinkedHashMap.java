package com.test.skills;

import java.util.LinkedHashMap;

public class LRULinkedHashMap extends LinkedHashMap<Integer, String>{
	private final int capacity;
	public LRULinkedHashMap(int capacity) {
		// TODO Auto-generated constructor stub
		super(capacity, 0.75f, true);
		this.capacity = capacity;
	}

	@Override
	protected boolean removeEldestEntry(java.util.Map.Entry<Integer, String> eldest) {
		// TODO Auto-generated method stub
		return (size() > this.capacity);
	}
	
	public String find(Integer key)
	{
		return super.get(key);
	}
	public void set(Integer key, String value)
	{
		super.put(key, value);
	}
	public static void main(String[] args)
	{
		LRULinkedHashMap cache = new LRULinkedHashMap(3);
		cache.set(2,"Hello");
		cache.set(3, "String");
		cache.set(1, "value");
		System.out.println(cache.find(3));
		cache.set(6, "value2");
		cache.set(4, "value3");
		System.out.println(cache.find(2));
		System.out.println(cache.find(1));
		cache.forEach((k,v)->System.out.print("  Key : "+k+" Value "+v));
	}
}
