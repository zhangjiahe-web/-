<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
        <h1>租客未缴列表</h1>
    </div>
    <form action="/house/paid/topaidlist.action" method="post" name="myform">


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

                    <td>应缴租金</td>
                    <td>租金应缴日期</td>

                    <td>租客姓名</td>

                    <td>状态</td>


                </tr>
                <c:forEach items="${pageInfo.list}" var="topaid">
                    <tr
                            style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
                        <td>${topaid.houseId }</td>
                        <td>${topaid.address}</td>
                        <td>${topaid.price}</td>
                        <td><fmt:formatDate value="${topaid.date}" pattern="yyyy-MM-dd"/></td>
                        <td>${topaid.userlist.name}</td>
                        <td>${topaid.status}</td>


                    </tr>

                </c:forEach>

                </tbody>
            </table>
        </div>
        <tr>
        <tr>

            <div style="LINE-HEIGHT: 20px; HEIGHT: 20px; TEXT-ALIGN: right; margin-top:10px">
                <a href="/topaidlist?pageNumStr=${pageInfo.firstPage}">首页</a>
                <c:if test="${pageInfo.hasPreviousPage}">
                    <a href="/topaidlist?pageNumStr=${pageInfo.prePage}">上一页</a>
                </c:if>
                <c:forEach items="${pageInfo.navigatepageNums}" var="i">
                    <a href="/topaidlist?pageNumStr=${i}">${i}</a>
                </c:forEach>
                <c:if test="${pageInfo.hasNextPage}">
                    <a href="/topaidlist?pageNumStr=${pageInfo.nextPage}">下一页</a>
                </c:if>
                <a href="/topaidlist?pageNumStr=${pageInfo.lastPage}">尾页</a>
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
        document.myform.submit();
    }
</script>
</body>
</html>