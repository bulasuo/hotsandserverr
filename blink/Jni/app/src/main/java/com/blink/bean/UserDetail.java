package com.blink.bean;

import java.io.Serializable;


/**
 * The persistent class for the user_detail database table.
 * 用户详细表
 */
public class UserDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	private int udId;
	private int udBlinkeds;
	private int udBlinks;
	private byte ud_bodyOdor;
	private int udBreaks;
	private String udDriving;
	private String udEducation;
	private int udHeight;
	private String udHometown;
	private byte udLiveparents;
	private String udLocation;
	private String ud_ownCar;
	private byte ud_ownHouse;
	private int ud_replyTopics;
	private int udSalary;
	private String udSettlement;
	private byte udSnore;
	private int udStates;
	private int udTopics;
	private byte udVirgin;
	private int udWeight;
	private int u_id;

	public UserDetail() {
	}

	public UserDetail(int udId, int udBlinkeds, int udBlinks, byte ud_bodyOdor, int udBreaks,
					  String udDriving, String udEducation, int udHeight, String udHometown,
					  byte udLiveparents, String udLocation, String ud_ownCar, byte ud_ownHouse,
					  int ud_replyTopics, int udSalary, String udSettlement, byte udSnore,
					  int udStates, int udTopics, byte udVirgin, int udWeight, int u_id) {
		this.udId = udId;
		this.udBlinkeds = udBlinkeds;
		this.udBlinks = udBlinks;
		this.ud_bodyOdor = ud_bodyOdor;
		this.udBreaks = udBreaks;
		this.udDriving = udDriving;
		this.udEducation = udEducation;
		this.udHeight = udHeight;
		this.udHometown = udHometown;
		this.udLiveparents = udLiveparents;
		this.udLocation = udLocation;
		this.ud_ownCar = ud_ownCar;
		this.ud_ownHouse = ud_ownHouse;
		this.ud_replyTopics = ud_replyTopics;
		this.udSalary = udSalary;
		this.udSettlement = udSettlement;
		this.udSnore = udSnore;
		this.udStates = udStates;
		this.udTopics = udTopics;
		this.udVirgin = udVirgin;
		this.udWeight = udWeight;
		this.u_id = u_id;
	}

	public int getUdId() {
		return this.udId;
	}

	public void setUdId(int udId) {
		this.udId = udId;
	}

	public int getUdBlinkeds() {
		return this.udBlinkeds;
	}

	public void setUdBlinkeds(int udBlinkeds) {
		this.udBlinkeds = udBlinkeds;
	}

	public int getUdBlinks() {
		return this.udBlinks;
	}

	public void setUdBlinks(int udBlinks) {
		this.udBlinks = udBlinks;
	}

	public byte getUd_bodyOdor() {
		return this.ud_bodyOdor;
	}

	public void setUd_bodyOdor(byte ud_bodyOdor) {
		this.ud_bodyOdor = ud_bodyOdor;
	}

	public int getUdBreaks() {
		return this.udBreaks;
	}

	public void setUdBreaks(int udBreaks) {
		this.udBreaks = udBreaks;
	}

	public String getUdDriving() {
		return this.udDriving;
	}

	public void setUdDriving(String udDriving) {
		this.udDriving = udDriving;
	}

	public String getUdEducation() {
		return this.udEducation;
	}

	public void setUdEducation(String udEducation) {
		this.udEducation = udEducation;
	}

	public int getUdHight() {
		return this.udHeight;
	}

	public void setUdHight(int udHeight) {
		this.udHeight = udHeight;
	}

	public String getUdHometown() {
		return this.udHometown;
	}

	public void setUdHometown(String udHometown) {
		this.udHometown = udHometown;
	}

	public byte getUdLiveparents() {
		return this.udLiveparents;
	}

	public void setUdLiveparents(byte udLiveparents) {
		this.udLiveparents = udLiveparents;
	}

	public String getUdLocation() {
		return this.udLocation;
	}

	public void setUdLocation(String udLocation) {
		this.udLocation = udLocation;
	}

	public String getUd_ownCar() {
		return this.ud_ownCar;
	}

	public void setUd_ownCar(String ud_ownCar) {
		this.ud_ownCar = ud_ownCar;
	}

	public byte getUd_ownHouse() {
		return this.ud_ownHouse;
	}

	public void setUd_ownHouse(byte ud_ownHouse) {
		this.ud_ownHouse = ud_ownHouse;
	}

	public int getUd_replyTopics() {
		return this.ud_replyTopics;
	}

	public void setUd_replyTopics(int ud_replyTopics) {
		this.ud_replyTopics = ud_replyTopics;
	}

	public int getUdSalary() {
		return this.udSalary;
	}

	public void setUdSalary(int udSalary) {
		this.udSalary = udSalary;
	}

	public String getUdSettlement() {
		return this.udSettlement;
	}

	public void setUdSettlement(String udSettlement) {
		this.udSettlement = udSettlement;
	}

	public byte getUdSnore() {
		return this.udSnore;
	}

	public void setUdSnore(byte udSnore) {
		this.udSnore = udSnore;
	}

	public int getUdStates() {
		return this.udStates;
	}

	public void setUdStates(int udStates) {
		this.udStates = udStates;
	}

	public int getUdTopics() {
		return this.udTopics;
	}

	public void setUdTopics(int udTopics) {
		this.udTopics = udTopics;
	}

	public byte getUdVirgin() {
		return this.udVirgin;
	}

	public void setUdVirgin(byte udVirgin) {
		this.udVirgin = udVirgin;
	}

	public int getUdWeight() {
		return this.udWeight;
	}

	public void setUdWeight(int udWeight) {
		this.udWeight = udWeight;
	}

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	

}