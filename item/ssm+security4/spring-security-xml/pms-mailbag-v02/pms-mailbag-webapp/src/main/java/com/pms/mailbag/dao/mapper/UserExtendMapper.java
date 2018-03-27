package com.pms.mailbag.dao.mapper;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.pms.mailbag.dao.model.CUserLoginRecord;
import com.pms.mailbag.dao.model.User;

@Repository
public interface UserExtendMapper {

	User getUserInfoByUsername(Map<String, Object> paramMap);

	User getUserInfoByUserId(Map<String, Object> paramMap);

	Integer updatePasswordByUsername(Map<String, Object> paramMap);
	
	Integer updatePasswordByUserId(Map<String, Object> paramMap);

	Integer insertCUserLoginRecordSelective(CUserLoginRecord userLoginRecord);

	User getUserInfoByUserIdAndPasswod(Map<String, Object> param);
	
}
