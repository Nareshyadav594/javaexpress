package com.javaexpress.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
@Table(name = "Book_java")

public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "BookId")
	private int id;
	@Column(name = "BookName")
	private String name;
	@Column(name = "BookAuthorName")
	private String authorName;

	@CreationTimestamp
	@JsonFormat(shape = Shape.STRING, pattern = "dd-mm-yyy  hh:mm:ss")
	private Date createTime;
	@CreationTimestamp
	@JsonFormat(shape = Shape.STRING, pattern = "dd-mm-yyy  hh:mm:ss")

	private Date updateTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
