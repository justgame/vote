package me.justgame.dao.mapper;

import me.justgame.model.Role;
import me.justgame.model.User;
import me.justgame.model.UserRoleRelation;
import me.justgame.vote.common.annotations.MyBatisMapper;

import java.util.List;

/**
 * Created by xcl on 2017-03-03.
 */
@MyBatisMapper
public interface AllMapper {
    List<User> getUserList() throws Exception;

    User getUserByNo(String userNo) throws Exception;

    int addUser(User user) throws Exception;

    List<Role> getRoleList() throws Exception;

    List<Role> getRoleByUserNo(String userNo) throws Exception;

    int addRole(Role role) throws Exception;

    int addUserRoleRelation(UserRoleRelation relation) throws Exception;

    List<String> getAllKindeditor() throws Exception;

    int addKindeditor(String content) throws Exception;
}
