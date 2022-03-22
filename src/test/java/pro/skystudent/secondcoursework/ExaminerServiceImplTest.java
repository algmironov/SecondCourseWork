package pro.skystudent.secondcoursework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.skystudent.secondcoursework.exceptions.ErrorInGeneratingExamQuestionsException;
import pro.skystudent.secondcoursework.exceptions.WrongRequestException;
import pro.skystudent.secondcoursework.service.QuestionService;
import pro.skystudent.secondcoursework.service.impl.ExaminerServiceImpl;

import java.util.Collection;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ExaminerServiceImplTest {

    private ExaminerServiceImpl out;
    private QuestionService mock1;
    private QuestionService mock2;

    @BeforeEach
    public void setUp() {
        mock1 = mock(QuestionService.class);
        mock2 = mock(QuestionService.class);

        this.out = new ExaminerServiceImpl(List.of(mock1, mock2));
    }

    @Test
    public void testingIfQuestionsAmountIsZeroOrNegative() {
        assertThrows(ErrorInGeneratingExamQuestionsException.class, () -> out.getQuestions(0));
        assertThrows(ErrorInGeneratingExamQuestionsException.class, () -> out.getQuestions(-5));
    }

    @Test
    public void testingRandomQuestionsGeneration() {

        when(mock1.getRandomQuestion()).thenReturn(
                new Question("m1q1", "m1a1"),
                new Question("m1q2", "m1a1")
        );
        when(mock2.getRandomQuestion()).thenReturn(
                new Question("m2q1", "m2a1"),
                new Question("m2q2", "m2a2"),
                new Question("m3q3", "m3a3")
        );

        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt(anyInt())).thenReturn(0, 1, 1, 0, 1);
        out.setRandom(mockRandom);

        Collection<Question> actualQuestions = out.getQuestions(5);
        List<Question> expectedQuestions = List.of(
                new Question("m1q1", "m1a1"),
                new Question("m2q1", "m2a1"),
                new Question("m2q2", "m2a2"),
                new Question("m1q2", "m1a1"),
                new Question("m3q3", "m3a3")
        );

        assertIterableEquals(expectedQuestions, actualQuestions);
    }

}
