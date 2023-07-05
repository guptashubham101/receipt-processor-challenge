package com.fetch.receipt;

import com.fetch.receipt.controllers.ReceiptController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class WebApplicationTests {

    @Autowired
    ReceiptController receiptsController;

    @Test
    public void contextLoads() throws Exception {
        assertNotNull(receiptsController);
    }

}
