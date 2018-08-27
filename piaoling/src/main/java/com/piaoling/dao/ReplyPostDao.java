package com.piaoling.dao;

import com.piaoling.entity.ReplyPost;

public interface ReplyPostDao {
    int deleteByPrimaryKey(Integer id);

    int insert(ReplyPost record);

    int insertSelective(ReplyPost record);

    ReplyPost selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ReplyPost record);

    int updateByPrimaryKeyWithBLOBs(ReplyPost record);

    int updateByPrimaryKey(ReplyPost record);
}