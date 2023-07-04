package com.fetch.receipt.repository;

import com.fetch.receipt.entities.Receipt;

public interface ReceiptRepository {

	public Receipt createReceipt(Receipt receiptObj);
	
	public Receipt getReceipt(String id);
}
