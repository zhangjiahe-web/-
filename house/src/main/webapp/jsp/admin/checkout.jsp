<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

</head>
<body>
<div class="result-title">
    <h1>已退租列表</h1>
</div>

<div>
    <form id="houseForm" name="houseForm" action="/toCheckout" method=post>
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


                    <td>申请人姓名</td>
                    <td>申请人身份证号</td>
                    <td>申请人电话号码</td>
                    <td>状态</td>
                    <td>操作</td>


                </tr>
                <c:forEach items="${checkoutPageInfo.list}" var="checkout">
                    <tr
                            style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
                        <td>${checkout.houseId }</td>

                        <td>${checkout.address}</td>


                        <td>${checkout.name}</td>

                        <td>${checkout.idcard}</td>
                        <td>${checkout.phone}</td>
                        <td>${checkout.status}</td>
                        <td>

                            <input type="hidden" name="id" value="${checkout.cid}"/>
                            <a class="link-del"
                               href="/delcheckout?id=${checkout.cid}"
                               onclick="return window.confirm('确定要删除该记录吗？')">删除</a></td>


                        </td>


                    </tr>

                </c:forEach>

                </tbody>
            </table>
        </div>


        <tr>
        <tr>
							<span id=pagelink>
								<div style="LINE-HEIGHT: 20px; HEIGHT: 20px; TEXT-ALIGN: right; margin-top:10px">


                                         <a href="/toCheckout?pageNumStr=${checkoutPageInfo.firstPage}">首页</a>
            <c:if test="${checkoutPageInfo.hasPreviousPage}">
                <a href="/toCheckout?pageNumStr=${checkoutPageInfo.prePage}">上一页</a>
            </c:if>
            <c:forEach items="${checkoutPageInfo.navigatepageNums}" var="i">
                <a href="/toCheckout?pageNumStr=${i}">${i}</a>
            </c:forEach>
            <c:if test="${checkoutPageInfo.hasNextPage}">
                <a href="/toCheckout?pageNumStr=${checkoutPageInfo.nextPage}">下一页</a>
            </c:if>
            <a href="/toCheckout?pageNumStr=${checkoutPageInfo.lastPage}">尾页</a>
								</div>

							</span>

        </tr>
        </tbody>


        </tbody>


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