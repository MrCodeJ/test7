<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'login.jsp' starting page</title>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.7.js"></script>

  </head>
  
  <body>
  <form action="${pageContext.request.contextPath }/user/login" method="post">
   用户名：<input type="text" name="username" />
   密码：<input type="password" name="password" />
   <input type="submit" value="登录" />
  </form>
  

  </body>
</html>
