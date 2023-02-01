package com.city.diary.model;

import java.util.Date;

public class NoteModel {
	
	public int getNoteid() {
		return noteid;
	}
	public void setNoteid(int noteid) {
		this.noteid = noteid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public int getTypeid() {
		return typeid;
	}
	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}
	public Date getPubtime() {
		return pubtime;
	}
	public void setPubtime(Date pubtime) {
		this.pubtime = pubtime;
	}
	private int noteid;//日记编号
	private String title;//日记标题
	private String Content;//日记内容
	private int typeid;//类型编号
	private Date pubtime;//发布日期
	private int noteowner;
	private int total;
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getNoteowner() {
		return noteowner;
	}
	public void setNoteowner(int noteowner) {
		this.noteowner = noteowner;
	}
}
