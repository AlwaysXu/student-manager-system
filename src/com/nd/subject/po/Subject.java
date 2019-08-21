package com.nd.subject.po;

public class Subject {
	private int id;
	private String subjectName;
	private int createPersonId;
	private String ifValid;
	
	 public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public int getCreatePersonId() {
		return createPersonId;
	}
	public void setCreatePersonId(int createPersonId) {
		this.createPersonId = createPersonId;
	}
	public String getIfValid() {
		return ifValid;
	}
	public void setIfValid(String ifValid) {
		this.ifValid = ifValid;
	}
	

}
