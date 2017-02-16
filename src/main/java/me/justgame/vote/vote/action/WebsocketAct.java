package me.justgame.vote.vote.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by xcl on 2017-02-16.
 */
@Controller
@RequestMapping("/websocket")
public class WebsocketAct {
    @RequestMapping("/websocketPage.do")
    public ModelAndView websocketPage() throws Exception {
        ModelAndView modelAndView = new ModelAndView("websocket/websocket_test");
        return modelAndView;
    }
}
