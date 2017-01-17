package me.justgame.vote.vote.action;

import com.alibaba.fastjson.JSON;
import me.justgame.vote.common.utils.CommonResult;
import me.justgame.vote.common.utils.IpUtil;
import me.justgame.vote.vote.model.Vote;
import me.justgame.vote.vote.service.VoteService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by xcl on 2017-01-06.
 */
@Controller
@RequestMapping("/vote")
public class VoteAct {
    @Resource
    private VoteService voteService;

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
    public ModelAndView votePage(String id, HttpServletRequest request) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        Vote vote = voteService.getVoteById(id);
        if (vote == null) {
            modelAndView.setViewName("exception/404");
            return modelAndView;
        }

        // 判断展示投票结果还是展示投票选择 true.投票结果 false.投票选择
        boolean status = true;
        if (!vote.isExpired()) { // 当投票还没过期时判断该用户是否已经投过票
            String userName = IpUtil.getIpAddress(request);
            status = voteService.isVoted(id, userName); // 如果用户已经投过票 status为true 即显示投票结果
            modelAndView.addObject("process", "doing");
        } else
            modelAndView.addObject("process", "end");

        // 判断访问者是否是投票发起人
        boolean isAuthor = false;
        if (IpUtil.getIpAddress(request).equals(vote.getAuthor()))
            isAuthor = true;


        modelAndView.addObject("isAuthor", isAuthor);
        modelAndView.addObject("status", status);
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

    @RequestMapping("/addVote.do")
    public @ResponseBody String addVote(Vote vote, String[] option, HttpServletRequest request) throws Exception {
        vote.setAuthor(IpUtil.getIpAddress(request));
        CommonResult commonResult = voteService.addVote(vote, option);
        return JSON.toJSONString(commonResult);
    }

    @RequestMapping("/vote.do")
    public ModelAndView vote(String voteId, String[] choose, HttpServletRequest request) throws Exception {
        if (StringUtils.isBlank(voteId) || choose == null || choose.length == 0)
            return new ModelAndView("exception/500");
        voteService.vote(voteId, choose, IpUtil.getIpAddress(request));
        return votePage(voteId, request);
    }

    @RequestMapping("/delVote.do")
    public @ResponseBody String delVote(@RequestParam String id, HttpServletRequest request) throws Exception {

        String userName = IpUtil.getIpAddress(request);
        String result = "";
        try {
            result = voteService.delVote(id, userName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

}
