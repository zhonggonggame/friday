package com.sxbang.friday.model;



public class ShopUsers extends BaseEntity<Integer> {

	private Integer userId;
	private String userName;
	private String portrait;
	private String phone;
	private String userPassword;
	private String shcool;

	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPortrait() {
		return portrait;
	}
	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getShcool() {
		return shcool;
	}
	public void setShcool(String shcool) {
		this.shcool = shcool;
	}

}
