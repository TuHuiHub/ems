<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<style type="text/css">
		td{
			width: 100px;
			height: 60px;
		}
		
		th{
			width: 100px;
			height: 60px;
		}
		
</style>
<script type="text/javascript">
		$(function() {
			$("#sel").change(function(){
				$("#courseinfoTable td").html("");
				$.ajax({
					type:"get",
					url:"${pageContext.request.contextPath}/coursetable/studentcourse/list",
					async:true,
					success:function(list){
						var num = ($("#sel").val());
						for (var i = 0;list.length>i; i++) {
							var start = Number(list[i].startWeek);
							var end = Number(list[i].endWeek);
							if(num>=start && num<=end){
								var weekDay = list[i].weekDay;
								var lesson = list[i].lesson;
								if(weekDay=="1"&&lesson=="1"){
									$("#o1").html(list[i].courseName+'</br>' +'教室：'+list[i].classRoomName+'</br>'+'老师：'+list[i].teacherName);
								}
								if(weekDay=="1"&&lesson=="2"){
									$("#r1").html(list[i].courseName+'</br>' +'教室：'+list[i].classRoomName+'</br>'+'老师：'+list[i].teacherName);
								}
								if(weekDay=="1"&&lesson=="3"){
									$("#s1").html(list[i].courseName+'</br>' +'教室：'+list[i].classRoomName+'</br>'+'老师：'+list[i].teacherName);
								}
								if(weekDay=="1"&&lesson=="4"){
									$("#si1").html(list[i].courseName+'</br>' +'教室：'+list[i].classRoomName+'</br>'+'老师：'+list[i].teacherName);
								}
								if(weekDay=="1"&&lesson=="5"){
									$("#w1").html(list[i].courseName+'</br>' +'教室：'+list[i].classRoomName+'</br>'+'老师：'+list[i].teacherName);
								}
	//-----------------------------------------------------------------------------------------------------
								if(weekDay=="2"&&lesson=="1"){
									$("#o2").html(list[i].courseName+'</br>' +'教室：'+list[i].classRoomName+'</br>'+'老师：'+list[i].teacherName);
								}
								if(weekDay=="2"&&lesson=="2"){
									$("#r2").html(list[i].courseName+'</br>' +'教室：'+list[i].classRoomName+'</br>'+'老师：'+list[i].teacherName);
								}
								if(weekDay=="2"&&lesson=="3"){
									$("#s2").html(list[i].courseName+'</br>' +'教室：'+list[i].classRoomName+'</br>'+'老师：'+list[i].teacherName);
								}
								if(weekDay=="2"&&lesson=="4"){
									$("#si2").html(list[i].courseName+'</br>' +'教室：'+list[i].classRoomName+'</br>'+'老师：'+list[i].teacherName);
								}
								if(weekDay=="2"&&lesson=="5"){
									$("#w2").html(list[i].courseName+'</br>' +'教室：'+list[i].classRoomName+'</br>'+'老师：'+list[i].teacherName);
								}
	//-----------------------------------------------------------------------------------------------------
								if(weekDay=="3"&&lesson=="1"){
									$("#o3").html(list[i].courseName+'</br>' +'教室：'+list[i].classRoomName+'</br>'+'老师：'+list[i].teacherName);
								}
								if(weekDay=="3"&&lesson=="2"){
									$("#r3").html(list[i].courseName+'</br>' +'教室：'+list[i].classRoomName+'</br>'+'老师：'+list[i].teacherName);
								}
								if(weekDay=="3"&&lesson=="3"){
									$("#s3").html(list[i].courseName+'</br>' +'教室：'+list[i].classRoomName+'</br>'+'老师：'+list[i].teacherName);
								}
								if(weekDay=="3"&&lesson=="4"){
									$("#si3").html(list[i].courseName+'</br>' +'教室：'+list[i].classRoomName+'</br>'+'老师：'+list[i].teacherName);
								}
								if(weekDay=="3"&&lesson=="5"){
									$("#w3").html(list[i].courseName+'</br>' +'教室：'+list[i].classRoomName+'</br>'+'老师：'+list[i].teacherName);
								}
	//-----------------------------------------------------------------------------------------------------							
								if(weekDay=="4"&&lesson=="1"){
									$("#o4").html(list[i].courseName+'</br>' +'教室：'+list[i].classRoomName+'</br>'+'老师：'+list[i].teacherName);
								}
								if(weekDay=="4"&&lesson=="2"){
									$("#r4").html(list[i].courseName+'</br>' +'教室：'+list[i].classRoomName+'</br>'+'老师：'+list[i].teacherName);
								}
								if(weekDay=="4"&&lesson=="3"){
									$("#s4").html(list[i].courseName+'</br>' +'教室：'+list[i].classRoomName+'</br>'+'老师：'+list[i].teacherName);
								}
								if(weekDay=="4"&&lesson=="4"){
									$("#si4").html(list[i].courseName+'</br>' +'教室：'+list[i].classRoomName+'</br>'+'老师：'+list[i].teacherName);
								}
								if(weekDay=="4"&&lesson=="5"){
									$("#w4").html(list[i].courseName+'</br>' +'教室：'+list[i].classRoomName+'</br>'+'老师：'+list[i].teacherName);
								}
	//-----------------------------------------------------------------------------------------------------							
								if(weekDay=="5"&&lesson=="1"){
									$("#o5").html(list[i].courseName+'</br>' +'教室：'+list[i].classRoomName+'</br>'+'老师：'+list[i].teacherName);
								}
								if(weekDay=="5"&&lesson=="2"){
									$("#r5").html(list[i].courseName+'</br>' +'教室：'+list[i].classRoomName+'</br>'+'老师：'+list[i].teacherName);
								}
								if(weekDay=="5"&&lesson=="3"){
									$("#s5").html(list[i].courseName+'</br>' +'教室：'+list[i].classRoomName+'</br>'+'老师：'+list[i].teacherName);
								}
								if(weekDay=="5"&&lesson=="4"){
									$("#si5").html(list[i].courseName+'</br>' +'教室：'+list[i].classRoomName+'</br>'+'老师：'+list[i].teacherName);
								}
								if(weekDay=="5"&&lesson=="5"){
									$("#w5").html(list[i].courseName+'</br>' +'教室：'+list[i].classRoomName+'</br>'+'老师：'+list[i].teacherName);
								}
							}
						}
					}
				})
			})
		})

