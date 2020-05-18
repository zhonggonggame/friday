package com.sxbang.friday.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Userinformation extends BaseEntity<Integer> {

	/*private String modified;*/
	private String username;
	private String phone;
	private String email;
	private String school;
	/*private String sno;
	private String dormitory;
	private String gender;
	private String createtime;
	private String avatar;
	private int status;*/
}
