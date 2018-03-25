package com.b2c.score.handler;

import org.springframework.beans.factory.annotation.Autowired;

import com.b2c.score.service.IUserScoreService;

public class ListenerHandler {

	@Autowired
	private IUserScoreService userScoreService;
	
	public void listen(Integer id){
		userScoreService.saveOrUpdateByUserId(id);
	}
}
