<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>后台管理</title>

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/js\bootstrap\css\bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="../../assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}\css\dashboard.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>
  </head>

  <body>
	
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">商城后台管理</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
        
        </div>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
          	<li ><a href="${pageContext.request.contextPath}/" target="mainFrame">首页</a></li>
            <li ><a href="${pageContext.request.contextPath}/product/productList/1" target="mainFrame">商品信息管理<span class="sr-only"></span></a></li>
          </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main" id="mainFrame">
        <!-- style="border: 0px; width: 100%;height: 1000px;" -->
        <!-- <iframe  class="embed-responsive-item"  name="mainFrame"></iframe> -->
          <!-- 16:9 aspect ratio -->
        <h1 class="page-header" id="sm_title">首页</h1>
        
		<div class="embed-responsive embed-responsive-16by9">
 			 <iframe class="embed-responsive-item" name="mainFrame" src="${pageContext.request.contextPath}/"></iframe>
		</div>
  
          </div>
        </div>
      </div>
    </div>
	<nav class="navbar navbar-default navbar-fixed-bottom active">
			  		<div class="container">
			    		...
			  		</div>
	</nav>
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <script src="../../assets/js/vendor/holder.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
    
    <script type="text/javascript">
    	/* 左导航栏变化 */	
    	$(function() {
			$("li a").click(function() {
				$(this).parent().parent().children("li").attr("class","");
				$(this).parent().attr("class","active");
				$("#sm_title").text($(this).text());
			})
		})
    </script>
  </body>
</html>
