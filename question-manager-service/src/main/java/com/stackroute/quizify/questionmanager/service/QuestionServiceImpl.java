package com.stackroute.quizify.questionmanager.service;

import com.stackroute.quizify.questionmanager.domain.Question;
import com.stackroute.quizify.questionmanager.exception.EnoughQuestionsNotFound;
import com.stackroute.quizify.questionmanager.exception.NoQuestionFoundException;
import com.stackroute.quizify.questionmanager.exception.QuestionAlreadyExistsException;
import com.stackroute.quizify.questionmanager.exception.QuestionDoesNotExistException;

import com.stackroute.quizify.questionmanager.repository.QuestionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * This "QuestionServiceImpl" Class implements all the methods declared by "QuestionService" Interface.
 *
 * Spring @Service annotation is used with classes that provide business functionalities/logics.
 */

@Slf4j
@Service
public class QuestionServiceImpl implements QuestionService {

    private QuestionRepository questionRepository;

    @Autowired
    public QuestionServiceImpl(QuestionRepository questionRepository)
    {
        this.questionRepository = questionRepository;
    }


    /* The Method "addNewQuestion" saves a new document of Question in a collection,
     * and returns the Saved Question.
     * If Question ID already exist then it throws the Exception "CategoryNameAlreadyExistsException".
     */
    @Override
    public Question addNewQuestion(Question question) throws QuestionAlreadyExistsException {
        if (this.questionRepository.existsById(question.getId()))
            throw new QuestionAlreadyExistsException();
        else {
            if(this.questionRepository.findTopByOrderByIdDesc().isEmpty())
                question.setId(1);
            else
                question.setId(this.questionRepository.findTopByOrderByIdDesc().get().getId()+1);
            log.info("New Question Added : \n");
            log.info(""+question);
            return this.questionRepository.save(question);
        }


    }

    /*
    * The Method "updateQuestion" updates the Question Document, and returns the Updated Document.
    * If any Question not found with the question ID then it throws the exception "QuestionDoesNotExistException".
    */
    @Override
    public Question updateQuestion(Question question) throws QuestionDoesNotExistException {
        if (this.questionRepository.existsById(question.getId())) {
            return this.questionRepository.save(question);
        }
        else
            throw new QuestionDoesNotExistException();

    }

    /*
     * The Method "removeQuestion" removes a specific Question form the collection and will
     * return the Deleted Question.
     * If the Question doesn't exist then it throws "QuestionDoesNotExistException".
     */
    @Override
    public Question removeQuestion(long questionId) throws QuestionDoesNotExistException {
        if (this.questionRepository.existsById(questionId)) {
            Question question = this.questionRepository.findById(questionId);
            this.questionRepository.delete(question);
            return question;
        }
        else
            throw new QuestionDoesNotExistException();
    }


    @Override
    public List<Question> getQuestionsByTopicByLevel(String topicName, String level, int numberOfQuestions) throws NoQuestionFoundException, EnoughQuestionsNotFound {
        List<Question> questionList = this.questionRepository.getQuestionsByTopicByLevel(topicName, level);
        if (questionList.isEmpty())
            throw new NoQuestionFoundException();
        else if (questionList.size()<numberOfQuestions)
            throw new EnoughQuestionsNotFound();
        else {
            List<Question> resultList = new ArrayList<>();
            List<Integer> randomList = randomNumbers(questionList.toArray().length, numberOfQuestions);

            for (int i: randomList)
                resultList.add(questionList.get(i));

            return resultList;
        }
    }

    @Override
    public List<Question> getQuestionsByTopic(String topicName, int numberOfQuestions) throws NoQuestionFoundException, EnoughQuestionsNotFound {
        List<Question> questionList = this.questionRepository.getQuestionsByTopic(topicName);
        if (questionList.isEmpty())
            throw new NoQuestionFoundException();
        else if (questionList.size()<numberOfQuestions)
            throw new EnoughQuestionsNotFound();
        else {
            List<Question> resultList = new ArrayList<>();
            List<Integer> randomList = randomNumbers(questionList.toArray().length, numberOfQuestions);

            for (int i: randomList)
                resultList.add(questionList.get(i));

            return resultList;
        }
    }

