package fr.solutec.re.controller;

import fr.solutec.re.entites.ErrorMessage;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice

public class ApplicationControllerAdvice {
    /// chaque methode traite une exception
    @ExceptionHandler(IllegalArgumentException.class)
    public ErrorMessage handleIllegalArgumentException(IllegalArgumentException e) {
        e.printStackTrace();
        return new ErrorMessage(404, e.getMessage());
    }
}
