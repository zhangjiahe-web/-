<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
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

	/*if (${param=="applysuccess"}) {

		alert("申请已提交，请耐心等待管理员的处理。如需查看进度，可前往“我的退租申请”中查看");
	}*/
</script>
</head>
<body>
	<div>
		<div class="result-title">
			<h1>我的租赁</h1>
		</div>
		<form id="houseForm" name="houseForm"
			action="/house/zulist/myzulist.action" method=post>
			<div class="result-title">
				<div class="result-list"></div>
			</div>

			<div class="result-content">
				<table id=grid class="result-tab" width="100%">
					<tbody>
						<tr
							style="FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">

							<td>租赁人</td>
							<td>租赁人身份证号</td>
							<td>租赁人联系电话</td>
							<td>房屋id</td>
							<td>地址</td>
							<td>价格</td>
							<td>操作</td>

						</tr>
						<c:forEach items="${pageInfo.list }"  var="zulist">

							<tr
								style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">

								<td>${zulist.userlist.name }</td>

								<td>${zulist.userlist.idcard}</td>

								<td>${zulist.userlist.phone}</td>
								
									<td>${zulist.houseId}</td>
									<td>${zulist.address}</td>
									<td>${zulist.price}</td>

									<td><a class="link-update"
										href="/zukeseehetong?contractId=${zulist.contractId}">查看合同</a>
										&nbsp;&nbsp; <a class="link-del"
										href="/insertapplyout?houseid=${zulist.houseId }&address=${zulist.address}"
										onclick="return window.confirm('确定要申请退租吗？')">申请退租</a></td>
								
							</tr>



						</c:forEach>

					</tbody>
				</table>
			</div>


			<tr>
			<tr>
				<span id=pagelink>
					    <div style="LINE-HEIGHT: 20px; HEIGHT: 20px; TEXT-ALIGN: right; margin-top: 10px" class="page-div">

                   <a href="/myzulist?pageNumStr=${pageInfo.firstPage}">首页</a>
            <c:if test="${pageInfo.hasPreviousPage}">
				<a href="/myzulist?pageNumStr=${pageInfo.prePage}">上一页</a>
			</c:if>
            <c:forEach items="${pageInfo.navigatepageNums}" var="i">
				<a href="/myzulist?pageNumStr=${i}">${i}</a>
			</c:forEach>
            <c:if test="${pageInfo.hasNextPage}">
				<a href="/myzulist?pageNumStr=${pageInfo.nextPage}">下一页</a>
			</c:if>
            <a href="/myzulist?pageNumStr=${pageInfo.lastPage}">尾页</a>
               </div>
				</span>

			</tr>
			</tbody>




			</tbody>


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