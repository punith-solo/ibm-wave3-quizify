package com.stackroute.quizify.questionmanager.domain.sparQL;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dob {

	private String value;

	@Override
	public String toString() {
		return "Dob [value=" + value + "]";
	}

}
