package fr.solutec.re.controller;

import fr.solutec.re.entites.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.net.BindException;

@ControllerAdvice
public class ApplicationControllerAdvice {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(IllegalArgumentException.class)

    public @ResponseBody ErrorMessage handleIllegalArgumentException(IllegalArgumentException e) {
        e.printStackTrace();
        return new ErrorMessage(404, e.getMessage());
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(BindException.class)
    public @ResponseBody ErrorMessage handleBindException(BindException e) {
        e.printStackTrace();
        return new ErrorMessage(409, e.getMessage());
    }
}
