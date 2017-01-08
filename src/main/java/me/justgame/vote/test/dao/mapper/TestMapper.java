package me.justgame.vote.test.dao.mapper;

import me.justgame.vote.common.annotations.MyBatisMapper;
import me.justgame.vote.test.model.Test;

import java.util.List;

/**
 * Created by xcl on 2017-01-05.
 */

@MyBatisMapper
public interface TestMapper {

    List<Test> getTest() throws Exception;

}
