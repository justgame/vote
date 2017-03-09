package me.justgame.model;

/**
 * Created by xcl on 2017-03-06.
 */
public class UserRoleRelation {
    private String userNo;
    private String roleNo;

    @Override
    public String toString() {
        return "UserRoleRelation{" +
                "userNo='" + userNo + '\'' +
                ", roleNo='" + roleNo + '\'' +
                '}';
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getRoleNo() {
        return roleNo;
    }

    public void setRoleNo(String roleNo) {
        this.roleNo = roleNo;
    }
}
