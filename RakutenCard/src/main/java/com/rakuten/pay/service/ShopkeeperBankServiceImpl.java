package com.rakuten.pay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rakuten.pay.Banks.ShopkeeperBankAccount;
import com.rakuten.pay.dao.ShopkeeperDAO;

@Service
public class ShopkeeperBankServiceImpl implements ShopkeeperBankService {

	@Autowired
	ShopkeeperDAO shopkeeperdao;
	
	@Override
	public void createUser(ShopkeeperBankAccount shopkeeper) {
		shopkeeperdao.save_customer(shopkeeper);
		
	}

	@Override
	public void deleteUser(int id) {
		shopkeeperdao.delete_shopkeeper(id);
		
	}

	@Override
	public void addAmount(int shop_id, double amount) {
		shopkeeperdao.addAmount(shop_id, amount);
		
	}

	@Override
	public double checkBalance(int id) {
		return shopkeeperdao.checkBalance(id);
	}

	@Override
	public List<ShopkeeperBankAccount> findAll() {
		return shopkeeperdao.find_all_shops();
	}


	

}
