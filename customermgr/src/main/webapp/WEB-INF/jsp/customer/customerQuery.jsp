<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="pageTag" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/static/css/application.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/static/js/application.js"></script>
<script src="${pageContext.request.contextPath}/static/js/jquery-1.11.0.js"></script>
<script src="${pageContext.request.contextPath}/static/js/jquery.json-2.6.js"></script>
</head>
<body>
<script type="text/javascript">
	$(function(){
		$("#btn_query").click(function(){
			var jsVo = {customerId:$("#customerId").val(),
						pwd:$("#pwd").val(),
						showName:$("#showName").val(),
						trueName:$("#trueName").val()
						} ;
			var json = $.toJSON(jsVo);
			window.location.href = "${pageContext.request.contextPath}/customer/toList?queryList=" + json ;
		});
	});
</script>

<table id="" width="100%" border="1" cellpadding="0" cellspacing="1" class="tableLine DoubleColorTable" >
  <tr>
    <td colspan="4" align="center" class="tableLineBg" >客户查询 </td>
  </tr>
  <tr>
  	<td>客户编号</td>
	<td><input type="text" id="customerId" name="customerId" class="input"></td>
	<td>客户密码</td>
	<td><input type="text" id="pwd" name="pwd" class="input"></td>
  </tr>
  <tr>
  	<td>显示名称</td>
	<td><input type="text" id="showName" name="showName" class="input"></td>
	<td>真实姓名</td>
	<td><input type="text" id="trueName" name="trueName" class="input"></td>
  </tr>
  <tr>
	<td colspan=4 align=center><input id="btn_query" type="button" value="查询" class="button"></td>
  </tr>
</table>
</body>
</html>