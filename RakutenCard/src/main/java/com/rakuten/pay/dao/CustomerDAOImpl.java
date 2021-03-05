package com.rakuten.pay.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.rakuten.pay.Banks.CustomerBankAccount;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	@Autowired
	private RedisTemplate template;

	private static final Object HASH_KEY = "Customer";
	
	@Override
	public void save_customer(CustomerBankAccount customer) {
		template.opsForHash().put(HASH_KEY, customer.getCust_account_id(), customer);
	}

	@Override
	public void delete_customer(int cust_id) {
		template.opsForHash().delete(HASH_KEY, cust_id);
	}

	@Override
	public CustomerBankAccount find_customer(int cust_id) {
		return (CustomerBankAccount)template.opsForHash().get(HASH_KEY, cust_id);
	}

	@Override
	public List<CustomerBankAccount> find_all_customers() {
		return template.opsForHash().values(HASH_KEY);
		}

	@Override
	public void addAmount(int cust_id, double amount) {
		CustomerBankAccount c = (CustomerBankAccount)template.opsForHash().get(HASH_KEY, cust_id);
		c.setAccount_balance(c.getAccount_balance()+amount);
		
	}

	@Override
	public double checkBalance(int cust_id) {
		CustomerBankAccount c = (CustomerBankAccount)template.opsForHash().get(HASH_KEY, cust_id);
		return c.getAccount_balance();
	}
	
	

}
