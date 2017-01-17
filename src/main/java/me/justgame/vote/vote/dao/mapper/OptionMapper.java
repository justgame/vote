package me.justgame.vote.vote.dao.mapper;

import me.justgame.vote.common.annotations.MyBatisMapper;
import me.justgame.vote.vote.model.Option;
import me.justgame.vote.vote.model.OptionUserRelate;

import java.util.List;

/**
 * Created by xcl on 2017-01-05.
 */
@MyBatisMapper
public interface OptionMapper {

    List<Option> getOptionAll(String voteId) throws Exception;

    Option getOptionById(String id) throws Exception;

    int addOption(Option option) throws Exception;

    int delOptionByVoteId(String id) throws Exception;

    int delOptionBatch(List<String> list) throws Exception;

    int getOptionVoteCounts(String id) throws Exception;

    int addVote4Option(OptionUserRelate optionUserRelate) throws Exception;

    List<String> getUserVoted(String id) throws Exception;

    int delOptionUserRelByVoteId(String id) throws Exception;
}

