package me.justgame.vote.vote.dao.impl;

import me.justgame.vote.vote.dao.VoteDao;
import me.justgame.vote.vote.model.Vote;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Calendar;

/**
 * Created by xcl on 2017-01-05.
 */
public class VoteDaoImplTest {

    private ApplicationContext applicationContext;

    private VoteDao voteDao;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("classpath:springcontext.xml");
        voteDao = (VoteDao) applicationContext.getBean("voteDaoImpl");
    }

    @Test
    public void getAllVote() throws Exception {

    }

    @Test
    public void getVoteById() throws Exception {

    }

    @Test
    public void addVote() throws Exception {
        Vote vote = new Vote();
        Calendar calendar = Calendar.getInstance();
        vote.setId("2");
        vote.setSubject("中午吃什么");
        vote.setStartTime(new Timestamp(calendar.getTimeInMillis()));
        calendar.add(Calendar.DAY_OF_YEAR, 10);
        vote.setEndTime(new Timestamp(calendar.getTimeInMillis()));
        vote.setAuthor("xiecongle");
        System.out.println(voteDao.addVote(vote));
    }

    @Test
    public void delVote() throws Exception {

    }

    @Test
    public void delVoteBatch() throws Exception {
        System.out.println(voteDao.delVoteBatch(Arrays.asList("1", "2", "3")));
    }

}