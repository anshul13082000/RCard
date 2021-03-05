package com.rakuten.pay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rakuten.pay.Banks.RakutenCardBank;
import com.rakuten.pay.purchase.RCardProcess;
import com.rakuten.pay.service.RakutenCardServiceImpl;

@RestController
@EnableCaching
public class RCardController {
	
	@Autowired
	RCardProcess rcard_process;
	
	@Autowired
	RakutenCardServiceImpl rcard_service;
	
	@GetMapping("/card/transactions")
	public List<RakutenCardBank> getTransactionDetails() {
		return rcard_service.getRcardData();
	}
	
	@GetMapping("/send_money/{cust_id}/{shop_id}/{amount}")
	public void  send_money(@PathVariable("cust_id") int cust_id, @PathVariable("shop_id") int shop_id, @PathVariable("amount") double amount) {
		rcard_process.customer_sends_money_to_shopkeeper(cust_id, shop_id, amount);
	}
	

}
