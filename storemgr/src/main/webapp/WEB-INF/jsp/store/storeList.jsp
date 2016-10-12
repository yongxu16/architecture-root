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
</head>
<body>
<table  width="100%" border="1" cellpadding="0" cellspacing="1" class="tableLine DoubleColorTable" >
  <tr>
    <td colspan="3">
    	<a href="${pageContext.request.contextPath}/store/toQuery">转到查询</a>
    	&nbsp;&nbsp;
    	<a href="${pageContext.request.contextPath}/store/toAdd">转到新增</a>
    </td>
  </tr>
  <tr>
    <td colspan="3" align="center" class="tableLineBg">
    	库存列表
    </td>
  </tr>
  <tr>
	<td>商品编号</td>
	<td>库存数量</td>
	<td>操作</td>
  </tr>
  <c:forEach var="m" items="${page.result}">
  <tr>
	<td>${m.goodsUuid}</td>
	<td>${m.storeNum}</td>
	<td>
		<a href="${pageContext.request.contextPath}/store/toUpdate/${m.uuid}">修改</a>
    	&nbsp;&nbsp;
    	<a href="${pageContext.request.contextPath}/store/toDelete/${m.uuid}">刪除</a>
	</td>
  </tr>
  </c:forEach>
  <tr>
  	<td colspan="3" align="center">
  		<input type="hidden" id="queryJsonStr" value='${wm.queryJsonStr}'>
  		<pageTag:pageTag page="${page}"></pageTag:pageTag>
  	</td>
  </tr>
</table>
</body>
</html>