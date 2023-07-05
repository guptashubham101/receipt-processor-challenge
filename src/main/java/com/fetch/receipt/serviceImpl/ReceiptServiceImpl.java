package com.fetch.receipt.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fetch.receipt.entities.Item;
import com.fetch.receipt.entities.Receipt;
import com.fetch.receipt.models.PointsDTO;
import com.fetch.receipt.models.ReceiptDTO;
import com.fetch.receipt.repository.ReceiptRepository;
import com.fetch.receipt.services.ReceiptService;

@Service
public class ReceiptServiceImpl implements ReceiptService {

	@Autowired
	ReceiptRepository receiptRepository;

	@Override
	public PointsDTO getPoints(String id) {
		// Retrieve receipt from map through ID
		Receipt receiptObj = receiptRepository.getReceipt(id);

		// If ID is present in map then calculates the points
		if (receiptObj != null)
			return new PointsDTO(calculatePoints(receiptObj));
		else
			return new PointsDTO(0);
	}

	@Override
	public ReceiptDTO saveReceipt(Receipt receiptObj) {

		// Save the receipt in in-memory
		receiptObj = receiptRepository.createReceipt(receiptObj);

		// Return the generated ID
		return new ReceiptDTO(receiptObj.getId());
	}

	// Function to calculate points according to rules
	public Integer calculatePoints(Receipt receiptObj) {
		Integer totalPoints = 0;

		// Retailer
		for (Character retailer : receiptObj.getRetailer().toCharArray()) {
			if (Character.isLetterOrDigit(retailer)) {
				totalPoints++;
			}
		}

		// Total
		String cents = receiptObj.getTotal().split("\\.")[1];
		if (Float.parseFloat(cents) == 0) {
			totalPoints += 50;
		}

		if (Float.parseFloat(receiptObj.getTotal()) % 0.25 == 0) {
			totalPoints += 25;
		}

		// Items
		int size = receiptObj.getItems().size();
		int pairs = size / 2;
		totalPoints += pairs * 5;

		List<Item> items = receiptObj.getItems();
		for (Item item : items) {
			String shortDescription = item.getShortDescription().trim();
			if (shortDescription.length() % 3 == 0) {
				Float price = Float.parseFloat(item.getPrice());
				totalPoints += (int) Math.ceil(price * 0.2);
			}
		}

		// Purchase Date
		int date = Integer.parseInt(receiptObj.getPurchaseDate().split("-")[2]);
		if (date % 2 != 0) {
			totalPoints += 6;
		}

		// Purchase Time
		int hour = Integer.parseInt(receiptObj.getPurchaseTime().split(":")[0]);
		if (hour >= 14 && hour <= 16) {
			totalPoints += 10;
		}

		return totalPoints;
	}
}
