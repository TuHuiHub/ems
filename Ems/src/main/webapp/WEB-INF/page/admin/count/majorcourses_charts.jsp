<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
		<div id="page-wrapper">
		<br/>
			<div class="row">
			  <div class="col-lg-12">
                        <label class="col-sm-1 control-label">学院</label>
                        <div class="col-sm-4">
                        <select class="form-control" id="collegeSelect">
                        </select>
                        </div>
                </div>
                <div class="col-lg-12">
                        <label class="col-sm-1 control-label">专业</label>
                        <div class="col-sm-4">
                        <select class="form-control" id="majorSelect">
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
            	// 初始化ECharts控件
				
            	var flag = false;
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
				    flag = showMajors(cid,flag);
					$("#collegeSelect").change(function(){
							var collegeid = $(this).val();
							showMajors(collegeid);
					})
						
				// 设置下拉框的change：
				$('#page-wrapper select').change (function () {
					showChart();
				});
            })
            
            	function showChart () {
            	var bugCharts = echarts.init(document.getElementById('courseSelectedCharts'));
            		$.get('${pageContext.request.contextPath}/coursetable/majorCoursesCharts?collegeId=' + $('#collegeSelect').val() + '&majorId=' + $('#majorSelect').val()).done(function (eChartsData) {
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
         		function showMajors(id,flag){
            		
            	if(!flag){
            		$.ajax({
            			type:"GET",
            			url:"${pageContext.request.contextPath}/collegeinfo/major/show?collegeId="+id,
            			async:false,
            			success:function(result){
            				var major=$('#majorSelect');
            				major.empty();
            				for(var i=0;i<result.length;i++){
            				major.append("<option value="+result[i].id+">"+result[i].name+"</option>");
            				}
            			}
            		})
            		showChart();
            	}else{
            		$.post("${pageContext.request.contextPath}/collegeinfo/major/show",{collegeId:id},
            				function(result){
            				var major=$('#majorSelect');
            				major.empty();
            				for(var i=0;i<result.length;i++){
            				major.append("<option value="+result[i].id+">"+result[i].name+"</option>");
            					}
            				},"json");
            	}
				return true;
 	}
			</script>
        </div>

