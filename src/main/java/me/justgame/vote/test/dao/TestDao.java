package me.justgame.vote.test.dao;

import me.justgame.vote.test.model.Test;

import java.util.List;

/**
 * Created by xcl on 2017-01-05.
 */
public interface TestDao {
    List<Test> getTest() throws Exception;
}
