package me.justgame.vote.vote.model;

/**
 * Created by xcl on 2017-01-06.
 */
public class Option {
    private String id;
    private String name;
    private String voteId;
    private Integer counts;

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

    public String getVoteId() {
        return voteId;
    }

    public void setVoteId(String voteId) {
        this.voteId = voteId;
    }

    public Integer getCounts() {
        return counts;
    }

    public void setCounts(Integer counts) {
        this.counts = counts;
    }

    @Override
    public String toString() {
        return "Option{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", voteId='" + voteId + '\'' +
                ", counts=" + counts +
                '}';
    }
}
