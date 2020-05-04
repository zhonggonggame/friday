package com.sxbang.friday.model;



public class Allkinds extends BaseEntity<Integer> {

	private String name;
	private String modified;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getModified() {
		return modified;
	}
	public void setModified(String modified) {
		this.modified = modified;
	}

}
