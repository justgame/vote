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

    @RequestMapping("/main.do")
    public ModelAndView main(String id) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<Vote> list = voteService.getVoteAll();
        modelAndView.addObject("selectId", id);
        modelAndView.addObject("list", list);
        modelAndView.setViewName("vote/main");
        return modelAndView;
    }

    @RequestMapping("/votePage.do")
    public ModelAndView votePage(String id) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        Vote vote = voteService.getVoteById(id);
        modelAndView.addObject("vote", vote);
        modelAndView.setViewName("vote/votePage");
        return modelAndView;
    }

    @RequestMapping("/addVotePage.do")
    public ModelAndView addVotePage() throws Exception {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("vote/addVote");
        return modelAndView;
    }

}
