package com.fetch.receipt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.fetch.receipt.entities.Item;
import com.fetch.receipt.entities.Receipt;
import com.fetch.receipt.models.PointsDTO;
import com.fetch.receipt.models.ReceiptDTO;
import com.fetch.receipt.repository.ReceiptRepository;
import com.fetch.receipt.serviceImpl.ReceiptServiceImpl;

//@ExtendWith(MockitoExtension.class)
//@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class WebLayerTest {

	@Mock
	ReceiptRepository receiptRepository;

	@InjectMocks
	private ReceiptServiceImpl receiptService;

	private Receipt receipt;

	private static String id;

	@BeforeEach
	public void setup() {
		receiptRepository = Mockito.mock(ReceiptRepository.class);
		receiptService = Mockito.mock(ReceiptServiceImpl.class);

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

		System.out.println(receiptRepository);
		System.out.println(receiptService);
		System.out.println(receipt.getPurchaseDate());

		// action taken to save receipt object
		Receipt savedReceipt = receiptRepository.createReceipt(receipt);

		System.out.println(savedReceipt);
		// then - verify the output
		this.id = savedReceipt.getId();
		assertNotNull(savedReceipt.getId());
	}

	@DisplayName("JUnit test to check save receipt API (POST)")
	@Test
	public void givenReceiptObject_whenSaveReceipt_thenCheckJSON() {

		// action taken to save receipt object
		ReceiptDTO savedReceipt = receiptService.saveReceipt(receipt);

		System.out.println(savedReceipt);
		// then - verify the output
		assertNotNull(savedReceipt.getId());
		this.id = savedReceipt.getId();
	}

	@DisplayName("JUnit test to check points")
	@Test
	public void givenReceiptID_checkPoints() {

		// action taken to give receipt ID
		PointsDTO points = receiptService.getPoints(this.id);

		System.out.println(points);
		// then - verify the output (28 is the output of the saved receipt - Given in
		// examples)
		assertEquals(points.getPoints(), 28);
	}

}
