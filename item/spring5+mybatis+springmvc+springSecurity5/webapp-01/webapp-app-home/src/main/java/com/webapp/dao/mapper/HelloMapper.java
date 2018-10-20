package com.webapp.dao.mapper;


import org.springframework.stereotype.Repository;

@Repository
public interface HelloMapper {

    String getDatabaseVersion();
}
