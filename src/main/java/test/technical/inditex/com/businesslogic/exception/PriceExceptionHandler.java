package test.technical.inditex.com.businesslogic.exception;

import org.hibernate.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice(basePackages = "test.technical.inditex.com")
public class PriceExceptionHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = ObjectNotFoundException.class)
    public ErrorMessage resourceNotFoundException(ObjectNotFoundException exception, WebRequest request) {
        return ErrorMessage.builder().message(" The searched Price has not been found").statusCode(HttpStatus.NOT_FOUND.value()).build();
    }
}
