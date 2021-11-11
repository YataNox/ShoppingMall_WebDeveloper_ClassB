function go_wrt(){
	document.frm.action = "shop.do?command=adminProductWriteForm";
	document.frm.submit();
}

function go_mov(){
	location.href="shop.do?command=adminProductList";
}