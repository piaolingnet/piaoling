package com.piaoling.service;

import com.piaoling.entity.News;

public interface NewsService {
	
	public News getNewsByPrimaryKey(String newsId);

	public int saveNews(News news) throws Exception;
	
	public int deleteByPrimaryKey(String newsId) throws Exception;
}
