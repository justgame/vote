package me.justgame.shiro;

import me.justgame.dao.AllDao;
import me.justgame.model.Role;
import org.apache.shiro.ShiroException;
import org.apache.shiro.util.Initializable;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xcl on 2017-03-08.
 */
public class PermissionService implements Initializable {
    @Resource
    private AllDao allDao;

    @Override
    public void init() throws ShiroException {

    }

    public List<Role> getRoleByUserNo(String userNo) throws Exception {
        return allDao.getRoleByUserNo(userNo);
    }
}
