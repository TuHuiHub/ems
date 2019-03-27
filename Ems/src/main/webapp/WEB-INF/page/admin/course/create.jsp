<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.dream.ems.dto.MajorDto" %>
<%
	MajorDto  major = (MajorDto)request.getAttribute("major");
%>
<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">新建课程</div>
				<div class="panel-body">
					<form role="form" id="courseCreateForm"
						class="form-horizontal"
						action="${pageContext.request.contextPath}/collegeinfo/course/publicCreate"
						method="post" >
						<div class="form-group">
							<label class="col-sm-2 control-label">ID</label>
							<div class="col-sm-10">
								<input class="form-control" placeholder="请输入ID" name="id">
							</div>
						</div>
							<div class="form-group">
							<label class="col-sm-2 control-label">课程名</label>
							<div class="col-sm-10">
								<input class="form-control" placeholder="请输入课程名" name="name">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">学时</label>
							<div class="col-sm-10">
								<input class="form-control" placeholder="请输入学时" name="courseWeek">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">学分</label>
							<div class="col-sm-10">
								<input class="form-control" placeholder="请输入学分" name="courseScore">
							</div>
						</div>
						
						<input type="hidden" class="form-control"  name="isOptional">
					
						<div class="form-group">
							<label class="col-sm-2 control-label">专业ID</label>
							<div class="col-sm-10">
								<input class="form-control" name="majorId">
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-2 control-label">开始周</label>
							<div class="col-sm-10">
								<input class="form-control" placeholder="请输入开始周" name="startWeek">
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-2 control-label">结束周</label>
							<div class="col-sm-10">
								<input class="form-control" placeholder="请输入结束周" name="endWeek">
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-2 control-label">学期</label>
							<div class="col-sm-10">
								<input class="form-control" placeholder="请输入学期" name="semesterId">
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
   			$('#courseCreateForm').bootstrapValidator({
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
   	    	$('#courseCreateForm .input-group-btn').click (function () {
				var nameField = $(this).prev().attr ('name');
				var idField = $(this).prev().prev().attr ('name');
				$('#courseDialog').remove();
            	$('body').append ('<div class="modal fade" id="courseDialog" tabindex="-1" role="dialog" aria-labelledby="courseSelectorModalLabel"></div>');
            	// 显示对话框
            	$('#courseDialog').load ('${pageContext.request.contextPath}/' + $(this).attr('wo:url'), {
            		formId : 'courseCreateForm',
            		idField : idField,
            		nameField : nameField,
            		singleSelect : $(this).hasClass('woSingleSelect')
            	},function () {
            		$('#courseDialog').modal ('show');
            	});
			});
	    });

  	</script>
</div>