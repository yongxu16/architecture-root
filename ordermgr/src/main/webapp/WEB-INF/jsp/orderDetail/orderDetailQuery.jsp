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
			var jsVo = {orderUuid:$("#orderUuid").val(),
						goodsUuid:$("#goodsUuid").val(),
						orderNum:$("#orderNum").val(),
						price:$("#price").val(),
						money:$("#money").val(),
						saveMoney:$("#saveMoney").val()
						} ;
			var json = $.toJSON(jsVo);
			window.location.href = "${pageContext.request.contextPath}/orderDetail/toList?queryJsonStr=" + json ;
		});
	});
</script>

<table id="" width="100%" border="1" cellpadding="0" cellspacing="1" class="tableLine DoubleColorTable" >
  <tr>
    <td colspan="4" align="center" class="tableLineBg" >订单明细查询 </td>
  </tr>
<tr>
  <td>订单编号</td>
    <td><input type="text" name="orderUuid" id="orderUuid" class="input"></td>
    <td>商品编号</td>
    <td><input type="text" name="goodsUuid" id="goodsUuid" class="input"></td>
  </tr>
  <tr>
    <td>购买数量</td>
    <td><input type="text" name="orderNum" id="orderNum" class="input"></td>
    <td>购买价格</td>
    <td><input type="text" name="price" id="price" class="input"></td>
  </tr>
  <tr>
    <td>总金额</td>
    <td><input type="text" name="money" id="money" class="input"></td>
    <td>节省金额</td>
    <td><input type="text" name="saveMoney" id="saveMoney" class="input"></td>
  </tr>
  <tr>
	<td colspan=4 align=center><input id="btn_query" type="button" value="查询" class="button"></td>
  </tr>
</table>
</body>
</html>