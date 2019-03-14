package com.stackroute.quizify.questionmanager.domain.sparQL;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Head {

	private String[] vars;

	@Override
	public String toString() {
		return "Head [vars=" + Arrays.toString(vars) + "]";
	}

}
