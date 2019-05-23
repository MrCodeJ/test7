<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.7.js"></script>
    <title>My JSP 'updateUser.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <form action="" method="post">
  <input type="hidden" value="${user.id }" name="id"/>
   <table>
   <tr>
   <td>用户名</td>
   <td><input type="text" value="${user.username }" name="username"/></td>
   </tr>
   <tr>
   <td>密码</td>
   <td><input type="text" value="${user.password }" name="password"/></td>
   </tr>
   <tr>
   <td>年龄</td>
   <td><input type="text" value="${user.age }" name="age"/></td>
   </tr>
   <tr>
   <td><input type="submit" value="提交"/></td>
   <td><input type="button" value="返回" onclick="history.back(-1)"/></td>
   </tr>
   </table>
   </form>
  </body>
</html>
