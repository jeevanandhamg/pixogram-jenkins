package com.pixogram.PixoGram.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "posts")
@SequenceGenerator(name = "seq2", initialValue = 1, allocationSize = 100)
public class Posts {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq2")
	private long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userid")
	User userid;

	@Lob
	private byte[] image;

	@Column
	private long liked;

	@Column
	private long unlike;

	@Column
	private String comment;

	@Column
	private String title;

	@Column
	private String description;

	public Posts() {
	
		// TODO Auto-generated constructor stub
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

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public long getLiked() {
		return liked;
	}

	public void setLiked(long liked) {
		this.liked = liked;
	}

	public long getUnlike() {
		return unlike;
	}

	public void setUnlike(long unlike) {
		this.unlike = unlike;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Posts [id=" + id + ", userid=" + userid + ", image=" + image + ", liked=" + liked + ", unlike=" + unlike
				+ ", comment=" + comment + ", title=" + title + ", description=" + description + "]";
	}

	
	
	
	
}
