package pro.skystudent.secondcoursework.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
public class WrongRequestException extends IllegalArgumentException{
    public WrongRequestException() {
        super("Requested method isn't allowed!");
    }
}
