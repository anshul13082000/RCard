package com.rakuten.pay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rakuten.pay.Banks.RakutenCardBank;
import com.rakuten.pay.dao.RCardDAO;

@Service
public class RakutenCardServiceImpl implements RakutenCardService {
	
	@Autowired
	RCardDAO rcard_dao;

	@Override
	public void addInformation(RakutenCardBank rcard) {
		
		rcard_dao.save(rcard);
		                           
	}

	@Override
	public List<RakutenCardBank> getRcardData() {
		return rcard_dao.getData();
	}

}
