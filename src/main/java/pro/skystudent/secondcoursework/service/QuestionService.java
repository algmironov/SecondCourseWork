package pro.skystudent.secondcoursework.service;

import pro.skystudent.secondcoursework.Question;

import java.util.Collection;

public interface QuestionService {
    boolean addQuestion(String question, String answer);

    boolean addQuestion(Question question);

    boolean removeQuestion(String question, String answer);

    Collection<Question> getAllQuestions();

    Question getRandomQuestion();

    int getSize();
}
