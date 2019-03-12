package com.stackroute.quizify.questionmanager.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dod {

	private String value;

	@Override
	public String toString() {
		return "Dod [value=" + value + "]";
	}

}
