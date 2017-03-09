package me.justgame.actino;

import me.justgame.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by xcl on 2017-03-09.
 */
@Controller
public class RestTestAct {


    @RequestMapping(method = RequestMethod.GET, value = "/user/{id}")
    public ModelAndView getUser(@PathVariable("id") String id) throws Exception {
        User user = new User();
        user.setId(id);
        user.setName("test");
        user.setUserNo("test001");
        ModelAndView modelAndView = new ModelAndView("all/rest_test_page");
        modelAndView.addObject("user", user);
        return modelAndView;
    }
}
