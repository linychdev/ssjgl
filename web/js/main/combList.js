$(function(){
	/*var chart = echarts.init(document.getElementById('wordcloud'));
    var option = {
        tooltip: {},
        series: [ {
            type: 'wordCloud',
            gridSize: 40,
            sizeRange: [12, 40],
            rotationRange: [-90, 90],
            shape: 'pentagon',
            width: 1000,
            height: 600,
            drawOutOfBound: true,
            textStyle: {
                normal: {
                    color: function () {
                        return 'rgb(' + [
                            Math.round(Math.random() * 160),
                            Math.round(Math.random() * 160),
                            Math.round(Math.random() * 160)
                        ].join(',') + ')';
                    }
                },
                emphasis: {
                    shadowBlur: 10,
                    shadowColor: '#333'
                }
            },
            data: combListJson
        } ]
    };

    chart.setOption(option);
    
    chart.on("click", function (param){               
       var selectVal = option.series[0].data[param.dataIndex].combId;
       var tmp=window.open("about:blank")  
       tmp.moveTo(0,0)  
       tmp.resizeTo(screen.width+20,screen.height)  
       tmp.focus()  
       tmp.location=contextPath+"/search/detail/"+selectVal;  
    });
    window.onresize = chart.resize;*/
    
    
    $(".element-label .label-define").on("click",function(){
    	var selectVal = $(this).attr("id"); 
    	var tmp=window.open("about:blank")  
    	tmp.moveTo(0,0)  
    	tmp.resizeTo(screen.width+20,screen.height)  
    	tmp.focus()  
    	tmp.location=contextPath+"/search/detail/"+selectVal;  
    });
});