package com.jcolby.sse554.p1;

public class Person {
	    private String name;
	    private int age;

	    Person(String name, int age) {
	        this.name = name;
	        this.age = age;
	    }

	    @Override
	    public String toString() {
	        return name +": " + age;
	    }
	    
	    public int getAge() {
			return age;
		}
	    
	    public String getName() {
	        return name;
	    }
}

