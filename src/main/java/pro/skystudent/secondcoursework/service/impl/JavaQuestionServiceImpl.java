package pro.skystudent.secondcoursework.service.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.skystudent.secondcoursework.Question;
import pro.skystudent.secondcoursework.repository.QuestionsRepository;
import pro.skystudent.secondcoursework.service.QuestionService;

import java.util.*;

@Service("javaService")
public class JavaQuestionServiceImpl implements QuestionService {

    private final QuestionsRepository questionsRepositoryImpl;
    Random random = new Random();

    public JavaQuestionServiceImpl(@Qualifier("javaRepository") QuestionsRepository questionsRepositoryImpl) {
        this.questionsRepositoryImpl = questionsRepositoryImpl;
    }

    @Override
    public boolean addQuestion(String question, String answer) {
        return addQuestion(new Question(question, answer));
    }

    @Override
    public boolean addQuestion(Question question) {
        return questionsRepositoryImpl.addQuestion(question);
    }


    @Override
    public boolean removeQuestion(String question, String answer) {
        return questionsRepositoryImpl.removeQuestion(new Question(question, answer));
    }

    @Override
    public Collection<Question> getAllQuestions() {
        return Set.copyOf(questionsRepositoryImpl.getAllQuestions());
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> randomQuestions = List.copyOf(questionsRepositoryImpl.getAllQuestions());
        int randomQuestionNumber = random.nextInt(randomQuestions.size());
        return randomQuestions.get(randomQuestionNumber);
    }

    @Override
    public int getSize() {
        return questionsRepositoryImpl.getAllQuestions().size();
    }

    public void setRandom(Random random) {
        this.random = random;
    }
}