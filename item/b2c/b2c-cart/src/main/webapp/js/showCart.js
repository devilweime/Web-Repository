$(function() {
	$.ajax({
		url:'http://localhost:8093/b2c-cart/showCart',
		type:'post',
		success:function(data){
			var html="";
			if(data!=""){
				var carItem = eval("(" + data + ")");
				for (var i = 0; i < carItem.length; i++) {
					html+='<tr><td class="gwc_list_pic"><a href=""><img src="'+carItem[i].product.images+'" /></a></td>';
					html+='<td class="gwc_list_title"><a href="">'+carItem[i].product.name+'</a></td>';
					html+='<td class="gwc_list_danjia"><span>￥<strong id="danjia_001">'+carItem[i].product.price+'</strong></span></td>';
					html+='<td class="gwc_list_shuliang"><span><a class="good_num_jian this_good_nums" did="danjia_001" xid="xiaoji_001" ty="-" valId="goods_001" href="javascript:void(0);">-</a><input type="text" value="'+carItem[i].count+'" id="goods_001" class="good_nums" /><a href="javascript:void(0);" did="danjia_001" xid="xiaoji_001" ty="+" class="good_num_jia this_good_nums" valId="goods_001">+</a></span></td>';
					html+='<td class="gwc_list_xiaoji"><span>￥<strong id="xiaoji_001" class="good_xiaojis">'+(carItem[i].count*carItem[i].product.price)+'</strong></span></td>';
					html+='<td class="gwc_list_caozuo"><a href="">收藏</a><a href="javascript:void(0);" class="shop_good_delete">删除</a></td></tr>';
				}
			}else{
				html+='您还没有购买商品';
				
			}
			$("tbody").html(html);
			totalPrice();
		}
	});
	
	function totalPrice() {
		var totalPrice = 0;
		$(".good_xiaojis").each(function() {
			totalPrice += parseFloat($(this).html());
		})
		$("#good_zongjia").html(totalPrice);
	}
	
})