package com.stackroute.quizify.questionmanager.domain.sparQL;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Results {

	private List<Bindings> bindings;

	@Override
	public String toString() {
		return "Results [bindings=" + bindings + "]";
	}

}
