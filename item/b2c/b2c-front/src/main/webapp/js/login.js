$(function() {
	/* <!-- 分类导航 --> */
	$.ajax({
				type : 'GET',
				dataType : 'jsonp',
				jsonpCallback : 'callback',
				url : 'http://localhost:8091/b2c-cache/loginCheck',
			})
})
function callback(data) {
	var html = "";
	if(data!=null){
		html+='[<a href="">'+data.username+'</a>][<a href="">注销</a>]'
	}else{
		html+='[<a href="">登录</a>][<a href="">注册</a>]';
	}
	$(".shop_hd_topNav_all_left p").append(html);
//处理代码块
}
