<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>后台管理登录界面</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<link href="background/css/alogin.css" rel="stylesheet"
			type="text/css" />
	</head>

	<body>
		<form id="form1" runat="server" action="ManagerServlet?type=login"
			method="post">
			<div class="Main">
				<ul>
					<li class="top"></li>
					<li class="top2"></li>
					<li class="topA"></li>
					<li class="topB">
						<span><img src="background/images/login/logo.gif" alt=""
								style="" />
						</span>
					</li>
					<li class="topC"></li>
					<li class="topD">
						<ul class="login">
							<li>
								<span class="left login-text">用户名：</span>
								<span style=""> <input id="Text1" type="text" class="txt"
										name="username" /> </span>
							</li>
							<li>
								<span class="left login-text">密码：</span>
								<span style=""> <input id="Text2" type="password"
										class="txt" name="pwd" /> </span>
							</li>
						</ul>
					</li>
					<li class="topE"></li>
					<li class="middle_A"></li>
					<li class="middle_B"></li>
					<li class="middle_C">
						<span class="left login-text">验证码：</span>
						<span style=""> <input id="checkCode" type="text" class="txt" name="checkCode" style="width:120px;"/> </span>	
						<span><a href=""><img src="background/checkCodeImg.jsp"/></a></span>
						<br/>
							<input type="hidden" id="checkOut" value=${requestScope.checkOut}>
						<span class="btn"><input name="" type="image"
								src="background/images/login/btnlogin.gif" />
						</span>
					</li>
					<li class="middle_D"></li>
					<li class="bottom_A"></li>
					<li class="bottom_B">
						网站后台管理系统&nbsp;&nbsp;www.php.com
					</li>
				</ul>
			</div>
		</form>
		<script>
			function checkOutFunc(){
				var checkOut = document.getElementById("checkOut").value;
				if(checkOut == "1"){
					alert("用户名或密码错误！");
				}
				else if(checkOut == "2"){
					alert("验证码错误!");
				}
			}
			checkOutFunc();
		</script>
	</body>
</html>
