package com.fetch.receipt.entities;

public class Item {

	String shortDescription;
	String price;

	public Item(String shortDescription, String price) {
		super();
		this.shortDescription = shortDescription;
		this.price = price;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

}
