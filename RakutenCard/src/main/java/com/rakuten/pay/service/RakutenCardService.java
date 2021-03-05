package com.rakuten.pay.service;

import java.util.List;

import com.rakuten.pay.Banks.RakutenCardBank;

public interface RakutenCardService {
	
	void addInformation(RakutenCardBank rcard);
	List<RakutenCardBank> getRcardData();

}
