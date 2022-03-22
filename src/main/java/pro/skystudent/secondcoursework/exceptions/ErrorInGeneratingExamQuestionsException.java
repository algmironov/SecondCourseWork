package pro.skystudent.secondcoursework.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ErrorInGeneratingExamQuestionsException extends IllegalArgumentException{
    public ErrorInGeneratingExamQuestionsException(int questionsAmount, int currentSize) {
        super(String.format("Error in generating %d questions, because current size is %d", questionsAmount, currentSize));
    }

    public ErrorInGeneratingExamQuestionsException(String message) {
        super(message);
    }
}
