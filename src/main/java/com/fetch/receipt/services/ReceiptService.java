package com.fetch.receipt.services;

import com.fetch.receipt.entities.Receipt;
import com.fetch.receipt.models.PointsDTO;
import com.fetch.receipt.models.ReceiptDTO;

public interface ReceiptService {

	ReceiptDTO saveReceipt(Receipt receipts);

	PointsDTO getPoints(String id);

}
