package me.justgame.actino;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by xcl on 2017-03-06.
 */
@Controller
public class AllAct {
    @RequestMapping("/loginPage.do")
    public String loginPage() throws Exception {
        return "all/login";
    }
}
