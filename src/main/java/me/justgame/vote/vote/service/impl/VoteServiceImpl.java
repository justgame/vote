package me.justgame.vote.vote.service.impl;

import me.justgame.vote.common.utils.CommonResult;
import me.justgame.vote.common.utils.IdUtil;
import me.justgame.vote.vote.dao.OptionDao;
import me.justgame.vote.vote.dao.VoteDao;
import me.justgame.vote.vote.model.Option;
import me.justgame.vote.vote.model.OptionUserRelate;
import me.justgame.vote.vote.model.Vote;
import me.justgame.vote.vote.service.OptionService;
import me.justgame.vote.vote.service.VoteService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

/**
 * Created by xcl on 2017-01-05.
 */
@Service
public class VoteServiceImpl implements VoteService {

    @Resource
    private VoteDao voteDao;
    @Resource
    private OptionDao optionDao;
    @Resource
    private OptionService optionService;

    @Override
    public List<Vote> getVoteAll() throws Exception {
        List<Vote> list = voteDao.getAllVote();
        List<Option> options;
        // 在这里把投票的所有选项也获取到存放在options里
        for (Vote vote : list) {
            String voteId = vote.getId();
            options = optionDao.getOptionAll(voteId);
            vote.setOptions(options);
            judgeExpired(vote);
        }

        return list;
    }

    @Override
    public Vote getVoteById(String id) throws Exception {
        Vote vote = voteDao.getVoteById(id);
        // 在这里把投票的所有选项也获取到存放在options里
        if (vote != null) {
            List<Option> options = optionDao.getOptionAll(vote.getId());
            int voCounts = voteDao.getVoteTotalCounts(id);
            for (Option option : options) {
                int opCounts = optionDao.getOptionVoteCounts(option.getId());
                option.setCounts(opCounts);
                if (opCounts == 0 || voCounts == 0)
                    option.setPercent(0d);
                else
                    option.setPercent( (double) opCounts / voCounts);
            }

            judgeExpired(vote);
            vote.setOptions(options);
            vote.setCounts(voteDao.getVoteTotalCounts(id));

        }
        return vote;
    }

    private void judgeExpired(Vote vote) throws Exception {
        boolean expired = false;
        if (new Timestamp(System.currentTimeMillis()).after(vote.getEndTime()))
            expired = true;
        vote.setExpired(expired);
    }

    @Transactional
    @Override
    public CommonResult addVote(Vote vote, String[] option) throws Exception {
        CommonResult commonResult = new CommonResult();
        // 判断数据是否完整
        if (vote == null
                || StringUtils.isBlank(vote.getSubject())
                || null == vote.getEndTime()
                || StringUtils.isBlank(vote.getAuthor())) {
            commonResult.setMsg("参数出错！");
            return commonResult;
        }
        // 选项不能小于2个
        int chooseItemCount = 0;
        for (String s : option) {
            if (StringUtils.isNotBlank(s))
                chooseItemCount++;
        }
        if (chooseItemCount < 2) {
            commonResult.setMsg("选项必须至少两个");
            return commonResult;
        }

        if(null == vote.getMode())
            vote.setMode("0");

        if ("0".equals(vote.getMode()))
            vote.setMaxVoteNum(1); // 单选模式最多选一项
        else if (null == vote.getMaxVoteNum() || 0 == vote.getMaxVoteNum() || vote.getMaxVoteNum() > chooseItemCount)
            vote.setMaxVoteNum(2); // 多选模式如果项数传值不合理自动设置为2项

        try {
            String voteId = IdUtil.getUID();
            vote.setId(voteId);
            vote.setStartTime(new Timestamp(Calendar.getInstance().getTimeInMillis()));
            voteDao.addVote(vote);
            optionService.addOption(option, voteId);
            commonResult.setFlag(true);
        } catch (Exception e) {
            e.printStackTrace();
            commonResult.setMsg("添加出错！");
        }
        return commonResult;
    }

    @Transactional
    @Override
    public void delVote(String id) throws Exception {
        optionDao.delOptionUserRelByVoteId(id);
        optionDao.delOptionByVoteId(id);
        voteDao.delVote(id);
    }

    @Override
    public String delVote(String id, String userName) throws Exception {
        Vote vote = voteDao.getVoteById(id);
        if (vote == null || StringUtils.isBlank(userName) || !userName.equals(vote.getAuthor()))
            return "failure";
        delVote(id);
        return "success";
    }

    @Transactional
    @Override
    public void vote(String voteId, String[] choose, String userName) throws Exception {
        Vote vote = voteDao.getVoteById(voteId);
        if (vote == null || vote.getMaxVoteNum() < choose.length)
            throw new RuntimeException();
        for (String s : choose) {
            OptionUserRelate optionUserRelate = new OptionUserRelate();
            optionUserRelate.setOptionId(s);
            optionUserRelate.setUserName(userName);
            optionDao.addVote4Option(optionUserRelate);
        }
    }

    @Override
    public boolean isVoted(String id, String userName) throws Exception {
        List<String> userNames = optionDao.getUserVoted(id);
        if (userNames.contains(userName))
            return true;
        return false;
    }
}
