package com.jcolby.sse554.p1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamExample {
	
	private List<String> words_;

	public StreamExample() {	
	}
	
	public StreamExample(String file_contents) {
		createListOfWords(file_contents);
	}
	
	private void createListOfWords(String input) {
		words_ = Arrays.asList(input.split("\\PL+"));
	}
	
	public List<String> words() {
		return words_;
	}

	public long countWords() {		
		long number_of_words = words_.stream().count();
		System.out.println(number_of_words);
		return number_of_words;
	}
	
	public long countWordsOfLength(int length) {
		
		long number_of_words = words_.stream()
				.filter(w -> w.length() > length)
				.count();
		System.out.println(number_of_words);
		return number_of_words;
	}
	
	public void arrayToStream(String input) {
		Stream<String> words = Stream.of(input.split("\\PL+")); 
	}
		
}
