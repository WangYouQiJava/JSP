<%@page import="com.test.entity.PageBean"%>
<%@page import="com.test.entity.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
	<center>
	<h1>全部用户</h1>
	<table border="1px">
		<tr style="width: 50px;height: 30px">
			<th>用户名</th>
			<th>密码</th>
			<th>年龄</th>
		</tr>
		<%
			/* List<User> items = (List)request.getAttribute("items"); */
			PageBean pages = (PageBean)request.getAttribute("page");
			List<User> userall = pages.getusers();
			//总页数
			int totalPageCount = pages.getTotalPageCount();
			//数据总条数
			int totalPageCounts = pages.getTotalPageCounts();
			//当前页数
			int currPageNo = pages.getCurrPageNo();
			for(User user:userall){
		%>
		<tr>
			<td style="width: 200px"><%=user.getUname() %></td>
			<td style="width: 200px"><%=user.getUpwd() %></td>
			<td style="width: 200px"><%=user.getage() %></td>
		</tr>
		<%	
			}
		%>
	</table>
		<%
			if(currPageNo>1){
		%>
		<a href="ShowUsersPageServlet?currPageNo=1">首页</a>
		<a href="ShowUsersPageServlet?currPageNo=<%=currPageNo-1 %>">上一页</a>
		<%
			}
			if(currPageNo<totalPageCounts){
		%>
		<a href="ShowUsersPageServlet?currPageNo=<%=currPageNo+1 %>">下一页</a>
		<a href="ShowUsersPageServlet?currPageNo=<%=totalPageCount %>">末页</a>
		<%
			}
		%>
		共<%=totalPageCount %>条记录
		当前页数：[<%=currPageNo %>/<%=totalPageCounts %>]
</body>
</html>