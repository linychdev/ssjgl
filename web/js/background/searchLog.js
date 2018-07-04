$(function () {
    // 基于准备好的dom，初始化echarts实例
    var myChartHotSearch = echarts.init(document.getElementById('hotSearch'));

    var xAxisDataHotSearch = new Array();
	var yAxisDataHotSearch = new Array();
	if(hotSearchListJson.length > 0){
		$.each(hotSearchListJson,function(index,item){
			xAxisDataHotSearch.push(item.searchText);
			yAxisDataHotSearch.push(item.total);
		});
	}else{
		var xAxisDataHotSearch = ["暂无数据"]
		var yAxisDataHotSearch = [0];
	}
	
    // 指定图表的配置项和数据
    var optionHotSearch = {
		
		calculable : true,
		xAxis : [
		    {
		        type : 'category',
		        data : xAxisDataHotSearch
		    }
		],
		yAxis : [
		    {
		        type : 'value'
		    }
		],
		series : [
		    {
		        name:'搜索量',
		        type:'bar',
		        barWidth : 30,
		        data:yAxisDataHotSearch,
		        itemStyle: {   
	                normal:{  
	                	color:function(d){return "#"+Math.floor(Math.random()*(256*256*256-1)).toString(16);}
	                },
	                emphasis: {
	                        shadowBlur: 10,
	                        shadowOffsetX: 0,
	                        shadowColor: 'rgba(0, 0, 0, 0.5)'
	                }
	            },
		      
		    },
    
	    ]
};           
    // 使用刚指定的配置项和数据显示图表。
    myChartHotSearch.setOption(optionHotSearch);
    
    
    // 基于准备好的dom，初始化echarts实例
    var myChartHotVisit = echarts.init(document.getElementById('hotVisit'));

    var xAxisDataHotVisit = new Array();
	var yAxisDataHotVisit = new Array();
	if(hotPotenListJson.length > 0){
		$.each(hotPotenListJson,function(index,item){
			xAxisDataHotVisit.push(item.searchText);
			yAxisDataHotVisit.push(item.total);
		});
	}else{
		var xAxisDataHotVisit = ["暂无数据"]
		var yAxisDataHotVisit = [0];
	}
    
    // 指定图表的配置项和数据
    var optionHotVisit = {

		calculable : true,
		xAxis : [
		    {
		        type : 'category',
		        data : xAxisDataHotVisit
		    }
		],
		yAxis : [
		    {
		        type : 'value'
		    }
		],
		series : [
		    {
		        name:'搜索量',
		        type:'bar',
		        barWidth : 30,
		        data:yAxisDataHotVisit,
		        itemStyle: {   
	                normal:{  
	                	color:function(d){return "#"+Math.floor(Math.random()*(256*256*256-1)).toString(16);}
	                },
	                emphasis: {
	                        shadowBlur: 10,
	                        shadowOffsetX: 0,
	                        shadowColor: 'rgba(0, 0, 0, 0.5)'
	                }
	            },
		      
		    },
		   
		]
};           
    // 使用刚指定的配置项和数据显示图表。
   myChartHotVisit.setOption(optionHotVisit); 
   
   
    // 基于准备好的dom，初始化echarts实例
    var myChartInvalidSearch = echarts.init(document.getElementById('invalidSearch'));

    var xAxisDataInvalidSearch = new Array();
	var yAxisDataInvalidSearch = new Array();
	if(invalidSearchListJson.length > 0){
		$.each(invalidSearchListJson,function(index,item){
			xAxisDataInvalidSearch.push(item.searchText);
			yAxisDataInvalidSearch.push(item.total);
		});
	}else{
		var xAxisDataInvalidSearch = ["暂无数据"]
		var yAxisDataInvalidSearch = [0];
	}
    // 指定图表的配置项和数据
    var optionInvalidSearch = {

		calculable : true,
		xAxis : [
		    {
		        type : 'category',
		        data : xAxisDataInvalidSearch
		    }
		],
		yAxis : [
		    {
		        type : 'value'
		    }
		],
		series : [
		    {
		        name:'搜索量',
		        type:'bar',
		        barWidth : 30,
		        data:yAxisDataInvalidSearch,
		        itemStyle: {   
	                normal:{  
	                	color:function(d){return "#"+Math.floor(Math.random()*(256*256*256-1)).toString(16);}
	                },
	                emphasis: {
	                        shadowBlur: 10,
	                        shadowOffsetX: 0,
	                        shadowColor: 'rgba(0, 0, 0, 0.5)'
	                }
	            },
		      
		    },
		   
		]
};           
    // 使用刚指定的配置项和数据显示图表。
   myChartInvalidSearch.setOption(optionInvalidSearch); 
});