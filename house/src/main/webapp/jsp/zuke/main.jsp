<%--
  Created by IntelliJ IDEA.
  User: 张家和
  Date: 2020/9/10
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>房屋租赁系统</title>
    <style>
        .a:hover {
            cursor: pointer;
        }
    </style>
    <link rel="stylesheet"   href="/static/css/common.css" />
    <link rel="stylesheet"  href="/static/css/main.css" />
    <script type="text/javascript" src="/static/js/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="/static/js/libs/modernizr.min.js"></script>
    <script type="text/javascript">

        $().ready(function(){

            $('#fangyuan').click(function(){
                $('#afangyuan').slideToggle("slow");

            });
            $('#zulin').click(function(){
                $('#azulin').slideToggle("slow");
            });
            $('#sq').click(function(){
                $('#asq').slideToggle("slow");
            });
            $('#xinxi').click(function(){
                $('#axinxi').slideToggle("slow");
            });
            $('#baoz').click(function(){
                $('#abaoz').slideToggle("slow");
            });
            $('#qita').click(function(){
                $('#aqita').slideToggle("slow");
            });
            $('#caidan').click(function(){
                $('#acaidan').slideToggle("slow");
            });


        })


        // 提交分页的查询的表单
        function to_page(url1) {

            $.ajax({
                url : url1,
                type : "post",
                async : false,

                success : function(data) {
                    // 你的具体操作
                    // alert(data);
                    $("#inside").html(data);
                    alert("成功");

                },
                error : function() {
                    alert("失败，请稍后再试！");
                }
            });
        }

    </script>
</head>
<body style="background: url('/static/imgs/背景图.png');">
<div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <h1 class="topbar-logo none">
                <a href="index.html" class="navbar-brand">后台管理</a>
            </h1>
            <ul class="navbar-list clearfix">
                <li><a class="on sendRequest" href="">首页</a></li>

            </ul>
        </div>
        <div class="top-info-wrap">
            <ul class="top-info-list clearfix">
                <li>欢迎您，${sessionScope.user.username}！</li>

                <li><a
                        href="javascript:if(confirm('确实要退出登录吗?'))location='/leavelogin'">退出</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="container clearfix">
    <div class="sidebar-wrap">
        <div class="sidebar-title">
            <h1 id="caidan">菜单</h1>
        </div>
        <div style="display: none;" id="hide"><%--${info }--%></div>
        <%--<c:if test="${not empty info }">
            <div style="display: none;" id="hide">${info }</div>
        </c:if>--%>
        <div class="sidebar-content" id="acaidan">
            <ul class="sidebar-list">
                <li><a class="a" id="fangyuan" class="ziliao">房源信息</a>
                    <div class="p" id="afangyuan">
                        <ul class="sub-menu">
                            <li class="ziliao"><a href="/houselist" >房源列表</a></li>
                        </ul>
                    </div></li>
                <li><a class="a" id="zulin">租赁信息</a>
                    <div class="p" id="azulin">
                        <ul class="sub-menu">
                            <li><a href="/myzulist" class="ziliao">我的租赁</a></li>
                            <li><a href="/getmycheckout" class="ziliao">已退租列表</a></li>
                        </ul>
                    </div></li>
                <li><a class="a" id="sq">我的申请</a>
                    <div class="p" id="asq">
                        <ul class="sub-menu">
                            <li><a href="/getmyapply" class="ziliao">看房申请列表</a></li>
                            <li><a href="/zukejujueapply" class="ziliao">拒绝申请列表</a></li>
                        </ul>
                    </div></li>
                <li><a class="a" id="xinxi">租金信息</a>
                    <div class="p" id="axinxi">
                        <ul class="sub-menu">
                            <li><a href="/mytopaidlist" class="ziliao">待缴租金</a></li>
                            <li><a href="/findmypaid" class="ziliao">已缴租金</a></li>
                        </ul>
                    </div></li>
                <li><a class="a" id="baoz">报障模块</a>
                    <div class="p" id="abaoz">
                        <ul class="sub-menu">
                            <li><a href="/toaddwrong" class="ziliao">我要报障</a></li>
                            <li><a href="/mywronglist" class="ziliao">未处理报障</a></li>
                            <li><a href="/findmysolve" class="ziliao">已处理报障</a></li>
                        </ul>
                    </div></li>
                <li><a class="a" id="qita">其他操作</a>
                    <div class="p" id="aqita">
                        <ul class="sub-menu">
                            <li><a href="/findhasuserlist">账户绑定</a></li>
                        </ul>
                    </div></li>
            </ul>
        </div>
    </div>
    <!--/sidebar-->
    <div class="main-wrap">
        <div class="crumb-wrap">
            <div class="crumb-list">
                <i class="icon-font">&#xe06b;</i><span>欢迎使用本网站！</span>
            </div>
        </div>
  <div class="result-wrap" id="inside">
            <jsp:include page="${mainPage==null?'../admin/index.jsp':mainPage}"></jsp:include>

        </div>
    </div>
</div>
<!--/main-->
</div>
</body>
</html>
<script type="text/javascript">

    $(".ziliao").click(function(){
        $.ajax({url:"/checkuserlists",success:function(date){
                if(date.status=='true'){
                    return true;
                }else{
                    alert("请先完善资料再访问本资源");
                    window.location="/findhasuserlist";
                    return false;
                }

            }});
    })
/*  /!*  var error="";
    if(error=="error"){
        alert("请完善资料后再使用本功能！");
    }*!/*/
</script>
