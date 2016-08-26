package com.blink.bean;

import java.io.Serializable;


/**
 * The persistent class for the topiccollect database table.
 * 话题收藏表
 */
public class TopicCollect implements Serializable {
	private static final long serialVersionUID = 1L;

	private int tcClt_id;
	private int u_id;
	private int tc_id;
	private Topic topic;

	public TopicCollect() {
	}

	public TopicCollect(int tcClt_id, int u_id, int tc_id, Topic topic) {
		this.tcClt_id = tcClt_id;
		this.u_id = u_id;
		this.tc_id = tc_id;
		this.topic = topic;
	}

	public int getTcClt_id() {
		return this.tcClt_id;
	}

	public void setTcClt_id(int tcClt_id) {
		this.tcClt_id = tcClt_id;
	}

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public Topic getTopic() {
		return this.topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public int getTc_id() {
		return tc_id;
	}

	public void setTc_id(int tc_id) {
		this.tc_id = tc_id;
	}
	
	

}