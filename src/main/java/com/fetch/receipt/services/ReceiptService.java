package com.fetch.receipt.services;

import org.springframework.stereotype.Service;

import com.fetch.models.PointsDTO;
import com.fetch.models.ReceiptDTO;
import com.fetch.receipt.entities.Receipt;

@Service
public interface ReceiptService {

	ReceiptDTO saveReceipt(Receipt receipts);

	PointsDTO getPoints(String id);

}
