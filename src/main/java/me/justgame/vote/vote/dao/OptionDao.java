package me.justgame.vote.vote.dao;

import me.justgame.vote.vote.model.Option;

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
     * 新增选项
     * @param option
     * @return
     * @throws Exception
     */
    int addOption(Option option) throws Exception;

    /**
     * 批量删除
     * @param list
     * @return
     * @throws Exception
     */
    int delOptionBatch(List<String> list) throws Exception;
}
