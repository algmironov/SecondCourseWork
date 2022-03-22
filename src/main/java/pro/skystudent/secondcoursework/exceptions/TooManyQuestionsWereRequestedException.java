package pro.skystudent.secondcoursework.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TooManyQuestionsWereRequestedException extends IllegalArgumentException{
    public TooManyQuestionsWereRequestedException(String message) {
        super(message);
    }
}
