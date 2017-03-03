package me.justgame.dao.mapper;

import me.justgame.vote.common.annotations.MyBatisMapper;

import java.util.List;

/**
 * Created by xcl on 2017-03-03.
 */
@MyBatisMapper
public interface AllMapper {
    List<String> getAllKindeditor() throws Exception;

    int addKindeditor(String content) throws Exception;
}
