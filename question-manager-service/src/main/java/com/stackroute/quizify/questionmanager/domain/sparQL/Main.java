package com.stackroute.quizify.questionmanager.domain.sparQL;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Main {
	
	private Head head;
	private Results results;


	@Override
	public String toString() {
		return "Main [head=" + head + ", results=" + results + "]";
	}

}
