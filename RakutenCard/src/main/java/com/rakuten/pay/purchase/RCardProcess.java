package com.rakuten.pay.purchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rakuten.pay.Banks.CustomerBankAccount;
import com.rakuten.pay.Banks.RakutenCardBank;
import com.rakuten.pay.Banks.ShopkeeperBankAccount;
import com.rakuten.pay.dao.CustomerDAO;
import com.rakuten.pay.dao.ShopkeeperDAO;
import com.rakuten.pay.service.RakutenCardService;

@Service
public class RCardProcess {
	
	@Autowired
	RakutenCardService rcard;
	
	@Autowired
	CustomerDAO customer;
	
	@Autowired
	ShopkeeperDAO shopkeeper;
	
	public void customer_sends_money_to_shopkeeper(int cust_id,int shop_id, double amount) {
		
		CustomerBankAccount c = customer.find_customer(cust_id);
		
		ShopkeeperBankAccount s = shopkeeper.find_shopkeeper(shop_id);
		
		if(amount <= c.getAccount_balance()) {
			double temp = c.getAccount_balance()-amount;
			c.setAccount_balance(temp);
			customer.save_customer(c);
			s.setAccount_balance(amount+s.getAccount_balance());
			shopkeeper.save_customer(s);
			
			RakutenCardBank r = new RakutenCardBank(amount,"success",cust_id,shop_id);
			rcard.addInformation(r);
		}else {
			RakutenCardBank r = new RakutenCardBank(amount,"failed",cust_id,shop_id);
			rcard.addInformation(r);
		}
		
	}

}
