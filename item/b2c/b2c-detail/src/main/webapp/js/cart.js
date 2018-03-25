$(function() {
	if(document.cookie.indexOf('user_token=')!=-1){
		$.getScript("../js/userData.js");
	}
	$(".goods_sub_gou").click(function() {
		//生成cookie
		if(document.cookie.indexOf('user_token=')==-1){
			if(document.cookie.indexOf('out_cart_token=')==-1){
				var cookieUUID=Math.uuid();
				$.cookie('out_cart_token',cookieUUID, { expires: 7,path:'/' }); 
			}
		}else{
			$.cookie('in_cart_token',user.id, { expires: 7,path:'/' }); 
		}
		//向后台传数据，生成订单
		var param = new Object();
		param.productId=$("#productId").val();
		param.count=$("#good_nums").val();
		$.ajax({
				type : 'GET',
				dataType :'jsonp',
				data : param,
				jsonpCallback : 'Handle',
				url: 'http://localhost:8093/b2c-cart/test'
			})
		return false;
	})

})

function Handle(data){
	window.location.href="http://localhost:8093/b2c-cart/gotoCart";
}