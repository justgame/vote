package me.justgame.vote.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by xcl on 2017-01-04.
 */
@Controller("/test")
public class TestAct {

    @RequestMapping("/home.do")
    public ModelAndView home() throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/home.html");
        return modelAndView;
    }

}
