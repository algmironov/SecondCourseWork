package pro.skystudent.secondcoursework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.skystudent.secondcoursework.exceptions.QuestionDoesntExistException;
import pro.skystudent.secondcoursework.exceptions.QuestionOrAnswerAlreadyExistsException;
import pro.skystudent.secondcoursework.repository.QuestionsRepository;
import pro.skystudent.secondcoursework.repository.impl.QuestionsRepositoryImpl;
import pro.skystudent.secondcoursework.service.impl.JavaQuestionServiceImpl;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static pro.skystudent.secondcoursework.Constants.ANSWER1;
import static pro.skystudent.secondcoursework.Constants.QUESTION1;
import static pro.skystudent.secondcoursework.Constants.*;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceImplTest {

    @Mock
    private QuestionsRepository questionsRepository;

    @InjectMocks
    private JavaQuestionServiceImpl out;

    @Test
    public void testingAddingNewQuestion() {

        Question question1 = new Question(QUESTION1, ANSWER1);
        Question question2 = new Question(QUESTION2, ANSWER2);
        when(questionsRepository.addQuestion(question1)).thenReturn(true, false);
        when(questionsRepository.addQuestion(question2)).thenReturn(true, false);

        assertTrue(out.addQuestion(question1));
        assertTrue(out.addQuestion(question2));

        assertFalse(out.addQuestion(question1));
        assertFalse(out.addQuestion(question2));

        assertFalse(out.getAllQuestions().contains(new Question(QUESTION3, ANSWER3)));
    }

    @Test
    public void testingRemoveQuestionMethod() {
        out.addQuestion(QUESTION_FOR_SET_1);

        when(questionsRepository.removeQuestion(QUESTION_FOR_SET_1)).thenReturn(true, false);
        assertTrue(out.removeQuestion(QUESTION1, ANSWER1));
        assertFalse(out.removeQuestion(QUESTION1, ANSWER1));

    }

    @Test
    public void testingGetAllQuestionsMethod() {
        when(questionsRepository.getAllQuestions()).thenReturn(TEST_QUESTIONS_SET);
        assertEquals(out.getAllQuestions().size(), TEST_QUESTIONS_SET.size());
        assertTrue(out.getAllQuestions().containsAll(TEST_QUESTIONS_SET));

        assertEquals(TEST_QUESTIONS_SET.contains(QUESTION_FOR_SET_1)
                && TEST_QUESTIONS_SET.contains(QUESTION_FOR_SET_2),
                out.getAllQuestions().contains(QUESTION_FOR_SET_1) &&
                        out.getAllQuestions().contains(QUESTION_FOR_SET_2));
    }

    @Test
    public void testingGetRandomQuestion() {

        when(questionsRepository.getAllQuestions()).thenReturn(List.of(
                new Question(QUESTION1, ANSWER1),
                new Question(QUESTION2, ANSWER2),
                new Question(QUESTION3, ANSWER3)
        ));

        assertTrue(TEST_QUESTIONS_SET.contains(out.getRandomQuestion()));

        Random randomTest = mock(Random.class);
        when(randomTest.nextInt(anyInt())).thenReturn(0, 2);
        out.setRandom(randomTest);

        assertEquals(new Question(QUESTION1, ANSWER1), out.getRandomQuestion());
        assertEquals(new Question(QUESTION3, ANSWER3), out.getRandomQuestion());
    }
}