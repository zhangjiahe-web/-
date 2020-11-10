<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <script type="text/javascript" src="/static/js/libs/modernizr.min.js"></script>
    <script type="text/javascript" src="/static/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="/static/js/jquery-ui-datepicker.js"></script>
    <script type="text/javascript" src="/static/js/jquery.validate.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/static/css/jquery-ui.css"/>

    <style type="text/css">
        .sum {
            float: right;
        }

    </style>
    <script type="text/javascript">
        $().ready(function () {
            // 在键盘按下并释放及提交后验证提交表单
            $("#fromdate").datepicker();
            $("#todate").datepicker();
        });

    </script>

</head>
<body>
<div>
    <div class="result-title">
        <h1>已处理报障列表</h1>
    </div>
    <div class="search-wrap">
        <div class="search-content">
            <form id="houseForm" name="houseForm" action="/toSolve" method="post">
                <table class="search-tab">
                    <tr>
                        <th width="120">租客姓名：</th>
                        <td><input class="common-text" placeholder="姓名" name="zuname" value="${vo.zuname }" id="zuname"
                                   type="text"></td>
                        <input type="hidden" id="pageNumStr" name="pageNumStr" value="1">
                        <th width="120">房屋id：</th>
                        <td><input class="common-text" placeholder="id" name="id" value="${vo.id }" id="id"
                                   type="text"></td>
                        <td><input class="btn btn-primary btn2" name="sub" value="查询" type="submit"></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>

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
                <td>房屋id</td>
                <td>地址</td>
                <td>报障日期</td>
                <td>租赁人</td>
                <td>报障内容</td>
                <td>状态</td>
                <td>操作</td>


            </tr>
            <c:forEach items="${solves.list}" var="s">
                <tr
                        style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
                    <td>${s.houseId }</td>
                    <td>${s.address}</td>
                    <td><fmt:formatDate type="date" value="${s.date}" pattern="yyyy-MM-dd"/></td>
                    <td>${s.name}</td>
                    <td>${s.detail}</td>
                    <td>${s.status}</td>
                    <td>
                        <a class="link-update"
                           href="/dolsolve/${s.id}"
                           onclick="return window.confirm('确定删除吗？')">删除</a>
                        &nbsp;&nbsp;
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>


    <tr>
    <tr>
        <div style="LINE-HEIGHT: 20px; HEIGHT: 20px; TEXT-ALIGN: right; margin-top:10px">
            以上报障：<B style="color:red">${solves.total} </B>条
        </div>
        <div style="LINE-HEIGHT: 20px; HEIGHT: 20px; TEXT-ALIGN: right; margin-top:10px">
            <a href="/toSolve?pageNumStr=${solves.firstPage}">首页</a>
            <c:if test="${pageInfo.hasPreviousPage}">
                <a href="/toSolve?pageNumStr=${solves.prePage}">上一页</a>
            </c:if>
            <c:forEach items="${solves.navigatepageNums}" var="i">
                <a href="/toSolve?pageNumStr=${i}">${i}</a>
            </c:forEach>
            <c:if test="${solves.hasNextPage}">
                <a href="/toSolve?pageNumStr=${solves.nextPage}">下一页</a>
            </c:if>
            <a href="/toSolve?pageNumStr=${solves.lastPage}">尾页</a>

        </div>
        </span>

    </tr>
    </tbody>


    </tbody>


</div>
<script language=javascript>
    // 提交分页的查询的表单
    function to_page(pageNumStr) {
        if (pageNumStr) {
            $("#pageNumStr").val(pageNumStr);
        }
        $("#houseForm").submit();
    }
</script>
</body>
</html>