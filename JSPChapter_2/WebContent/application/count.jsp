<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在线人数</title>
</head>
<body>
	<%
		int count = 0;//计数变量
		//获取num的值，判断是否为空，如果空，第一次访问，给null赋值1
		if(application.getAttribute("num")==null){
			count = 1;
		}else{
			//获取application对象中的计数器的值
			//+1
			count = (Integer)application.getAttribute("num");
			count +=1;
		}
		//每次访问，将之前的计数数值+1，将新的数值保存到application
	/*	
		count = 1; 
		count +=1;
	*/	
		//将count重新保存
		application.setAttribute("num",count);
	%>
	您是第<%=application.getAttribute("num") %>位访问用户
</body>
</html>