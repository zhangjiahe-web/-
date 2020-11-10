<%--
  Created by IntelliJ IDEA.
  User: 张家和
  Date: 2020/9/10
  Time: 8:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>房屋租赁系统</title>
    <link rel="stylesheet" href="/static/css/styles.css">
</head>
<body style="background: url(/static/imgs/3.jpg);background-size:cover;">
<div class="wrapper">

    <div class="container">
        <h1>房屋租赁网站</h1>
        <form class="form" id="loginform" action="/dologin" method="post">
            <div><input type="text" name="username" placeholder="用户名" ></div>
            <div><input type="password" id="password" name="password" placeholder="密码" ></div>
            <div>
                <label class="radio inline">
                    <input id="admin" type="radio" name="type" value="admin"/> 房东
                </label>
                <label class="radio inline">
                    <input id="zuke" type="radio" name="type" value="zuke" checked/> 租客
                </label>
               <%-- <label class="radio inline">
                    <input id="superadmin" type="radio" name="type" value="superadmin"/>管理员
                </label>--%>
                &nbsp;&nbsp;&nbsp;&nbsp;<a href="/tozhuce">没有账号？点我</a>
            </div>
            <button class="sub">登录</button>
        </form>
    </div>
</div>

<script type="text/javascript" src="/static/js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="/static/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="/static/js/localization/messages_zh.js"></script>
<script type="text/javascript" src="/static/js/md5.js"></script>
<script type="text/javascript">
    $(document).ready(function() {

        $(".sub").click(function(){
            var a = $('#password').val();
            var b = hex_md5(a);
            console.log(b)
            $('#password').val(b);
            var form=$("#loginform");
            form.submit;
        });

        // 在键盘按下并释放及提交后验证提交表单
        $("#loginform").validate({
            rules : {
                username : {
                    required : true,
                    rangelength:[2,8]
                },

                password : {
                    required : true,
                    rangelength:[2,32]
                },
            },
            messages : {
                username : {
                    required : "请输入用户名",
                    error:"帐户名或密码错误",
                    rangelength:"用户名长度必须在2-8个字符之间"
                },
                password : {
                    required : "请输入密码",
                    rangelength:"密码长度必须在2-32个字符之间"
                },
            }
        });
    })

    var error="${requestScope.error}";
    if(error=="error"){
        alert("帐户名或密码错误");
    }
</script>
</body>
</html>
