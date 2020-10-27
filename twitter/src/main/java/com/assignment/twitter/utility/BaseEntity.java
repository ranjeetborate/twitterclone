package com.assignment.twitter.utility;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@MappedSuperclass
public class BaseEntity {
	
    @Basic
    @Column(name = "modifiedTime", insertable = true, updatable = true)
    private Date modifiedTime;
	
	@Basic
	@Column(name = "createdTime", insertable = true, updatable = false)
	private Date createdTime;
	
	@Basic
	@Column(name="creator", updatable = false)
	private String creator;
	
	@Basic
	@Column(name="creator_id", updatable = false)
	private Integer creatorId;
	
	@Basic
	@Column(name="last_modifier")
	private String lastModifier;
	
	@Basic
	@Column(name="last_modifier_id")
	private Integer lastModifierId;

	public Date getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Integer getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(Integer creatorId) {
		this.creatorId = creatorId;
	}

	public String getLastModifier() {
		return lastModifier;
	}

	public void setLastModifier(String lastModifier) {
		this.lastModifier = lastModifier;
	}

	public Integer getLastModifierId() {
		return lastModifierId;
	}

	public void setLastModifierId(Integer lastModifierId) {
		this.lastModifierId = lastModifierId;
	}

	@PrePersist
	void onCreate() {
		Date date = new Date();
		if(this.creator == null)
			this.setCreator("API User");
		if(this.creatorId == null)
			this.setCreatorId(0);
		if(this.createdTime == null)
			this.setCreatedTime(date);
		if(this.lastModifier == null)
			this.setLastModifier("API User");
		if(this.lastModifierId == null)
			this.setLastModifierId(0);
		if(this.modifiedTime == null)
			this.setModifiedTime(date);
	}

	@PreUpdate
	void onUpdate() {		
		this.setLastModifier("API User");
		this.setLastModifierId(0);
		this.setModifiedTime(new Date());
	}
}
