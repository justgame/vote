package me.justgame.vote.test.action;

import me.justgame.vote.test.dao.TestDao;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by xcl on 2017-01-05.
 */
@Controller
@RequestMapping("/test")
public class TestAct {
    @Resource
    TestDao testDao;

    @RequestMapping("/home.do")
    public ModelAndView home() throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        // modelAndView.addObject("messages", testDao.getTest());
        System.out.println(testDao.getTest());
        modelAndView.setViewName("test/home");
        return modelAndView;
    }
}
