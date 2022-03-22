package pro.skystudent.secondcoursework.service;

import pro.skystudent.secondcoursework.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int questionsAmount);
}
