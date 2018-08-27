package com.piaoling.dao;

import com.piaoling.entity.BbsBlock;

public interface BbsBlockDao {
    int deleteByPrimaryKey(Integer id);

    int insert(BbsBlock record);

    int insertSelective(BbsBlock record);

    BbsBlock selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BbsBlock record);

    int updateByPrimaryKey(BbsBlock record);
}