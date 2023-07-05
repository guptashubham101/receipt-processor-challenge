package com.fetch.receipt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fetch.receipt.entities.Receipt;
import com.fetch.receipt.models.PointsDTO;
import com.fetch.receipt.models.ReceiptDTO;
import com.fetch.receipt.services.ReceiptService;

@RequestMapping("receipts")
@RestController
public class ReceiptController {

	@Autowired
	ReceiptService receiptService;

	// POST request to return ID
	@PostMapping(value = "/process")
	public ReceiptDTO saveReceipts(@RequestBody Receipt receipts) {

		return receiptService.saveReceipt(receipts);
	}

	// GET request to return points of a particular ID
	@GetMapping(value = "/{id}/points")
	public PointsDTO getPoints(@PathVariable("id") String id) {

		return receiptService.getPoints(id);
	}
}
