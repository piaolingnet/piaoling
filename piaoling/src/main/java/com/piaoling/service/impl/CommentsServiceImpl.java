package com.piaoling.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.piaoling.dao.CommentsMapper;
import com.piaoling.entity.Comments;
import com.piaoling.entity.News;
import com.piaoling.service.CommentsService;
import com.piaoling.service.NewsService;
@Service
public class CommentsServiceImpl implements CommentsService{

	@Resource
	private CommentsMapper commentMapper;
	@Resource
	private NewsService newsService;
	
	@Override
	public int saveComments(Comments comments) {
		// TODO Auto-generated method stub
		int i=commentMapper.insert(comments);
		News news =new News();
		news.setNewsId("3"); 
		news.setKeywords("爱国");
		news.setNewsContent("我是中国人范德萨发打谁范德萨范德萨发");
		try {
			newsService.saveNews(news);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

}
