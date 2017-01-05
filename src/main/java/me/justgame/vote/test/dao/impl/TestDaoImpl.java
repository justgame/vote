package me.justgame.vote.test.dao.impl;

import me.justgame.vote.test.dao.TestDao;
import me.justgame.vote.test.dao.mapper.TestMapper;
import me.justgame.vote.test.model.Test;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xcl on 2017-01-06.
 */
@Repository
public class TestDaoImpl implements TestDao {
    @Resource
    TestMapper mapper;

    @Override
    public List<Test> getTest() throws Exception {
        return mapper.getTest();
    }
}
