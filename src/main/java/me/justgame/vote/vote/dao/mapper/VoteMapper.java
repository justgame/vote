package me.justgame.vote.vote.dao.mapper;

import me.justgame.vote.common.annotations.MyBatisMapper;
import me.justgame.vote.vote.model.Vote;

import java.util.List;

/**
 * Created by xcl on 2017-01-05.
 */
@MyBatisMapper
public interface VoteMapper {

    List<Vote> getAllVote() throws Exception;

    Vote getVoteById(String id) throws Exception;

    int addVote(Vote vote) throws Exception;

    int delVote(String id) throws Exception;

    int delVoteBatch(List<String> list) throws Exception;
}
