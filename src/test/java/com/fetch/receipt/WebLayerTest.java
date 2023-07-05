package com.fetch.receipt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fetch.receipt.entities.Item;
import com.fetch.receipt.entities.Receipt;
import com.fetch.receipt.models.PointsDTO;
import com.fetch.receipt.models.ReceiptDTO;
import com.fetch.receipt.repository.ReceiptRepository;
import com.fetch.receipt.services.ReceiptService;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WebLayerTest {

	@Autowired
	private ReceiptRepository receiptRepository;

	@Autowired
	private ReceiptService receiptService;

	Receipt receipt;
	private String id;

	@BeforeAll
	public void setup() {
		List<Item> items = new ArrayList<>();
		items.add(new Item("Mountain Dew 12PK", "6.49"));
		items.add(new Item("Emils Cheese Pizza", "12.25"));
		items.add(new Item("Knorr Creamy Chicken", "1.26"));
		items.add(new Item("Doritos Nacho Cheese", "3.35"));
		items.add(new Item("   Klarbrunn 12-PK 12 FL OZ  ", "12.00"));
		receipt = new Receipt("Target", "2022-01-01", "13:01", "35.35", items);
	}

	@DisplayName("JUnit test for save receipt method")
	@Test
	public void givenReceiptObject_whenSaveReceipt_thenReturnID() {

		// action taken to save receipt object
		Receipt savedReceipt = receiptRepository.createReceipt(receipt);

		// then - verify the output
		this.id = savedReceipt.getId();
		assertNotNull(savedReceipt.getId());
		System.out.println("ReceiptId:" + savedReceipt.getId());
	}

	@DisplayName("JUnit test to check save receipt API (POST)")
	@Test
	public void givenReceiptObject_whenSaveReceipt_thenCheckJSON() {

		// action taken to save receipt object
		ReceiptDTO savedReceipt = receiptService.saveReceipt(receipt);

		// then - verify the output
		assertNotNull(savedReceipt.getId());
		this.id = savedReceipt.getId();
	}

	@DisplayName("JUnit test to check points")
	@Test
	public void givenReceiptID_checkPoints() {

		// action taken to give receipt ID
		PointsDTO points = receiptService.getPoints(this.id);

		// then - verify the output (28 is the output of the saved receipt - Given in
		// examples)
		assertEquals(points.getPoints(), 28);
	}

}
