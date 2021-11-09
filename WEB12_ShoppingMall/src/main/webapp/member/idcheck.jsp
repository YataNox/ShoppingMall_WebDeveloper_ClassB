<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>IDCheck</title>
		<link href="css/shopping.css" rel="stylesheet">
		<script src="member/member.js"></script>
		<style type="text/css">
			body{background-color: #FDE8FF;}
		</style>
	</head>
	<body>
		<div id="wrap" style="margin:20px 0">
			<h1>ID 중복확인</h1>
			<form action="shop.do" method="post" name="idCheckForm">
				<input type="hidden" name="command" value="idCheckForm">
				User ID <input type="text" name="id" value="${id}">
				<input type="submit" value="검색" class="submit"><br>
				
				<div style="margin-top:20px">
					<c:if test="${result == 1}">
						<script type="text/javascript">opener.document.joinForm.id.value="";</script>
						${id}는 이미 사용중인 아이디입니다.
					</c:if>
					<c:if test="${result == -1}">
						${id}는 사용 가능한 ID입니다.
						<input type="button" value="사용" class="cancel" onClick="idok('${id}');">
					</c:if>
				</div>
			</form>
		</div>
	</body>
</html>