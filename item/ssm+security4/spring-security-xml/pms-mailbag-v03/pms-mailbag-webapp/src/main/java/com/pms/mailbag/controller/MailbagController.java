package com.pms.mailbag.controller;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pms.mailbag.service.MailbagService;

@Controller
@RequestMapping("/mailbag")
public class MailbagController {

	@Autowired
	private MailbagService mailbagService;
	
	@RequestMapping("/getAllMailbags")
	@ResponseBody
	public String getAllMailbags(){
		
		String result = mailbagService.getAllMailbags();
		return result;
	}
	
	
	@RequestMapping(value="/scanMailbagDetails",method=RequestMethod.POST,produces="application/json; charset=utf-8")
	@ResponseBody
	public String scanMailbagDetails(@RequestBody Map<Object, Object> mailbagCodeMap){
		String mailbagCode = ((String) mailbagCodeMap.get("mailbagCode")).trim();
		String result = mailbagService.scanMailbagDetails(mailbagCode);
		return result;
	}
	
	
	
	@RequestMapping(value="/getUnreceivedMailbags",produces="application/json; charset=utf-8")
	@ResponseBody
	public String getUnreceivedMailbags(@RequestBody Map<String, Object> paramMap){
		String agentCompanyId = (String) paramMap.get("agentCompanyId");
		String result = mailbagService.getUnreceivedMailbags(agentCompanyId);
		
		return result;
	}
	
	
	@RequestMapping(value="/confirmMailbag",method=RequestMethod.POST,produces="application/json; charset=utf-8")
	@ResponseBody
	public String confirmMailbag(@RequestBody Map<String, String> paramMap){
		String mailbagCode = ((String) paramMap.get("mailbagCode")).trim();
		String userId = ((String) paramMap.get("userId")).trim();
		String result = mailbagService.confirmMailbag(mailbagCode,userId);
		return result;
	}
	
	@RequestMapping(value="/getMailbagDetailsById",method=RequestMethod.POST,produces="application/json; charset=utf-8")
	@ResponseBody
	public String getMailbagDetailsById(@RequestBody Map<String, String> mailbagIdMap){
		String mailbagId = mailbagIdMap.get("mailbagId").trim();
		String result = mailbagService.getMailbagDetailsById(mailbagId);
		return result;
	}
	
	@RequestMapping(value="/getMailbagDetails",method=RequestMethod.POST,produces="application/json; charset=utf-8")
	@ResponseBody
	public String getMailbagDetails(@RequestBody Map<Object, Object> mailbagCodeMap){
		String mailbagCode = ((String) mailbagCodeMap.get("mailbagCode")).trim();
		String result = mailbagService.getMailbagDetailsByCode(mailbagCode);
		return result;
	}
	
	
	@RequestMapping(value="/getUndeliveredMailbags",produces="application/json; charset=utf-8")
	@ResponseBody
	public String getUndeliveredMailbags(@RequestBody Map<String, Object> paramMap){
		String agentCompanyId = (String) paramMap.get("agentCompanyId");
		String result = mailbagService.getUndeliveredMailbags(agentCompanyId);
		
		return result;
	}
	
	@RequestMapping(value="/getDeliveredMailbags",produces="application/json; charset=utf-8")
	@ResponseBody
	public String geDeliveredMailbags(@RequestBody Map<String, Object> paramMap){
		String agentCompanyId = (String) paramMap.get("agentCompanyId");
		String result = mailbagService.geDeliveredMailbags(agentCompanyId);
		
		return result;
	}
	
}
