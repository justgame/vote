package me.justgame.vote.vote.service.impl;

import me.justgame.vote.common.utils.IdUtil;
import me.justgame.vote.vote.dao.OptionDao;
import me.justgame.vote.vote.dao.VoteDao;
import me.justgame.vote.vote.model.Option;
import me.justgame.vote.vote.model.Vote;
import me.justgame.vote.vote.service.VoteService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/**
 * Created by xcl on 2017-01-05.
 */
@Service
public class VoteServiceImpl implements VoteService {

    @Resource
    private VoteDao voteDao;
    @Resource
    private OptionDao optionDao;

    @Override
    public List<Vote> getVoteAll() throws Exception {
        List<Vote> list = voteDao.getAllVote();
        List<Option> options;
        // 在这里把投票的所有选项也获取到存放在options里
        for (Vote vote : list) {
            String voteId = vote.getId();
            options = optionDao.getOptionAll(voteId);
            vote.setOptions(options);
        }

        return list;
    }

    @Override
    public Vote getVoteById(String id) throws Exception {
        Vote vote = voteDao.getVoteById(id);
        // 在这里把投票的所有选项也获取到存放在options里
        if (vote != null) {
            List<Option> options = optionDao.getOptionAll(vote.getId());
            vote.setOptions(options);
        }
        return vote;
    }

    @Transactional
    @Override
    public void addVote(Vote vote) throws Exception {
        List<Option> options = vote.getOptions();
        vote.setId(IdUtil.getUID());
        voteDao.addVote(vote);
        for (Option option : options) {
            option.setId(IdUtil.getUID());
            optionDao.addOption(option);
        }
    }

    @Transactional
    @Override
    public void delVote(Vote vote) throws Exception {
        List<Option> options = vote.getOptions();
        List<String> list = new LinkedList<>();
        for (Option option : options)
            list.add(option.getId());
        optionDao.delOptionBatch(list);
        voteDao.delVote(vote.getId());
    }
}
