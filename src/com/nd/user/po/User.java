package com.nd.user.po;

public class User {
	private int id;
	private String userName;
	private String passWord;
	private String realName;
	private String sex;
	private String birthday;
	private String telephone;
	private String address;
	private String type;//0为管理员，1为教师，2为学生
	private String ifValid;//判断账户是否可用，1为可用，2不可用
	private String photo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getIfValid() {
		return ifValid;
	}
	public void setIfValid(String ifValid) {
		this.ifValid = ifValid;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", passWord=" + passWord + ", realName=" + realName
				+ ", sex=" + sex + ", birthday=" + birthday + ", telephone=" + telephone + ", address=" + address
				+ ", type=" + type + ", ifValid=" + ifValid + ", photo=" + photo + "]";
	}
	

}
