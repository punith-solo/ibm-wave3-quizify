package com.stackroute.quizify.questionmanager.domain.sparQL;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PresidentResults {

	private List<PresidentBindings> bindings;

	@Override
	public String toString() {
		return "PresidentResults [bindings=" + bindings + "]";
	}

}
