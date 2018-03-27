package com.pms.mailbag.utils;

import com.pms.mailbag.messageAndCode.BaseMessageCode;
import com.pms.mailbag.messageAndCode.BusinessMessageCode;
import com.pms.mailbag.messageAndCode.ParamterMessageCode;
import com.pms.mailbag.messageAndCode.SystemMessageCode;
import com.pms.mailbag.response.BaseResponse;

public class CopyOfResponseUtils {

	public static BaseResponse getResponse(Object data, Enum<?> message) {
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setData(data);

		boolean success = false;// 不能找到对应的code
		BaseMessageCode[] baseMessageCodes = BaseMessageCode.values();
		for (BaseMessageCode baseMessageCode : baseMessageCodes) {
			if (message.name().equals(baseMessageCode.name())) {
				baseResponse.setCode(baseMessageCode.getCode());
				baseResponse.setMessage(baseMessageCode.getMessge());
				success = true;
			}

		}

		BusinessMessageCode[] businessMessageCodes = BusinessMessageCode
				.values();
		for (BusinessMessageCode businessMessageCode : businessMessageCodes) {
			if (message.name().equals(businessMessageCode.name())) {
				baseResponse.setCode(businessMessageCode.getCode());
				baseResponse.setMessage(businessMessageCode.getMessge());
				success = true;
			}

		}

		SystemMessageCode[] systemMessageCodes = SystemMessageCode.values();
		for (SystemMessageCode systemMessageCode : systemMessageCodes) {
			if (message.name().equals(systemMessageCode.name())) {
				baseResponse.setCode(systemMessageCode.getCode());
				baseResponse.setMessage(systemMessageCode.getMessge());
				success = true;
			}

		}

		ParamterMessageCode[] paramterMessageCodes = ParamterMessageCode
				.values();
		for (ParamterMessageCode paramterMessageCode : paramterMessageCodes) {
			if (message.name().equals(paramterMessageCode.name())) {
				baseResponse.setCode(paramterMessageCode.getCode());
				baseResponse.setMessage(paramterMessageCode.getMessge());
				success = true;
			}

		}
		
		if(!success){
			throw new RuntimeException("该异常的message和code未定义");
		}
		
		return baseResponse;
		
	}
	
	
	public static BaseResponse getResponse(Object data){
		return getResponse(data,BaseMessageCode.SUCCEESS);
	} 
	

}
