<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>findIdconfirmNumber</title>
		<style type="text/css">
			body{background-color: #FDE8FF;}
		</style>
	</head>
	<body>
		<h2>Id 찾기</h2>
		<form action="shop.do" name="frm" method="post">
			<input type="hidden" name="command" value="findIdStep2">
			<table align="center" bgcolor="#FDE8FF" cellspacing="1" width="400">
				<tr align="center" bdcolor="#FDE8FF">
					<td width="430"><h3>성명 : ${member.name}</h3>
					<input type="hidden" name="name" value="${member.name}">
					</td>
				</tr>
				
				<tr align="center" bdcolor="#FDE8FF">
					<td width="430"><h3>전화번호 : ${member.phone}</h3>
					<input type="hidden" name="name" value="${member.phone}">
					<input type="hidden" name="id" value="${member.id}">
					</td>
				</tr>
				
				<tr align="center" bdcolor="#FDE8FF">
					<td width="430"><h3>인증번호 
					<input type="text" name="confirmNum"></h3> 전송받은 번호를 입력하세요
					<br>${msg}<br><input type="submit" value="인증번호 확인">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>