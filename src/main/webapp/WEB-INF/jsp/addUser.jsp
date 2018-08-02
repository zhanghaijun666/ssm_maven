<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加用户信息</title>
<script src="static/jquery-3.3.1.js"></script>
<script type="text/javascript">
	function quit(){
		window.history.back(-1);
	}
</script>
<style type="text/css">
body {
	margin: auto;
	margin-top: 10%;
}

.divClass {
	margin: auto;
	margin-top: 10%;
	margin-bottom: 10px;
	border: 1px solid #000;
	text-align: center;
	height: 300px;
	width: 400px;
}

.button {
	margin-left: 5%;
	width: 80px;
}
</style>
</head>
<body>
	<form action="adduser.do" method="post">
		<div class="divClass">
			<div>
				<h2>添加用户信息</h2>
			</div>
			<div>
				<label>用户姓名：</label> 
				<input type="text" value="" name="user" /><br><br> 
				<label>用户密码：</label>
				<input type="text" value="" name="password" /><br><br> 
				<label>用户年龄：</label> 
				<input type="text" value="" name="age" /><br> <br> 
				<label>用户班级：</label>
				<input type="text" value="" name="grade" /><br> <br>
			</div>
			<div>
				<input type="submit" class="button" value="确认"/> 
				<input type="button" class="button" onclick="quit()" value="取消" /> 
				<input type="reset" class="button" value="重置" />
			</div>
		</div>
	</form>
</body>
<script type="text/javascript">
		window.onload=function (){
		    var error="${errormsg}";
			if(error){
				alert(error);
			}
		}
	</script>
</html>