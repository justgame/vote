package me.justgame.vote.vote.dao.impl;

import me.justgame.vote.vote.dao.OptionDao;
import me.justgame.vote.vote.dao.mapper.OptionMapper;
import me.justgame.vote.vote.model.Option;
import me.justgame.vote.vote.model.OptionUserRelate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xcl on 2017-01-06.
 */
@Repository
public class OptionDaoImpl implements OptionDao {
    @Resource
    OptionMapper mapper;

    @Override
    public List<Option> getOptionAll(String voteId) throws Exception {
        return mapper.getOptionAll(voteId);
    }

    @Override
    public Option getOptionById(String id) throws Exception {
        return mapper.getOptionById(id);
    }

    @Override
    public int addOption(Option option) throws Exception {
        return mapper.addOption(option);
    }

    @Override
    public int delOptionByVoteId(String id) throws Exception {
        return mapper.delOptionByVoteId(id);
    }

    @Override
    public int delOptionBatch(List<String> list) throws Exception {
        return mapper.delOptionBatch(list);
    }

    @Override
    public int getOptionVoteCounts(String id) throws Exception {
        return mapper.getOptionVoteCounts(id);
    }

    @Override
    public int addVote4Option(OptionUserRelate optionUserRelate) throws Exception {
        return mapper.addVote4Option(optionUserRelate);
    }

    @Override
    public List<String> getUserVoted(String id) throws Exception {
        return mapper.getUserVoted(id);
    }

    @Override
    public int delOptionUserRelByVoteId(String id) throws Exception {
        return mapper.delOptionUserRelByVoteId(id);
    }
}
