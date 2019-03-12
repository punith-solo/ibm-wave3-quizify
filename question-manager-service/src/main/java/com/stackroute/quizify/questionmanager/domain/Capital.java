package com.stackroute.quizify.questionmanager.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Capital {

	private String value;

	@Override
	public String toString() {
		return "Capital [value=" + value + "]";
	}

}
