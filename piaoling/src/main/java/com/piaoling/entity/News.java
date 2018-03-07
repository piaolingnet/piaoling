package com.piaoling.entity;

import java.util.Date;

public class News extends BaseEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//新闻id
    private String newsId;
    //新闻标题
    private String newsTitle;
    //新闻类型
    private String newsType;

    private Date publishDate;

    private String newsSource;

    private String parentColumn;

    private String keywords;

    private String relevantNews;

    private String isComment;

    private String newsContent;

    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId == null ? null : newsId.trim();
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle == null ? null : newsTitle.trim();
    }

    public String getNewsType() {
        return newsType;
    }

    public void setNewsType(String newsType) {
        this.newsType = newsType == null ? null : newsType.trim();
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getNewsSource() {
        return newsSource;
    }

    public void setNewsSource(String newsSource) {
        this.newsSource = newsSource == null ? null : newsSource.trim();
    }

    public String getParentColumn() {
        return parentColumn;
    }

    public void setParentColumn(String parentColumn) {
        this.parentColumn = parentColumn == null ? null : parentColumn.trim();
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords == null ? null : keywords.trim();
    }

    public String getRelevantNews() {
        return relevantNews;
    }

    public void setRelevantNews(String relevantNews) {
        this.relevantNews = relevantNews == null ? null : relevantNews.trim();
    }

    public String getIsComment() {
        return isComment;
    }

    public void setIsComment(String isComment) {
        this.isComment = isComment == null ? null : isComment.trim();
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent == null ? null : newsContent.trim();
    }
}