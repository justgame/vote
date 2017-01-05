package me.justgame.vote.vote.service.impl;

import me.justgame.vote.vote.service.VoteService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by xcl on 2017-01-05.
 */
public class VoteServiceImplTest {

    private ApplicationContext applicationContext;

    private VoteService voteService;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("classpath:springcontext.xml");
        voteService = (VoteService) applicationContext.getBean("voteServiceImpl");
    }

    @Test
    public void getVoteAll() throws Exception {

    }

    @Test
    public void getVoteById() throws Exception {
        System.out.println(voteService.getVoteById("1"));
    }

}