package com.piaoling.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.piaoling.dao.NewsMapper;
import com.piaoling.entity.News;
import com.piaoling.service.NewsService;
@Service
public class NewsServiceImpl implements NewsService{
	
	@Resource
	private NewsMapper newsMapper;
	
	@Override
	public News getNewsByPrimaryKey(String newsId) {
		return newsMapper.selectByPrimaryKey(newsId);
	}
	
	@Override
	public int saveNews(News news) throws Exception {
		// TODO Auto-generated method stub
		int i=newsMapper.insert(news);
		//throw new Exception("保存失败");
		String s=null;
		s.hashCode();
		
		return i;
	}

	@Override
	public int deleteByPrimaryKey(String newsId) throws Exception {
		// TODO Auto-generated method stub
		int i=newsMapper.deleteByPrimaryKey(newsId);
		return i;
	}

}
