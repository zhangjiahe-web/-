<%--
  Created by IntelliJ IDEA.
  User: 张家和
  Date: 2020/9/10
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>房屋租赁系统</title>
    <link rel="stylesheet" type="text/css" href="/static/css/common.css" />
    <link rel="stylesheet" type="text/css" href="/static/css/main.css" />
    <script type="text/javascript" src="/static/js/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="/static/js/libs/modernizr.min.js"></script>
    <style type="text/css">
        .img-span {
            float: left;
            margin: 20px 20px 20px 20px;
        }

        .page-div {
            float: right;
        }
    </style>
    <script type="text/javascript">
        var error = "${param.error}";
        if (error == "applycheck") {

            alert("你还没完善个人信息，请完善个人信息后再进行申请操作");
        } else if (error == "applysuccess") {
            alert("申请成功，请耐心等待房东联系您！");
        }
       /* $(function(){
            $('#sub').click(function(){
                var price = $('#price').val();
                var area = $('#area').val();
                var status = $('#status').val();
                var address = $('#address').val();
                $(this).attr("href","selects.action?price="+price+"&area="+area+"&status="+status+"&address="+address);
                //location.href="selects.action?";
                //alert("price="+price+"&area="+area+"&status="+status+"&address="+address);
            })
        })*/
    </script>
</head>
<body>
<div>
    <div class="result-title">
        <h1>房源列表</h1>
    </div>
    <form action="/houselist" method=post>
        <div class="result-title">
            <div class="result-list"></div>
        </div>
        <div class="result-content">
            <div>
                <div>
                    &nbsp; &nbsp; &nbsp; &nbsp; 房屋价格:<select name="price" id="price" class="required">
                    <option value="">全部</option>
                    <option value="0,500">0-500</option>
                    <option value="500,1000">500-1000</option>
                    <option value="1000,2000">1000-2000</option>
                    <option value="2000,4000">2000-4000</option>
                    <option value="4000,10000">4000+</option>
                </select>
                    &nbsp; &nbsp; &nbsp; &nbsp; 房屋面积:<select name="area" id="area" class="required">
                    <option value="">全部</option>
                    <option value="0,10">0-10</option>
                    <option value="10,20">10-20</option>
                    <option value="20,30">20-30</option>
                    <option value="30,50">30-50</option>
                    <option value="50,100">50-100</option>
                    <option value="100,1000">100+</option>
                </select>
                    &nbsp; &nbsp; &nbsp; &nbsp; 租赁类型:<select name="status" id="status" class="required">
                        <option value="">全部</option>
                        <option value="未租赁">未租赁</option>
                        <option value="已租赁">已租赁</option>
                    </select>
                    &nbsp; &nbsp; &nbsp; &nbsp;地铁线路:<select name="address" id="address" class="required">
                    <option value="">全部</option>
                    <option value="地铁1号线">地铁1号线</option>
                    <option value="地铁2号线">地铁2号线</option>
                    <option value="地铁3号线">地铁3号线</option>
                    <option value="地铁4号线">地铁4号线</option>
                    <option value="地铁5号线">地铁5号线</option>
                    <option value="地铁6号线">地铁6号线</option>
                    <option value="地铁7号线">地铁7号线</option>
                    <option value="地铁8号线">地铁8号线</option>
                    <option value="地铁9号线">地铁9号线</option>
                    <option value="地铁10号线">地铁10号线</option>
                </select>
                    &nbsp; &nbsp; &nbsp; &nbsp;<input type="submit" id="sub" class="btn btn-primary btn2"></input>
                </div>
                <c:forEach items="${houselist.list}" var="houselist">
						<span class="img-span"> <a href="houseDetails?id=${houselist.id }">-
					 <img alt="${houselist.houseid}" src="/static${houselist.img}" width="350px" height="300px">
								<p>价格: ${houselist.price }</p>
								<p>面积: ${houselist.area }</p>
								<p>状态: ${houselist.status }</p>
						</a>
						</span>
                </c:forEach>
            </div>
        </div>
   <span id=pagelink>
               <div style="LINE-HEIGHT: 20px; HEIGHT: 20px; TEXT-ALIGN: right; margin-top: 10px" class="page-div">

                   <a href="/houselist?pageNumStr=${houselist.firstPage}&address=${address}&status=${status}&area=${area}&price=${price}">首页</a>
            <c:if test="${houselist.hasPreviousPage}">
                <a href="/houselist?pageNumStr=${houselist.prePage}&address=${address}&status=${status}&area=${area}&price=${price}">上一页</a>
            </c:if>
            <c:forEach items="${houselist.navigatepageNums}" var="i">
                <a href="/houselist?pageNumStr=${i}&address=${address}&status=${status}&area=${area}&price=${price}">${i}</a>
            </c:forEach>
            <c:if test="${houselist.hasNextPage}">
                <a href="/houselist?pageNumStr=${houselist.nextPage}&address=${address}&status=${status}&area=${area}&price=${price}">下一页</a>
            </c:if>
            <a href="/houselist?pageNumStr=${houselist.lastPage}&address=${address}&status=${status}&area=${area}&price=${price}">尾页</a>
               </div>
           </span>

     <%--   <span id=pagelink>
				<div style="LINE-HEIGHT: 20px; HEIGHT: 20px; TEXT-ALIGN: right; margin-top: 10px" class="page-div">
					共[<B>${p.total}</B>]条记录，共[<B>${p.pages}</B>]页 ,
					<c:if test="${ p.pageNum > 1 }">
                        [<A href="javascript:to_page(${p.prePage})">前一页</A>]
                    </c:if>
					<input type="hidden" name="page" id="page" value="" /> 第<B>${p.pageNum}</B>页

					<c:if test="${ p.pageNum < p.pages }">
                        [<A href="javascript:to_page(${p.nextPage})">后一页</A>]
                    </c:if>
				</div>
			</span>--%>
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
