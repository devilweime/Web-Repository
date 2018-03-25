$(function() {
	/* <!-- 分类导航 --> */
	$.ajax({
				type : 'GET',
				dataType : 'jsonp',
				jsonpCallback : 'callback',
				url : 'http://localhost:8091/b2c-cache/loginCheck',
			})
})
var user = null;
function callback(data) {
	user = data;
//处理代码块
}
