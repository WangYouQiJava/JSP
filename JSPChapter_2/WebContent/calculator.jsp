<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input value="">
	<select class="MathCode">
		<option value="+">+</option>
		<option value="-">-</option>
		<option value="*">*</option>
		<option value="/">/</option>
		<option value="%">%</option>
	</select>
	<input value="">=
	<input value="">
	<button class="btn_qr">确认</button>

	<script type="text/javascript" src="./plugins/jquery-3.5.1.js"></script>
	<script>
	$(function(){
		$(".btn_qr").click(function(){
			var one= parseFloat($("input:eq(0)").val());
			var two= parseFloat($("input:eq(1)").val());
			var code =$(".MathCode").val();
			switch(code){
				case '+':
					var results =  one + two;
				break;
				case '-':
					var results =  one - two;
				break;
				case '*':
					var results =  one * two;
				break;
				case '/':
					var results =  one / two;
				break;
				case '%':
					var results =  one % two;
				break;
			}
					
			$("input:eq(2)").val(results);
		})
	})
	</script>
</body>
</html>