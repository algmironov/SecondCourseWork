package pro.skystudent.secondcoursework.repository;

import pro.skystudent.secondcoursework.Question;

import java.util.Collection;

public interface QuestionsRepository {


        boolean addQuestion(Question question);

        boolean removeQuestion(Question question);

        Collection<Question> getAllQuestions();

}
