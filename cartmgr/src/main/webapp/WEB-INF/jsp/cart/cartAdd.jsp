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
<form action="${pageContext.request.contextPath}/cart/add" method="post">
	<table width="100%" border="1" cellpadding="0" cellspacing="1" class="tableLine">
	  <tr>
	    <td colspan="4" align="center" class="tableLineBg">购物车新增</td>
	  </tr>
	  <tr>
	    <td>客户编号</td>
	    <td><input type="text" name="customerUuid" id="customerUuid" class="input"></td>
	    <td>商品编号</td>
	    <td><input type="text" name="goodsUuid" id="goodsUuid" class="input"></td>
	  </tr>
	  <tr>
	    <td>购买数量</td>
	    <td><input type="text" name="buyNum" id="buyNum" class="input"></td>
	  </tr>
	  <tr>
	  	<td colspan="4" align="center"><input type="submit" value="新增" class="button"></td>
	  </tr>
	</table>
</form>
</body>
</html>