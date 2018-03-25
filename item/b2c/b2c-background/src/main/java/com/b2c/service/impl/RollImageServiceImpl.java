package com.b2c.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b2c.mapper.RollImageMapper;
import com.b2c.model.RollImage;
import com.b2c.model.RollImageExample;
import com.b2c.model.RollImageExample.Criteria;
import com.b2c.service.IRollImageService;
@Service
public class RollImageServiceImpl implements IRollImageService {
	@Autowired
	private RollImageMapper rollImageMapper;
	
	@Override
	public List<RollImage> getImageList() {
		List<RollImage> list = rollImageMapper.getImageList((byte) 1);
		if(list!=null && !list.isEmpty()){
			return list;
		}
		return null;
	}
}
