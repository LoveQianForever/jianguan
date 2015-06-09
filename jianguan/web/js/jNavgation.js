
/*****************************************
	jNavigation by hanJun
	Primary use：head menu and left
*****************************************/
(function ($) {
	jQuery.jnav = {
		bindHeadNavigationEvent:function (par) {
			$("#_Navigation li").bind("click", function () {
				$(".liOver").removeClass("liOver");
				$(this).attr("class", "liOver");
				loadLeftMenu($(this).attr("id"));
			});
			$("#_Navigation li").bind("mounseover", function () {
				$(this).attr("class", "liOver");
			});
			$("#_Navigation li").bind("mounseout", function () {
				$(this).removeClass("liOver");
			});
			$("#_Navigation li:first").click();
		}, 
		bindLeftNavigationEvent:function () {
			$(".verticalTabpageBar div").bind("click", function () {
				$(".divtabCurrent").attr("class", "divtab");
				$(this).attr("class", "divtabCurrent");
				$("#_MainArea").attr("src", $(".divtabCurrent").attr("url"));
				document.getElementById("_MainArea").location=$(".divtabCurrent").attr("url");
			});
			$(".verticalTabpageBar div").bind("mounseover", function () {
				$(this).attr("class", "divtabHover");
			});
			$(".verticalTabpageBar  div:first").click();
		}
	};
})(jQuery);

