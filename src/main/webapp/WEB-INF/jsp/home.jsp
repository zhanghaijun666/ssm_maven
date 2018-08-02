<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页面</title>
<script src="static/jquery-3.3.1.js"></script>

<style type="text/css">
html, body {
	height: 100%;
	margin: 0px 0px 0px 0px;
	min-height: 500px;
	min-width: 1000px;
}

body>div {
	width: 100%;
}

.headClass {
	height: 13%;
	border-bottom: 1px solid #000;
}

.bodyClass {
	height: 80%;
}

.footClass {
	height: 5%;
	border-top: 1px solid #000;
}

.leftClass {
	width: 18%;
	height: 100%;
	float: left;
	border-right: 1px solid #000;
}

.rightClass {
	width: 81%;
	height: 100%;
	float: left;
}

.rightClass table {
	border-collapse: collapse;
	width:100%;
	
}

.rightClass table, .rightClass table tr th, .rightClass table tr td {
	border: 1px solid blue;
	text-align: center;
}

#deleteId{
	width:70%;
	height:80%;	
	text-align: center; 
	
}
.rightClass > div{
	width: 100%;
	height: 38px;
}
</style>
<script type="text/javascript">
function addUser(){
	window.location.href = '<%=path%>/adduser';
}
</script>
<script type="text/javascript">
function deleteUser(userId){
	window.location.href = '<%=path%>/deleteuser.do?userId='+userId;
}
</script>
</head>
<body>
	<div class="headClass">
		<span>欢迎【${sessionScope.user.name}】</span>
	</div>
	<div class="bodyClass">
		<div class="leftClass"></div>
		<div class="rightClass">
			<div>
				<input type="button" value="添加用户" onclick="addUser()"/>
			</div>
			<table>
				<thead>
					<tr>
						<th>登录名</th>
						<th>姓名</th>
						<th>电话</th>
						<th>邮箱</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
			     	<c:forEach items="${allUsers}" var="user" begin="0">
						<tr>
							<td>${user.name}</td>
							<td>${user.fullName}</td>
							<td>${user.tel}</td>
							<td>${user.email}</td>
							<td><input type="button" value="删除" id="deleteId" onclick="deleteUser('${user.id}')"/></td>
						</tr>
			     	</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="footClass">
			
		</div>
	</body>
	<script type="text/javascript">
		window.onload=function (){
		}
	</script>
</html>