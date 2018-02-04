package com.jcolby.sse554.p1;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamExample2 {

	public static void main(String[] args) {
		
		String filename = "StreamExampleText4.txt";
		PersonProcessor processor = new PersonProcessor(filename);
		ParallelPersonProcessor p_processor = new ParallelPersonProcessor(filename);
		
		/*Start clock for regular stream processing*/
		double startTime = System.nanoTime();
		
		List<Person> people = processor.getPeople();
		List<Person> people_sorted_by_age = processor.sortByAge();
		List<Person> people_sorted_by_name = processor.sortByName();
		Map<Integer, List<Person>> peopleByAge = people_sorted_by_age
				.parallelStream()
				.collect(Collectors.groupingBy(p -> p.getAge()));
		Long number_of_people = processor.countNames();
		Long people_with_letter_j = processor.countNames("J");
		Double average_age_of_people = processor.calculateAverage();
		
		double endTime   = System.nanoTime();
		
		/*Start clock for parallel stream processing*/
		double p_startTime = System.nanoTime();
		
		List<Person> p_people = p_processor.getPeople();
		List<Person> p_people_sorted_by_age = p_processor.sortByAge();
		List<Person> p_people_sorted_by_name = p_processor.sortByName();
		Map<Integer, List<Person>> p_peopleByAge = p_people_sorted_by_age
				.parallelStream()
				.collect(Collectors.groupingBy(p -> p.getAge()));
		Long p_number_of_people = p_processor.countNames();
		Long p_people_with_letter_j = p_processor.countNames("J");
		Double p_average_age_of_people = p_processor.calculateAverage();
		
		double p_endTime   = System.nanoTime();
		
		double totalTime = endTime - startTime;
		double p_totalTime = p_endTime - p_startTime;
				
		System.out.println("File Statistics-----------------------------");
		System.out.println("Filename: " + filename);
		System.out.println("Number of People in list: " + number_of_people);
		System.out.println("Number of \"J\" names in list: " + people_with_letter_j);
		System.out.println("Average age of People in list: " + average_age_of_people);
		
		System.out.println("\nRaw List of Persons-------------------------");
		people.forEach(p -> System.out.println(p.toString()));
		
		System.out.println("\nList of Persons by Age----------------------");
		people_sorted_by_age.forEach(p -> System.out.println(p.toString()));
		
		System.out.println("\nList of Persons by Name---------------------");
		people_sorted_by_name.forEach(p -> System.out.println(p.toString()));
		
		System.out.println("\nPersons Grouped by Age----------------------");
		peopleByAge.forEach((age, p) -> System.out.format("Age %s: %s\n", age,p));
		
		System.out.println("\nProcessor Statistics--------------------------");
		System.out.println("Total time for regular stream processor : " + (totalTime/1000000) +" miliseconds.");
		System.out.println("Total time for parallel stream processor : " + (p_totalTime/1000000) +" miliseconds.");
		System.out.println("The parallel processor was: " + ((totalTime - p_totalTime)/1000000) +" miliseconds faster.");

	}
}
