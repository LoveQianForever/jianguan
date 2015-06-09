(function($){

// focus img change // start

$.fn.changeImg=function(obj){
	var thisObj=this;
	var defaults={
			drt:"top",
			transition:false,
			time:2000,
			path:"",
			auto:true,
			nav:false,moveVal:0
		}
	var obj=$.extend(defaults,obj);//alert(obj.drt)
	var auto=obj.auto;
	var drt=obj.drt;
	var atime=600;
	var tOut=obj.time;
	var tId,moveVal=-obj.moveVal,it=1; //alert(moveVal);
	var loop=false;
	var chgT=false;
	//////
	var nav=thisObj.children('.js_numNav');
	var title=thisObj.children('.js_title').children('a').get()[0]; //alert(title);
	var navA=nav.children('a');
	var total=navA.length;
	if(obj.navOpacity){nav.css('opacity',obj.navOpacity);}
	var imglst=thisObj.children('.js_imgLst');
	if(loop){ imglst.children('a:first').clone().appendTo(imglst); }
	switch(drt){
		case "top":
			cssName='margin-top';
			if(!moveVal)moveVal=-thisObj.innerHeight();
		break;
		case "left":
			cssName='margin-left';
			if(!moveVal)moveVal=-thisObj.innerWidth();
		break;
	}

	function ctl(){
		clearTout();
		//$('#msg').html("total "+total+" it: "+it);
		if(!loop){it=(it<total)?++it:1;}
		else{it=(it!=total+1)?++it:0;}
		addCur(it);
		change(it);
		autoPlay();
	}
	function change(num){
		//change img
		clearAnimate();
		if(drt=='top'||drt=='bottom'){
			if(num==total+1){
					addCur(1);
					imglst.animate({marginTop:((num-1)*moveVal)},atime,"",function(){ if(loop){ init(); } });
			}else{
					imglst.animate({marginTop:((num-1)*moveVal)},atime,"",function(){ it=num; });
			}
		
		}else{
			if(num==total+1){
					addCur(1);
					imglst.animate({marginLeft:((num-1)*moveVal)},atime,"",function(){ if(loop){ init(); } });
			}else{
					imglst.animate({marginLeft:((num-1)*moveVal)},atime,"",function(){ it=num; });
			}
		
		}
	}
	//event
	function init(){
		imglst.css(cssName,0+'px');
		it=1;		
	}
	function addCur(n){	
			var curA=navA.removeClass('cur').eq(n-1).get()[0];
			/*if(curA.className)*/curA.className='cur';
			if(!title)return;
			title.title=curA.title;
			title.innerHTML=curA.title;
			title.href=imglst.children('a').eq(n-1).attr('href');
		}
	function clearAnimate(){ imglst.stop(true,chgT); }
	function clearTout(){ if(tId){clearTimeout(tId);} }
	function autoPlay(){ if(auto){ clearTout; tId=setTimeout(ctl,tOut); } }	
	thisObj.hover(function(){ clearTout(); },function(){ autoPlay(); })
	navA.bind('mouseenter',function(){
		clearAnimate();
		addCur(this.name);
		change(this.name);
	})
	addCur(1);
	autoPlay();

}

// focus img change // end

})(jQuery);