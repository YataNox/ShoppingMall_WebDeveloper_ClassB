<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>findZipNum</title>
		<style type="text/css">
			@import url('http://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap');
			body{
				font-family: Verdana; background: #FDE8FF;
			}
			#popup{padding: 0 10px;}
		</style>
	</head>
	<body>
		<div id="popup">
			<h1>우편번호검색</h1>
			<form method="post" name="formm" action="shop.co">
				<input type="hidden" name="command" value="findZipNum">
					동 이름 : <input name="dong" type="text">
					<input type="submit" value="찾기" class="submit">
			</form>
		</div>
	</body>
</html>