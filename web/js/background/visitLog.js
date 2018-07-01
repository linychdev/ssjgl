Date.prototype.format = function(format)
{
 var o = {
 "M+" : this.getMonth()+1, //month
 "d+" : this.getDate(),    //day
 "h+" : this.getHours(),   //hour
 "m+" : this.getMinutes(), //minute
 "s+" : this.getSeconds(), //second
 "q+" : Math.floor((this.getMonth()+3)/3),  //quarter
 "S" : this.getMilliseconds() //millisecond
 }
 if(/(y+)/.test(format)) format=format.replace(RegExp.$1,
 (this.getFullYear()+"").substr(4 - RegExp.$1.length));
 for(var k in o)if(new RegExp("("+ k +")").test(format))
 format = format.replace(RegExp.$1,
 RegExp.$1.length==1 ? o[k] :
 ("00"+ o[k]).substr((""+ o[k]).length));
 return format;
}

$(function () {
	 var currentDate = new Date();//获取当前时间
	 var defBeginDate = new Date();
	 defBeginDate.setDate(defBeginDate.getDate()-30);
	 
	 layui.use(['laydate','layer'], function(){
		var laydate = layui.laydate;
		var layer = layui.layer;
		laydate.render({
			    elem: '#begin-date'
			    ,min: -30
			    ,max: 0
			    ,value: beginDate
			    ,isInitValue: true
			    ,done: function(value, date){
			        if(checkBeginEnd()){
			        	//向后台发送请求,刷新页面
						 reloadPage();
			        }else{
			        	layer.msg("开始时间必须小于结束时间！",{time:1000}, function(){
			        		$("#begin-date").val(defBeginDate.format('yyyy-MM-dd'));
			        	});
			        }
			     }
			  });

		laydate.render({
			elem: '#end-date'
				,min: -30
				,max: 0
				,value: endDate
			    ,isInitValue: true
				,done: function(value, date){
					 if(checkBeginEnd()){
				         //向后台发送请求,刷新页面
						 reloadPage();
				        }else{
				        	layer.msg("结束时间必须大于开始时间！", {time:1000}, function(){
				        		$("#end-date").val(currentDate.format('yyyy-MM-dd'));
				        	});
				        }
				 }
		});
	});
	
	function checkBeginEnd(){
		var begin = $("#begin-date").val();
		var end = $("#end-date").val();
		var beginDate = new Date(begin);
		var endDate = new Date(end);
		if(endDate.getTime() >= beginDate.getTime()){
			return true;
		}else{
			return false;
		}
	}
	
	function reloadPage(){
		var beginDate = $("#begin-date").val();
		var endDate = $("#end-date").val();
		$(location).attr("href", "visiterPage?beginDate="+ beginDate + "&endDate="+endDate);
	}
	
	var worldMapContainer = document.getElementById('trendFigure');

	//用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
	var resizeWorldMapContainer = function () {
	    worldMapContainer.style.width = window.innerWidth+'px';
	};
	//设置容器高宽
	resizeWorldMapContainer();
	var xAxisData = new Array();
	var yAxisData = new Array();
	if(ymlllListJson.length > 0){
		$.each(ymlllListJson,function(index,item){
			xAxisData.push(item.dateStr);
			yAxisData.push(item.total);
		});
	}else{
		var xAxisData = ["暂无数据"]
		var yAxisData = [0];
	}
	
	// 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(worldMapContainer);
 
        // 指定图表的配置项和数据
        var option = {
    title : {
        text: '页面浏览量',
		textStyle:{
		  color:'#000000'
		},
		left:'30px',
    },
    tooltip : {
        trigger: 'axis'
    },
 
    calculable : true,
    xAxis : [
        {
            type : 'category',
            boundaryGap : false,
            data : xAxisData
        }
    ],
    yAxis : [
        {
            type : 'value'
        }
    ],
    grid :  {  
        left: '65',
        bottom : '20'
    },
   series : [
       
        {
            name:'访问量',
            type:'line',
            smooth:true,
            itemStyle: {normal: {areaStyle: { color:'#00ccff', }}},
			itemStyle: {  
                        normal: {  
                            color: '#0099ff'  
                        }  
                    },  
                    areaStyle: {  
                        normal: {  
                            color:'#0099ff'   
                            }
						},
            data:yAxisData
        }
    ]
};
                    
       // 使用刚指定的配置项和数据显示图表。
       myChart.setOption(option); 
       //用于使chart自适应高度和宽度
       window.onresize = function () {
       //重置容器高宽
       resizeWorldMapContainer();
       myChart.resize();
   };
});