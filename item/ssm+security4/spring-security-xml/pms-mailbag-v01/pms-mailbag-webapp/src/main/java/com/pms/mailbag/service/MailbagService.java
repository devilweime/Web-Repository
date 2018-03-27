package com.pms.mailbag.service;

public interface MailbagService {

	String getAllMailbags();

	String getUnreceivedMailbags(String agentCompanyId);

	String scanMailbagDetails(String mailbagCode);

	String getMailbagDetailsById(String mailbagId);

	String getMailbagDetailsByCode(String mailbagCode);

	String getUndeliveredMailbags(String agentCompanyId);

	String geDeliveredMailbags(String agentCompanyId);

	String confirmMailbag(String mailbagCode, String userId);

	Integer getUndeliveredMailbagsCount(String agentCompanyId);

}
