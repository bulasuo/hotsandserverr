package com.blinkserver.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 用户表
 */
public class UserHS implements Serializable {
	private static final long serialVersionUID = 1L;

	private int uId;
	private byte uAffective;
	private Timestamp uBirth;
	private int u_blinkerId;
	private Timestamp u_createDate;
	private String u_headImg;
	private double uLat;
	private double uLng;
	private String u_nickName;
	private String uOccupation;
	private String uPassword;
	private String uPhone;
	private byte u_sealUp;
	private String u_sealUpReason;
	private byte uSex;
	private String uSign;
	private List<AttentionHS> attentions;//我的关注list
	private List<BlinkeredHS> blinkereds;//被我眨眼者list
	private List<BlinkerHS> blinkers;//对我眨眼者list
	private List<BookHS> books;
	private List<DynamicHS> dynamics;
	private List<MovieHS> movies;
	private List<MusicHS> musics;
	private List<MVHS> mvs;
	private List<TopicHS> topics;//我的话题
	private List<TopicCollectHS> topiccollects;//我的话题收藏
	private List<TopicReplyHS> topicreplies;//我的一级回复记录list
	private List<TopicReply2HS> topicreply2s;//我的二级回复记录list
	private List<UserDetailHS> userDetails;
	private List<UserImgHS> userimgs;
	
	public UserHS() {
	}

	public UserHS(int uId, byte uAffective, Timestamp uBirth, int u_blinkerId
			, Timestamp u_createDate, String u_headImg, double uLat, double uLng
			, String u_nickName, String uOccupation, String uPhone
			, byte u_sealUp, String u_sealUpReason, byte uSex, String uSign) {
		this.uId = uId;
		this.uAffective = uAffective;
		this.uBirth = uBirth;
		this.u_blinkerId = u_blinkerId;
		this.u_createDate = u_createDate;
		this.u_headImg = u_headImg;
		this.uLat = uLat;
		this.uLng = uLng;
		this.u_nickName = u_nickName;
		this.uOccupation = uOccupation;
		this.uPhone = uPhone;
		this.u_sealUp = u_sealUp;
		this.u_sealUpReason = u_sealUpReason;
		this.uSex = uSex;
		this.uSign = uSign;
	}

	@Override
	public String toString() {
		return "UserHS{" +
				"uId=" + uId +
				", uAffective=" + uAffective +
				", uBirth=" + uBirth +
				", u_blinkerId=" + u_blinkerId +
				", u_createDate=" + u_createDate +
				", u_headImg='" + u_headImg + '\'' +
				", uLat=" + uLat +
				", uLng=" + uLng +
				", u_nickName='" + u_nickName + '\'' +
				", uOccupation='" + uOccupation + '\'' +
				", uPassword='" + uPassword + '\'' +
				", uPhone='" + uPhone + '\'' +
				", u_sealUp=" + u_sealUp +
				", u_sealUpReason='" + u_sealUpReason + '\'' +
				", uSex=" + uSex +
				", uSign='" + uSign + '\'' +
				", attentions=" + attentions +
				", blinkereds=" + blinkereds +
				", blinkers=" + blinkers +
				", books=" + books +
				", dynamics=" + dynamics +
				", movies=" + movies +
				", musics=" + musics +
				", mvs=" + mvs +
				", topics=" + topics +
				", topiccollects=" + topiccollects +
				", topicreplies=" + topicreplies +
				", topicreply2s=" + topicreply2s +
				", userDetails=" + userDetails +
				", userimgs=" + userimgs +
				'}';
	}

	public int getUId() {
		return this.uId;
	}

	public void setUId(int uId) {
		this.uId = uId;
	}

	public byte getUAffective() {
		return this.uAffective;
	}

	public void setUAffective(byte uAffective) {
		this.uAffective = uAffective;
	}

	public Timestamp getUBirth() {
		return this.uBirth;
	}

	public void setUBirth(Timestamp uBirth) {
		this.uBirth = uBirth;
	}

	public int getU_blinkerId() {
		return this.u_blinkerId;
	}

	public void setU_blinkerId(int u_blinkerId) {
		this.u_blinkerId = u_blinkerId;
	}

	public Timestamp getU_createDate() {
		return this.u_createDate;
	}

	public void setU_createDate(Timestamp u_createDate) {
		this.u_createDate = u_createDate;
	}

