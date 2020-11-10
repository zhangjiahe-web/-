<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>房屋租赁系统</title>
<link rel="stylesheet" type="text/css" href="/static/css/common.css" />
<link rel="stylesheet" type="text/css" href="/static/css/main.css" />
<script type="text/javascript" src="/static/js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="/static/js/libs/modernizr.min.js"></script>

<style type="text/css">
</style>
<script type="text/javascript">
	var error = "${param.error}";
	if (error == "inserttopaid") {

		alert("租金信息添加成功！");
	}
</script>
</head>
<body>
	<div>
		<div class="result-title">
			<h1>待处理报障</h1>
		</div>
		<form id="houseForm" name="houseForm"
			action="/house/wrong/mywronglist.action" method=post>
			<div class="result-title">
				<div class="result-list"></div>
			</div>

			<div class="result-content">
				<table id=grid class="result-tab" width="100%">
					<tbody>
						<tr
							style="FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
							<td>房屋id</td>
							<td>地址</td>
							<td>报障日期</td>
							<td>租赁人</td>
							<td>报障内容</td>
							<td>状态</td>
						</tr>
						<c:forEach items="${pageInfo.list}" var="wrong">
							<tr
								style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
								<td>${wrong.houseId }</td>
								<td>${wrong.address}</td>
								<td><fmt:formatDate value="${wrong.date}" pattern="yyyy-MM-dd"/></td>
								<td>${wrong.name}</td>
								<td>${wrong.detail}</td>
								<td>${wrong.status}</td>
						</c:forEach>
					</tbody>
				</table>
			</div>
				<span id=pagelink>
					<div style="LINE-HEIGHT: 20px; HEIGHT: 20px; TEXT-ALIGN: right; margin-top: 10px">
						<a href="/mywronglist?pageNumStr=${pageInfo.firstPage}">首页</a>
						<c:if test="${pageInfo.hasPreviousPage}">
							<a href="/mywronglist?pageNumStr=${pageInfo.prePage}">上一页</a>
						</c:if>
						<c:forEach items="${pageInfo.navigatepageNums}" var="i">
							<a href="/mywronglist?pageNumStr=${i}">${i}</a>
						</c:forEach>
						<c:if test="${pageInfo.hasNextPage}">
							<a href="/mywronglist?pageNumStr=${pageInfo.nextPage}">下一页</a>
						</c:if>
						<a href="/mywronglist?pageNumStr=${pageInfo.lastPage}">尾页</a>
					</div>
				</span>
		</form>
	</div>
	<script language=javascript>
		// 提交分页的查询的表单
		function to_page(page) {
			if (page) {
				$("#page").val(page);
			}
			document.houseForm.submit();
		}
	</script>
</body>
</html>