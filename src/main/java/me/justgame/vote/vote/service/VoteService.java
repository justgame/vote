package me.justgame.vote.vote.service;

import me.justgame.vote.common.utils.CommonResult;
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
     * @param option
     * @throws Exception
     */
    CommonResult addVote(Vote vote, String[] option) throws Exception;

    /**
     * 删除投票+权限判断
     * @param id
     * @param userName
     * @return
     * @throws Exception
     */
    String delVote(String id, String userName) throws Exception;

    /**
     * 删除投票
     * @param id
     * @throws Exception
     */
    void delVote(String id) throws Exception;

    /**
     * 投票
     * @param voteId
     * @param choose
     * @throws Exception
     */
    void vote(String voteId, String[] choose, String userName) throws Exception;

    /**
     * 判断用户是否已投票
     * @param id
     * @param userName
     * @return
     * @throws Exception
     */
    boolean isVoted(String id, String userName) throws Exception;


}
