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
        return new ErrorMessage (404, e.getMessage());

    }
    @ResponseStatus(HttpStatus.IM_USED)
    @ExceptionHandler(BindException.class)
    public @ResponseBody ErrorMessage handleBindException(BindException e) {
        e.printStackTrace();
        return new ErrorMessage(422, e.getMessage());
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalStateException.class)
    public @ResponseBody ErrorMessage handleIllegalStateException(IllegalStateException e) {
        e.printStackTrace();
        return new ErrorMessage(400, e.getMessage());
    }


}