    @Override
    public List<Question> getAllQuestionsByTopic(String topicName) throws NoQuestionFoundException {
        List<Question> questionList = this.questionRepository.getQuestionsByTopic(topicName);
        if (questionList.isEmpty())
            throw new NoQuestionFoundException();
        else {
            return questionList;
        }
    }

    @Override
    public List<Question> getQuestionsByGenreByLevel(String genre, String level, int numberOfQuestions) throws NoQuestionFoundException, EnoughQuestionsNotFound {
        List<Question> questionList = this.questionRepository.getQuestionsByGenreByLevel(genre, level);
        if (questionList.isEmpty())
            throw new NoQuestionFoundException();
        else if (questionList.size()<numberOfQuestions)
            throw new EnoughQuestionsNotFound();
        else {
            List<Question> resultList = new ArrayList<>();
            List<Integer> randomList = randomNumbers(questionList.toArray().length, numberOfQuestions);

            for (int i: randomList)
                resultList.add(questionList.get(i));

            return resultList;
        }
    }

    @Override
    public List<Question> getQuestionsByGenre(String genre, int numberOfQuestions) throws NoQuestionFoundException, EnoughQuestionsNotFound {
        List<Question> questionList = this.questionRepository.getQuestionsByGenre(genre);
        if (questionList.isEmpty())
            throw new NoQuestionFoundException();
        else if (questionList.size()<numberOfQuestions)
            throw new EnoughQuestionsNotFound();
        else {
            List<Question> resultList = new ArrayList<>();
            List<Integer> randomList = randomNumbers(questionList.toArray().length, numberOfQuestions);

            for (int i: randomList)
                resultList.add(questionList.get(i));

            return resultList;
        }
    }

    @Override
    public List<Question> getAllQuestionsByGenre(String genre) throws NoQuestionFoundException {
        List<Question> questionList = this.questionRepository.getQuestionsByGenre(genre);
        if (questionList.isEmpty())
            throw new NoQuestionFoundException();
        else {
            return questionList;
        }
    }

    @Override
    public List<Question> getQuestionsByTopicByGenreByLevel(String topicName, String genreName, String level, int numberOfQuestions) throws NoQuestionFoundException, EnoughQuestionsNotFound {
        List<Question> questionList = this.questionRepository.getQuestionsByTopicByGenreByLevel(topicName, genreName, level);
        if (questionList.isEmpty())
            throw new NoQuestionFoundException();
        else if (questionList.size()<numberOfQuestions)
            throw new EnoughQuestionsNotFound();
        else {
            List<Question> resultList = new ArrayList<>();
            List<Integer> randomList = randomNumbers(questionList.toArray().length, numberOfQuestions);

            for (int i: randomList)
                resultList.add(questionList.get(i));

            return resultList;
        }
    }

    @Override
    public List<Question> getAllQuestions() throws NoQuestionFoundException {
        List<Question> questionList = this.questionRepository.findAll();
        if(questionList.isEmpty())
            throw new NoQuestionFoundException();
        else
        {
            questionList.sort(new CustomComparator());
            return questionList;
        }

    }

    @Override
    public boolean checkAvailability(String topicName, String genreName, String level, int numberOfQuestions) {
        List<Question> questionList = this.questionRepository.getQuestionsByTopicByGenreByLevel(topicName, genreName, level);
        if (questionList.size()<numberOfQuestions)
            return false;
        else
            return true;

    }

    private class CustomComparator implements Comparator<Question> {
        @Override
        public int compare(Question o1, Question o2) {
            return (int)(o2.getId() - (o1.getId()));
        }
    }

    /*
    * This "randomNumbers" is a private method for this class which Generates a List of Random Numbers
    */
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
