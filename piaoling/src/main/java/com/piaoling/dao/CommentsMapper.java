package com.piaoling.dao;

import com.piaoling.entity.Comments;

public interface CommentsMapper {
    int deleteByPrimaryKey(String comId);

    int insert(Comments record);

    int insertSelective(Comments record);

    Comments selectByPrimaryKey(String comId);

    int updateByPrimaryKeySelective(Comments record);

    int updateByPrimaryKey(Comments record);
}