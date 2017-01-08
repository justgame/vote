package me.justgame.vote.vote.service.impl;

import me.justgame.vote.vote.dao.OptionDao;
import me.justgame.vote.vote.model.Option;
import me.justgame.vote.vote.service.OptionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by xcl on 2017-01-06.
 */
@Service
public class OptionServiceImpl implements OptionService {

    @Resource
    private OptionDao optionDao;

    @Override
    public void countsPlus(String id) throws Exception {
        Option option = optionDao.getOptionById(id);
        int counts = option.getCounts() != null ? option.getCounts() + 1 : 1;
        option.setCounts(counts);
        optionDao.editOption(option);
    }

    @Override
    public void countsPlus(Option option) throws Exception {
        String id = option.getId();
        countsPlus(id);
    }
}
