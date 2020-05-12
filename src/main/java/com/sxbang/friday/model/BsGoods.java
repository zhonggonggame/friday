package com.sxbang.friday.model;

import java.math.BigDecimal;


public class BsGoods extends BaseEntity<Integer> {

	private String name;
	private String publishDate;
	private String publisher;
	private BigDecimal oldPrice;
	private BigDecimal newPrice;
	private Integer suit;
	private String style;
	private Integer category;
	private String info;
	private String imgUrl;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public BigDecimal getOldPrice() {
		return oldPrice;
	}
	public void setOldPrice(BigDecimal oldPrice) {
		this.oldPrice = oldPrice;
	}
	public BigDecimal getNewPrice() {
		return newPrice;
	}
	public void setNewPrice(BigDecimal newPrice) {
		this.newPrice = newPrice;
	}
	public Integer getSuit() {
		return suit;
	}
	public void setSuit(Integer suit) {
		this.suit = suit;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public Integer getCategory() {
		return category;
	}
	public void setCategory(Integer category) {
		this.category = category;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

}
