package com.blink.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the dynamic database table.
 * 
 */
public class Dynamic implements Serializable {
	private static final long serialVersionUID = 1L;

	private int dncId;
	private Timestamp dncDate;
	private String dncDescribe;
	private int u_id;
	private List<DynamicImg> dynamicimgs;

	public Dynamic() {
	}

	public Dynamic(int dncId, Timestamp dncDate, String dncDescribe, int u_id, List<DynamicImg> dynamicimgs) {
		this.dncId = dncId;
		this.dncDate = dncDate;
		this.dncDescribe = dncDescribe;
		this.u_id = u_id;
		this.dynamicimgs = dynamicimgs;
	}

	public int getDncId() {
		return this.dncId;
	}

	public void setDncId(int dncId) {
		this.dncId = dncId;
	}

	public Timestamp getDncDate() {
		return this.dncDate;
	}

	public void setDncDate(Timestamp dncDate) {
		this.dncDate = dncDate;
	}

	public String getDncDescribe() {
		return this.dncDescribe;
	}

	public void setDncDescribe(String dncDescribe) {
		this.dncDescribe = dncDescribe;
	}

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public List<DynamicImg> getDynamicimgs() {
		return this.dynamicimgs;
	}

	public void setDynamicimgs(List<DynamicImg> dynamicimgs) {
		this.dynamicimgs = dynamicimgs;
	}


}