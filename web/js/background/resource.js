$(function () {
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('resourceFigure'));

	var xAxisData = new Array();
	var yAxisData = new Array();
	if(potenGroupListJson.length > 0){
		$.each(potenGroupListJson,function(index,item){
			xAxisData.push(item.groupName);
			yAxisData.push(item.total);
		});
	}else{
		var xAxisData = ["暂无数据"]
		var yAxisData = [0];
	}
    
    // 指定图表的配置项和数据
    var option = {
		title : {
		    text: '势的个数',
		    subtext: '数据来自于当前数据库'
		},
		tooltip : {
		    trigger: 'axis'
		},
		legend: {
		    data:[]
		},
		calculable : true,
		xAxis : [
		    {
		        type : 'value',
		        boundaryGap : [0, 0.01]
		    }
		],
		yAxis : [
		    {
		        type : 'category',
		        data : xAxisData
		    }
		],
		series : [
		    {
		        type:'bar',
		        data:yAxisData,
		        //配置样式
			    itemStyle: {   
			        //通常情况下：
			        normal:{  
			            color: function (params){
			                var colorList = ['rgb(164,205,238)','rgb(42,170,227)','rgb(25,46,94)','rgb(195,229,235)'];
			                return colorList[params.dataIndex];
			            }
			        },
			        //鼠标悬停时：
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
   myChart.setOption(option); 
});