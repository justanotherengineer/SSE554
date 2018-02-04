package com.jcolby.sse554.p1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PersonProcessor {
	
	private List<Person> people_;
	
	public PersonProcessor() {
		people_ = null;
	}

	public PersonProcessor(String filename) {
		people_=this.parseFile(filename);
	}

	public List<Person> parseFile(String file) {
	    
		List<Person> inputList = new ArrayList<Person>();
	    
	    try{
	      File input_file = new File(file);
	      InputStream input_file_stream = new FileInputStream(input_file);
	      BufferedReader reader = new BufferedReader(new InputStreamReader(input_file_stream));
	      
	      inputList = reader.lines()
	    		  .map(mapToPerson)
	    		  .collect(Collectors.toList());
	      
	      reader.close();
	    } catch (Exception e) {
	      
	    }
	    return inputList ;
	}
	
	private Function<String, Person> mapToPerson = (line) -> {
		  String[] p = line.split(",");
		  Person person = new Person(p[0],Integer.parseInt(p[1]));
		  				  
		  return person; 
	};

	public List<Person> getPeople() {
		return people_;
	}
	
	public Double calculateAverage() {
		Double average_age = people_.stream()
				.collect(Collectors.averagingInt(p -> p.getAge()));
		return average_age;
	}

	public long countNames() {
		long number_of_names = people_.stream()
				.count();
		
		return number_of_names;
	}

	public long countNames(String Letter) {
		long number_of_names = people_.stream()
				.filter(p -> p.getName().startsWith("J"))
				.count();
		
		return number_of_names;
	}
	
	public List<Person> sortByAge() {
		
		List<Person> plist = people_.stream()
				.sorted(Comparator.comparing(Person::getAge))
				.collect(Collectors.toList());
		
		return plist;		
	}
	
	public List<Person> sortByName() {
		
		List<Person> sorted_list = people_.stream()
				.sorted(Comparator.comparing(Person::getName))
				.collect(Collectors.toList());
		
		return sorted_list;		
	}


 
}
