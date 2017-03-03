package me.justgame.dao;

import java.util.List;

/**
 * Created by xcl on 2017-03-03.
 */
public interface AllDao {
    List<String> getAllKindeditor() throws Exception;

    int addKindeditor(String content) throws Exception;
}
