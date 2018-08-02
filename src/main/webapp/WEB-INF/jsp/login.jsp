<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>欢迎登陆</title>
		<style type="text/css">
			body{
				min-height: 300px;
				min-width: 500px;
				background-color: #eee;
			}
			.loginClass{
				border: 1px solid #000;
				width: 500px;
				height: 300px;
				margin: auto;
				margin-top: 7%;
				background-color: #fff;
			}
			.loginClass > div {
				text-align: center;
				width: 70%;
				margin: auto;
				margin-top: 20px;
				min-height: 32px;
				font-size: 20px;
			}
			.loginClass input{
				height: 18px;
			}
			#loginId{
				width: 70%;
				height: 36px;
			}
		</style>
	</head>
	<body>
		<form action="login.do" method="post">
			<div class="loginClass">
				<div><h2>登陆</h2></div>
				<div>
					<label>用户：</label>
					<input type="text" name="username" />
				</div>
				<div>
					<label>密码：</label>
					<input type="password" name="password"/>
				</div>
				<div>
					<input type="submit" value="登陆" id="loginId"/>
				</div>
			</div>
		</form>
	</body>
	<script type="text/javascript">
		window.onload=function (){
		    var error="${error}";
			if(error){
				alert(error);
			}
		}
	</script>
</html>