package me.justgame.vote.test.model;

/**
 * Created by xcl on 2017-01-05.
 */
public class Test {
    private String id;
    private String message;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id='" + id + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
