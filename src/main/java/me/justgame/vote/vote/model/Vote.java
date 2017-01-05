package me.justgame.vote.vote.model;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by xcl on 2017-01-05.
 */

/**
 * 投票类
 */
public class Vote {
    // id
    private String id;
    // 投票主题
    private String subject;
    // 开始时间
    private Timestamp startTime;
    // 结束时间
    private Timestamp endTime;
    // 发起人
    private String author;
    // 投票选项
    private List<Option> options;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "id='" + id + '\'' +
                ", subject='" + subject + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", author='" + author + '\'' +
                ", options=" + options +
                '}';
    }
}
