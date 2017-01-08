package me.justgame.vote.vote.action;

import me.justgame.vote.vote.model.Vote;
import me.justgame.vote.vote.service.OptionService;
import me.justgame.vote.vote.service.VoteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xcl on 2017-01-06.
 */
@Controller
@RequestMapping("/vote")
public class VoteAct {
    @Resource
    private VoteService voteService;
    @Resource
    private OptionService optionService;

    @RequestMapping("/home.do")
    public ModelAndView home() throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<Vote> list = voteService.getVoteAll();
        modelAndView.addObject("list", list);
        modelAndView.setViewName("vote/home");
        return modelAndView;
    }

}
