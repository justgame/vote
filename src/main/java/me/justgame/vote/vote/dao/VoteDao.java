package me.justgame.vote.vote.dao;

import me.justgame.vote.vote.model.Vote;

import java.util.List;

/**
 * Created by xcl on 2017-01-05.
 */
public interface VoteDao {
    /**
     * 获取全部投票
     * @return 存放所有投票的list
     * @throws Exception
     */
    List<Vote> getAllVote() throws Exception;

    /**
     * 根据id取投票信息
     * @param id 投票的id
     * @return 投票信息
     * @throws Exception
     */
    Vote getVoteById(String id) throws Exception;

    /**
     * 新增投票
     * @param vote 投票实体
     * @return 插入数量
     * @throws Exception
     */
    int addVote(Vote vote) throws Exception;

    /**
     * 删除投票
     * @param id 投票的id
     * @return 删除数量
     * @throws Exception
     */
    int delVote(String id) throws Exception;

    /**
     * 删除投票
     * @param list 存放要删除的投票的id的list
     * @return 删除数量
     * @throws Exception
     */
    int delVoteBatch(List<String> list) throws Exception;

    /**
     * 获取投票总数
     * @param id
     * @return
     * @throws Exception
     */
    int getVoteTotalCounts(String id) throws Exception;
}
