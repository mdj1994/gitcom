 $(document).ready(function(){
	
  $("#header_container .btn_search").click(function(){
	if($(".search_wrap").css("display")=="none"){
	  $("#header_container .btn_search,#header_container .search_wrap").addClass("on");
	  $("").show();
	  $("#header_container .search_wrap input").focus();
	}else{
	  $("#header_container .btn_search,#header_container .search_wrap").removeClass("on");
	}
	return false;
  });

 });