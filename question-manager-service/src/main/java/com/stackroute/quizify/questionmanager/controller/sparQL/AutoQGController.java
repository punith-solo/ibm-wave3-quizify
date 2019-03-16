package com.stackroute.quizify.questionmanager.controller.sparQL;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.stackroute.quizify.questionmanager.domain.Category;
import com.stackroute.quizify.questionmanager.domain.Genre;
import com.stackroute.quizify.questionmanager.domain.Question;
import com.stackroute.quizify.questionmanager.domain.Topic;
import com.stackroute.quizify.questionmanager.domain.sparQL.*;
import com.stackroute.quizify.questionmanager.exception.QuestionAlreadyExistsException;
import com.stackroute.quizify.questionmanager.service.QuestionService;
import com.stackroute.quizify.questionmanager.service.sparQL.QGCategoryService;
import com.stackroute.quizify.questionmanager.service.sparQL.QGTopicService;
import com.stackroute.quizify.questionmanager.service.sparQL.SparQLQueryService;
import io.micrometer.core.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


@CrossOrigin("*")
@RequestMapping("/api/v1/question-generator")
@RestController
public class AutoQGController {
	@Autowired
	private QuestionService questionService;

	@Autowired
	private QGCategoryService qGCategoryService;

	@Autowired
	private QGTopicService qgTopicService;

	@Autowired
	private SparQLQueryService sparQLQueryService;

	/*
	 * Get all questions in a topic by topic name and also with category ID
	 */
	@Timed(value = "qg.get.AuroGenerationquestions", histogram = true, percentiles = { 0.95 }, extraTags = { "version", "1.0" })

	@RequestMapping(value = "/auto-questions", method = RequestMethod.POST)
	public ResponseEntity<List<Question>> autoGenerateQuestions(@RequestBody QuestionDetails details)
			throws JsonParseException, JsonMappingException, IOException, QuestionAlreadyExistsException {
		Category category = details.getCategory();
		Topic topic = details.getTopic();
		Genre genre = details.getGenre();
		String type = details.getType();
		String level = details.getLevel();
		String topicName=topic.getName();
		List<Question> listQuestions = new ArrayList<>();

		if (topicName.equalsIgnoreCase("Capitals")) {
			Main main = new Main();
			Main data = sparQLQueryService.capitals(main);
			String questionStem = "What is capital of ";
			Random rand = new Random();
			int i = rand.nextInt(data.getResults().getBindings().size()) + 1;
			int j = rand.nextInt(data.getResults().getBindings().size()) + 1;
			int k = rand.nextInt(data.getResults().getBindings().size()) - 3;
			for (int c = 0; c < data.getResults().getBindings().size(); c++) {
				Question question = new Question();
				List<String> listOptions= new ArrayList();
				question.setId(0);
				question.setCategory(category);
				question.setTopic(topic);
				question.setGenre(genre);
				question.setStatement(
						questionStem + data.getResults().getBindings().get(c).getCountry().getValue() + "?");
				question.setLevel(level);
				question.setType(type);
				listOptions.add(data.getResults().getBindings().get(i).getCapital().getValue());
				listOptions.add(data.getResults().getBindings().get(j).getCapital().getValue());
				listOptions.add(data.getResults().getBindings().get(c).getCapital().getValue());
				listOptions.add(data.getResults().getBindings().get(k).getCapital().getValue());

				Collections.shuffle(listOptions);
				question.setOptions(listOptions);
				question.setCorrectAnswer(data.getResults().getBindings().get(c).getCapital().getValue());

				listQuestions.add(question);
				this.questionService.addNewQuestion(question);
			}
		}
		if (topicName.equalsIgnoreCase("Presidents")) {
			PresidentMain main = new PresidentMain();
			PresidentMain data = sparQLQueryService.presidents(main);
			String questionStem = "When and how President ";
			Random rand = new Random();
			int i = rand.nextInt(data.getResults().getBindings().size()) + 1;
			int j = rand.nextInt(data.getResults().getBindings().size()) + 1;
			int k = rand.nextInt(data.getResults().getBindings().size()) + 1;
			for (int c = 0; c < data.getResults().getBindings().size(); c++) {
				Question question = new Question();
				List<String> listOptions= new ArrayList();
				question.setId(0);
				question.setCategory(category);
				question.setTopic(topic);
				question.setGenre(genre);
				question.setStatement(questionStem
						+ data.getResults().getBindings().get(c).getPresident().getValue() + " Died ?");
				question.setLevel(level);
				question.setType(type);
				listOptions.add(data.getResults().getBindings().get(i).getDod().getValue() + " & "
						+ data.getResults().getBindings().get(i).getCause().getValue());
				listOptions.add(data.getResults().getBindings().get(j).getDod().getValue() + " & "
						+ data.getResults().getBindings().get(k).getCause().getValue());
				listOptions.add(data.getResults().getBindings().get(c).getDod().getValue() + " & "
						+ data.getResults().getBindings().get(c).getCause().getValue());
				listOptions.add(data.getResults().getBindings().get(k).getDod().getValue() + " & "
						+ data.getResults().getBindings().get(j).getCause().getValue());

				Collections.shuffle(listOptions);
				question.setOptions(listOptions);
				question.setCorrectAnswer(data.getResults().getBindings().get(c).getDod().getValue() + " & "
						+ data.getResults().getBindings().get(c).getCause().getValue());

				listQuestions.add(question);
				this.questionService.addNewQuestion(question);
			}
		}
		if (topicName.equalsIgnoreCase("Languages")) {
			LanguageMain main = new LanguageMain();
			LanguageMain data = sparQLQueryService.languages(main);
			String questionStem = "What is language of ";
			Random rand = new Random();
			int i = rand.nextInt(data.getResults().getBindings().size()) + 1;
			int j = rand.nextInt(data.getResults().getBindings().size()) + 1;
			int k = rand.nextInt(data.getResults().getBindings().size()) + 1;
			for (int c = 0; c < data.getResults().getBindings().size(); c++) {
				Question question = new Question();
				List<String> listOptions= new ArrayList();
				question.setId(0);
				question.setCategory(category);
				question.setTopic(topic);
				question.setGenre(genre);
				question.setStatement(questionStem
						+ data.getResults().getBindings().get(c).getItemLabel_en().getValue() + " ?");
				question.setLevel(level);
				question.setType(type);
				listOptions.add(data.getResults().getBindings().get(i).getOfficial_language().getValue());
				listOptions.add(data.getResults().getBindings().get(j).getOfficial_language().getValue());
				listOptions.add(data.getResults().getBindings().get(c).getOfficial_language().getValue());
				listOptions.add(data.getResults().getBindings().get(k).getOfficial_language().getValue());

				Collections.shuffle(listOptions);
				question.setOptions(listOptions);
				question.setCorrectAnswer(data.getResults().getBindings().get(c).getOfficial_language().getValue());

				listQuestions.add(question);
				this.questionService.addNewQuestion(question);
			}
		}

		return new ResponseEntity<List<Question>>(listQuestions, HttpStatus.OK);
	}

	private List<Integer> randomNumbers(int maxRange, int totalNumbers) {
		List<Integer> result = new ArrayList<>();
		List<Integer> numbers = new ArrayList<>();
		for(int i = 0; i < maxRange; i++)
			numbers.add(i);
		Collections.shuffle(numbers);
		for(int i =0; i < totalNumbers; i++)
			result.add(numbers.get(i));
		return result;
	}


}
