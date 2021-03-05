package com.rakuten.pay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rakuten.pay.Banks.ShopkeeperBankAccount;
import com.rakuten.pay.service.ShopkeeperBankService;

@RestController
@EnableCaching
public class ShopkeeperController {

	@Autowired
	ShopkeeperBankService shopkeeper;
	
	@PostMapping("/shopkeepers")
	public void addNewCustomer(@RequestBody ShopkeeperBankAccount c) {
		shopkeeper.createUser(c);
	}
	
	@GetMapping("/shopkeepers")
	public List<ShopkeeperBankAccount> findAllCustomers() {
		return shopkeeper.findAll();
	}
	
}
