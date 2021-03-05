package com.rakuten.pay.dao;

import java.util.List;

import com.rakuten.pay.Banks.RakutenCardBank;

public interface RCardDAO {
	
	void save(RakutenCardBank rcard);
	List<RakutenCardBank> getData();

}
