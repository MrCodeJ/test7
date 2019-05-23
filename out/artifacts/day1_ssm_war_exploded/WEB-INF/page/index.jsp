<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.7.js"></script>
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/index.css">
	
  </head>
  
  <body>
  
  <form  name="searchForm" action="${pageContext.request.contextPath }/user/pager" >
  	<input type="hidden" id="currentPage" name="currentNum" value="${pager.currentPage }"/>
  <input type="hidden" id="pageSize" name="pageSize" value="${pager.pageSize }"/>
  <table>
  <tr>
  <td>用户名：<input type="text" name="username"/></td>
  <td>状态：
  <select name="status">
  	<option value="0">请选择</option>
  	<option value="1">正常</option>
  	<option value="2">禁用</option>
  </select>
  </td>
  <td><input type="submit" value="查询"/></td>
  </tr>
  </table>
  
  
    <table border="1px" class="data_table">
   		<tr class="head_tr">
   			<td>序号</td>
   			<td>用户名</td>
   			<td>密码</td>
   			<td>状态</td>
   			<td>创建时间</td>
   			<td>角色ID</td>
   			<td>操作/<a href="${pageContext.request.contextPath }/user/AddUser">增加</a></td>  		
   		</tr>
   		<c:forEach var="user" items="${pager.pageRecords }" varStatus="s">
   		<tr <c:if test="${s.index%2==1 }"> style="background-color:#eee;"</c:if>>
   			<td>${s.index+1}</td>
   			<td>${user.username }</td>
   			<td>${user.password }</td>
   			<td>${user.status==1?"正常":"<span style='color:#f00;'>禁用</span>"}</td>
   			<td><fmt:formatDate value="${user.createtime }" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
   			<td>${user.roleId==1?"管理员":"普通用户" }</td>
   			<td>
   				<a href="${pageContext.request.contextPath }/user/UpdateUser?id=${user.id }">修改</a>
   				<a href="javascript:if(confirm('你确定要删除吗?')){location.href='${pageContext.request.contextPath }/user/deleteUser?id=${user.id }'}">删除</a>
   			</td>  		
   		</tr>
   		</c:forEach>
   	</table>
   	
<input type="hidden" id="pageCount" value="${pager.pageCount }"/>
<table style="width:98%;margin:0px auto;">
	<tr>
		<td style="text-align:left;">
			第<span style="color:red;">${pager.currentPage }</span>/${pager.pageCount }页
			共${pager.total }条
		</td>
		<td style="text-align:right;">
			<c:if test="${pager.currentPage>1 }">
				<a href="javascript:jump(1,${pager.pageSize})">首页</a>
				<a href="javascript:jump(${pager.currentPage-1 },${pager.pageSize})">上一页</a>
			</c:if>
			<c:if test="${pager.currentPage<pager.pageCount }">
				<a href="javascript:jump(${pager.currentPage+1 },${pager.pageSize})">下一页</a>
				<a href="javascript:jump(${pager.pageCount },${pager.pageSize})">末页</a>
			</c:if>
			转到<input type="text" id="gPage" name="pager.currentPage" style="width:20px;"/>
			<input type="button" value="GO" onclick="jump(document.getElementById('gPage').value,${pager.pageSize})'"/>
		</td>
	</tr>
</table>
</form>
   	<script type="text/javascript">
	function jump(p,s){
		//window.location.href="${ctx}/user/userList.action?pager.currentPage="+p+"&pager.pageSize="+s;
		var reg = /^[1-9]\d*$/;
		if(!reg.test(parseInt(p))){
			alert("请输入数字");
			document.getElementById("gPage").select();
			return;
		}
		var pageCount = $("#pageCount").val();
		if(parseInt(pageCount)<parseInt(p)){
			alert("不能大于最大页数！");
			document.getElementById("gPage").select();
			return;
		}
		var oForm = document.searchForm || document.form[0];
		with(oForm){
			elements["pageSize"].value = s;
			elements["currentPage"].value =p;
			submit();
		};
	};

</script>
  </body>
</html>
