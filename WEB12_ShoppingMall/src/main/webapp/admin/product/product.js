function go_wrt(){
	document.frm.action = "shop.do?command=adminProductWriteForm";
	document.frm.submit();
}

function go_mov(){
	location.href="shop.do?command=adminProductList";
}

function go_save(){
	var theForm = document.frm;
	if(theForm.kind.value==""){
		alert("상품분류를 선택하세요.");
		theForm.kind.focus();
	}else if(theForm.name.value==""){
		alert("상품명을 입력하세요.");
		theForm.name.focus();
	}else if(theForm.price1.value=""){
		alert("원가를 입력하세요");
		theForm.price1.focus();
	}else if(theForm.price2.value=""){
		alert("판매가를 입력하세요");
		theForm.price2.focus();
	}else if(theForm.content.value=""){
		alert("상품상세를 입력하세요");
		theForm.content.focus();
	}else if(theForm.image.value=""){
		alert("상품이미지를 입력하세요");
		theForm.image.focus();
	}else{
		theForm.action = "shop.do?command=adminProductWrite";
		theForm.submit();
	}
}