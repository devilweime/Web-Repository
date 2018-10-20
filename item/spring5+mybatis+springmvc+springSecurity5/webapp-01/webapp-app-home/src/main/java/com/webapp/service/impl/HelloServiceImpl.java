package com.webapp.service.impl;

import com.webapp.dao.mapper.HelloMapper;
import com.webapp.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    private HelloMapper helloMapper;

    @Override
    public String getDatabaseVersion() {
        return helloMapper.getDatabaseVersion();
    }
}
