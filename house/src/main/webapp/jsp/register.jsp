<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>房屋租赁系统</title>
    <link rel="stylesheet" type="text/css" href="/static/css/styles.css">
</head>
<body style="background: url(/static/imgs/3.jpg);background-size:cover;">
<div class="wrapper">

    <div class="container">
        <h1>房屋租赁网站</h1>
        <form class="form" id="registerform" action="/registercheck" method="post">
            <div><input type="text" name="username" id="userName" placeholder="用户名" onblur="a()"><span
                    id="msg">${msg}</span></div>
            <div><input type="password" id="password" name="password" placeholder="密码"></div>
            <div><input type="password" id="quepassword" name="quepassword" onblur="b()" placeholder="确认密码">
                <span
                        id="msg2">${msg2}</span></div>
            <div>
                <label class="radio inline">
                    <input id="admin" type="radio" name="type" value="admin" checked/> 房东
                </label>
                <label class="radio inline">
                    <input id="zuke" type="radio" name="type" value="zuke"/> 租客
                </label>
            </div>
            <button class="sub2">注册</button>
        </form>
    </div>
</div>

<script type="text/javascript" src="/static/js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="/static/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="/static/js/localization/messages_zh.js"></script>
<script type="text/javascript" src="/static/js/md5.js"></script>
<script type="text/javascript">
    function a() {
        var userName = $("#userName").val();
        $.post('/ucexist', {userName: userName}, function (data) {
            if (data.status == "true") {
                $("#msg").css({'color': 'red'});
                $("#msg").text('用户名已存在！');

            } else {
                $("#msg").css({'color': 'green'});
                $("#msg").text('用户名可用！');

            }
        })
    }

    function b() {
        var password = $("#password").val();
        var quepassword = $("#quepassword").val();

        $.post('/quemima', {
            quepassword: quepassword,
            password: password
        }, function (data) {
            if (data.status == "false") {
                $("#msg2").css({'color': 'red'});
                $("#msg2").text('两次密码不一致！');

            } else {
                $("#msg2").css({'color': 'green'});
                $("#msg2").text('');
            }
        })
    }
</script>
<script type="text/javascript">
    $(document).ready(function () {

        $('.sub2').click(function () {
            var password1 = $('#password').val();
            var password2 = hex_md5(password1);
            $('#password').val(password2);
            var form2 = $("#registerform");
            form2.submit;
        });

        // 在键盘按下并释放及提交后验证提交表单
        $("#registerform").validate({
            rules: {
                username: {
                    required: true,
                    rangelength: [2, 8]
                },
                password: {
                    required: true,
                    rangelength: [2, 32]
                },
            },
            messages: {
                username: {
                    required: "请输入用户名",
                    rangelength: "用户名长度必须在2-8个字符之间"
                },
                password: {
                    required: "请输入密码",
                    rangelength: "密码长度必须在2-32个字符之间"
                },
            }
        });
    })

</script>
</body>
</html>