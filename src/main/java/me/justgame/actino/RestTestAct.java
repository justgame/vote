package me.justgame.actino;

import me.justgame.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by xcl on 2017-03-09.
 */
@Controller
public class RestTestAct {


    @RequestMapping(method = RequestMethod.GET, value = "/user/{id}.do")
    public ModelAndView getUser(@PathVariable("id") String id) throws Exception {
        User user = new User();
        user.setId(id);
        user.setName("test");
        user.setUserNo("test001");
        ModelAndView modelAndView = new ModelAndView("all/rest_test_page");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping(value = "/takeResult/{result}.do", method = RequestMethod.GET, produces = "text/html")
    @ResponseBody public String getResult(@PathVariable("result") String result) throws Exception {
        return  result + " ,method : get";
    }

    @RequestMapping(value = "/takeResult/{result}.do", method = RequestMethod.POST)
    @ResponseBody public String postResult(@PathVariable("result") String result) throws Exception {
        return  result + " ,method : post";
    }

    @RequestMapping(value = "/takeResult/{result}.do", method = RequestMethod.PUT)
    @ResponseBody public String putResult(@PathVariable("result") String result) throws Exception {
        return  result + " ,method : put";
    }

    @RequestMapping(value = "/takeResult/{result}.do", method = RequestMethod.DELETE)
    @ResponseBody public String deleteResult(@PathVariable("result") String result) throws Exception {
        return  result + " ,method : delete";
    }
}
