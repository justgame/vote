package me.justgame.vote.vote.dao.impl;

import me.justgame.vote.vote.dao.VoteDao;
import me.justgame.vote.vote.dao.mapper.VoteMapper;
import me.justgame.vote.vote.model.Vote;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xcl on 2017-01-05.
 */
@Repository
public class VoteDaoImpl implements VoteDao {

    @Resource
    private VoteMapper mapper;

    @Override
    public List<Vote> getAllVote() throws Exception {
        return mapper.getAllVote();
    }

    @Override
    public Vote getVoteById(String id) throws Exception {
        return mapper.getVoteById(id);
    }

    @Override
    public int addVote(Vote vote) throws Exception {
        return mapper.addVote(vote);
    }

    @Override
    public int delVote(String id) throws Exception {
        return mapper.delVote(id);
    }

    @Override
    public int delVoteBatch(List<String> list) throws Exception {
        return mapper.delVoteBatch(list);
    }
}
