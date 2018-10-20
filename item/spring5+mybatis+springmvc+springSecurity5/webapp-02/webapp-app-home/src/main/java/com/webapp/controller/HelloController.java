package com.webapp.controller;

import com.webapp.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@Controller
public class HelloController {

    @Autowired
    private HelloService helloService;


    @RequestMapping(value = {"/","/index"})
    public void index(HttpServletRequest request , HttpServletResponse response, ModelAndView mav) throws IOException {

        mav.setViewName("/views/index.jsp");
    }
    //与上面效果相同，使用视图解析器解析视图文件名
   /* public String index(HttpServletRequest request , HttpServletResponse response, ModelAndView mav) throws IOException {
       return "index";
    }*/


    @RequestMapping("/getDatabaseVersion")
    public void getDatabaseVersion(HttpServletRequest request , HttpServletResponse response) throws IOException {

        String databaseVersion = helloService.getDatabaseVersion();
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(databaseVersion);
    }

}
