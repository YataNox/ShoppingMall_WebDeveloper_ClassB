function go_cart(){
	if(document.formm.quantity.value==""){
		alert("수량을 입력하여 주세요.");
		document.formm.quantity.focust();
	}else{
		document.formm.action = "shop.do?command=cartInsert";
		document.formm.submit();
	}
}