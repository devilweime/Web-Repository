package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html;charset=UTF-8\" />\r\n");
      out.write("<base href=\"");
      out.print(request.getContextPath());
      out.write("/\">\r\n");
      out.write("<title>用户登录</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/base.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/global.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/login-register.css\" />\r\n");
      out.write("<script type=\"text/javascript\" src=\"js\\jquery.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$(function() {\r\n");
      out.write("\t\t$(\"#reg_form\").submit(function() {\r\n");
      out.write("\t\t\t//检测密码\r\n");
      out.write("\t\t\tif ($.trim($(\"#password\").val()) != $.trim($(\"#confirm\").val())) {\r\n");
      out.write("\t\t\t\talert(\"两次密码不相同\");\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t//检测邮箱\r\n");
      out.write("\t\t\t//无双引号，开头结尾/.../包含\r\n");
      out.write("\t\t\t/* var reg = /^(\\w)+(\\.\\w+)*@(\\w)+((\\.\\w{2,3}){1,3})$/;\r\n");
      out.write("\t\t\tif(!reg.test($(\"#email\").val)){\r\n");
      out.write("\t\t\t\talert(\"邮箱格式不对！！\");\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t} */\r\n");
      out.write("\t\t})\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//获取手机验证码\r\n");
      out.write("\t\t$(\"#getPhoneCode\").click(function() {\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\ttype:'get',\r\n");
      out.write("\t\t\t\turl:'http://localhost:8090/b2c-massage/sendCode',\r\n");
      out.write("\t\t\t\tdata:'phone='+$(\"#phone\").val(),\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\t\t})\r\n");
      out.write("\t\t//较验手机验证码\r\n");
      out.write("\t\t$(\"#phoneCode\").focusout(function() {\r\n");
      out.write("\t\t\tvar code = $(this).val();\r\n");
      out.write("\t\t\tvar len = code.length;\r\n");
      out.write("\t\t\tif(len!=6){\r\n");
      out.write("\t\t\t\talert(\"验证码为6位数\");\r\n");
      out.write("\t\t\t}else{\r\n");
      out.write("\t\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t\ttype:'post',\r\n");
      out.write("\t\t\t\t\turl:'http://localhost:8085/b2c-register/register/checkCode',\r\n");
      out.write("\t\t\t\t\tdata:\"phoneCode=\"+code,\r\n");
      out.write("\t\t\t\t\tsuccess:function(data){\r\n");
      out.write("\t\t\t\t\t\t$(\"small\").html(data);\r\n");
      out.write("\t\t\t\t\t\tdebugger;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t})\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t})\r\n");
      out.write("\t\t\r\n");
      out.write("\t})\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"header wrap1000\">\r\n");
      out.write("\t\t<a href=\"\"><img src=\"images/logo.png\" alt=\"\" /></a>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"main\">\r\n");
      out.write("\t\t<div class=\"login-form fr\">\r\n");
      out.write("\t\t\t<div class=\"form-hd\">\r\n");
      out.write("\t\t\t\t<h3>用户注册</h3>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"form-bd\">\r\n");
      out.write("\t\t\t\t<form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/register/register\"\r\n");
      out.write("\t\t\t\t\tid=\"reg_form\" method=\"POST\">\r\n");
      out.write("\t\t\t\t\t<dl>\r\n");
      out.write("\t\t\t\t\t\t<dt>用户名</dt>\r\n");
      out.write("\t\t\t\t\t\t<dd>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" name=\"username\" class=\"text\" />\r\n");
      out.write("\t\t\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t\t</dl>\r\n");
      out.write("\t\t\t\t\t<dl>\r\n");
      out.write("\t\t\t\t\t\t<dt>密码</dt>\r\n");
      out.write("\t\t\t\t\t\t<dd>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"password\" name=\"password\" id=\"password\" class=\"text\" />\r\n");
      out.write("\t\t\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t\t</dl>\r\n");
      out.write("\t\t\t\t\t<dl>\r\n");
      out.write("\t\t\t\t\t\t<dt>确认密码</dt>\r\n");
      out.write("\t\t\t\t\t\t<dd>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"password\" name=\"confirm\" id=\"confirm\" class=\"text\" />\r\n");
      out.write("\t\t\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t\t</dl>\r\n");
      out.write("\t\t\t\t\t<dl>\r\n");
      out.write("\t\t\t\t\t\t<dt>邮箱</dt>\r\n");
      out.write("\t\t\t\t\t\t<dd>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" name=\"email\" id=\"email\" class=\"text\" />\r\n");
      out.write("\t\t\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t\t</dl>\r\n");
      out.write("\t\t\t\t\t<dl>\r\n");
      out.write("\t\t\t\t\t\t<dt>中国 0086</dt>\r\n");
      out.write("\t\t\t\t\t\t<dd>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" id=\"phone\" name=\"phone\" placeholder=\"建议使用常用手机\" class=\"text\"/>\r\n");
      out.write("\t\t\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t\t</dl>\r\n");
      out.write("\t\t\t\t\t<dl>\r\n");
      out.write("\t\t\t\t\t\t<dt>手机验证码</dt>\r\n");
      out.write("\t\t\t\t\t\t<dd><small></small></dd>\r\n");
      out.write("\t\t\t\t\t\t<dd>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" name=\"phoneCode\"\r\n");
      out.write("\t\t\t\t\t\t\t\tmaxlength=\"6\" id=\"phoneCode\" size=\"17\" style=\"height: 22px;\"\r\n");
      out.write("\t\t\t\t\t\t\t\tplaceholder=\"请输入手机验证码\" autocomplete=\"off\"/>\r\n");
      out.write("\t\t\t\t\t\t\t<button id=\"getPhoneCode\" type=\"button\">获取验证码</button>\r\n");
      out.write("\t\t\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t\t</dl>\r\n");
      out.write("\t\t\t\t\t<dl>\r\n");
      out.write("\t\t\t\t\t\t<dt>验证码</dt>\r\n");
      out.write("\t\t\t\t\t\t<dd>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" name=\"code\" class=\"text\" size=\"10\"\r\n");
      out.write("\t\t\t\t\t\t\t\tstyle=\"width: 58px;\"> <img src=\"images/code.png\" alt=\"\"\r\n");
      out.write("\t\t\t\t\t\t\t\talign=\"absmiddle\" style=\"position: relative; top: -2px;\" /> <a\r\n");
      out.write("\t\t\t\t\t\t\t\thref=\"\" style=\"color: #999;\">看不清，换一张</a>\r\n");
      out.write("\t\t\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t\t</dl>\r\n");
      out.write("\t\t\t\t\t<dl>\r\n");
      out.write("\t\t\t\t\t\t<dt>&nbsp;</dt>\r\n");
      out.write("\t\t\t\t\t\t<dd>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"submit\" value=\"立即注册\" class=\"submit\" /> <input\r\n");
      out.write("\t\t\t\t\t\t\t\ttype=\"checkbox\" checked=\"checked\" />阅读并同意\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"\" class=\"forget\">服务协议</a>\r\n");
      out.write("\t\t\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t\t</dl>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"form-ft\"></div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"login-form-left fl\">\r\n");
      out.write("\t\t\t<dl class=\"func clearfix\">\r\n");
      out.write("\t\t\t\t<dt>注册之后您可以</dt>\r\n");
      out.write("\t\t\t\t<dd class=\"ico05\">\r\n");
      out.write("\t\t\t\t\t<i></i>购买商品支付订单\r\n");
      out.write("\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t<dd class=\"ico01\">\r\n");
      out.write("\t\t\t\t\t<i></i>申请开店销售商品\r\n");
      out.write("\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t<dd class=\"ico03\">\r\n");
      out.write("\t\t\t\t\t<i></i>空间好友推送分享\r\n");
      out.write("\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t<dd class=\"ico02\">\r\n");
      out.write("\t\t\t\t\t<i></i>收藏商品关注店铺\r\n");
      out.write("\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t<dd class=\"ico06\">\r\n");
      out.write("\t\t\t\t\t<i></i>商品资讯服务评价\r\n");
      out.write("\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t<dd class=\"ico04\">\r\n");
      out.write("\t\t\t\t\t<i></i>安全交易诚信无忧\r\n");
      out.write("\t\t\t\t</dd>\r\n");
      out.write("\t\t\t</dl>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div class=\"if\">\r\n");
      out.write("\t\t\t\t<h2>如果您是本站用户</h2>\r\n");
      out.write("\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t我已经注册过账号，立即 <a href=\"\" class=\"register\">登录</a> 或是 <a href=\"\"\r\n");
      out.write("\t\t\t\t\t\tclass=\"findpwd\">找回密码？</a>\r\n");
      out.write("\t\t\t\t</p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"footer clear wrap1000\">\r\n");
      out.write("\t\t<p>\r\n");
      out.write("\t\t\t<a href=\"\">首页</a> | <a href=\"\">招聘英才</a> | <a href=\"\">广告合作</a> | <a\r\n");
      out.write("\t\t\t\thref=\"\">关于ShopCZ</a> | <a href=\"\">联系我们</a>\r\n");
      out.write("\t\t</p>\r\n");
      out.write("\t\t<p>Copyright 2004-2013 itcast Inc.,All rights reserved.</p>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
