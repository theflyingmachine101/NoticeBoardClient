package org.noticeBoard.entities;

import java.sql.Date;
import java.sql.Time;



import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Notice {
	private int noticeId;
	private int teacherId;
	private String title;
	private String content;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date creationDate;
	private Time creationTime;

	
	public Notice() {
		super();
	}
	
	public Notice(int noticeId, int teacherId, String title, String content, Date creationDate,Time creationTime) {
		super();
		this.noticeId = noticeId;
		this.teacherId = teacherId;
		this.title = title;
		this.content = content;
		this.creationDate = creationDate;
		this.creationTime=creationTime;
	}
	public Notice( int teacherId, String title, String content, Date creationDate,Time creationTime) {
		super();
		this.teacherId = teacherId;
		this.title = title;
		this.content = content;
		this.creationDate = creationDate;
		this.creationTime=creationTime;
	}
	public int getNoticeId() {
		return noticeId;
	}
	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
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
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Time getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Time creationTime) {
		this.creationTime = creationTime;
	}

	@Override
	public String toString() {
		return "Notice [noticeId=" + noticeId + ", teacherId=" + teacherId + ", title=" + title + ", content=" + content
				+ ", creationDate=" + creationDate + ", creationTime=" + creationTime + "]";
	}
	
	
}
