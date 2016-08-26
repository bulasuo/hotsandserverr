package com.blink.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the topic database table.
 * 
 */
public class Topic implements Serializable {
	private static final long serialVersionUID = 1L;

	private int tcId;
	private Timestamp tcDate;
	private String tcDescribe;
	private String tcName;
	private String tcType;
	private int u_id;
	private List<TopicCollect> topiccollects;
	private List<TopicImg> topicimgs;
	private List<TopicReply> topicreplies;

	public Topic() {
	}

	public Topic(int tcId, Timestamp tcDate, String tcDescribe, String tcName, String tcType, int u_id, List<TopicCollect> topiccollects, List<TopicImg> topicimgs, List<TopicReply> topicreplies) {
		this.tcId = tcId;
		this.tcDate = tcDate;
		this.tcDescribe = tcDescribe;
		this.tcName = tcName;
		this.tcType = tcType;
		this.u_id = u_id;
		this.topiccollects = topiccollects;
		this.topicimgs = topicimgs;
		this.topicreplies = topicreplies;
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

	public List<TopicCollect> getTopiccollects() {
		return this.topiccollects;
	}

	public void setTopiccollects(List<TopicCollect> topiccollects) {
		this.topiccollects = topiccollects;
	}

	public List<TopicImg> getTopicimgs() {
		return this.topicimgs;
	}

	public void setTopicimgs(List<TopicImg> topicimgs) {
		this.topicimgs = topicimgs;
	}

	public List<TopicReply> getTopicreplies() {
		return this.topicreplies;
	}

	public void setTopicreplies(List<TopicReply> topicreplies) {
		this.topicreplies = topicreplies;
	}



}