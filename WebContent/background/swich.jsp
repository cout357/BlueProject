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

		<title>灞曞紑鍚堥棴鎸夐挳</title>


		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<link href="css/css.css" type="text/css" rel="stylesheet" />
		<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
		<script language="javascript">
	function switchSysBar() {
		if (parent.document.getElementById('attachucp').cols == "194,12,*") {
			document.getElementById('leftbar').style.display = "";
			parent.document.getElementById('attachucp').cols = "0,12,*";
		} else {
			parent.document.getElementById('attachucp').cols = "194,12,*";
			document.getElementById('leftbar').style.display = "none"
		}
	}
	function load() {
		if (parent.document.getElementById('attachucp').cols == "0,12,*") {
			document.getElementById('leftbar').style.display = "";
		}
	}
</script>
	</head>

	<body>

	</body>
</html>
