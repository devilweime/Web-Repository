package com.pms.mailbag.dao.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.pms.mailbag.dao.model.Authority;

@Repository
public interface AuthExtendMapper {

	public List<Authority> getAuthorityByUserId(Map<String, Object> paramMap);

}
