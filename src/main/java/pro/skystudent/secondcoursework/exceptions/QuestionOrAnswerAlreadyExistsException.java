package pro.skystudent.secondcoursework.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class QuestionOrAnswerAlreadyExistsException extends IllegalArgumentException{
    public QuestionOrAnswerAlreadyExistsException(String message) {
        super(message);
    }
}
