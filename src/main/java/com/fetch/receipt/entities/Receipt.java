package com.fetch.receipt.entities;

import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Receipt {

	String retailer;
	String purchaseDate;
	String purchaseTime;
	String total;
	List<Item> items;
	String id;

	public Receipt(String retailer, String purchaseDate, String purchaseTime, String total, List<Item> items) {
		super();
		this.retailer = retailer;
		this.purchaseDate = purchaseDate;
		this.purchaseTime = purchaseTime;
		this.total = total;
		this.items = items;
	}

}