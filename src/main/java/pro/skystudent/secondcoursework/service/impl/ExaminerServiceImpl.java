package pro.skystudent.secondcoursework.service.impl;

import org.springframework.stereotype.Service;
import pro.skystudent.secondcoursework.Question;
import pro.skystudent.secondcoursework.exceptions.ErrorInGeneratingExamQuestionsException;
import pro.skystudent.secondcoursework.service.ExaminerService;
import pro.skystudent.secondcoursework.service.QuestionService;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final List<QuestionService> servicesList;
    private Random random = new Random();

    public ExaminerServiceImpl(List<QuestionService> questionServices) {
        this.servicesList = questionServices;
    }

    private Random generateRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    @Override
    public Collection<Question> getQuestions(int questionsAmount) {
        if (questionsAmount <= 0) {
            throw new ErrorInGeneratingExamQuestionsException("Unable to generate exam questions because amount of questions should be positive ");
        }
        Random random = generateRandom();
        Set<Question> requestedQuestions = new LinkedHashSet<>();
        while (requestedQuestions.size() < questionsAmount) {
            requestedQuestions.add(servicesList.get(random.nextInt(servicesList.size())).getRandomQuestion());
        }
        return requestedQuestions;
    }
}
