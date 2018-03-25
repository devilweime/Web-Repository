<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title></title>
</head>
<body>
success<br>
     <shiro:hasAnyRoles name="user:v1">
         <shiro:principal/>拥有角色user:v1
     </shiro:hasAnyRoles>
     <br>
     <shiro:hasPermission name="look">  
          	用户[<shiro:principal/>]拥有权限user:look<br/>  
	</shiro:hasPermission> 
     
</body>
</html>