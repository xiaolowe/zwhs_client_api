package cn.org.citycloud.zwhs.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the article_class database table.
 * 
 */
@Entity
@Table(name="article_class")
@NamedQuery(name="ArticleClass.findAll", query="SELECT a FROM ArticleClass a")
public class ArticleClass implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="article_class_id", unique=true, nullable=false)
	private int articleClassId;

	@Column(name="article_class_name", length=30)
	private String articleClassName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ins_date")
	private Date insDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="upd_date")
	private Date updDate;

	public ArticleClass() {
	}

	public int getArticleClassId() {
		return this.articleClassId;
	}

	public void setArticleClassId(int articleClassId) {
		this.articleClassId = articleClassId;
	}

	public String getArticleClassName() {
		return this.articleClassName;
	}

	public void setArticleClassName(String articleClassName) {
		this.articleClassName = articleClassName;
	}

	public Date getInsDate() {
		return this.insDate;
	}

	public void setInsDate(Date insDate) {
		this.insDate = insDate;
	}

	public Date getUpdDate() {
		return this.updDate;
	}

	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}

}