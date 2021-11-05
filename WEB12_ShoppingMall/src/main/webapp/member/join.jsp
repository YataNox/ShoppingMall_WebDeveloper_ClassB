<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<%@ include file="sub_img.html" %>
<%@ include file="sub_menu.html" %>

<article>
	<form method="post" name="joinForm">
		<input type="hidden" name="command" value="join">
			<fieldset>
				<legend>Basic Info</legend>
				<label>User ID</label><input type="text" name="id" size="12"><input type="hidden" name="reid">
				<input type="button" value="중복 체크" class="dup" onclick="idcheck()"><br><br>
				<label>Password</label><input type="password" name="pwd"><br><br>
				<label>Retype Password</label><input type="password" name="pwdCheck"><br><br>
				<label>Name</label><input type="text" name="name"><br><br>
				<label>Email</label><input type="text" name="email"><br><br>
			</fieldset>
			
			<fieldset>
				<legend>Optional</legend>
				<label>Zip Code</label><input type="text" name="zip_num" size="10">
				<input type="button" value="주소 찾기" class="dup" onclick="post_zip()"><br><br>
				<label>Address</label><input type="text" name="addr1" size="50"><br><br>
				<label>&nbsp;</label><input type="text" name="addr2" size="25"><br><br>
				<label>Phone Number</label><input type="text" name="phone"><br><br>
			</fieldset>
			
			<div class="clear"></div>
			<div id="buttons">
				<input type="button" value="회원가입" class="submit" onclick="go_save()">
				<input type="reset" value="취소" class="cancel">
			</div>
	</form>
</article>


<%@ include file="../footer.jsp"%>