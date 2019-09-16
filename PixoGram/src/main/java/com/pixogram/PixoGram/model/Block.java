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
@Table(name = "block")
@SequenceGenerator(name = "seq4", initialValue = 1, allocationSize = 100)
public class Block {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq4")
	private long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userid")
	User userid;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "blockid")
	User blockid;

	public Block() {
	}

	public Block(User userid, User blockid) {

		this.userid = userid;
		this.blockid = blockid;
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

	public User getBlockid() {
		return blockid;
	}

	public void setBlockid(User blockid) {
		this.blockid = blockid;
	}

	@Override
	public String toString() {
		return "Block [id=" + id + ", userid=" + userid + ", blockid=" + blockid + "]";
	}

}
