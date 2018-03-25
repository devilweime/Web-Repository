package com.b2c.login.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b2c.mapper.UserScoreMapper;
import com.b2c.model.UserScore;
import com.b2c.model.UserScoreExample;
import com.b2c.model.UserScoreExample.Criteria;

@Service
public class UserScoreServiceImpl implements IUserScoreService {
	
	@Autowired
	private UserScoreMapper userScoreMapper;

	@Override
	public void saveOrUpdateByUserId(Integer id) {
		
		UserScoreExample example = new UserScoreExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(id);
		List<UserScore> list = userScoreMapper.selectByExample(example);
		
		//增加
		if (list == null || list.isEmpty()) {
			UserScore score = new UserScore();
			score.setScore(10);
			score.setUserId(id);
			userScoreMapper.insert(score);
		}else{
			//修改
			UserScore score = list.get(0);
			Integer oldScore = score.getScore();
			oldScore +=10;
			score.setScore(oldScore);
			userScoreMapper.updateByExampleSelective(score, example);
		}
	}

}
