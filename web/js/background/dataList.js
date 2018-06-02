$(function () {
//处理分页
  layui.use(['laypage', 'layer'], function(){
  var laypage = layui.laypage, layer = layui.layer;
  laypage.render({
	    elem: 'paging-div'
	    ,count: record //从服务器获取
	    ,layout: ['count', 'prev', 'page', 'next', 'limit', 'refresh', 'skip']
  		,curr : pageIndex
  		,limit : pageSize
  		,limits : [15, 30, 50, 100]
	    ,jump: function(obj){
	     if(obj.curr != pageIndex){
	    	 $(location).attr("href", "dataList?pageIndex="+obj.curr + "&pageSize="+obj.limit);
	     }
	    }
	  });
	});
});
