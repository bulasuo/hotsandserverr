package com.blink.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the topicreply database table.
 * 
 */
public class TopicReply implements Serializable {
	private static final long serialVersionUID = 1L;

	private int tcR_id;
	private String tcR_content;
	private Timestamp tcR_date;
	private int tc_id;
	private int u_id;
	private List<TopicReply2> topicreply2s;

	public TopicReply() {
	}

	public TopicReply(int tcR_id, String tcR_content, Timestamp tcR_date, int tc_id, int u_id, List<TopicReply2> topicreply2s) {
		this.tcR_id = tcR_id;
		this.tcR_content = tcR_content;
		this.tcR_date = tcR_date;
		this.tc_id = tc_id;
		this.u_id = u_id;
		this.topicreply2s = topicreply2s;
	}

	public int getTcR_id() {
		return this.tcR_id;
	}

	public void setTcR_id(int tcR_id) {
		this.tcR_id = tcR_id;
	}

	public String getTcR_content() {
		return this.tcR_content;
	}

	public void setTcR_content(String tcR_content) {
		this.tcR_content = tcR_content;
	}

	public Timestamp getTcR_date() {
		return this.tcR_date;
	}

	public void setTcR_date(Timestamp tcR_date) {
		this.tcR_date = tcR_date;
	}

	public int getTc_id() {
		return tc_id;
	}

	public void setTc_id(int tc_id) {
		this.tc_id = tc_id;
	}

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public List<TopicReply2> getTopicreply2s() {
		return this.topicreply2s;
	}

	public void setTopicreply2s(List<TopicReply2> topicreply2s) {
		this.topicreply2s = topicreply2s;
	}

}