	public String getU_headImg() {
		return this.u_headImg;
	}

	public void setU_headImg(String u_headImg) {
		this.u_headImg = u_headImg;
	}

	public double getULat() {
		return this.uLat;
	}

	public void setULat(double uLat) {
		this.uLat = uLat;
	}

	public double getULng() {
		return this.uLng;
	}

	public void setULng(double uLng) {
		this.uLng = uLng;
	}

	public String getU_nickName() {
		return this.u_nickName;
	}

	public void setU_nickName(String u_nickName) {
		this.u_nickName = u_nickName;
	}

	public String getUOccupation() {
		return this.uOccupation;
	}

	public void setUOccupation(String uOccupation) {
		this.uOccupation = uOccupation;
	}

	public String getUPassword() {
		return this.uPassword;
	}

	public void setUPassword(String uPassword) {
		this.uPassword = uPassword;
	}

	public String getUPhone() {
		return this.uPhone;
	}

	public void setUPhone(String uPhone) {
		this.uPhone = uPhone;
	}

	public byte getU_sealUp() {
		return this.u_sealUp;
	}

	public void setU_sealUp(byte u_sealUp) {
		this.u_sealUp = u_sealUp;
	}

	public String getU_sealUpReason() {
		return this.u_sealUpReason;
	}

	public void setU_sealUpReason(String u_sealUpReason) {
		this.u_sealUpReason = u_sealUpReason;
	}

	public byte getUSex() {
		return this.uSex;
	}

	public void setUSex(byte uSex) {
		this.uSex = uSex;
	}

	public String getUSign() {
		return this.uSign;
	}

	public void setUSign(String uSign) {
		this.uSign = uSign;
	}

	public List<AttentionHS> getAttentions() {
		return this.attentions;
	}

	public void setAttentions(List<AttentionHS> attentions) {
		this.attentions = attentions;
	}

	public List<BlinkeredHS> getBlinkereds() {
		return this.blinkereds;
	}

	public void setBlinkereds(List<BlinkeredHS> blinkereds) {
		this.blinkereds = blinkereds;
	}

	public List<BlinkerHS> getBlinkers() {
		return this.blinkers;
	}

	public void setBlinkers(List<BlinkerHS> blinkers) {
		this.blinkers = blinkers;
	}

	public List<BookHS> getBooks() {
		return this.books;
	}

	public void setBooks(List<BookHS> books) {
		this.books = books;
	}

	public List<DynamicHS> getDynamics() {
		return this.dynamics;
	}

	public void setDynamics(List<DynamicHS> dynamics) {
		this.dynamics = dynamics;
	}

	public List<MovieHS> getMovies() {
		return this.movies;
	}

	public void setMovies(List<MovieHS> movies) {
		this.movies = movies;
	}

	public List<MusicHS> getMusics() {
		return this.musics;
	}

	public void setMusics(List<MusicHS> musics) {
		this.musics = musics;
	}

	public List<MVHS> getMvs() {
		return this.mvs;
	}

	public void setMvs(List<MVHS> mvs) {
		this.mvs = mvs;
	}

	public List<TopicHS> getTopics() {
		return this.topics;
	}

	public void setTopics(List<TopicHS> topics) {
		this.topics = topics;
	}

	public List<TopicCollectHS> getTopiccollects() {
		return this.topiccollects;
	}

	public void setTopiccollects(List<TopicCollectHS> topiccollects) {
		this.topiccollects = topiccollects;
	}

	public List<TopicReplyHS> getTopicreplies() {
		return this.topicreplies;
	}

	public void setTopicreplies(List<TopicReplyHS> topicreplies) {
		this.topicreplies = topicreplies;
	}

	public List<TopicReply2HS> getTopicreply2s() {
		return this.topicreply2s;
	}

	public void setTopicreply2s(List<TopicReply2HS> topicreply2s) {
		this.topicreply2s = topicreply2s;
	}

	public List<UserDetailHS> getUserDetails() {
		return this.userDetails;
	}

	public void setUserDetails(List<UserDetailHS> userDetails) {
		this.userDetails = userDetails;
	}

	public List<UserImgHS> getUserimgs() {
		return this.userimgs;
	}

	public void setUserimgs(List<UserImgHS> userimgs) {
		this.userimgs = userimgs;
	}

}