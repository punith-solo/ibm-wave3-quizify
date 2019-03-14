package com.stackroute.quizify.questionmanager.domain.sparQL;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vars {
	private String country;
	private String capital;

	@Override
	public String toString() {
		return "Vars [country=" + country + ", capital=" + capital + "]";
	}

}
