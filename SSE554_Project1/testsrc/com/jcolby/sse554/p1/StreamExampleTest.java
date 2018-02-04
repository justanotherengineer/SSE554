package com.jcolby.sse554.p1;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StreamExampleTest {
	
	StreamExample example1_, example2_;
	String test1_file_contents_,test2_file_contents_;
	
	@BeforeEach
	void setUp() throws Exception {

		test1_file_contents_ = new String(Files.readAllBytes(
				Paths.get("StreamExampleText1.txt")), StandardCharsets.UTF_8);
		test2_file_contents_ = new String(Files.readAllBytes(
				Paths.get("StreamExampleText2.txt")), StandardCharsets.UTF_8);
		example1_ = new StreamExample(test1_file_contents_);
		example2_ = new StreamExample(test2_file_contents_);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void canInstantiateWithNoString() {
		StreamExample example_null = new StreamExample();
		assertNotNull(example_null);
	}
	
	@Test
	void canInstantiateWithAString() {
		assertNotNull(example1_);
		assertNotNull(example2_);
	}
	
	@Test
	void contructorWithStringCreatesList() {
		assertNotNull(example1_.words());
		assertNotNull(example2_.words());
	}
	
	@Test
	void countWordsReturnsNumberOfWords() {
		long test1_expected_words = 7;
		long test2_expected_words = 78;
		assertEquals(test1_expected_words, example1_.countWords());
		assertEquals(test2_expected_words, example2_.countWords());
	}
	
	@Test
	void countWordsOfLengthReturnsNumberOfWordsLongerThanInput() {
		long test1_expected_words = 0;
		long test2_expected_words = 30;
		assertEquals(test1_expected_words, example1_.countWordsOfLength(5));
		assertEquals(test2_expected_words, example2_.countWordsOfLength(5));
	}
	
}
