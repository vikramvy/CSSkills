package com.test.practice;

import java.util.ArrayList;
import java.util.Comparator;

class Movie implements Comparable<Object>
{
	private String name;
	private int rating;
	private int year;
	
	public Movie() {};
	public Movie(String name, int rating, int year)
	{
		this.name = name;
		this.rating = rating;
		this.year = year;
		
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
			Movie m = (Movie) o;
			return this.year - m.year;
	}
	public String getName() {
		return name;
	}
	public int getRating() {
		return rating;
	}
	public int getYear() {
		return year;
	}
	
}

public class Main {


	public static void main(String[] args) {
	
		
	}
	
}
