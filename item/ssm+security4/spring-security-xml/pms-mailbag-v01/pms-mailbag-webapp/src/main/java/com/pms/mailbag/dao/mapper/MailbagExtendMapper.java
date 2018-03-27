package com.pms.mailbag.dao.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface MailbagExtendMapper {

	List<Map<String, String>> getAllMailbags(Map<String, Object> paramMap);

	List<Map<String, String>> getUnreceivedMailbags(Map<String, Object> paramMap);

	Map<String, Object> scanMailbagDetails(Map<String, Object> paramMap);

	Integer mailbagIsExsit(Map<String, Object> paramMap);

	Integer confirmMailbag(Map<String, Object> paramMap);

	Map<String, Object> getMailbagDetailsById(Map<String, Object> paramMap);

	Map<String, Object> getMailbagDetailsByCode(Map<String, Object> paramMap);

	List<Map<String, Object>> getUndeliveredMailbags(Map<String, Object> paramMap);

	List<Map<String, Object>> geDeliveredMailbags(Map<String, Object> paramMap);

	List<String> getUndeliveredMailbagsDates(Map<String, Object> paramMap);

	Integer getUndeliveredMailbagsCount(Map<String, Object> paramMap);

}
