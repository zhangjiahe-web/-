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
        var error = "${param.error}";
        if (error == "applysuccess") {

            alert("申请已提交，请耐心等待管理员的处理。如需查看进度，可前往“我的退租申请”中查看");
        }
	</script>
</head>
<body>
<div>
	<div class="result-title">
		<h1>看房申请列表</h1>
	</div>
	<form id="houseForm" name="houseForm"
		  action="/house/getmyapply.action" method=post>
		<div class="result-title">
			<div class="result-list"></div>
		</div>

		<div class="result-content">
			<table id=grid class="result-tab" width="100%">
				<tbody>
				<tr
						style="FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">

					<td>申请人</td>
					<td>申请人身份证号</td>
					<td>申请人联系电话</td>
					<td>房屋id</td>
					<td>地址</td>
					<td>价格</td>
					<td>状态</td>
					<td>操作</td>

				</tr>
				<c:forEach items="${userlist.list}" var="apply">
					<tr
					style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
						<td>${apply.userlist.name }</td>
						<td>${apply.userlist.idcard}</td>
						<td>${apply.userlist.phone}</td>
						<td>${apply.houseId}</td>
						<td>${apply.address}</td>
						<td>${apply.price}</td>
						<td>${apply.status}</td>
						<td><a href="/deleteapply?applyid=${apply.applyId}&houseid=${apply.houseId}"   onclick="return window.confirm('确定要删除该记录吗？')">删除</a></td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>


		<tr>
		<tr>
				 <span id=pagelink>
               <div style="LINE-HEIGHT: 20px; HEIGHT: 20px; TEXT-ALIGN: right; margin-top: 10px" class="page-div">

                   <a href="/zukejujueapply?pageNumStr=${userlist.firstPage}">首页</a>
            <c:if test="${userlist.hasPreviousPage}">
				<a href="/zukejujueapply?pageNumStr=${userlist.prePage}">上一页</a>
			</c:if>
            <c:forEach items="${userlist.navigatepageNums}" var="i">
				<a href="/zukejujueapply?pageNumStr=${i}">${i}</a>
			</c:forEach>
            <c:if test="${userlist.hasNextPage}">
				<a href="/zukejujueapply?pageNumStr=${userlist.nextPage}">下一页</a>
			</c:if>
            <a href="/zukejujueapply?pageNumStr=${userlist.lastPage}">尾页</a>
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