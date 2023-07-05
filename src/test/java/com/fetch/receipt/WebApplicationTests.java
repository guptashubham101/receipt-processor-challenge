package com.fetch.receipt;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.fetch.receipt.controllers.ReceiptController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class WebApplicationTests {
	
	@Autowired
	ReceiptController receiptsController;

	@Test
	public void contextLoads() throws Exception {
		assertNotNull(receiptsController);
	}

}
