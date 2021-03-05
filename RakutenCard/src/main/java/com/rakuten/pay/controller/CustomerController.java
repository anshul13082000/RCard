package com.rakuten.pay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rakuten.pay.Banks.CustomerBankAccount;
import com.rakuten.pay.service.CustomerBankService;

@RestController
@RequestMapping("/customers")
@EnableCaching
public class CustomerController {
	
	@Autowired
	CustomerBankService customer;
	
	@PostMapping
	public void addNewCustomer(@RequestBody CustomerBankAccount c) {
		customer.createUser(c);
	}
	
	@GetMapping
	public List<CustomerBankAccount> findAllCustomers() {
		return customer.findAll();
	}
	
	

}
