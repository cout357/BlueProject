<%@ page language="java" import="java.util.*" pageEncoding="utf-8"  %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="java.util.ArrayList"  %>
<%@ page import="com.xxgc.model.Manager"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>主要内容区main</title>
<link href="css/css.css" type="text/css" rel="stylesheet" />
<link href="css/main.css" type="text/css" rel="stylesheet" />
<link rel="shortcut icon" href="images/main/favicon.ico" />
<style>
body{overflow-x:hidden; background:#f2f0f5; padding:15px 0px 10px 5px;}
#searchmain{ font-size:12px;}
#search{ font-size:12px; background:#548fc9; margin:10px 10px 0 0; display:inline; width:100%; color:#FFF; float:left}
#search form span{height:40px; line-height:40px; padding:0 0px 0 10px; float:left;}
#search form input.text-word{height:24px; line-height:24px; width:180px; margin:8px 0 6px 0; padding:0 0px 0 10px; float:left; border:1px solid #FFF;}
#search form input.text-but{height:24px; line-height:24px; width:55px; background:url(images/main/list_input.jpg) no-repeat left top; border:none; cursor:pointer; font-family:"Microsoft YaHei","Tahoma","Arial",'宋体'; color:#666; float:left; margin:8px 0 0 6px; display:inline;}
#search a.add{ background:url(images/main/add.jpg) no-repeat -3px 7px #548fc9; padding:0 10px 0 26px; height:40px; line-height:40px; font-size:14px; font-weight:bold; color:#FFF; float:right}
#search a:hover.add{ text-decoration:underline; color:#d2e9ff;}
#main-tab{ border:1px solid #eaeaea; background:#FFF; font-size:12px;}
#main-tab th{ font-size:12px; background:url(images/main/list_bg.jpg) repeat-x; height:32px; line-height:32px;}
#main-tab td{ font-size:12px; line-height:40px;}
#main-tab td a{ font-size:12px; color:#548fc9;}
#main-tab td a:hover{color:#565656; text-decoration:underline;}
.bordertop{ border-top:1px solid #ebebeb}
.borderright{ border-right:1px solid #ebebeb}
.borderbottom{ border-bottom:1px solid #ebebeb}
.borderleft{ border-left:1px solid #ebebeb}
.gray{ color:#dbdbdb;}
td.fenye{ padding:10px 0 0 0; text-align:right;}
.bggray{ background:#f9f9f9}
</style>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function del(){
			if(confirm("确定要删除吗?")){
				return true;
			}
			else{
				return false;
			}
		}
		
		
	</script>
  </head>
  
  <body>
    <!--main_top-->
<table width="99%" border="0" cellspacing="0" cellpadding="0" id="searchmain">
  <tr>
    <td width="99%" align="left" valign="top">您的位置：管理员管理</td>
  </tr>
  <tr>
    <td align="left" valign="top">
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="search">
  		<tr>
   		 <td width="90%" align="left" valign="middle">
	         <form method="post" action="">
	         <span>管理员：</span>
	         <input type="text" name="" value="" class="text-word">
	         <input name="" type="button" value="查询" class="text-but">
	         </form>
         </td>
  		  <td width="10%" align="center" valign="middle" style="text-align:right; width:150px;">
  		  <a href="background/addManager.jsp" target="mainFrame" onFocus="this.blur()" class="add">新增管理员</a></td>
  		</tr>
	</table>
    </td>
  </tr>
  <tr>
    <td align="left" valign="top">
      <%
      	ArrayList<Manager> managerList = (ArrayList<Manager>)request.getAttribute("managers"); 
		int sum = 10;	/*每页显示数据条数*/  
		int managerCount = (Integer)request.getAttribute("managerCount"); 
		int pageCount = managerCount%sum==0?managerCount/sum:managerCount/sum+1;		//总页数
		int pageIdx = 1;			//当前页数
		if(request.getParameter("pageIdx")!=null){
			pageIdx = Integer.parseInt(request.getParameter("pageIdx"));
		}
      %>
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="main-tab">
      <tr>
        <th align="center" valign="middle" class="borderright">编号</th>
        <th align="center" valign="middle" class="borderright">管理帐号</th>
        <th align="center" valign="middle" class="borderright">密码</th>
        <th align="center" valign="middle" class="borderright">账户状态</th>
        <th align="center" valign="middle">操作</th>
      </tr>
      <%if(managerList!=null)for(int idx = (pageIdx-1)*sum;idx < managerList.size()&&idx<pageIdx*sum;idx++){ %>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="center" valign="middle" class="borderright borderbottom"><%=managerList.get(idx).getManagerid() %></td>
        <td align="center" valign="middle" class="borderright borderbottom"><%=managerList.get(idx).getManagername() %></td>
        <td align="center" valign="middle" class="borderright borderbottom"><%=managerList.get(idx).getPasswd() %></td>
        <td align="center" valign="middle" class="borderright borderbottom"><%=managerList.get(idx).getMstate().equals("1")?"已启动":"已锁定" %></td>
        <td align="center" valign="middle" class="borderbottom"><a href="ManagerServlet?type=edit&id=<%=managerList.get(idx).getManagerid()%>" target="mainFrame" onFocus="this.blur()" class="add">编辑</a><span class="gray">&nbsp;|&nbsp;</span>
        <a href="ManagerServlet?type=delete&id=<%=managerList.get(idx).getManagerid() %>" target="mainFrame" onFocus="this.blur()" onclick="return del()" class="add">删除</a></td>
      </tr>
      <%} else out.print("null");%>

    </table></td>
    </tr>
  <tr>
  	
    <td align="left" valign="top" class="fenye"><%= managerCount%>条数据&nbsp;<%=pageIdx %>/<%=pageCount %> 页&nbsp;&nbsp;
    <a href="ManagerServlet?type=findAll" target="mainFrame" onFocus="this.blur()">首页</a>&nbsp;&nbsp;
    <%if(pageIdx>1){%>
    	<a href='ManagerServlet?type=findAll&pageIdx=<%=pageIdx-1 %>' target='mainFrame' onFocus='this.blur()''>上一页</a>&nbsp;&nbsp;
    <%} %>
    <%if(pageIdx<pageCount){%>
    	<a href='ManagerServlet?type=findAll&pageIdx=<%=pageIdx+1 %>' target='mainFrame' onFocus='this.blur()''>下一页</a>&nbsp;&nbsp;
    <%} %>
    <a href='ManagerServlet?type=findAll&pageIdx=<%=pageCount %>' target="mainFrame" onFocus="this.blur()">尾页</a></td>
  </tr>
</table>
  </body>
</html>
