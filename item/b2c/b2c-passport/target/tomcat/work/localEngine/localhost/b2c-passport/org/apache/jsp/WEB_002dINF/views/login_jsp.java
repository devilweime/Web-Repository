package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
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
      out.write("<script type=\"text/javascript\" src=\"js/jquery.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/login.js\"></script>\r\n");
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
      out.write("\t\t\t\t<h3>用户登录</h3>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"form-bd\">\r\n");
      out.write("\t\t\t\t<form action=\"login/login\" method=\"POST\">\r\n");
      out.write("\t\t\t\t\t<dl>\r\n");
      out.write("\t\t\t\t\t\t<dt>用户名</dt>\r\n");
      out.write("\t\t\t\t\t\t<dd>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" name=\"username\" class=\"text\" />\r\n");
      out.write("\t\t\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t\t</dl>\r\n");
      out.write("\t\t\t\t\t<dl>\r\n");
      out.write("\t\t\t\t\t\t<dt>密&nbsp;&nbsp;&nbsp;&nbsp;码</dt>\r\n");
      out.write("\t\t\t\t\t\t<dd>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"password\" name=\"password\" class=\"text\" />\r\n");
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
      out.write("\t\t\t\t\t\t\t<input type=\"button\" value=\"登  录\" class=\"submit\" /> <a href=\"\"\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"forget\">忘记密码?</a>\r\n");
      out.write("\t\t\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t\t</dl>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t<dl>\r\n");
      out.write("\t\t\t\t\t<dt>&nbsp;</dt>\r\n");
      out.write("\t\t\t\t\t<dd>\r\n");
      out.write("\t\t\t\t\t\t还不是本站会员？立即 <a href=\"\" class=\"register\">注册</a>\r\n");
      out.write("\t\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t</dl>\r\n");
      out.write("\t\t\t\t<dl class=\"other\">\r\n");
      out.write("\t\t\t\t\t<dt>&nbsp;</dt>\r\n");
      out.write("\t\t\t\t\t<dd>\r\n");
      out.write("\t\t\t\t\t\t<p>您可以用合作伙伴账号登录：</p>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"\" class=\"qq\"></a> <a href=\"\" class=\"sina\"></a>\r\n");
      out.write("\t\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t</dl>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"form-ft\"></div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"login-form-left fl\">\r\n");
      out.write("\t\t\t<img src=\"images/left.jpg\" alt=\"\" />\r\n");
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
