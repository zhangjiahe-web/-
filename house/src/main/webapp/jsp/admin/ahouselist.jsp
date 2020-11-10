<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
</head>
<body>
	<div>
		<div class="result-title">
			<h1>房源列表</h1>
		</div>
		<form id="houseForm" name="houseForm" action="ahouselist.action"
			method=post>
			<div class="result-title">
				<div class="result-list"></div>
			</div>
			<div class="result-content">
				<table id=grid class="result-tab" width="100%">
					<tbody>
						<tr
							style="FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
							<td>房屋图片</td>
							<td>房屋ID</td>
							<td>地址</td>
							<td>面积</td>
							<td>价格</td>
							<td>状态</td>
							<td>操作</td>
						</tr>
						<c:forEach items="${houselist.list}" var="houselist">
							<tr
								style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
								<td><img src="/static${houselist.img }"
									style="width: 150px; height: 100px;"></td>
								<td>${houselist.houseid}</td>
								<td>${houselist.address}</td>
								<td>${houselist.area}</td>
								<td>${houselist.price}</td>
								<td>${houselist.status}</td>
								<td><a class="link-update"
									href="/tochangehouse?id=${houselist.id}">修改</a> &nbsp;&nbsp; <input
									type="hidden" name="id" value="${houselist.id}" /> <a
									class="link-del" href="/delhouse?id=${houselist.id}"
									onclick="return window.confirm('确定删除吗？')">删除</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<tr>
				   <span id=pagelink>
               <div style="LINE-HEIGHT: 20px; HEIGHT: 20px; TEXT-ALIGN: right; margin-top: 10px" class="page-div">

                   <a href="/ahouselist?pageNumStr=${houselist.firstPage}">首页</a>
            <c:if test="${houselist.hasPreviousPage}">
				<a href="/ahouselist?pageNumStr=${houselist.prePage}">上一页</a>
			</c:if>
            <c:forEach items="${houselist.navigatepageNums}" var="i">
				<a href="/ahouselist?pageNumStr=${i}">${i}</a>
			</c:forEach>
            <c:if test="${houselist.hasNextPage}">
				<a href="/ahouselist?pageNumStr=${houselist.nextPage}">下一页</a>
			</c:if>
            <a href="/ahouselist?pageNumStr=${houselist.lastPage}">尾页</a>
               </div>
           </span>

			</tr>
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