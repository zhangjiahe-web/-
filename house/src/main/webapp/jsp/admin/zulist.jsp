<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <link rel="stylesheet" type="text/css" href="/static/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="/static/css/main.css"/>
    <script type="text/javascript" src="/static/js/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="/static/js/libs/modernizr.min.js"></script>

    <style type="text/css">
    </style>
    <script type="text/javascript">
        var error = "${param.error}";
        if (error == "zusuccess") {

            alert("该房已租赁，可在租赁列表中查看详情！");
        } else if (error == "checkoutsuccess") {
            alert("该合同已被终止！");
        }
    </script>
</head>
<body>
<div>
    <div class="result-title">
        <h1>在租列表</h1>
    </div>
    <form id="houseForm" name="houseForm" action="/toZuList" method=post>
        <div class="result-title">
            <div class="result-list"></div>
        </div>
        <div class="result-content">
            <table id=grid class="result-tab" width="100%">
                <tbody>
                <tr style="FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
                    <td>房屋id</td>
                    <td>地址</td>
                    <td>价格</td>
                    <td>租赁人</td>
                    <td>租赁人身份证号</td>
                    <td>租赁人联系电话</td>
                    <td>操作</td>
                </tr>
                <c:forEach items="${zulistPageInfo.list}" var="zulist">
                    <tr style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
                        <td>${zulist.houseId }</td>
                        <td>${zulist.address}</td>
                        <td>${zulist.price}</td>
                        <td>${zulist.name}</td>
                        <td>${zulist.idcard}</td>
                        <td>${zulist.phone}</td>
                        <td><a class="link-update"
                               href="/tohetong?house_id=${zulist.houseId }">查看合同</a>
                            &nbsp;&nbsp; <a class="link-del"
                                            href="/delhetong?house_id=${zulist.houseId }&address=${zulist.address}&userlist_id=${zulist.userlistId}"
                                            onclick="return window.confirm('确定要终止合同吗？')">终止合同</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <tr>
				<span id=pagelink>
					<div style="LINE-HEIGHT: 20px; HEIGHT: 20px; TEXT-ALIGN: right; margin-top: 10px">

                         <a href="/toZuList?pageNumStr=${zulistPageInfo.firstPage}">首页</a>
            <c:if test="${checkoutPageInfo.hasPreviousPage}">
                <a href="/toZuList?pageNumStr=${zulistPageInfo.prePage}">上一页</a>
            </c:if>
            <c:forEach items="${zulistPageInfo.navigatepageNums}" var="i">
                <a href="/toZuList?pageNumStr=${i}">${i}</a>
            </c:forEach>
            <c:if test="${zulistPageInfo.hasNextPage}">
                <a href="/toZuList?pageNumStr=${zulistPageInfo.nextPage}">下一页</a>
            </c:if>
            <a href="/toZuList?pageNumStr=${zulistPageInfo.lastPage}">尾页</a>
					</div>
				</span>
        </tr>
    </form>
</div>
<script language=javascript>
    // 提交分页的查询的表单
    function to_page(pageNumStr) {
        if (pageNumStr) {
            $("#pageNumStr").val(pageNumStr);
        }
        document.houseForm.submit();
    }
</script>
</body>
</html>