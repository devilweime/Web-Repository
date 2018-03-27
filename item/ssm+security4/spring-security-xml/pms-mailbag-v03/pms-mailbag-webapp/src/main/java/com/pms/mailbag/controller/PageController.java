package com.pms.mailbag.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.pms.mailbag.dao.mapper.UserExtendMapper;
import com.pms.mailbag.dao.model.User;
import com.pms.mailbag.response.BaseResponse;
import com.pms.mailbag.service.MailbagService;
import com.pms.mailbag.utils.DateUtils;
import com.pms.mailbag.utils.Des3;
import com.pms.mailbag.utils.SimpleHttpUtils;

@Controller
@RequestMapping("/mailbag/page")
public class PageController {

	@Autowired
	private MailbagService mailbagService;

	@Autowired
	private UserExtendMapper userExtendMapper;

	@RequestMapping(value = "/home")
	public String home(Model model, HttpSession session) {
		try {
			User loginUser = (User) session.getAttribute("loginUser");
			String respReslt = mailbagService.getUnreceivedMailbags(loginUser.getAgentCompanyId());
			Gson gson = new Gson();
			BaseResponse response = gson.fromJson(respReslt, BaseResponse.class);
			if (!"0".equals(response.getCode())) {
				throw new RuntimeException(response.getMessage());
			}
			model.addAttribute("data", response.getData());
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return "unreceivedMailbags";
	}

	@RequestMapping(value = "/unreceivedMailbags")
	public String unreceivedMailbagsPage(Model model, HttpSession session) {
		try {
			User loginUser = (User) session.getAttribute("loginUser");
			String respReslt = mailbagService.getUnreceivedMailbags(loginUser.getAgentCompanyId());
			Gson gson = new Gson();
			BaseResponse baseResponse = gson.fromJson(respReslt, BaseResponse.class);
			if (!"0".equals(baseResponse.getCode())) {
				throw new RuntimeException(baseResponse.getMessage());
			}
			model.addAttribute("data", baseResponse.getData());
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return "unreceivedMailbags";
	}

	@RequestMapping(value = "/toReceiveMailbag")
	public String toReceiveMailbagPage(Model model) {

		return "toReceiveMailbag";
	}

	@RequestMapping(value = "/scanMailbag/{mailbagCode}")
	public String scanMailbagPage(Model model, @PathVariable String mailbagCode,HttpSession session) {
		User loginUser = (User) session.getAttribute("loginUser");
		BaseResponse responseRsult = null;
		try {
			String respRsult = mailbagService.scanMailbagDetails(mailbagCode);
			Gson gson = new Gson();
			responseRsult = gson.fromJson(respRsult, BaseResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("responseRsult", responseRsult);
		return "scanMailbag";
	}

	@RequestMapping(value = "/confirmMailbag")
	@ResponseBody
	public Map<String, Object> confirmMailbagPage(@RequestBody Map<String, String> reqParamMap,HttpSession session) {
		User loginUser = (User) session.getAttribute("loginUser");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			String mailbagCode = reqParamMap.get("mailbagCode").trim().toUpperCase();
			String userId = loginUser.getUserId();
			String respResult = mailbagService.confirmMailbag(mailbagCode, userId);
			Gson gson = new Gson();
			BaseResponse baseResponse = gson.fromJson(respResult, BaseResponse.class);
			if(!"0".equals(baseResponse.getCode())){
				throw new RuntimeException(baseResponse.getMessage());
			}
			resultMap.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("success", false);
			resultMap.put("message", e.getMessage());
		}
		return resultMap;
	}

	@RequestMapping(value = "/myMailbags")
	public String myMalibagsPage(Model model,HttpSession session) {
		User loginUser = (User) session.getAttribute("loginUser");
		Integer undeliveredMailbagsCount =  mailbagService.getUndeliveredMailbagsCount(loginUser.getAgentCompanyId());
		model.addAttribute("undeliveredMailbagsCount", undeliveredMailbagsCount);
		return "myMailbags";
	}

	@RequestMapping(value = "/undeliveredMalbags")
	public String undeliveredMalbagsPage(Model model, HttpSession session) {
		User loginUser = (User) session.getAttribute("loginUser");

		Map<String, Object> resultMap = new HashMap<>();
		int totalCount = 0;
		try {
			String respResult = mailbagService.getUndeliveredMailbags(loginUser.getAgentCompanyId());
			Gson gson = new Gson();
			BaseResponse responseResult = gson.fromJson(respResult, BaseResponse.class);
			if (!"0".equals(responseResult.getCode())) {
				throw new RuntimeException(responseResult.getMessage());
			}

			List<Map<String, Object>> dataList = (List<Map<String, Object>>) responseResult.getData();
			Date date = new Date();
			String todayStr = DateUtils.convertYMD(date);
			String yesterdayStr = DateUtils.convertYMD(date, -1);
			String beforeYesterdayStr = DateUtils.convertYMD(date, -2);

			// 初始化数据---开始
			Map<String, Object> dataDetails01 = new HashMap<>();
			dataDetails01.put("datetime", todayStr);
			dataDetails01.put("total", 0);
			dataDetails01.put("dataList", null);

			Map<String, Object> dataDetails02 = new HashMap<>();
			dataDetails02.put("datetime", yesterdayStr);
			dataDetails02.put("total", 0);
			dataDetails02.put("dataList", null);

			Map<String, Object> dataDetails03 = new HashMap<>();
			dataDetails03.put("datetime", beforeYesterdayStr);
			dataDetails03.put("total", 0);
			dataDetails03.put("dataList", null);

			Map<String, Object> dataDetails04 = new HashMap<>();
			dataDetails04.put("datetime", "更早");
			dataDetails04.put("total", 0);
			dataDetails04.put("dataList", null);
			// 初始化数据---结束

			List<Map<String, Object>> respData = new ArrayList<>();
			respData.add(dataDetails01);
			respData.add(dataDetails02);
			respData.add(dataDetails03);
			respData.add(dataDetails04);
			
			List<Object> earlyList = new ArrayList<>();
			for (Map<String, Object> map : dataList) {
				Map<String, Object> dataDetails = new HashMap<>();
				List<Object> dateListOfMap = (List<Object>) map.get("details");
				if (todayStr.equals(map.get("datetime"))) {
					dataDetails01.put("dataList", dateListOfMap);
					int size = dateListOfMap.size();
					dataDetails01.put("total", size);
					dataDetails01.put("todayData", dataDetails);
					totalCount += size;
				} else if (yesterdayStr.equals(map.get("datetime"))) {
					int size = dateListOfMap.size();
					dataDetails02.put("dataList", dateListOfMap);
					dataDetails02.put("total", size);
					totalCount += size;
				} else if (beforeYesterdayStr.equals(map.get("datetime"))) {
					int size = dateListOfMap.size();
					dataDetails03.put("dataList", dateListOfMap);
					dataDetails03.put("total", size);
					totalCount += size;
				} else {

					earlyList.addAll(dateListOfMap);
					dataDetails04.put("dataList", earlyList);
					int size = earlyList.size();
					dataDetails04.put("total", size);
					totalCount += size;
				}

			}

			resultMap.put("success", true);
			resultMap.put("data", respData);
			System.out.println(resultMap);
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("success", false);
			resultMap.put("data", null);
			resultMap.put("message", e.getMessage());
		}
		model.addAttribute("resultMap", resultMap);
		model.addAttribute("totalCount", totalCount);
		// 加载iframe
		// response.setHeader("X-Frame-Options", "SAMEORIGIN");
		return "undeliveredMalbags";
	}
	
	@RequestMapping(value = "/mailbagDetails/{mailbagId}")
	public String mailbagDetailsPage(@PathVariable String mailbagId, Model model) {
		BaseResponse responseResult = null;
		try {
			String respResult = mailbagService.getMailbagDetailsById(mailbagId);
			Gson gson = new Gson();
			responseResult = gson.fromJson(respResult, BaseResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		model.addAttribute("responseResult", responseResult);
		return "mailbagDetails";
	}

	@RequestMapping(value = "/myinfo")
	public String myinfoPage() {

		return "myInfo";
	}

	@RequestMapping(value = "/deliveredMalbags")
	public String deliveredMailbagsPage(Model model, HttpSession session) {
		User loginUser = (User) session.getAttribute("loginUser");
		BaseResponse responseResult = null;
		try {
			String respResult = mailbagService.geDeliveredMailbags(loginUser.getAgentCompanyId());
			Gson gson = new Gson();
			responseResult = gson.fromJson(respResult, BaseResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		model.addAttribute("responseResult", responseResult);
		return "deliveredMalbags";
	}

	@RequestMapping(value = "/toModifyPassword")
	public String toModifyPasswordPage(Model model, HttpSession session) {
		
		return "modifyPassword";
	}

	@RequestMapping(value = "/modifyPassword")
	@ResponseBody
	public Map<String, Object> modifyPassword(@RequestBody Map<String, String> paramMap, HttpSession session) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			User loginUser = (User) session.getAttribute("loginUser");
			String oldPassword = ((String) paramMap.get("oldPassword")).trim();
			String newPassword = ((String) paramMap.get("newPassword")).trim();
			String confirmPassword = ((String) paramMap.get("confirmPassword")).trim();
			if (!newPassword.equals(confirmPassword)) {
				throw new RuntimeException("两次密码不相同");
			}
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("userId",loginUser.getUserId());
			param.put("password", Des3.encrypt(oldPassword));
			User userInfo = userExtendMapper.getUserInfoByUserIdAndPasswod(param);
			if(userInfo == null){
				throw new RuntimeException("原密码错误");
			}
			
			param.put("userId",loginUser.getUserId());
			param.put("newPassword", Des3.encrypt(newPassword));
			userExtendMapper.updatePasswordByUserId(param);
			resultMap.put("success", true);
		} catch (Exception e) {
			resultMap.put("success", false);
			resultMap.put("message", e.getMessage());
		}

		return resultMap;
	}
}
