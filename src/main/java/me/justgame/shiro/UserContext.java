package me.justgame.shiro;

import me.justgame.model.Role;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xcl on 2017-03-06.
 */
public class UserContext implements Serializable {

    private static final long serialVersionUID = -8754101160775044576L;
    private transient PermissionService permissionService;

    private String name;
    private String userNo;


    public List<Role> getRoleByUserNo(String userNo) {
        List<Role> roles = new ArrayList<>();
        try {
            roles =  permissionService.getRoleByUserNo(userNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return roles;
    }

    public UserContext getInstance() {
        Subject subject = SecurityUtils.getSubject();
        UserContext userContext = (UserContext) subject.getPrincipal();
        return userContext;
    }

    public PermissionService getPermissionService() {
        return permissionService;
    }

    public void setPermissionService(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    @Override
    public String toString() {
        return "UserContext{" +
                "name='" + name + '\'' +
                ", userNo='" + userNo + '\'' +
                '}';
    }
}
