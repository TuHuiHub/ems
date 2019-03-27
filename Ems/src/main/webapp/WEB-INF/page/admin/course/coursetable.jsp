<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="com.dream.ems.dto.CourseTableDto" %>
<%
	List<CourseTableDto> ctList = (List<CourseTableDto>)request.getAttribute("courseTableList");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div id="page-wrapper">
<br/>
<div class="row col-md-offset-3" >
<div class="col-md-3 col-lg-3">
		<div class="form-group">
			<input type="button" class="btn btn-primary" value="修改课程表" id="update" name="update"/>
		</div>
	</div>
		<div class="col-md-3 col-lg-3">
		<div class="form-group">
			<input type="button" class="btn btn-danger" value="删除课程表" id="delete" name="delete"/>
		</div>
	</div>
</div>



<div id="updatetitle">
<input type="hidden" id="cid" name="collegeId" value="${collegeId }"/>
<input type="hidden" id="mid" name="majorId" value="${majorId }"/>
<div class="row">
	<div class="col-md-3">
		<div class="form-group">
			<label>课程</label> <select class="form-control" name="courseId" id="courseSelect">
				
			</select>
		</div>
	</div>
	<div class="col-md-2">
		<div class="form-group">
			<label>教师</label> 
			<select class="form-control" name="teacherJobNo" id="teacherSelect">
			
			</select>
		</div>
	</div>
	<div class="col-md-3">
		<div class="form-group">
			<label>教室</label> 
			<input class="form-control" type="text" placeholder="请输入教室名" id="classroomText" name="classroomText"/>
		</div>
	</div>
	
	<div class="col-md-2">
		<div class="form-group">
			<br/>
			<input type="button" class="btn btn-warning" value="删除课次" id="emptyLesson" name="emptyLesson"/>
		</div>
	</div>
		<div class="col-md-2">
		<div class="form-group">
		<br/>
			<input type="button" class="btn btn-success" value="修改保存" id="save" name="save"/>
		</div>
	</div>
	</div>
	<div class="row">
	<div class="col-md-3">
		<div class="form-group">
			<label>星期</label> 
			<select class="form-control" id="weekdaySelect" name="weekDay" >
				<option value="1">周一</option>
				<option value="2">周二</option>
				<option value="3">周三</option>
				<option value="4">周四</option>
				<option value="5">周五</option>
			</select>
		</div>
	</div>
	<div class="col-md-3">
		<div class="form-group">
			<label>上课时间</label> 
			<select class="form-control" id="lessonSelect" name="lesson" >
				<option value="1">第一节课</option>
				<option value="2">第二节课</option>
				<option value="3">第三节课</option>
				<option value="4">第四节课</option>
				<option value="5">第五节课</option>
			</select>
		</div>
	</div>
	
	<div class="col-md-3">
		<div class="form-group">
			<label>开始周</label> 
			<select class="form-control" id="startweekSelect" name="startWeek">
				<option value="1">第一周</option>
				<option value="2">第二周</option>
				<option value="3">第三周</option>
				<option value="4">第四周</option>
				<option value="5">第五周</option>
				<option value="6">第六周</option>
				<option value="7">第七周</option>
				<option value="8">第八周</option>
				<option value="9">第九周</option>
				<option value="10">第十周</option>
				<option value="11">第十一周</option>
				<option value="12">第十二周</option>
				<option value="13">第十三周</option>
				<option value="14">第十四周</option>
				<option value="15">第十五周</option>
				<option value="16">第十六周</option>
				<option value="17">第十七周</option>
				<option value="18">第十八周</option>
				<option value="19">第十九周</option>
				<option value="20">第二十周</option>
			</select>
		</div>
	</div>
	<div class="col-md-3">
		<div class="form-group">
			<label>结束周</label> 
			<select class="form-control" id="endweekSelect" name="endWeek">
				<option value="1">第一周</option>
				<option value="2">第二周</option>
				<option value="3">第三周</option>
				<option value="4">第四周</option>
				<option value="5">第五周</option>
				<option value="6">第六周</option>
				<option value="7">第七周</option>
				<option value="8">第八周</option>
				<option value="9">第九周</option>
				<option value="10">第十周</option>
				<option value="11">第十一周</option>
				<option value="12">第十二周</option>
				<option value="13">第十三周</option>
				<option value="14">第十四周</option>
				<option value="15">第十五周</option>
				<option value="16">第十六周</option>
				<option value="17">第十七周</option>
				<option value="18">第十八周</option>
				<option value="19">第十九周</option>
				<option value="20">第二十周</option>
			</select>
		</div>
	</div>
	</div>
	</div>
	
	
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading" style="text-align: center"><%=ctList.get(0).getCollegeName() %>
				<%=ctList.get(0).getMajorName() %>专业 课程表</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<div class="table-responsive">
					<table class="table table-striped table-bordered table-hover">
						<thead>
							<tr>
								<th></th>
								<th>星期一</th>
								<th>星期二</th>
								<th>星期三</th>
								<th>星期四</th>
								<th>星期五</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th height="100px"
									style="text-align: center; vertical-align: middle;">第一节课</th>
								<td height="100px"
									style="text-align: center; vertical-align: middle;"
									id="table_1_1">#</td>
								<td height="100px"
									style="text-align: center; vertical-align: middle;"
									id="table_2_1">#</td>
								<td height="100px"
									style="text-align: center; vertical-align: middle;"
									id="table_3_1">#</td>
								<td height="100px"
									style="text-align: center; vertical-align: middle;"
									id="table_4_1">#</td>
								<td height="100px"
									style="text-align: center; vertical-align: middle;"
									id="table_5_1">#</td>
							</tr>
							<tr>
								<th height="100px"
									style="text-align: center; vertical-align: middle;">第二节课</th>
								<td height="100px"
									style="text-align: center; vertical-align: middle;"
									id="table_1_2">#</td>
								<td height="100px"
									style="text-align: center; vertical-align: middle;"
									id="table_2_2">#</td>
								<td height="100px"
									style="text-align: center; vertical-align: middle;"
									id="table_3_2">#</td>
								<td height="100px"
									style="text-align: center; vertical-align: middle;"
									id="table_4_2">#</td>
								<td height="100px"
									style="text-align: center; vertical-align: middle;"
									id="table_5_2">#</td>
							</tr>
							<tr>
								<th height="100px"
									style="text-align: center; vertical-align: middle;">第三节课</th>
								<td height="100px"
									style="text-align: center; vertical-align: middle;"
									id="table_1_3">#</td>
								<td height="100px"
									style="text-align: center; vertical-align: middle;"
									id="table_2_3">#</td>
								<td height="100px"
									style="text-align: center; vertical-align: middle;"
									id="table_3_3">#</td>
								<td height="100px"
									style="text-align: center; vertical-align: middle;"
									id="table_4_3">#</td>
								<td height="100px"
									style="text-align: center; vertical-align: middle;"
									id="table_5_3">#</td>
							</tr>
							<tr>
								<th height="100px"
									style="text-align: center; vertical-align: middle;">第四节课</th>
								<td height="100px"
									style="text-align: center; vertical-align: middle;"
									id="table_1_4">#</td>
								<td height="100px"
									style="text-align: center; vertical-align: middle;"
									id="table_2_4">#</td>
								<td height="100px"
									style="text-align: center; vertical-align: middle;"
									id="table_3_4">#</td>
								<td height="100px"
									style="text-align: center; vertical-align: middle;"
									id="table_4_4">#</td>
								<td height="100px"
									style="text-align: center; vertical-align: middle;"
									id="table_5_4">#</td>
							</tr>
							<tr>
								<th height="100px"
									style="text-align: center; vertical-align: middle;">第五节课</th>
								<td height="100px"
									style="text-align: center; vertical-align: middle;"
									id="table_1_5">#</td>
								<td height="100px"
									style="text-align: center; vertical-align: middle;"
									id="table_2_5">#</td>
								<td height="100px"
									style="text-align: center; vertical-align: middle;"
									id="table_3_5">#</td>
								<td height="100px"
									style="text-align: center; vertical-align: middle;"
									id="table_4_5">#</td>
								<td height="100px"
									style="text-align: center; vertical-align: middle;"
									id="table_5_5">#</td>
							</tr>
						</tbody>
					</table>
				</div>
				<!-- /.table-responsive -->
			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
	<script>

		$(document).ready(function(){
			<%for(CourseTableDto ct:ctList){%>
			$("#table_"+<%=ct.getWeekDay()%>+"_"+<%=ct.getLesson()%>).html("<%=ct.getCourseName()%><p hidden><%=ct.getCourseId()%></p>"+
					"<br/><%=ct.getTeacherName()%><p hidden><%=ct.getTeacherJobNo()%></p>"+
					"<br/><%=ct.getClassRoom()%><br/><%=ct.getStartWeek()%>-<%=ct.getEndWeek()%>周<p hidden><%=ct.getId()%></p>");
			<%}%>
			var delCourseTableIds = new Array();
			var courseSelect = $("#courseSelect");
			var teacherSelect = $("#teacherSelect");
			var classroomText = $("#classroomText");
			var weekdaySelect = $("#weekdaySelect");
			var lessonSelect = $("#lessonSelect");
			var startweekSelect = $("#startweekSelect");
			var endweekSelect = $("#endweekSelect");
			$("#updatetitle").hide();
			$("#update").click(function(){
				$("#updatetitle").toggle();
				
				var collegeId = $("#cid").val();
				var majorId = $("#mid").val();
				var courseSelect = $("#courseSelect");
				var teacherSelect = $("#teacherSelect");
			
			
				if($("#courseSelect option").length==0){
					$.ajax({
						type:"GET",
						url:'${pageContext.request.contextPath}/coursetable/getCourses?majorId='+majorId,
						success:function(result){
							for(var i=0;i<result.length;i++){
								
								courseSelect.append("<option value="+result[i].id+">"+result[i].name+"</option>");
							
							}
						}
					})
				}
				if($("#teacherSelect option").length==0){
					$.ajax({
						type:"GET",
						url:'${pageContext.request.contextPath}/coursetable/getteachers?collegeId='+collegeId,
						success:function(result){
							for(var i=0;i<result.length;i++){
								
								teacherSelect.append("<option value="+result[i].jobNo+">"+result[i].name+"</option>");
							
							}
						}
					})
				}
				
				
			})
			
			
				$("table tr td").click(function(){
					if($("#updatetitle").is(':visible')){
						$("table tr td").removeClass("info");
						$(this).addClass("info");
						var str = $(this).html();
						if(str!="#"){
							var arry = str.split("<br>");
							coureseStartIndex = arry[0].indexOf("<p hidden=")+13;
							coureseEndIndex = arry[0].indexOf("</p>");
							teacherStartIndex = arry[1].indexOf("<p hidden=")+13;
							teacherEndIndex = arry[1].indexOf("</p>");
							var courseId = arry[0].substring(coureseStartIndex,coureseEndIndex);
							var	teacherJobNo = arry[1].substring(teacherStartIndex,teacherEndIndex);
							var	classRoom = arry[2];
							var	startWeek = arry[3].split("-")[0];
							var	endWeek = arry[3].split("-")[1].split("周")[0];
							var	weekDay = $(this).attr("id").split("_")[1];
							var	lesson = $(this).attr("id").split("_")[2];

							courseSelect.val(courseId);
							teacherSelect.val(teacherJobNo);
							classroomText.val(classRoom);
							weekdaySelect.val(weekDay);
							lessonSelect.val(lesson);
							startweekSelect.val(startWeek);
							endweekSelect.val(endWeek);
						}else{
							weekdaySelect.val($(this).attr("id").split("_")[1]);
							lessonSelect.val($(this).attr("id").split("_")[2]);
						}
						
					}
				})
				courseSelect.change(function(){
					$("table tr td").each(function(){
						if($(this).hasClass("info")){
							var str = $(this).html();
							if(str!="#"){
								var arry = str.split("<br>");
								coureseStartIndex = arry[0].indexOf("<p hidden=")+13;
								coureseEndIndex = arry[0].indexOf("</p>");
								teacherStartIndex = arry[1].indexOf("<p hidden=")+13;
								teacherEndIndex = arry[1].indexOf("</p>");
								var courseId = arry[0].substring(coureseStartIndex,coureseEndIndex);
								var courseName = arry[0].split("<p")[0];
								var	teacherJobNo = arry[1].substring(teacherStartIndex,teacherEndIndex);
								var teacherName = arry[1].split("<p")[0];
								var	classRoom = arry[2];
								var	startWeek = arry[3].split("-")[0];
								var	endWeek = arry[3].split("-")[1].split("周")[0];
								var	weekDay = $(this).attr("id").split("_")[1];
								var	lesson = $(this).attr("id").split("_")[2];
								var coursetableId = arry[3].split("周")[1].split(">")[1].split("<")[0];
								$(this).html($("#courseSelect option:selected").text()+"<p hidden>"+courseSelect.val()+"</p>"
											+"<br/>"+teacherName+"<p hidden>"+teacherJobNo+"</p>"
											+"<br/>"+classRoom+"<br/>"+startWeek+"-"+endWeek+"周<p hidden>"+coursetableId+"</p>");
							}else{
								
								$(this).html($("#courseSelect option:selected").text()+"<p hidden>"+courseSelect.val()+"</p>"
											+"<br/>"+$("#teacherSelect option:selected").text()+"<p hidden>"+teacherSelect.val()+"</p>"
											+"<br/>"+classroomText.val()+"<br/>"+startweekSelect.val()+"-"+endweekSelect.val()+"周<p hidden>"+""+"</p>");
							}
							
						}
					})
						
								
			})
			teacherSelect.change(function(){
					$("table tr td").each(function(){
						if($(this).hasClass("info")){
							var str = $(this).html();
							if(str!="#"){
								var arry = str.split("<br>");
								coureseStartIndex = arry[0].indexOf("<p hidden=")+13;
								coureseEndIndex = arry[0].indexOf("</p>");
								teacherStartIndex = arry[1].indexOf("<p hidden=")+13;
								teacherEndIndex = arry[1].indexOf("</p>");
								var courseId = arry[0].substring(coureseStartIndex,coureseEndIndex);
								var courseName = arry[0].split("<p")[0];
								var	teacherJobNo = arry[1].substring(teacherStartIndex,teacherEndIndex);
								var teacherName = arry[1].split("<p")[0];
								var	classRoom = arry[2];
								var	startWeek = arry[3].split("-")[0];
								var	endWeek = arry[3].split("-")[1].split("周")[0];
								var	weekDay = $(this).attr("id").split("_")[1];
								var	lesson = $(this).attr("id").split("_")[2];
								var coursetableId = arry[3].split("周")[1].split(">")[1].split("<")[0];
								$(this).html(courseName+"<p hidden>"+courseId+"</p>"
											+"<br/>"+$("#teacherSelect option:selected").text()+"<p hidden>"+teacherSelect.val()+"</p>"
											+"<br/>"+classRoom+"<br/>"+startWeek+"-"+endWeek+"周<p hidden>"+coursetableId+"</p>");
							}else{
								$(this).html($("#courseSelect option:selected").text()+"<p hidden>"+courseSelect.val()+"</p>"
											+"<br/>"+$("#teacherSelect option:selected").text()+"<p hidden>"+teacherSelect.val()+"</p>"
											+"<br/>"+classroomText.val()+"<br/>"+startweekSelect.val()+"-"+endweekSelect.val()+"周<p hidden>"+""+"</p>");
							}
						}
					})
			})
			
			classroomText.keyup(function(){
					$("table tr td").each(function(){
						if($(this).hasClass("info")){
							var str = $(this).html();
							if(str!="#"){
								var arry = str.split("<br>");
								coureseStartIndex = arry[0].indexOf("<p hidden=")+13;
								coureseEndIndex = arry[0].indexOf("</p>");
								teacherStartIndex = arry[1].indexOf("<p hidden=")+13;
								teacherEndIndex = arry[1].indexOf("</p>");
								var courseId = arry[0].substring(coureseStartIndex,coureseEndIndex);
								var courseName = arry[0].split("<p")[0];
								var	teacherJobNo = arry[1].substring(teacherStartIndex,teacherEndIndex);
								var teacherName = arry[1].split("<p")[0];
								var	classRoom = arry[2];
								var	startWeek = arry[3].split("-")[0];
								var	endWeek = arry[3].split("-")[1].split("周")[0];
								var	weekDay = $(this).attr("id").split("_")[1];
								var	lesson = $(this).attr("id").split("_")[2];
								var coursetableId = arry[3].split("周")[1].split(">")[1].split("<")[0];
								$(this).html(courseName+"<p hidden>"+courseId+"</p>"
											+"<br/>"+teacherName+"<p hidden>"+teacherJobNo+"</p>"
											+"<br/>"+classroomText.val()+"<br/>"+startWeek+"-"+endWeek+"周<p hidden>"+coursetableId+"</p>");
							}else{
								$(this).html($("#courseSelect option:selected").text()+"<p hidden>"+courseSelect.val()+"</p>"
											+"<br/>"+$("#teacherSelect option:selected").text()+"<p hidden>"+teacherSelect.val()+"</p>"
											+"<br/>"+classroomText.val()+"<br/>"+startweekSelect.val()+"-"+endweekSelect.val()+"周<p hidden>"+""+"</p>");
							}
						}
					})
			})
			
			startweekSelect.change(function(){
				var startweek = $(this).val();
				var endweek = $("#endweekSelect").val();
				for(var i=1;i<startweek;i++){
					$("#endweekSelect option[value='"+i+"']").hide();
				}
				$("#endweekSelect option[value='"+startweek+"']").prop("selected",true);
					$("table tr td").each(function(){
						if($(this).hasClass("info")){
							var str = $(this).html();
							if(str!="#"){
								var arry = str.split("<br>");
								coureseStartIndex = arry[0].indexOf("<p hidden=")+13;
								coureseEndIndex = arry[0].indexOf("</p>");
								teacherStartIndex = arry[1].indexOf("<p hidden=")+13;
								teacherEndIndex = arry[1].indexOf("</p>");
								var courseId = arry[0].substring(coureseStartIndex,coureseEndIndex);
								var courseName = arry[0].split("<p")[0];
								var	teacherJobNo = arry[1].substring(teacherStartIndex,teacherEndIndex);
								var teacherName = arry[1].split("<p")[0];
								var	classRoom = arry[2];
								var	startWeek = arry[3].split("-")[0];
								var	endWeek = arry[3].split("-")[1].split("周")[0];
								var	weekDay = $(this).attr("id").split("_")[1];
								var	lesson = $(this).attr("id").split("_")[2];
								var coursetableId = arry[3].split("周")[1].split(">")[1].split("<")[0];
								$(this).html(courseName+"<p hidden>"+courseId+"</p>"
											+"<br/>"+teacherName+"<p hidden>"+teacherJobNo+"</p>"
											+"<br/>"+classroomText.val()+"<br/>"+startweekSelect.val()+"-"+endweekSelect.val()+"周<p hidden>"+coursetableId+"</p>");
							}else{
								$(this).html($("#courseSelect option:selected").text()+"<p hidden>"+courseSelect.val()+"</p>"
											+"<br/>"+$("#teacherSelect option:selected").text()+"<p hidden>"+teacherSelect.val()+"</p>"
											+"<br/>"+classroomText.val()+"<br/>"+startweekSelect.val()+"-"+endweekSelect.val()+"周<p hidden>"+""+"</p>");
							}
						}
					})
			})
				endweekSelect.change(function(){
					$("table tr td").each(function(){
						if($(this).hasClass("info")){
							var str = $(this).html();
							if(str!="#"){
								var arry = str.split("<br>");
								coureseStartIndex = arry[0].indexOf("<p hidden=")+13;
								coureseEndIndex = arry[0].indexOf("</p>");
								teacherStartIndex = arry[1].indexOf("<p hidden=")+13;
								teacherEndIndex = arry[1].indexOf("</p>");
								var courseId = arry[0].substring(coureseStartIndex,coureseEndIndex);
								var courseName = arry[0].split("<p")[0];
								var	teacherJobNo = arry[1].substring(teacherStartIndex,teacherEndIndex);
								var teacherName = arry[1].split("<p")[0];
								var	classRoom = arry[2];
								var	startWeek = arry[3].split("-")[0];
								var	endWeek = arry[3].split("-")[1].split("周")[0];
								var	weekDay = $(this).attr("id").split("_")[1];
								var	lesson = $(this).attr("id").split("_")[2];
								var coursetableId = arry[3].split("周")[1].split(">")[1].split("<")[0];
								$(this).html(courseName+"<p hidden>"+courseId+"</p>"
											+"<br/>"+teacherName+"<p hidden>"+teacherJobNo+"</p>"
											+"<br/>"+classroomText.val()+"<br/>"+startweekSelect.val()+"-"+endweekSelect.val()+"周<p hidden>"+coursetableId+"</p>");
							}else{
								$(this).html($("#courseSelect option:selected").text()+"<p hidden>"+courseSelect.val()+"</p>"
											+"<br/>"+$("#teacherSelect option:selected").text()+"<p hidden>"+teacherSelect.val()+"</p>"
											+"<br/>"+classroomText.val()+"<br/>"+startweekSelect.val()+"-"+endweekSelect.val()+"周<p hidden>"+""+"</p>");
							}
						}
					})
			})
			weekdaySelect.change(function(){
				var  weekday = weekdaySelect.val();
				var lesson = lessonSelect.val();
				$("#table_"+weekday+"_"+lesson).click();
			})
				
			
			lessonSelect.change(function(){
				var  weekday = weekdaySelect.val();
				var lesson = lessonSelect.val();
				$("#table_"+weekday+"_"+lesson).click();
			})
		
			
			coursetableId=$("#emptyLesson").click(function(){
				$("table tr td").each(function(){
					if($(this).hasClass("info")){
						var str = $(this).html();
						if(str!="#"){
							if(confirm("确认要删除所选择的那节课吗？")){
								var str = $(this).html();
								var arry = str.split("<br>");
								coursetableId = arry[3].split("周")[1].split(">")[1].split("<")[0];
								delCourseTableIds.push(coursetableId);	
								$(this).html("#");
							}	
						}
					}
				})
			})
			$("#save").click(function(){
			if(confirm("确认保存？")){
					var courseArray = new Array();
					var selectCourseData = new Object();
					var cid = $("#cid");
					var mid = $("#mid");
					for(var i=1;i<6;i++){
						for(var j=1;j<6;j++){
							var str = $("#table_"+i+"_"+j).html();
							if(str!="#"){
								var arry = str.split("<br>");
								coureseStartIndex = arry[0].indexOf("<p hidden=")+13;
								coureseEndIndex = arry[0].indexOf("</p>");
								teacherStartIndex = arry[1].indexOf("<p hidden=")+13;
								teacherEndIndex = arry[1].indexOf("</p>");
								var param = {
										collegeId:cid.val(),
										majorId:mid.val(),
										coureseStartIndex:arry[0].indexOf("<p hidden=")+13,
										coureseEndIndex:arry[0].indexOf("</p>"),
										teacherStartIndex:arry[1].indexOf("<p hidden=")+13,
										teacherEndIndex:arry[1].indexOf("</p>"),
										courseId:arry[0].substring(coureseStartIndex,coureseEndIndex),
										courseName:arry[0].split("<p")[0],
										teacherJobNo:arry[1].substring(teacherStartIndex,teacherEndIndex),
										teacherName:arry[1].split("<p")[0],
										classRoom:arry[2],
										startWeek:arry[3].split("-")[0],
										endWeek:arry[3].split("-")[1].split("周")[0],
										weekDay:i,
										lesson:j,
										coursetableId:arry[3].split("周")[1].split(">")[1].split("<")[0]
										};
								courseArray.push(param);
							}
							
						}
					}
				
					$.ajax({
						type:'post',
						url:'${pageContext.request.contextPath}/coursetable/updatecoursetable',
						contentType: "application/json",
						data:JSON.stringify({"courseArray":courseArray,"delCourseTableIds":delCourseTableIds}),
						dataType:'json',
						success:function(result){
							if(result.success){
								alert(result.message);
								location.href = "${pageContext.request.contextPath}/";
							}else{
								alert("修改课程失败！");
							}
						}
					});
					
				}
			})
				
			$("#delete").click(function(){
				var majorId = $("#mid").val();
				if(confirm("确认删除该专业的课程表？")){
					$.ajax({
						type:'post',
						url:'${pageContext.request.contextPath}/coursetable/deleteall',
						data:{"majorId":majorId},
						success:function(result){
							if(result.success){
								alert(result.message);
								location.href = "${pageContext.request.contextPath}/";
							}else{
								alert("修改该课程表失败！");
							}
						}
					});
				}
			})
			
			
		})
	</script>
</div>