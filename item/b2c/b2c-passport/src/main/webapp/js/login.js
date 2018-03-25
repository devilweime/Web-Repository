$(function(){
	$(".submit").click(function () {
		$.ajax({
			url:'http://localhost:8092/b2c-passport/login',
			type:'post',
			data:$(".form-bd form").serialize(),
			success:function(msg){
				if ("ok" == msg) {
					window.location.href="http://localhost:8081/b2c-front/page/index";
				} else {
					alert(msg);
				}
			}
		})
	})
})