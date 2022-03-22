package pro.skystudent.secondcoursework.service;

import org.springframework.stereotype.Service;
import pro.skystudent.secondcoursework.Question;
import pro.skystudent.secondcoursework.exceptions.WrongRequestException;

import java.util.Collection;
import java.util.Random;

@Service("mathService")
public class MathQuestionService implements QuestionService{

    private final Random random = new Random();

    @Override
    public boolean addQuestion(String question, String answer) {
        return addQuestion(question, answer);
    }

    @Override
    public boolean addQuestion(Question question) {
        throw new WrongRequestException();
    }

    @Override
    public boolean removeQuestion(String question, String answer) {
        throw new WrongRequestException();
    }

    @Override
    public Collection<Question> getAllQuestions() {
        throw new WrongRequestException();
    }

    @Override
    public Question getRandomQuestion() {
        int numberOne = random.nextInt(20) + 1;
        int numberTwo = random.nextInt(20) + 1;
        int mathAction = random.nextInt(4);

        switch (mathAction) {
            case 0:
                return new Question(numberOne + " + " + numberTwo, String.valueOf(numberOne + numberTwo));
            case 1:
                return new Question(numberOne + " - " + numberTwo, String.valueOf(numberOne - numberTwo));
            case 2:
                return new Question(numberOne + " * " + numberTwo, String.valueOf(numberOne * numberTwo));
            case 3:
                return new Question(numberOne + " / " + numberTwo, String.valueOf(numberOne / numberTwo));
            default:
                throw new IllegalStateException("Wrong mathematical sign used!");
        }
    }

    @Override
    public int getSize() {
        throw new WrongRequestException();
    }
}
