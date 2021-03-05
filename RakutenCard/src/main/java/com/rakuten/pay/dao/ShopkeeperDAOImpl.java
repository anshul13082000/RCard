package com.rakuten.pay.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import com.rakuten.pay.Banks.ShopkeeperBankAccount;

@Repository
public class ShopkeeperDAOImpl implements ShopkeeperDAO {

	@Autowired
	private RedisTemplate template;

	private static final Object HASH_KEY = "Shopkeeper";
	
	@Override
	public void save_customer(ShopkeeperBankAccount shopkeeper) {
		template.opsForHash().put(HASH_KEY, shopkeeper.getShop_account_id(), shopkeeper);
		
	}

	@Override
	public void delete_shopkeeper(int shop_id) {
		template.opsForHash().delete(HASH_KEY, shop_id);
		
	}

	@Override
	public ShopkeeperBankAccount find_shopkeeper(int shop_id) {
		return (ShopkeeperBankAccount)template.opsForHash().get(HASH_KEY, shop_id);
	}

	@Override
	public List<ShopkeeperBankAccount> find_all_shops() {
		return template.opsForHash().values(HASH_KEY);
	}

	@Override
	public void addAmount(int shop_id, double amount) {
		ShopkeeperBankAccount c = (ShopkeeperBankAccount)template.opsForHash().get(HASH_KEY, shop_id);
		c.setAccount_balance(c.getAccount_balance()+amount);
		
	}

	@Override
	public double checkBalance(int shop_id) {
		ShopkeeperBankAccount c = (ShopkeeperBankAccount)template.opsForHash().get(HASH_KEY, shop_id);
		return c.getAccount_balance();
	}
	
	

}
