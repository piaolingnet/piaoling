package com.piaoling.entity;

public class Comments extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String comId; //评论id

    private String comTopicId; //主题id

    private String comTopicType; //主题类型

    private String comContent; //评论内容

    private String comFromId; //评论者id

    private String comToId; //被评论者id

    public String getComId() {
        return comId;
    }

    public void setComId(String comId) {
        this.comId = comId == null ? null : comId.trim();
    }

    public String getComTopicId() {
        return comTopicId;
    }

    public void setComTopicId(String comTopicId) {
        this.comTopicId = comTopicId == null ? null : comTopicId.trim();
    }

    public String getComTopicType() {
        return comTopicType;
    }

    public void setComTopicType(String comTopicType) {
        this.comTopicType = comTopicType == null ? null : comTopicType.trim();
    }

    public String getComContent() {
        return comContent;
    }

    public void setComContent(String comContent) {
        this.comContent = comContent == null ? null : comContent.trim();
    }

    public String getComFromId() {
        return comFromId;
    }

    public void setComFromId(String comFromId) {
        this.comFromId = comFromId == null ? null : comFromId.trim();
    }

    public String getComToId() {
        return comToId;
    }

    public void setComToId(String comToId) {
        this.comToId = comToId == null ? null : comToId.trim();
    }
}