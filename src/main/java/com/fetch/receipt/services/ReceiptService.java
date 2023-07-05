package com.fetch.receipt.services;

import org.springframework.stereotype.Service;

import com.fetch.receipt.entities.Receipt;
import com.fetch.receipt.models.PointsDTO;
import com.fetch.receipt.models.ReceiptDTO;

@Service
public interface ReceiptService {

	ReceiptDTO saveReceipt(Receipt receipts);

	PointsDTO getPoints(String id);

}
