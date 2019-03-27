<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">修改课次</div>
				<div class="panel-body">
					<form role="form" id="electiveCoursePlanForm" class="form-horizontal"
						action="${pageContext.request.contextPath}/coursetable/electiveCourse/update"
						method="post" enctype="multipart/form-data">
						<div class="form-group">
							<label class="col-sm-2 control-label">ID</label>
							<div class="col-sm-10">
								<input class="form-control" name="id" readonly
									value="${formData.id}">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">课程名</label>
							<div class="col-sm-10">
								<input class="form-control" name="courseName"
									value="${formData.courseName}" readonly="readonly">
								<input type="hidden" value="${formData.courseId}" name="courseId" />
							</div>
						</div>
						<input type="hidden" value="${formData.weekDay}" id="weekDaySelectval">
						<div class="form-group">
							<label class="col-sm-2 control-label">上课时间</label>
							<div class="col-sm-10">
								<select class="form-control" id="weekDaySelect" name="weekDay">
								<option value="1">周一</option>
								<option value="2">周二</option>
								<option value="3">周三</option>
								<option value="4">周四</option>
								<option value="5">周五</option>
								</select>
							</div>
							</div>
							<input type="hidden" value="${formData.lesson}" id="lessonSelectval">
						<div class="form-group"> 
							<label class="col-sm-2 control-label"></label>
							<div class="col-sm-10">
								<select class="form-control" id="lessonSelect" name="lesson">
								<option value="1">第一节课</option>
								<option value="2">第二节课</option>
								<option value="3">第三节课</option>
								<option value="4">第四节课</option>
								<option value="5">第五节课</option>
								</select>
							</div>
						</div>
						<input type="hidden" value="${formData.startWeek}" id="startWeekSelectval">
						<div class="form-group"> 
							<label class="col-sm-2 control-label">开始周</label>
							<div class="col-sm-10">
								<select class="form-control" id="startWeekSelect" name="startWeek">
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
						<input type="hidden" value="${formData.endWeek}" id="endWeekSelectval">
						<div class="form-group"> 
							<label class="col-sm-2 control-label">结束周</label>
							<div class="col-sm-10">
								<select class="form-control" id="endWeekSelect" name="endWeek">
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
						<div class="form-group">
							<label class="col-sm-2 control-label">教室</label>
							<div class="col-sm-10">
								<input class="form-control" value="${formData.classRoom}" name="classRoom">
							</div>
						</div>
						
			                <div class="form-group">
								<label class="col-sm-2 control-label">任课教师</label>
								<div class="input-group">
									<input type="hidden" name="teacherJobNo" value="${formData.teacherJobNo}">
		                            <input type="text" class="form-control" name="teacherName" value="${formData.teacherName }" readonly>
		                            <span class="input-group-btn woSingleSelect" wo:url="staff/teacher/selector">
		                                <button class="btn btn-default" type="button"><i class="fa fa-search"></i>
		                                </button>
		                            </span>
	                            </div>
	                        </div>
						<div class="form-group">
							<div class="col-sm-2"></div>
							<div class="col-sm-10">
								<button type="submit" class="btn btn-primary">提交</button>
								<button type="reset" class="btn btn-default">重置</button>
								<button type="button" class="btn btn-warning"
									onclick="location.href='${pageContext.request.contextPath}/'">返回</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<!-- /.panel-body -->
	</div>
<script type="text/javascript">
	   	    $(document).ready(function () {
	   	    	
	   	    	
	   	    	$("#weekDaySelect option").each(function(){
	   	    		var weekDaySelectval = $("#weekDaySelectval").val();
	   	    		if($(this).val()==weekDaySelectval){
	   	    			$(this).attr("selected",true);
	   	    		}
	   	    	})
	   	    	
	   	    	
	   	    	$("#lessonSelect option").each(function(){
	   	    		var lessonSelectval = $("#lessonSelectval").val();
	   	    		if($(this).val()==lessonSelectval){
	   	    			$(this).attr("selected",true);
	   	    		}
	   	    	})
	   	    	
	   	    	$("#startWeekSelect option").each(function(){
	   	    		var startWeekSelectval = $("#startWeekSelectval").val();
	   	    		if($(this).val()==startWeekSelectval){
	   	    			$(this).attr("selected",true);
	   	    		}
	   	    	})
	   	    	
	   	    	$("#endWeekSelect option").each(function(){
	   	    		var endWeekSelectval = $("#endWeekSelectval").val();
	   	    		if($(this).val()==endWeekSelectval){
	   	    			$(this).attr("selected",true);
	   	    		}
	   	    	})
	   	    	$("#startWeekSelect").change(function(){
					var startweek = $(this).val();
					var endweek = $("#endWeekSelect").val();
					for(var i=1;i<startweek;i++){
						$("#endWeekSelect option[value='"+i+"']").hide();
					}
					$("#endWeekSelect option[value='"+startweek+"']").prop("selected",true);
				})
	   	  		// 设置各字段的验证规则
	   	    	var fields = {};
	   	    		if (!fields['id']) {
	   	    		fields['id'] = {validators:{}};
	   	    	}
	   	    		fields['id'].validators['notEmpty'] = {
	   	    		message: 'ID不能为空'
	   	    	};
	   	    		if (!fields['name']) {
	   	    		fields['name'] = {validators:{}};
	   	    	}
	   	    		fields['name'].validators['notEmpty'] = {
	   	    		message: '名称不能为空'
	   	    	};
	   	    		if (!fields['courseWeek']) {
	   	    		fields['courseWeek'] = {validators:{}};
	   	    	}
	   	    		fields['courseWeek'].validators['notEmpty'] = {
	   	    		message: '学时不能为空'
	   	    	};
	   	    		if (!fields['courseScore']) {
	   	    		fields['courseScore'] = {validators:{}};
	   	    	}
	   	    		fields['courseScore'].validators['notEmpty'] = {
	   	    		message: '学分不能为空'
	   	    	};
	   	    		
	   	    	// 将验证规则应用到表单的字段中
	   			$('#courseUpdateForm').bootstrapValidator({
		            // 默认错误消息
	   				message: '输入值不合法',
	   				// 设置验证成功或者失败的图标
		            feedbackIcons: {
		                valid: 'glyphicon glyphicon-ok',
		                invalid: 'glyphicon glyphicon-remove',
		                validating: 'glyphicon glyphicon-refresh'
		            },
		            // 设置不同字段的验证规则和错误信息
		            fields: fields
		        });
	   	    	
	   	  		// 关联对象选择器按钮点击事件
	   			$('#electiveCoursePlanForm .input-group-btn').click (function () {
	   				var nameField = $(this).prev().attr ('name');
	   				var idField = $(this).prev().prev().attr ('name');
	   				$('#teacherUserDialog').remove();
	   		    	$('body').append ('<div class="modal fade" id="teacherUserDialog" tabindex="-1" role="dialog" aria-labelledby="teacherUserSelectorModalLabel"></div>');
	   		    	// 显示对话框
	   		    	$('#teacherUserDialog').load ('${pageContext.request.contextPath}/' + $(this).attr('wo:url'), {
	   		    		formId : 'electiveCoursePlanForm',
	   		    		idField : idField,
	   		    		nameField : nameField,
	   		    		singleSelect : $(this).hasClass('woSingleSelect')
	   		    	},function () {
	   		    		$('#teacherUserDialog').modal ('show');
	   		    	});
	   			});
		    });
   			</script>
</div>