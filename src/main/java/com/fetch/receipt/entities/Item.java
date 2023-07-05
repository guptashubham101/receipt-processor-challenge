package com.fetch.receipt.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Item {

	String shortDescription;
	String price;

	public Item(String shortDescription, String price) {
		super();
		this.shortDescription = shortDescription;
		this.price = price;
	}

}
