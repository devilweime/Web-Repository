$(function() {
	$("#myInfo").click(function() {
		window.location.href = baseUrl+"/mailbag/page/myinfo";
	});
})

function toReceiveMailbag() {
	window.location.href = baseUrl+"/mailbag/page/toReceiveMailbag";
}

function getMailbagDetails(mailbagId){
	window.location.href = baseUrl+"/mailbag/page/mailbagDetails/"+mailbagId;
}

(function($){
    $.fn.serializeJson=function(){
        var serializeObj={};
        var array=this.serializeArray();
        var str=this.serialize();
        $(array).each(function(){
            if(serializeObj[this.name]){
                if($.isArray(serializeObj[this.name])){
                    serializeObj[this.name].push(this.value);
                }else{
                    serializeObj[this.name]=[serializeObj[this.name],this.value];
                }
            }else{
                serializeObj[this.name]=this.value; 
            }
        });
        return serializeObj;
    };
})(jQuery);