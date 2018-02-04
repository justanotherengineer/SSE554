package com.jcolby.sse554.p1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ParallelPersonProcessorTest {
	
	ParallelPersonProcessor test_processor, tmp_processor;
	String testfile = "StreamExampleText4.txt";
	
	List<Person> expected_people_list = Arrays.asList(
		        new Person("Jackson", 22),
		        new Person("Liam", 75),
		        new Person("Noah", 29),
		        new Person("Aiden", 22));
		
	@BeforeEach
	void setUp() throws Exception {
		test_processor = new ParallelPersonProcessor(testfile);
	}

	@AfterEach
	void tearDown() throws Exception {
		test_processor = null;
	}

	@Test
	void canInstantiate() {
		tmp_processor = new ParallelPersonProcessor();
		assertNotNull(tmp_processor);
	}
	
	@Test
	void canInstantiateWithFileOfPeople() {
		tmp_processor = new ParallelPersonProcessor(testfile);
		assertNotNull(tmp_processor);
	}
	
	@Test
	void parseFileReturnsListOfPersons() {
		List<Person> people = test_processor.parseFile(testfile);
		
		assertEquals(expected_people_list.toString(), people.toString());
	}
	
	@Test
	void getPeopleReturnsListOfPersons() {
		List<Person> people = test_processor.getPeople();
		assertEquals(expected_people_list.toString(), people.toString());
	}
	
	@Test
	void calculateAverageAgeReturnsDouble() {
		
		Double expected_average = 37.0;
		assertEquals(expected_average, test_processor.calculateAverage());
	}
	
	@Test
	void countNumberOfNames() {
		long expected_number = 4;
		
		assertEquals(expected_number, test_processor.countNames());
	}
	
	@Test
	void countNumberOfNamesThatStartWithALetter() {
		long expected_number = 1;
		assertEquals(expected_number, test_processor.countNames("J"));
	}
	
	@Test
	void sortByAgeReturnsSortedList() {
		expected_people_list = Arrays.asList(
				new Person("Jackson", 22),
				new Person("Aiden", 22),
				new Person("Noah", 29),
				new Person("Liam", 75)		        
		        );
		List<Person> sorted_people = test_processor.sortByAge();
		assertEquals(expected_people_list.toString(), sorted_people.toString());
	}
	
	@Test
	void sortByNameReturnsSortedList() {
		expected_people_list = Arrays.asList(
				new Person("Aiden", 22),
				new Person("Jackson", 22),
		        new Person("Liam", 75),
		        new Person("Noah", 29)
		        );
		List<Person> sorted_people = test_processor.sortByName();
		assertEquals(expected_people_list.toString(), sorted_people.toString());
	}

}
