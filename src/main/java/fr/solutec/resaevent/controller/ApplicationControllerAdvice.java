package fr.solutec.resaevent.controller;


import fr.solutec.resaevent.entites.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ApplicationControllerAdvice {
    @ResponseStatus (HttpStatus.NOT_FOUND)
    @ExceptionHandler(IllegalArgumentException.class)
    public @ResponseBody ErrorMessage handleIllegalArgumentException(IllegalArgumentException e){
        e.printStackTrace();
        return new ErrorMessage(404, e.getMessage());
    }
}
