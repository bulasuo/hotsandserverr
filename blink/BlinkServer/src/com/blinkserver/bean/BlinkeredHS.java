package com.blinkserver.bean;

import java.io.Serializable;


/**
 * The persistent class for the blinkered database table.
 * 暂时未用到
 */
public class BlinkeredHS implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private int bkedId;
	private int bked_blinkerId;
	private int bked_blinkeredId;
	private UserHS blinkedUser;

	public BlinkeredHS() {
	}

	public BlinkeredHS(int bkedId, int bked_blinkerId, int bked_blinkeredId, UserHS blinkedUser) {
		this.bkedId = bkedId;
		this.bked_blinkerId = bked_blinkerId;
		this.bked_blinkeredId = bked_blinkeredId;
		this.blinkedUser = blinkedUser;
	}

	public int getBkedId() {
		return this.bkedId;
	}

	public void setBkedId(int bkedId) {
		this.bkedId = bkedId;
	}

	public int getBked_blinkerId() {
		return bked_blinkerId;
	}

	public void setBked_blinkerId(int bked_blinkerId) {
		this.bked_blinkerId = bked_blinkerId;
	}

	public int getBked_blinkeredId() {
		return bked_blinkeredId;
	}

	public void setBked_blinkeredId(int bked_blinkeredId) {
		this.bked_blinkeredId = bked_blinkeredId;
	}

	public UserHS getBlinkedUser() {
		return blinkedUser;
	}

	public void setBlinkedUser(UserHS blinkedUser) {
		this.blinkedUser = blinkedUser;
	}


	

}