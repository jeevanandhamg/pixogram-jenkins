package com.pixogram.PixoGram.model;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

 

@Entity
@Table(name = "follow")
@SequenceGenerator(name = "seq3", initialValue = 1, allocationSize = 100)
public class Follow {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq3")
	private long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userid")
	User userid;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "followid")
	User followid;

	public Follow() {

	}

	public Follow(User userid, User followid) {
	 
		this.userid = userid;
		this.followid = followid;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUserid() {
		return userid;
	}

	public void setUserid(User userid) {
		this.userid = userid;
	}

	public User getFollowid() {
		return followid;
	}

	public void setFollowid(User followid) {
		this.followid = followid;
	}

	@Override
	public String toString() {
		return "Follow [id=" + id + ", userid=" + userid + ", followid=" + followid + "]";
	}

	
}
