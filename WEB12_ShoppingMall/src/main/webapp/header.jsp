<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Header</title>
		<link href="css/shopping.css" rel="stylesheet">
		<script type="text/javascript" src="member/member.js"></script>
		<script type="text/javascript" src="mypage/mypage.js"></script>
	</head>
	<body>
		<div id="wrap">
			<header><!-- 로고, 주메뉴, 카테고리 메뉴 등이 표시되는 영역 -->
				<div id="logo"> <!-- 메인로고 시작 -->
					<a href="shop.do?command=index">
						<img src="images/logo.png" width="180" height="100">
					</a>
				</div> <!-- 메인로고 끝 -->
				
				<nav id="top_menu"> <!-- 상단 메뉴 시작 : 로그인 CART MyPage 등 -->
					<ul>
						<c:choose> <!-- 로그인 여부에 따라 보여지는 상단 메뉴가 변화 -->
							<c:when test="${empty loginUser}"> <!-- 로그인 한 유저가 없을 시 -->
								<li><a href="shop.do?command=loginForm">Login</a></li>
								<li><a href="shop.do?command=contract">Join</a></li>
							</c:when>
							<c:otherwise> <!-- 로그인을 했을 시 -->
								<li>${loginUser.name}(${loginUser.id})</li>
								<li><a href="shop.do?command=mEditForm&id=${loginUser.id}">정보수정</a></li>
							</c:otherwise>
						</c:choose>
						<li><a href="shop.do?command=cartList">Cart</a></li>
						<li><a href="shop.do?command=myPage">My Page</a></li>
						<li><a href="shop.do?command=qnaList">Q&amp;A (1:1)</a></li>
					</ul>
				</nav> <!-- 상단 메뉴 끝 -->
				
				<nav id="catagory_menu"> <!-- 카테고리 메뉴 시작 Heels Boots Sandals 등 -->
					<ul>
						<li><a href="shop.do?command=category&kind=1">Heels</a></li>
						<li><a href="shop.do?command=category&kind=2">Boots</a></li>
						<li><a href="shop.do?command=category&kind=3">Sandals</a></li>
						<li><a href="shop.do?command=category&kind=4">Sneakers</a></li>
						<li><a href="shop.do?command=category&kind=5">Sleeper</a></li>
						<li><a href="shop.do?command=category&kind=6">On Sale</a></li>
					</ul>
				</nav> <!-- 카테고리 메뉴 끝 -->
			</header>
		
