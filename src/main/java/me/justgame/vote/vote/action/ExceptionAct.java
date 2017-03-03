package me.justgame.vote.vote.action;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by xcl on 2017-02-16.
 */
@ControllerAdvice
public class ExceptionAct {
    @ExceptionHandler(RuntimeException.class)
    public ModelAndView runtimeExceptionPage(Exception e) {
        System.out.println(e);
        ModelAndView modelAndView = new ModelAndView("exception/500");
        return modelAndView;
    }

    @ExceptionHandler(UnsupportedOperationException.class)
    public ModelAndView unsupportedOperationExceptionPage(Exception e) {
        System.out.println(e);
        ModelAndView modelAndView = new ModelAndView("exception/404");
        return modelAndView;
    }

    @ExceptionHandler
    public ModelAndView exceptionPage(Exception e) {
        System.out.println(e);
        ModelAndView modelAndView = new ModelAndView("exception/other");
        return modelAndView;
    }

}
