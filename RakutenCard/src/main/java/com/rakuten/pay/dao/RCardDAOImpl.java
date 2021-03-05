package com.rakuten.pay.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.rakuten.pay.Banks.RakutenCardBank;

@Repository
public class RCardDAOImpl implements RCardDAO {

	
	@Autowired
	private RedisTemplate template;
	
	private static final Object HASH_KEY = "Rcard";
	
	@Override
	public void save(RakutenCardBank rcard) {
		template.opsForHash().put(HASH_KEY, rcard.getCard_id(), rcard);
	}

	@Override
	public List<RakutenCardBank> getData() {
		return template.opsForHash().values(HASH_KEY);
	}
	
	

}
