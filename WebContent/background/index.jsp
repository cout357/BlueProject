<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<script>
			/* window.onload = function(){
				if(${empty sessionScope.managername}){
					alert("管理员未登录！");
					window.location.href="login.jsp";
				}
			} */
		</script>
		<base href="<%=basePath%>">

		<title>网站后台管理系统</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<link rel="shortcut icon" href="images/favicon.ico" />
		<link href="css/css.css" type="text/css" rel="stylesheet" />
	</head>
	<!--框架样式-->
	<frameset rows="95,*,30" cols="*" frameborder="no" border="0"
		framespacing="0">
		<!--top样式-->
		<frame src="background/top.jsp" name="topframe" scrolling="no"
			noresize id="topframe" title="topframe" />
		<!--contact样式-->
		<frameset id="attachucp" framespacing="0" border="0" frameborder="no"
			cols="194,12,*" rows="*">
			<frame scrolling="auto" noresize="" frameborder="no" name="leftFrame"
				src="background/left.jsp"></frame>
			<frame id="leftbar" scrolling="no" noresize="" name="switchFrame"
				src="background/swich.jsp"></frame>
			<frame scrolling="auto" noresize="" border="0" name="mainFrame"
				src="background/main.jsp"></frame>
		</frameset>
		<!--bottom样式--> 
		<frame src="background/bottom.jsp" name="bottomFrame" scrolling="No"
			noresize="noresize" id="bottomFrame" title="bottomFrame" />
	</frameset>
	<noframes></noframes>
	<!--不可以删除-->
	<body>

	</body>
</html>
