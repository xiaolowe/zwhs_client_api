package cn.org.citycloud.zwhs.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the knowledge_info database table.
 * 
 */
@Entity
@Table(name="knowledge_info")
@NamedQuery(name="KnowledgeInfo.findAll", query="SELECT k FROM KnowledgeInfo k")
public class KnowledgeInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int id;

	@Column(name="article_class_id")
	private int articleClassId;

	@Column(name="article_class_name", length=30)
	private String articleClassName;

	@Lob
	@Column(name="article_comments")
	private String articleComments;

	@Column(name="article_state")
	private int articleState;

	@Column(name="article_title", length=30)
	private String articleTitle;

	@Column(name="cover_pic", length=100)
	private String coverPic;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ins_date")
	private Date insDate;

	@Column(name="thumbnail_pic", length=100)
	private String thumbnailPic;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="upd_date")
	private Date updDate;

	public KnowledgeInfo() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getArticleComments() {
		return this.articleComments;
	}

	public void setArticleComments(String articleComments) {
		this.articleComments = articleComments;
	}

	public int getArticleState() {
		return this.articleState;
	}

	public void setArticleState(int articleState) {
		this.articleState = articleState;
	}

	public String getArticleTitle() {
		return this.articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	public String getCoverPic() {
		return this.coverPic;
	}

	public void setCoverPic(String coverPic) {
		this.coverPic = coverPic;
	}

	public Date getInsDate() {
		return this.insDate;
	}

	public void setInsDate(Date insDate) {
		this.insDate = insDate;
	}

	public String getThumbnailPic() {
		return this.thumbnailPic;
	}

	public void setThumbnailPic(String thumbnailPic) {
		this.thumbnailPic = thumbnailPic;
	}

	public Date getUpdDate() {
		return this.updDate;
	}

	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}

}