<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/static/css/application.css" rel="stylesheet">
</head>
<body>
<form action="${pageContext.request.contextPath}/customer/delete" method="post">
	<input type="hidden" name="uuid" value="${cm.uuid}">
	<input type="hidden" name="registerTime" value="${cm.registerTime}">
	<table width="100%" border="1" cellpadding="0" cellspacing="1" class="tableLine">
	  <tr>
	    <td colspan="4" align="center" class="tableLineBg">客戶刪除</td>
	  </tr>
	  <tr>
	    <td>客户编号</td>
	    <td><input type="text" name="customerId" id="customerId" class="input" value="${cm.customerId}"></td>
	    <td>客户密码</td>
	    <td><input type="text" name="pwd" id="pwd" class="input" value="${cm.pwd}"></td>
	  </tr>
	  <tr>
	    <td>显示名称</td>
	    <td><input type="text" name="showName" id="showName" class="input" value="${cm.showName}"></td>
	    <td>真实姓名</td>
	    <td><input type="text" name="trueName" id="trueName" class="input" value="${cm.trueName}"></td>
	  </tr>
	  <tr>
	  	<td colspan="4" align="center"><input type="submit" value="刪除" class="button"></td>
	  </tr>
	</table>
</form>
</body>
</html>