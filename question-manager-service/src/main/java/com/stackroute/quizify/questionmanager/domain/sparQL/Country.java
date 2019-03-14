package com.stackroute.quizify.questionmanager.domain.sparQL;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country {
	
	private String value;

	@Override
	public String toString() {
		return "Country [value=" + value + "]";
	}
	
	

}
