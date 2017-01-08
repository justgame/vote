package me.justgame.vote.vote.service;

import me.justgame.vote.vote.model.Option;

/**
 * Created by xcl on 2017-01-06.
 */
public interface OptionService {
    /**
     * 票数+1
     * @param id 选项id
     * @throws Exception
     */
    void countsPlus(String id) throws Exception;

    /**
     * 票数+1
     * @param option 选项
     * @throws Exception
     */
    void countsPlus(Option option) throws Exception;
}
