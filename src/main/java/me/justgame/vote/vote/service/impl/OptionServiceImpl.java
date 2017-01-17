package me.justgame.vote.vote.service.impl;

import me.justgame.vote.common.utils.IdUtil;
import me.justgame.vote.vote.dao.OptionDao;
import me.justgame.vote.vote.model.Option;
import me.justgame.vote.vote.service.OptionService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by xcl on 2017-01-06.
 */
@Service
public class OptionServiceImpl implements OptionService {

    @Resource
    private OptionDao optionDao;

    @Override
    public void addOption(String name, String voteId) throws Exception {
        if (StringUtils.isBlank(name) || StringUtils.isBlank(voteId))
            return;
        Option option = new Option();
        option.setId(IdUtil.getUID());
        option.setName(name);
        option.setVoteId(voteId);
        option.setCounts(0);
        optionDao.addOption(option);
    }

    @Transactional
    @Override
    public void addOption(String[] name, String voteId) throws Exception {
        if (name == null || name.length == 0 || StringUtils.isBlank(voteId))
            return;
        for (int i = 0, j = name.length; i < j; i++) {
            if (StringUtils.isBlank(name[i]))
                continue;
            Option option = new Option();
            option.setId(IdUtil.getUID());
            // 防止xss攻击
            String fName = name[i];
            fName = fName.replace("<", "&lt;");

            option.setName(fName);
            option.setVoteId(voteId);
            option.setCounts(0);
            option.setSortNo(i);
            optionDao.addOption(option);
        }
    }

}
