package com.test.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Person //implements Comparable<Object>
{
	private String name;
	private int id;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	private int age;
	public Person()
	{
		
	}
	
	public Person(String name, int id, int age)
	{
		this.name = name;
		this.id = id;
		this.age = age;
	}
	
	/*@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Person p = (Person) o;
		return this.id - p.id;
		//return (this.id <p.id)?-1:(this.id > p.id)?1:0;
		
	}*/
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Person is : "+this.name+" id is "+this.id+" age is "+this.age;
	}
	
}

public class CompareExample {
	
	public static void main(String[] args) {
		Person[] personArr = new Person[3];
		personArr[0]= new Person("a1",2,30);
		personArr[1] = new Person("a2",1,40);
		personArr[2] = new Person("a3",3,20);
		List<Person> l = new ArrayList<Person>();
		l = Arrays.asList(personArr);
		l.sort((Person o1, Person o2)->o1.getAge()-o2.getAge());
		l.forEach(p->System.out.println(p.toString()));
		
    }
		
	


}
