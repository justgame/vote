package me.justgame.dao;

import me.justgame.dao.mapper.AllMapper;
import me.justgame.model.Role;
import me.justgame.model.User;
import me.justgame.model.UserRoleRelation;
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
    public List<User> getUserList() throws Exception {
        return mapper.getUserList();
    }

    @Override
    public User getUserByNo(String userNo) throws Exception {
        return mapper.getUserByNo(userNo);
    }

    @Override
    public int addUser(User user) throws Exception {
        return mapper.addUser(user);
    }

    @Override
    public List<Role> getRoleList() throws Exception {
        return mapper.getRoleList();
    }

    @Override
    public List<Role> getRoleByUserNo(String userNo) throws Exception {
        return mapper.getRoleByUserNo(userNo);
    }

    @Override
    public int addRole(Role role) throws Exception {
        return mapper.addRole(role);
    }

    @Override
    public int addUserRoleRelation(UserRoleRelation relation) throws Exception {
        return mapper.addUserRoleRelation(relation);
    }

    @Override
    public List<String> getAllKindeditor() throws Exception {
        return mapper.getAllKindeditor();
    }

    @Override
    public int addKindeditor(String content) throws Exception {
        return mapper.addKindeditor(content);
    }
}
