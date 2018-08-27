package com.piaoling.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piaoling.dao.PlUserDao;
import com.piaoling.entity.PlUser;
import com.piaoling.service.PlUserService;
@Service
public class PlUserServiceImpl implements PlUserService{

	@Autowired
	private PlUserDao plUserDao;
	
	@Override
	public Integer insert(PlUser plUser) {
		return plUserDao.insert(plUser);
	}

}
