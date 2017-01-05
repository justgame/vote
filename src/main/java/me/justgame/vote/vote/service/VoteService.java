package me.justgame.vote.vote.service;

import me.justgame.vote.vote.model.Vote;

import java.util.List;

/**
 * Created by xcl on 2017-01-05.
 */
public interface VoteService {

    /**
     * 获取全部投票
     * @return
     * @throws Exception
     */
    List<Vote> getVoteAll() throws Exception;

    /**
     * 根据ID获取投票
     * @param id
     * @return
     * @throws Exception
     */
    Vote getVoteById(String id) throws Exception;

    /**
     * 新增投票
     * @param vote
     * @throws Exception
     */
    void addVote(Vote vote) throws Exception;

    /**
     * 删除投票
     * @param vote
     * @throws Exception
     */
    void delVote(Vote vote) throws Exception;
}
