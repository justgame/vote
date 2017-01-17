package me.justgame.vote.vote.service;

import me.justgame.vote.vote.model.Option;

/**
 * Created by xcl on 2017-01-06.
 */
public interface OptionService {

    /**
     * 新增选项
     * @param name
     * @param voteId
     * @throws Exception
     */
    void addOption(String name, String voteId) throws Exception;

    /**
     * 新增选项
     * @param name
     * @param voteId
     * @throws Exception
     */
    void addOption(String[] name, String voteId) throws Exception;

}
