$(function(){
	$(".downLoadFile").on("click",function(){
		var fileId = $(this).attr("id");
		$.post(contextPath + "/manage/downloadPotentialsFile", {
			potentialsFileId : fileId
		  }, function(data) {
			  $("#funName").val(data.fun.cName);
			  $("#funDesc").val(data.fun.cDescription);
			  $("#funEdit").html(data.fun.cFormulaHtml);
			  $("#addFunDiv").removeClass("display_none");
		  }, "json");
	});
});