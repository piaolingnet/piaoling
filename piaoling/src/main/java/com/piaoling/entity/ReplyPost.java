package com.piaoling.entity;

import java.util.Date;

public class ReplyPost {
    private Integer id;

    private Integer userId;

    private Integer pId;

    private Integer mainId;

    private Date replyTime;

    private String replyContent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Integer getMainId() {
        return mainId;
    }

    public void setMainId(Integer mainId) {
        this.mainId = mainId;
    }

    public Date getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent == null ? null : replyContent.trim();
    }
}