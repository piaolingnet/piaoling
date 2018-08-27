package com.piaoling.dao;

import com.piaoling.entity.PlUser;

public interface PlUserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(PlUser record);

    int insertSelective(PlUser record);

    PlUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PlUser record);

    int updateByPrimaryKeyWithBLOBs(PlUser record);

    int updateByPrimaryKey(PlUser record);
}