</script>
		<div id="page-wrapper">
			<div class="row">
                <div class="col-lg-12">
                    <h4>课程信息</h4>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-3">
                    <div class="form-group">
                        <label>周数</label>
                        <select class="form-control" id="sel">
                        	<option value="">请选择</option>
                          <%for(int i = 1;i<=18;i++){ %>
                            <option value="<%=i%>">第<%=i%>周</option>
                           <%} %>
                        </select>
                    </div>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <!-- /.panel-heading -->
                        	
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="courseinfoTable">
                                <thead>
                                    <tr>
                                    	<th>节\周</th>
                                    	<th>星期一</th>
                                        <th>星期二</th>
                                        <th>星期三</th>
                                        <th>星期四</th>
                                        <th>星期五</th>
                                    </tr>
                                    <tr><th>第一节</th>
                                    	<td id="o1"></td>
                                    	<td id="o2"></td>
                                    	<td id="o3"></td>
                                    	<td id="o4"></td>
                                    	<td id="o5"></td>
                                    </tr>
                                    <tr><th>第二节</th>
                                    	<td id="r1"></td>
                                    	<td id="r2"></td>
                                    	<td id="r3"></td>
                                    	<td id="r4"></td>
                                    	<td id="r5"></td>
                                    </tr>
                                    <tr><th>第三节</th>
                                    	<td id="s1"></td>
                                    	<td id="s2"></td>
                                    	<td id="s3"></td>
                                    	<td id="s4"></td>
                                    	<td id="s5"></td>
                                    </tr>
                                    <tr><th>第四节</th>
                                    	<td id="si1"></td>
                                    	<td id="si2"></td>
                                    	<td id="si3"></td>
                                    	<td id="si4"></td>
                                    	<td id="si5"></td>
                                    </tr>
                                    <tr><th>晚自习</th>
                                    	<td id="w1"></td>
                                    	<td id="w2"></td>
                                    	<td id="w3"></td>
                                    	<td id="w4"></td>
                                    	<td id="w5"></td>
                                    </tr>
                                </thead>
                                
                            </table>
                            <!-- /.table-responsive -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
		</div>	