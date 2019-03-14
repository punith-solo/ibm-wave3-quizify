package com.stackroute.quizify.questionmanager.domain.sparQL;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PresidentMain {

	private PresidentResults results;

	@Override
	public String toString() {
		return "PresidentMain [results=" + results + "]";
	}

}
