package me.justgame.vote.vote.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

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
    // 选择模式(0.单选 1.多选)
    private String mode;
    // 最大选择项数
    private Integer maxVoteNum;
    // 已投票数
    private Integer counts;
    // 是否过期
    private boolean expired;

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

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public Integer getMaxVoteNum() {
        return maxVoteNum;
    }

    public void setMaxVoteNum(Integer maxVoteNum) {
        this.maxVoteNum = maxVoteNum;
    }

    public Integer getCounts() {
        return counts;
    }

    public void setCounts(Integer counts) {
        this.counts = counts;
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
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
