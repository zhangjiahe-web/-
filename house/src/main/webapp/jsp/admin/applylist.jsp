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

</head>
<body>
<div class="result-title">
    <h1>申请看房列表</h1>
</div>
<div>
    <form id="houseForm" name="houseForm" action="findapplylist.action" method=post>
        <div class="result-title">
            <div class="result-list"></div>
        </div>
        <table id=grid class="result-tab" width="100%">
            <tbody>
            <tr
                    style="FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
                <td>房屋id</td>
                <td>地址</td>
                <td>面积</td>
                <td>价格</td>
                <td>申请人姓名</td>
                <td>申请人身份证号</td>
                <td>申请人电话号码</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${applylist.list}" var="apply">
                <tr
                        style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
                    <td>${apply.houseId}</td>
                    <td>${apply.address}</td>
                    <td>${apply.area}</td>
                    <td>${apply.price}</td>
                    <td>${apply.userlist.name}</td>
                    <td>${apply.userlist.idcard}</td>
                    <td>${apply.userlist.phone}</td>

                    <td><a class="link-update"
                           href="tongyi?house_id=${apply.houseId}&userid=${apply.userlistId}">同意租赁</a>&ndash;%&gt;
                        &nbsp;&nbsp; <input type="hidden" name="id" value="${houselist.id}"/>&ndash;%&gt;
                        <a class="link-del" href="/updateapply?applyid=${apply.applyId}&houseid=${apply.houseId}"
                           onclick="return window.confirm('确定要拒绝该租客的申请吗？')">拒绝租赁</a></td>
                    </td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
        <span id=pagelink>
               <div style="LINE-HEIGHT: 20px; HEIGHT: 20px; TEXT-ALIGN: right; margin-top: 10px" class="page-div">

                   <a href="/findapplylist?pageNumStr=${applylist.firstPage}">首页</a>
            <c:if test="${applylist.hasPreviousPage}">
                <a href="/findapplylist?pageNumStr=${applylist.prePage}">上一页</a>
            </c:if>
            <c:forEach items="${applylist.navigatepageNums}" var="i">
                <a href="/findapplylist?pageNumStr=${i}">${i}</a>
            </c:forEach>
            <c:if test="${applylist.hasNextPage}">
                <a href="/findapplylist?pageNumStr=${applylist.nextPage}">下一页</a>
            </c:if>
            <a href="/findapplylist?pageNumStr=${applylist.lastPage}">尾页</a>
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