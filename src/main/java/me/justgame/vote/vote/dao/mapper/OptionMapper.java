package me.justgame.vote.vote.dao.mapper;

import me.justgame.vote.common.annotations.MyBatisMapper;
import me.justgame.vote.vote.model.Option;

import java.util.List;

/**
 * Created by xcl on 2017-01-05.
 */
@MyBatisMapper
public interface OptionMapper {

    List<Option> getOptionAll(String voteId) throws Exception;

    Option getOptionById(String id) throws Exception;

    int addOption(Option option) throws Exception;

    int editOption(Option option) throws Exception;

    int delOptionBatch(List<String> list) throws Exception;
}

