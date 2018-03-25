package com.b2c.score.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b2c.mapper.ScoreDetailMapper;
import com.b2c.mapper.ScoreRuleMapper;
import com.b2c.mapper.SysUserMapper;
import com.b2c.model.ScoreDetail;
import com.b2c.model.ScoreRule;
import com.b2c.model.ScoreRuleExample;
import com.b2c.model.ScoreRuleExample.Criteria;
import com.b2c.model.SysUser;

@Service
public class UserScoreServiceImpl implements IUserScoreService {

	@Autowired
	private SysUserMapper userMapper;
	@Autowired
	private ScoreRuleMapper scoreRuleMapper;
	@Autowired
	private ScoreDetailMapper scoreDetailMapper;

	@Override
	public void saveOrUpdateByUserId(Integer id) {
		// 查询lastLogintime
		SysUser user = userMapper.selectByPrimaryKey(id);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date nowDate = new Date();
		Date lastDate = user.getLastLogintime();
		if (lastDate!=null) {
			try {
				nowDate = sdf.parse(sdf.format(nowDate));
				lastDate = sdf.parse(sdf.format(lastDate));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		/*Calendar nowCalendar = Calendar.getInstance();
		nowCalendar.setTime(nowDate);
		Calendar lastCalendar = Calendar.getInstance();
		lastCalendar.setTime(user.getLastLogintime());*/
		
		// 判断登录日期
		if (lastDate==null || nowDate.before(lastDate)) {
			// 获得积分规则
			ScoreRuleExample example = new ScoreRuleExample();
			Criteria criteria = example.createCriteria();
			criteria.andRuleNameEqualTo("日常登录积分");
			List<ScoreRule> ruleList = scoreRuleMapper.selectByExample(example);
			if (ruleList!=null && !ruleList.isEmpty()) {
				ScoreRule rule = ruleList.get(0);
				//score详情
				ScoreDetail detail = new ScoreDetail();
				detail.setCreateTime(new Date());
				detail.setFlag((byte) 1);
				detail.setRuleName(rule.getRuleName());
				detail.setScore(rule.getScore());
				detail.setType(rule.getType());
				detail.setUserId(id);
				//插入score详情
				scoreDetailMapper.insert(detail);
				//用户score+10
				if (user.getScore()==null) {
					user.setScore(0);
				}
				user.setScore(user.getScore()+10);
				userMapper.updateByPrimaryKey(user);
			}

		}

	}

}
