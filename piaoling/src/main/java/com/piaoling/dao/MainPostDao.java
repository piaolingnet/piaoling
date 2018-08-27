package com.piaoling.dao;

import com.piaoling.entity.MainPost;

public interface MainPostDao {
    int deleteByPrimaryKey(Integer id);

    int insert(MainPost record);

    int insertSelective(MainPost record);

    MainPost selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MainPost record);

    int updateByPrimaryKeyWithBLOBs(MainPost record);

    int updateByPrimaryKey(MainPost record);
}