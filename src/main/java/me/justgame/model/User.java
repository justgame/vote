package me.justgame.model;

import java.io.Serializable;

/**
 * Created by xcl on 2017-03-06.
 */
public class User implements Serializable {
    private static final long serialVersionUID = -8754101160775044576L;

    private String id;
    private String name;
    private String userNo;

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", userNo='" + userNo + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
