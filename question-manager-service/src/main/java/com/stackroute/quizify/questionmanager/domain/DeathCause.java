package com.stackroute.quizify.questionmanager.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeathCause {

	private String value;

	@Override
	public String toString() {
		return "DeathCause [value=" + value + "]";
	}

}
