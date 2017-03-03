package me.justgame.dao;

import me.justgame.dao.mapper.AllMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xcl on 2017-03-03.
 */
@Repository
public class AllDaoImpl implements AllDao {
    @Resource
    AllMapper mapper;

    @Override
    public List<String> getAllKindeditor() throws Exception {
        return mapper.getAllKindeditor();
    }

    @Override
    public int addKindeditor(String content) throws Exception {
        return mapper.addKindeditor(content);
    }
}
