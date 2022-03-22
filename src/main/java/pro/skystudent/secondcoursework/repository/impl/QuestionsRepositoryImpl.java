package pro.skystudent.secondcoursework.repository.impl;

import org.springframework.stereotype.Repository;
import pro.skystudent.secondcoursework.Question;
import pro.skystudent.secondcoursework.exceptions.QuestionOrAnswerAlreadyExistsException;
import pro.skystudent.secondcoursework.repository.QuestionsRepository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Repository("javaRepository")
public class QuestionsRepositoryImpl implements QuestionsRepository {

    private final Set<Question> questionsList;

    public final Set<Question> questionsListCopy;

    public QuestionsRepositoryImpl() {
        questionsList = new HashSet<>();
        questionsListCopy = new HashSet<>(Set.copyOf(questionsList));
    }

    @PostConstruct
    public void init() {
        addQuestion(new Question("Когда была создана Java? (год)", "1995"));
        addQuestion(new Question("Можно ли изменять строки", "Нет"));
        addQuestion(new Question("Map - это коллекция?", "Нет"));
        addQuestion(new Question("Какой размер (в байтах) зарезервирован для int?", "4"));
        addQuestion(new Question("Последняя стабильная версия Java?", "17"));
        addQuestion(new Question("Как называется библиотека для юнит-тестов? Ответ с маленькой буквы.", "junit"));
        addQuestion(new Question("Класс, который позволяет изменять строки.", "StringBuilder"));
        addQuestion(new Question("Каким методом сравниваются объекты?", "equals"));
        addQuestion(new Question("Обязательно ли равны объекты, если равен их hashcode?", "Нет"));
    }

    @Override
    public boolean addQuestion(Question question) {
        return questionsList.add(question);
    }

    @Override
    public boolean removeQuestion(Question question) {
        return questionsList.remove(question);
    }

    @Override
    public Collection<Question> getAllQuestions() {
        return Collections.unmodifiableCollection(questionsList);
    }

    public void checkQuestion(String question, String answer) {

        Question questionToCheck = new Question(question, answer);
        if (questionsListCopy.contains(questionToCheck)) {
            throw new QuestionOrAnswerAlreadyExistsException("Question or answer already exists!");
        }
    }
}
