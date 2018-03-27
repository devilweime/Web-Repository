package com.pms.mailbag.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.pms.mailbag.dao.mapper.MailbagExtendMapper;
import com.pms.mailbag.exception.BusinessException;
import com.pms.mailbag.exception.ParamterException;
import com.pms.mailbag.messageAndCode.extraction.BusinessEnCode;
import com.pms.mailbag.messageAndCode.extraction.ParamterEnCode;
import com.pms.mailbag.response.BaseResponse;
import com.pms.mailbag.service.MailbagService;
import com.pms.mailbag.utils.ResponseUtils;

@Service
public class MailbagServiceImpl implements MailbagService {

	@Autowired
	private MailbagExtendMapper mailbagExtendMapper;

	@Override
	public String getAllMailbags() {

		Map<String, Object> paramMap = new HashMap<String, Object>();

		List<Map<String, String>> allMailbags = mailbagExtendMapper.getAllMailbags(paramMap);

		return null;
	}

	@Override
	public String getUnreceivedMailbags(String agentCompanyId) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("agentCompanyId", agentCompanyId);
		List<Map<String, String>> unreceivedMailbags = mailbagExtendMapper.getUnreceivedMailbags(paramMap);
		BaseResponse response = ResponseUtils.getResponse(unreceivedMailbags);
		Gson gson = new Gson();
		String result = gson.toJson(response);
		return result;
	}

	@Override
	public String scanMailbagDetails(String mailbagCode) {
		BaseResponse response = null;

		Map<String, Object> mailbagDetails = null;

		try {
			if (mailbagCode == null || "".equals(mailbagCode)) {
				throw new ParamterException(ParamterEnCode.MAILBAG_CODE_NOT_FOUND);
			}

			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("mailbagCode", mailbagCode);
			mailbagDetails = mailbagExtendMapper.scanMailbagDetails(paramMap);

			if (mailbagDetails == null || mailbagDetails.isEmpty()) {
				throw new BusinessException(BusinessEnCode.MAILBAG_IS_NOT_FOUND);
			}

			String mailbagStatus = (String) mailbagDetails.get("mailbagStatus");

			Integer packageCount = Integer.valueOf((String) mailbagDetails.get("packageCount"));

			if ("0".equals(mailbagStatus)) {
				throw new RuntimeException(BusinessEnCode.MAILBAG_IS_UNAVAILABLE);
			} else if ("1".equals(mailbagStatus)) {
				throw new RuntimeException(BusinessEnCode.MAILBAG_IS_BAGGING);
			} else if ("3".equals(mailbagStatus)) {
				throw new RuntimeException(BusinessEnCode.MAILBAG_IS_RECEIVED);
			} else if ("4".equals(mailbagStatus)) {
				throw new RuntimeException(BusinessEnCode.MAILBAG_IS_DELIVERED);
			} else if ("5".equals(mailbagStatus)) {
				throw new RuntimeException(BusinessEnCode.MAILBAG_IS_INVALIDATED);
			}

			if (packageCount == 0) {
				throw new RuntimeException(BusinessEnCode.MAILBAG_IS_NULL);
			}

			response = ResponseUtils.getResponse(mailbagDetails);

		} catch (Exception e) {
			e.printStackTrace();
			response = ResponseUtils.getResponse(mailbagDetails, e);
		}

		Gson gson = new Gson();
		String result = gson.toJson(response);
		return result;
	}

	@Override
	public String confirmMailbag(String mailbagCode, String userId) {

		BaseResponse response = null;
		try {
			if (mailbagCode == null || "".equals(mailbagCode)) {
				throw new ParamterException(ParamterEnCode.MAILBAG_CODE_NOT_FOUND);
			}

			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("mailbagCode", mailbagCode);
			paramMap.put("userId", userId);
			
			Integer mailbagCount = mailbagExtendMapper.mailbagIsExsit(paramMap);
			if (mailbagCount == 0) {
				throw new BusinessException(BusinessEnCode.MAILBAG_IS_NOT_FOUND_IN_COMPANY);
			}
			
		 	Map<String, Object> mailbagDetails = mailbagExtendMapper.scanMailbagDetails(paramMap);

			if (mailbagDetails == null || mailbagDetails.isEmpty()) {
				throw new BusinessException(BusinessEnCode.MAILBAG_IS_NOT_FOUND);
			}

			String mailbagStatus = (String) mailbagDetails.get("mailbagStatus");
			
			if ("0".equals(mailbagStatus)) {
				throw new RuntimeException(BusinessEnCode.MAILBAG_IS_UNAVAILABLE);
			} else if ("1".equals(mailbagStatus)) {
				throw new RuntimeException(BusinessEnCode.MAILBAG_IS_BAGGING);
			} else if ("3".equals(mailbagStatus)) {
				throw new RuntimeException(BusinessEnCode.MAILBAG_IS_RECEIVED);
			} else if ("4".equals(mailbagStatus)) {
				throw new RuntimeException(BusinessEnCode.MAILBAG_IS_DELIVERED);
			} else if ("5".equals(mailbagStatus)) {
				throw new RuntimeException(BusinessEnCode.MAILBAG_IS_INVALIDATED);
			}
			
			Integer packageCount = Integer.valueOf((String) mailbagDetails.get("packageCount"));
			if (packageCount == 0) {
				throw new RuntimeException(BusinessEnCode.MAILBAG_IS_NULL);
			}
			
			mailbagExtendMapper.confirmMailbag(paramMap);

			response = ResponseUtils.getResponse(BaseResponse.OPERATION_SUCCEESS);

		} catch (Exception e) {
			e.printStackTrace();
			response = ResponseUtils.getResponse(e);
		}

		Gson gson = new Gson();
		String result = gson.toJson(response);
		return result;
	}

	@Override
	public String getMailbagDetailsById(String mailbagId) {
		BaseResponse response = null;
		try {
			if (mailbagId == null || "".equals(mailbagId)) {
				throw new ParamterException(ParamterEnCode.MAILBAG_ID_NOT_FOUND);
			}

			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("mailbagId", mailbagId);

			Map<String, Object> mailbagDetails = mailbagExtendMapper.getMailbagDetailsById(paramMap);
			if (mailbagDetails == null || mailbagDetails.isEmpty()) {
				throw new BusinessException(BusinessEnCode.MAILBAG_IS_NOT_FOUND);
			}
			response = ResponseUtils.getResponse(mailbagDetails);

		} catch (Exception e) {
			e.printStackTrace();
			response = ResponseUtils.getResponse(e);
		}
		Gson gson = new Gson();
		return gson.toJson(response);
	}

	@Override
	public String getMailbagDetailsByCode(String mailbagCode) {
		BaseResponse response = null;
		try {
			if (mailbagCode == null || "".equals(mailbagCode)) {
				throw new ParamterException(ParamterEnCode.MAILBAG_CODE_NOT_FOUND);
			}

			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("mailbagCode", mailbagCode);
			Map<String, Object> mailbagDetails = mailbagExtendMapper.getMailbagDetailsByCode(paramMap);
			if (mailbagDetails == null || mailbagDetails.isEmpty()) {
				throw new BusinessException(BusinessEnCode.MAILBAG_IS_NOT_FOUND);
			}
			response = ResponseUtils.getResponse(mailbagDetails);

		} catch (Exception e) {
			e.printStackTrace();
			response = ResponseUtils.getResponse(e);
		}
		Gson gson = new Gson();
		return gson.toJson(response);
	}

	@Override
	public String getUndeliveredMailbags(String agentCompanyId) {
		BaseResponse response = null;
		try {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("agentCompanyId", agentCompanyId);
			List<String> dates = mailbagExtendMapper.getUndeliveredMailbagsDates(paramMap);

			List<Map<String, Object>> undeliveredMailbags = mailbagExtendMapper.getUndeliveredMailbags(paramMap);
			
			List<Object> resultList = new ArrayList<Object>();
			for (String date : dates) {
				Map<String, Object> resultMap = new HashMap<String, Object>();
				resultMap.put("datetime", date);
				List<Object> mailbagList = new ArrayList<Object>();
				
				for (int i = 0; i < undeliveredMailbags.size(); i++) {
					Iterator<Map<String, Object>> iterator = undeliveredMailbags.iterator();
					while (iterator.hasNext()) {//has遍历一遍后会停止
						Map<String, Object> map = iterator.next();
						if (date.equals((String) map.get("datetime"))) {
							mailbagList.add(map);
							iterator.remove();
						}
					}
				}
				/*
				 * for (Map<String, Object> map : undeliveredMailbags) {
				 * if(date.equals((String)map.get("datetime"))){
				 * mailbagList.add(map); //iterator.remove(); } }
				 */
				resultMap.put("details", mailbagList);
				resultMap.put("total", mailbagList.size());
				resultList.add(resultMap);
			}
			response = ResponseUtils.getResponse(resultList);

		} catch (Exception e) {
			e.printStackTrace();
			response = ResponseUtils.getResponse(e);
		}
		Gson gson = new Gson();
		return gson.toJson(response);
	}

	@Override
	public String geDeliveredMailbags(String agentCompanyId) {
		BaseResponse response = null;
		try {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("agentCompanyId", agentCompanyId);
			List<Map<String, Object>> deliveredMailbags = mailbagExtendMapper.geDeliveredMailbags(paramMap);
			response = ResponseUtils.getResponse(deliveredMailbags);
		} catch (Exception e) {
			e.printStackTrace();
			response = ResponseUtils.getResponse(e);
		}
		Gson gson = new Gson();
		return gson.toJson(response);
	}

	@Override
	public Integer getUndeliveredMailbagsCount(String agentCompanyId) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("agentCompanyId", agentCompanyId);
		Integer undeliveredMailbagsCount = mailbagExtendMapper.getUndeliveredMailbagsCount(paramMap);
		return undeliveredMailbagsCount;
	}

}
