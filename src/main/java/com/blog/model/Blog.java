package com.blog.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @Time 2018-4-22
 * @author 刘瀚霆
 * @Email 396882678@qq.com
 */
@Entity
public class Blog {
	/**
	 * 需要的内容
	 * @time  博客创建时间
	 * @title 标题
	 * @tags 标签 ， 暂时不考虑
	 * @content 内容
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	
	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(nullable = false,length = 10000)
	private String content;
	
	@Temporal(TemporalType.DATE)
	private Date createdDate;
	
	public Blog() {}
	public Blog(String title,String content){
		this.title = title;
		this.content = content;
		this.createdDate = new Date();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
}
