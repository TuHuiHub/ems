<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
		<div id="page-wrapper">
		<br/>
			<div class="row">
			  <div class="col-lg-12">
                        <label class="col-sm-1  control-label">学院</label>
                        <div class="col-sm-6 ">
                        <select class="form-control" id="collegeSelect">
                        </select>
                        </div>
                </div>
            </div>
            <br/>
            <br/>
			<div class="row">
                <div class="col-lg-12">
                    <div id="courseSelectedCharts" style="width: 600px;height:400px;"></div>
                </div>
            </div>
            <script>
            $(document).ready(function(){
            	var cid;
            	$.ajax({
					url:"${pageContext.request.contextPath}/collegeinfo/college/getColleges",
					type:"POST",
					async:false,
					success:function(result){
						var college = $("#collegeSelect");
						for(var i=0;i<result.length;i++){
							if(i==0){
								cid = result[i].id;
							}
								college.append("<option value='"+result[i].id+"'>"+result[i].name+"</option>");
							
						}
					}
				})
				
				
				showChart(cid);
				
				$('#page-wrapper select').change (function () {
					showChart($(this).val());
				});
            })
            
            	function showChart (id) {
            	var bugCharts = echarts.init(document.getElementById('courseSelectedCharts'));
            		$.get('${pageContext.request.contextPath}/coursetable/courseSelectedCharts?collegeId=' + id).done(function (eChartsData) {
						// 设置图表的数据
						bugCharts.setOption({
					        title: {
					            text: '选课学生分布图'
					        },
					        tooltip: {},
					        legend: {
					            data:eChartsData.legends
					        },
					        xAxis: {
					            data: eChartsData.xAxis
					        },
					        yAxis: {
					        },
					        series: eChartsData.series
					    });
					});
            	}
			</script>
        </div>

