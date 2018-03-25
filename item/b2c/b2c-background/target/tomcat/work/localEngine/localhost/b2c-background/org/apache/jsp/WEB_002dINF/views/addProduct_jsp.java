package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class addProduct_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("<!DOCTYPE HTML>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\r\n");
      out.write("<title>UploadiFive Test</title>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/uploadify/uploadify.css\">\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery-1.9.1.min.js\"\r\n");
      out.write("\ttype=\"text/javascript\"></script>\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/uploadify/jquery.uploadify.min.js\"\r\n");
      out.write("\ttype=\"text/javascript\"></script>\r\n");
      out.write("<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js\\bootstrap\\css\\bootstrap.min.css\">\r\n");
      out.write("<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js\\bootstrap\\js\\bootstrap.min.js\"></script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("body {\r\n");
      out.write("\tfont: 13px Arial, Helvetica, Sans-serif;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$(function() {\r\n");
      out.write("\t\t$(\"#uploadImage\").uploadify(\r\n");
      out.write("\t\t\t\t{\r\n");
      out.write("\t\t\t\t\theight : 20,\r\n");
      out.write("\t\t\t\t\tswf : '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/uploadify/uploadify.swf',\r\n");
      out.write("\t\t\t\t\tuploader : '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/upload/img',\r\n");
      out.write("\t\t\t\t\twidth : 80,\r\n");
      out.write("\t\t\t\t\t'fileObjName' : 'file',\r\n");
      out.write("\t\t\t\t\t'buttonText' : '上传图片',\r\n");
      out.write("\t\t\t\t\t'removeTimeout' : 0.3,\r\n");
      out.write("\t\t\t\t\t'onUploadSuccess' : function(file, data, response) {\r\n");
      out.write("\t\t\t           /*  alert('The file ' + file.name + ' was successfully uploaded with a response of ' + response + ':' + data); */\r\n");
      out.write("\t\t\t           $(\"#img\").attr(\"src\",data);\r\n");
      out.write("\t\t\t           $(\"#img\").show();\r\n");
      out.write("\t\t\t           $(\"#imgUrl\").val(data);\r\n");
      out.write("\t\t\t        }\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\t   type: \"POST\",\r\n");
      out.write("\t\t\t   url: \"");
      out.print(request.getContextPath());
      out.write("/productCategory/list/0\",\r\n");
      out.write("\t\t\tsuccess : function(data) {\r\n");
      out.write("\t\t\t\tvar text = '<option value=\"\">-请选择-</option>';\r\n");
      out.write("\t\t\t\tfor (var i = 0; i < data.length; i++) {\r\n");
      out.write("\t\t\t\t\ttext += \"<option value=\"+data[i].id+\">\" + data[i].name\r\n");
      out.write("\t\t\t\t\t\t\t+ \"</option>\";\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t$(\"#categoryId\").html(text);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t$(\"#categoryId\").change(function() {\r\n");
      out.write("\t\t\tvar selectText = $(\"#categoryId\").find(\"option:selected\").text();\r\n");
      out.write("\t\t\t$(\"#category\").val(selectText);\r\n");
      out.write("\t\t})\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t/* 添加商品 */\r\n");
      out.write("\t\t$(\"#save\").click(function () {\r\n");
      out.write("\t\t\tif($(\"#productId\").val()==''){\r\n");
      out.write("\t\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t\t type:'post',\r\n");
      out.write("\t\t\t\t\t url:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/product/addProduct',\r\n");
      out.write("\t\t\t\t\t data:$(\"#form_data\").serialize(),\r\n");
      out.write("\t\t\t\t\t success: function(msg){\r\n");
      out.write("\t\t\t\t\t\t if(msg=='ok'){\r\n");
      out.write("\t\t\t\t\t\t \tlocation.href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/product/productList/\"+(pages+1);\r\n");
      out.write("\t\t\t\t\t\t }\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t })\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t})\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<!-- <div style=\"width: 600px; height:400px;\"> -->\r\n");
      out.write("\t<div class=\"container\">\r\n");
      out.write("\t\t<!-- <div class=\"row\"> -->\r\n");
      out.write("\t\t\t<!-- <div class=\"col-md-6\"> -->\r\n");
      out.write("\t\t\t\t<form class=\"form-horizontal\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/product/addProduct\"\r\n");
      out.write("\t\t\tmethod=\"post\" id=\"form_data\">\r\n");
      out.write("\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t<label for=\"aaaa\" class=\"col-sm-2 control-label\">商品名称</label>\r\n");
      out.write("\t\t\t\t\t<div class=\"col-sm-3\"\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"name\" class=\"form-control\" id=\"aaaa\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<!-- 商品名称：<input type=\"text\" name=\"name\"><br>  -->\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"id\" id=\"productId\"> \r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t<label for=\"aaaa\" class=\"col-sm-2 control-label\">商品价格</label>\r\n");
      out.write("\t\t\t\t\t<div class=\"col-sm-3\"\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"price\" class=\"form-control\" id=\"aaaa\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<!-- 商品价格：<input type=\"text\" name=\"price\"><br>  -->\r\n");
      out.write("\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t<label for=\"aaaa\" class=\"col-sm-2 control-label\">商品买点</label>\r\n");
      out.write("\t\t\t\t\t<div class=\"col-sm-3\"\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"salePoint\" class=\"form-control\" id=\"aaaa\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<!-- 商品买点：<input type=\"text\" name=\"salePoint\"><br>  -->\r\n");
      out.write("\t\t\t<input type=\"hidden\"id=\"category\" name=\"category\"> \r\n");
      out.write("\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t<label for=\"aaaa\" class=\"col-sm-2 control-label\">商品类别</label>\r\n");
      out.write("\t\t\t\t\t<div class=\"col-sm-3\"\">\r\n");
      out.write("\t\t\t\t\t\t<select class=\"form-control\" name=\"categoryId\" id=\"categoryId\"></select>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t<!-- 商品类别：\r\n");
      out.write("\t\t\t<select class=\"form-control\" name=\"categoryId\" id=\"categoryId\">\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t</select> -->\r\n");
      out.write("\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t<label for=\"aaaa\" class=\"col-sm-2 control-label\">&nbsp; &nbsp; &nbsp; &nbsp; </label>\r\n");
      out.write("\t\t\t\t\t<div class=\"col-sm-3\"\">\r\n");
      out.write("\t\t\t\t\t\t<img alt=\"\" src=\"\"\r\n");
      out.write("\t\t\t\t\tstyle=\"width: 100px; height: 100px; display: none;\" id=\"img\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t<label for=\"aaaa\" class=\"col-sm-2 control-label\">&nbsp; &nbsp; &nbsp; &nbsp; </label>\r\n");
      out.write("\t\t\t\t\t<div class=\"col-sm-3\"\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"file\" name=\"file\" id=\"uploadImage\" />\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<!-- <div id=\"fileQueue\">\r\n");
      out.write("\t\t\t\t<img alt=\"\" src=\"\"\r\n");
      out.write("\t\t\t\t\tstyle=\"width: 100px; height: 100px; display: none;\" id=\"img\">\r\n");
      out.write("\t\t\t</div> -->\r\n");
      out.write("\t\t\t<!-- <br> <input type=\"file\" name=\"file\" id=\"uploadImage\" /><br> -->\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"images\" id=\"imgUrl\"> \r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t<label for=\"aaaa\" class=\"col-sm-2 control-label\">商品描述</label>\r\n");
      out.write("\t\t\t\t\t<div class=\"col-sm-3\"\">\r\n");
      out.write("\t\t\t\t\t\t<textarea class=\"form-control\" rows=\"8\" name=\"desc\"></textarea>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<!-- 商品描述：<br>\r\n");
      out.write("\t\t\t<textarea rows=\"10\" cols=\"20\" name=\"desc\"></textarea> -->\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"descId\">\r\n");
      out.write("\t\t\t<!-- <div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t<label for=\"aaaa\" class=\"col-sm-2 control-label\">&nbsp; &nbsp; &nbsp; &nbsp; </label>\r\n");
      out.write("\t\t\t\t\t<div class=\"col-sm-3\"\">\r\n");
      out.write("\t\t\t\t\t\t<input class=\"btn btn-default\"  type=\"submit\" value=\"提交\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div> -->\r\n");
      out.write("\t\t\t<!-- <br> <input type=\"submit\" value=\"提交\"> -->\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t\t\t<!-- </div> -->\r\n");
      out.write("\t\t\t<!-- <div class=\"col-md-2\"> -->\r\n");
      out.write("\t\t\t<!-- </div> -->\r\n");
      out.write("\t\t<!-- </div> -->\r\n");
      out.write("\t\t<!-- <div class=\"col-md-4\"></div> -->\r\n");
      out.write("<!-- \t</div> -->\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
