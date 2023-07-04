package com.fetch.receipt.repositoryImpl;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import com.fetch.receipt.entities.Receipt;
import com.fetch.receipt.repository.ReceiptRepository;

@Repository
public class ReceiptRepositoryImpl implements ReceiptRepository{

	//Using map to store the receipt in memory
	private Map<String, Receipt> map = new ConcurrentHashMap<>(); 
	
	@Override
	public Receipt createReceipt(Receipt receiptObj) {
		
		//Generate Random UUID
		UUID uuid = UUID.randomUUID();
		receiptObj.setId(uuid.toString());
		
		//Save in a map 
		map.put(uuid.toString(), receiptObj);
		return receiptObj;
	}
	
	@Override
	public Receipt getReceipt(String id) {
		
		return map.get(id);
	}
	
}
