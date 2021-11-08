<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>viewId</title>
	</head>
	<body>
		<h2>Id 찾기</h2>
		<table align="center" bgcolor="#FDE8FF" cellspacing="1" width="400">
				<tr align="center" bdcolor="white">
					<td width="430"><h3>성명 : ${member.name}</h3></td>
				</tr>
				
				<tr align="center" bdcolor="#FDE8FF">
					<td width="430"><h3>전화번호 : ${member.phone}</h3></td>
				</tr>
				
				<tr align="center" bdcolor="#FDE8FF">
					<td width="430"><h3>조회한 회원의 아이디는 ${member.id}입니다.</h3>
					<input type="button" value="로그인 창으로" onclick="">
					<input type="button" value="비밀번호 찾기">
					</td>
				</tr>
				
			</table>
	</body>
</html>