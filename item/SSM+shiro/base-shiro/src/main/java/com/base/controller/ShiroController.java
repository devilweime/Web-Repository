package com.base.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.base.model.User;

@Controller
public class ShiroController {
	
	@RequestMapping("passport")
	public ModelAndView passport(User user){
		  UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
	        Subject subject = SecurityUtils.getSubject();
	        try {
	        	//登录认证
	            subject.login(token);
	        } catch (IncorrectCredentialsException ice) {
	            // 捕获密码错误异常
	            ModelAndView mv = new ModelAndView("error");
	            mv.addObject("message", "password error!");
	            return mv;
	        } catch (UnknownAccountException uae) {
	            // 捕获未知用户名异常
	            ModelAndView mv = new ModelAndView("error");
	            mv.addObject("message", "username error!");
	            return mv;
	        } catch (ExcessiveAttemptsException eae) {
	            // 捕获错误登录过多的异常
	            ModelAndView mv = new ModelAndView("error");
	            mv.addObject("message", "times error");
	            return mv;
	        }
	        //User user = userService.findByUsername(username);
	        //session的设置
	        subject.getSession().setAttribute("user", user);
	        return new ModelAndView("success");
	}
	
	@RequiresRoles("user:v1")
	@RequestMapping("list")
	public ModelAndView list(){
		return new ModelAndView("list");
	}
	
	@RequiresPermissions("edit")
	@RequestMapping("edit")
	public ModelAndView edit(){
		return new ModelAndView("edit");
	}
	
	@RequiresPermissions("look")
	@RequestMapping("look")
	public ModelAndView look(){
		return new ModelAndView("look");
	}
	
}
