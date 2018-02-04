package com.jcolby.sse554.p1;

public class Template {

	private String template_text_;
	
	
	public Template() {
		
	}

	
	public Template(String template_text) {
		template_text_ = template_text;
	}

	
	public String render(int value) {
		
		return String.format(template_text_, value);
	}

}
