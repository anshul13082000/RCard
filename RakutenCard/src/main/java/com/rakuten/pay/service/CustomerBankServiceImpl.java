package com.rakuten.pay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rakuten.pay.Banks.CustomerBankAccount;
import com.rakuten.pay.dao.CustomerDAO;

@Service
public class CustomerBankServiceImpl implements CustomerBankService {
	
	@Autowired
	CustomerDAO customerdao;

	@Override
	public void createUser(CustomerBankAccount customer) {
		customerdao.save_customer(customer);
	}

	@Override
	public void deleteUser(int id) {
		customerdao.delete_customer(id);
		
	}

	@Override
	public void addAmount(int cust_id, double amount) {
		customerdao.addAmount(cust_id, amount);
		
	}

	@Override
	public double checkBalance(int id) {
		return customerdao.checkBalance(id);
	}

	@Override
	public List<CustomerBankAccount> findAll() {
			return customerdao.find_all_customers();
	}

	

}
