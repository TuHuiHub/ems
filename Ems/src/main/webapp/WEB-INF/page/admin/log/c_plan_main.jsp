<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h4>课程安排</h4>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-12">
			<div class="form-group">
				<label>学院选择</label> <select class="form-control" name="collegeId"
					id="collegeSelect">
				</select>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-lg-12">
			<div class="form-group">
				<label>专业选择</label> <select class="form-control" name="majorId"
					id="majorSelect">
				</select>
			</div>
		</div>
	</div>
	<br/>
	<br/> 
	<div class="row" style="text-align: center;">
		<div class="col-md-2 col-lg-2">
			<div class="form-group">
				<input type="button" class="btn btn-primary" value="安排课程"
					id="planCourse" name="planCourse" />
			</div>
		</div>
		<div class="col-md-2 col-lg-2">
			<div class="form-group">
				<input type="button" class="btn btn-danger" value="重置"
					id="reset" name="reset" onclick="location.href='${pageContext.request.contextPath}/'"/>
			</div>
		</div>
	</div>
	<script>
	$(document).ready(function(){
		var cid;
			$.ajax({
				type:'POST',
				url:"${pageContext.request.contextPath}/collegeinfo/college/getColleges",
				async:false,
				success:function(result){
					var college=$('#collegeSelect');
	    			college.empty();
	    			for(var i=0;i<result.length;i++){
	    				if(i==0){
	    					cid=result[i].id;
	    				}
	    				college.append("<option value="+result[i].id+">"+result[i].name+"</option>");
	    			}
				}
			});
	 	showMajors(cid);
		$("#collegeSelect").change(function(){
			var collegeid = $(this).val();
			showMajors(collegeid);
		})
		$("#planCourse").click(function(){
			var collegeId = $("#collegeSelect").val();
			var majorId = $("#majorSelect").val();
			location.href = "${pageContext.request.contextPath}/collegeinfo/course/selectCourse?collegeId="+collegeId+"&majorId="+majorId;
		})
	})
	 function showMajors(id){
		$.post("${pageContext.request.contextPath}/collegeinfo/major/show",{collegeId:id},
    		function(result){
    			var major=$('#majorSelect');
    			major.empty();
    			for(var i=0;i<result.length;i++){
    				major.append("<option value="+result[i].id+">"+result[i].name+"</option>");
    			}
    		},"json");
 	}
	</script>
</div>