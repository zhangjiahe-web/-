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
    <link rel="stylesheet" type="text/css" href="/static/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="/static/css/main.css"/>
    <script type="text/javascript" src="/static/js/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="/static/js/libs/modernizr.min.js"></script>

	<style type="text/css">
	
	
	</style>
	<script type="text/javascript">
	var error="${param.error}";
	if(error=="deletesuccess"){

	alert("删除成功！");
	}
		
	</script>
</head>
<body>
<div>
<div class="result-title">
<h1>用户列表</h1>
</div>
	<form id="houseForm" name="houseForm"
		action="/house/findalluserlist.action"
		method=post >
						 <div class="result-title">
                    <div class="result-list">
                      
                        
                    </div>
                </div>

					<div class="result-content">
						<table id=grid
							class="result-tab" width="100%">
							<tbody>
								<tr
									style="FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
									<td>租客登录名</td>
									<td>租客真实姓名</td>
									<td>租客身份证号</td>
									<td>租客联系电话</td>
<!-- 									
									
									<td>操作</td>
								
									
 -->								</tr>
								<c:forEach items="${pageInfo.list}" var="userlist">
									<tr
										style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
										<td>${userlist.user.username}</td>

										<td>${userlist.name}</td>
										<td>${userlist.idcard}</td>
										<td>${userlist.phone}</td>
										<%-- 
										<td>
										
													<a class="link-update"
											href="/house/deleteuserlist.action?id=${userlist.user.id}"
											onclick="return window.confirm('确定删除吗？')">删除</a>
										
												
											
									</td>		
										
										 --%>
									</tr>

								</c:forEach>

							</tbody>
						</table>
						</div>
					

						<tr>
						<tr>
							<span id=pagelink>
								<div style="LINE-HEIGHT: 20px; HEIGHT: 20px; TEXT-ALIGN: right; margin-top:10px">
									<a href="/findalluserlist?pageNumStr=${pageInfo.firstPage}">首页</a>
						<c:if test="${pageInfo.hasPreviousPage}">
							<a href="/findalluserlist?pageNumStr=${pageInfo.prePage}">上一页</a>
						</c:if>
						<c:forEach items="${pageInfo.navigatepageNums}" var="i">
							<a href="/findalluserlist?pageNumStr=${i}">${i}</a>
						</c:forEach>
						<c:if test="${pageInfo.hasNextPage}">
							<a href="/findalluserlist?pageNumStr=${pageInfo.nextPage}">下一页</a>
						</c:if>
						<a href="/findalluserlist?pageNumStr=${pageInfo.lastPage}">尾页</a>
									
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