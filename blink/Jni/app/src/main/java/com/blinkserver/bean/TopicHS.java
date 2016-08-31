package com.blinkserver.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the topic database table.
 * 话题表
 */
public class TopicHS implements Serializable {
	private static final long serialVersionUID = 1L;

	private int tcId;
	private Timestamp tcDate;
	private String tcDescribe;
	private String tcName;
	private String tcType;
	private int u_id;
	private List<TopicCollectHS> topiccollects;
	private List<TopicImgHS> topicimgs;
	private List<TopicReplyHS> topicreplies;

	public TopicHS() {
	}

	public TopicHS(int tcId, Timestamp tcDate, String tcDescribe, String tcName, String tcType, int u_id) {
		this.tcId = tcId;
		this.tcDate = tcDate;
		this.tcDescribe = tcDescribe;
		this.tcName = tcName;
		this.tcType = tcType;
		this.u_id = u_id;
	}

	@Override
	public String toString() {
		return "TopicHS{" +
				"tcId=" + tcId +
				", tcDate=" + tcDate +
				", tcDescribe='" + tcDescribe + '\'' +
				", tcName='" + tcName + '\'' +
				", tcType='" + tcType + '\'' +
				", u_id=" + u_id +
				", topiccollects=" + topiccollects +
				", topicimgs=" + topicimgs +
				", topicreplies=" + topicreplies +
				'}';
	}

	public int getTcId() {
		return this.tcId;
	}

	public void setTcId(int tcId) {
		this.tcId = tcId;
	}

	public Timestamp getTcDate() {
		return this.tcDate;
	}

	public void setTcDate(Timestamp tcDate) {
		this.tcDate = tcDate;
	}

	public String getTcDescribe() {
		return this.tcDescribe;
	}

	public void setTcDescribe(String tcDescribe) {
		this.tcDescribe = tcDescribe;
	}

	public String getTcName() {
		return this.tcName;
	}

	public void setTcName(String tcName) {
		this.tcName = tcName;
	}

	public String getTcType() {
		return this.tcType;
	}

	public void setTcType(String tcType) {
		this.tcType = tcType;
	}

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public List<TopicCollectHS> getTopiccollects() {
		return this.topiccollects;
	}

	public void setTopiccollects(List<TopicCollectHS> topiccollects) {
		this.topiccollects = topiccollects;
	}

	public List<TopicImgHS> getTopicimgs() {
		return this.topicimgs;
	}

	public void setTopicimgs(List<TopicImgHS> topicimgs) {
		this.topicimgs = topicimgs;
	}

	public List<TopicReplyHS> getTopicreplies() {
		return this.topicreplies;
	}

	public void setTopicreplies(List<TopicReplyHS> topicreplies) {
		this.topicreplies = topicreplies;
	}



}