package com.stackroute.quizify.questionmanager.domain.sparQL;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LangCountry {
	
	private String value;


	@Override
	public String toString() {
		return "LangCountry [value=" + value + "]";
	}
	
	
	
}
