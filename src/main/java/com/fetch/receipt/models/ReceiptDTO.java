package com.fetch.receipt.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ReceiptDTO {
	String id;

	public ReceiptDTO(String id) {
		super();
		this.id = id;
	}

}
