package com.blink.bean;

import java.io.Serializable;


/**
 * The persistent class for the topicreply2 database table.
 * 
 */
public class TopicReply2 implements Serializable {
	private static final long serialVersionUID = 1L;

	private int tcR2_id;
	private int tcR2_u_id;//二级回复者id
	private int tcR_u_id;//一级回复者id
	private String tcR2_content;
	private int tcR2_date;
	private int tcR_id;
	

	public TopicReply2() {
	}

	public TopicReply2(int tcR2_id, int tcR2_u_id, int tcR_u_id, String tcR2_content, int tcR2_date, int tcR_id) {
		this.tcR2_id = tcR2_id;
		this.tcR2_u_id = tcR2_u_id;
		this.tcR_u_id = tcR_u_id;
		this.tcR2_content = tcR2_content;
		this.tcR2_date = tcR2_date;
		this.tcR_id = tcR_id;
	}

	public int getTcR2_id() {
		return this.tcR2_id;
	}

	public void setTcR2_id(int tcR2_id) {
		this.tcR2_id = tcR2_id;
	}

	public int getTcR2_u_id() {
		return tcR2_u_id;
	}

	public void setTcR2_u_id(int tcR2_u_id) {
		this.tcR2_u_id = tcR2_u_id;
	}

	public int getTcR_u_id() {
		return tcR_u_id;
	}

	public void setTcR_u_id(int tcR_u_id) {
		this.tcR_u_id = tcR_u_id;
	}

	public String getTcR2_content() {
		return tcR2_content;
	}

	public void setTcR2_content(String tcR2_content) {
		this.tcR2_content = tcR2_content;
	}

	public int getTcR2_date() {
		return tcR2_date;
	}

	public void setTcR2_date(int tcR2_date) {
		this.tcR2_date = tcR2_date;
	}

	public int getTcR_id() {
		return tcR_id;
	}

	public void setTcR_id(int tcR_id) {
		this.tcR_id = tcR_id;
	}

	

}