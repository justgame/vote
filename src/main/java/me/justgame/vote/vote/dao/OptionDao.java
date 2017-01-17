package me.justgame.vote.vote.dao;

import me.justgame.vote.vote.model.Option;
import me.justgame.vote.vote.model.OptionUserRelate;

import java.util.List;

/**
 * Created by xcl on 2017-01-05.
 */
public interface OptionDao {
    /**
     * 获取特定投票的所有选项，没指定投票时则取全部
     * @param voteId
     * @return
     * @throws Exception
     */
    List<Option> getOptionAll(String voteId) throws Exception;

    /**
     * 根据id获取选项信息
     * @param id
     * @return
     * @throws Exception
     */
    Option getOptionById(String id) throws Exception;

    /**
     * 新增选项
     * @param option
     * @return
     * @throws Exception
     */
    int addOption(Option option) throws Exception;

    /**
     * 根据投票的id删除所有选项
     * @param id
     * @return
     * @throws Exception
     */
    int delOptionByVoteId(String id) throws Exception;

    /**
     * 批量删除
     * @param list
     * @return
     * @throws Exception
     */
    int delOptionBatch(List<String> list) throws Exception;

    /**
     * 获取选项投票数
     * @param id
     * @return
     * @throws Exception
     */
    int getOptionVoteCounts(String id) throws Exception;

    /**
     * 为选项投票
     * @param optionUserRelate
     * @return
     * @throws Exception
     */
    int addVote4Option(OptionUserRelate optionUserRelate) throws Exception;

    /**
     * 获取投过票的用户列表
     * @param id vote的id
     * @return
     * @throws Exception
     */
    List<String> getUserVoted(String id) throws Exception;

    /**
     * 删除投票相关联的选项的投票信息
     * @param id
     * @return
     * @throws Exception
     */
    int delOptionUserRelByVoteId(String id) throws Exception;
}
