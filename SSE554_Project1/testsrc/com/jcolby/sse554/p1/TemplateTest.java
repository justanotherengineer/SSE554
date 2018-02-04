package com.jcolby.sse554.p1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TemplateTest {
	
	public String pattern_string;
	public Template template;
	
	@BeforeEach
	void setUp() throws Exception {
		pattern_string = "Your test score was: %d";
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void canInstantiateATemplate() {
		template = new Template();
		assertNotNull(template);
	}
	
	@Test
	void canInstantiateATemplateWithAString() {
		template = new Template(pattern_string);
		assertNotNull(template);
	}
	
	@Test
	public void renderMethodReturnsAString() {
		template = new Template(pattern_string);
					
		assertNotNull(template.render(80));
	}
	
	@Test
	public void renderMethodReturnsProperMessageGivenScore() {
		int score = 90;
		template = new Template(pattern_string);
		
		String expected_message = "Your test score was: " + score;
		assertNotNull(template.render(score));
		assertEquals(expected_message, template.render(score));
	}
	
	@Test
	public void renderMethodThrowsExeptionWithNullTemplateText() {
		template = new Template(null);
		assertThrows(Exception.class,()->{template.render(90);});
	}
}
