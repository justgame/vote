package me.justgame.dao;

import me.justgame.model.Role;
import me.justgame.model.User;
import me.justgame.vote.common.utils.IdUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by xcl on 2017-03-06.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/springContext.xml"})
public class AllDaoImplTest {
    @Resource
    AllDao dao;

    @Test
    public void getUserList() throws Exception {
        System.out.println(dao.getUserList());
    }

    @Test
    public void getUserByNo() throws Exception {

    }

    @Test
    public void addUser() throws Exception {
        User user = new User();
        user.setId(IdUtil.getUID());
        user.setName("普通测试员");
        user.setUserNo("common_manager");
        dao.addUser(user);
    }

    @Test
    public void getRoleList() throws Exception {

    }

    @Test
    public void getRoleByUserNo() throws Exception {
        System.out.println(dao.getRoleByUserNo("V0001"));
    }

    @Test
    public void addRole() throws Exception {
        Role role = new Role();
        role.setId(IdUtil.getUID());
        role.setName("系统管理员");
        role.setRoleNo("sys_manager");
        dao.addRole(role);

        Role role1 = new Role();
        role1.setId(IdUtil.getUID());
        role1.setName("普通会员");
        role1.setRoleNo("common_tester");
        dao.addRole(role1);

    }

    @Test
    public void addUserRoleRelation() throws Exception {

    }

}