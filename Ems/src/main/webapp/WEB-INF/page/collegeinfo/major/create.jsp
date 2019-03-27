<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">新建专业</div>
				<div class="panel-body">
					<form role="form" id="MajorCreateForm"
						class="form-horizontal"
						action="${pageContext.request.contextPath}/collegeinfo/major/create"
						method="post" >
						<div class="form-group">
							<label class="col-sm-2 control-label">ID</label>
							<div class="col-sm-10">
								<input class="form-control" placeholder="请输入ID" name="id">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">专业名</label>
							<div class="col-sm-10">
								<input class="form-control" placeholder="请输入专业名" name="name">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">学制</label>
							<div class="col-sm-10">
								<input class="form-control" placeholder="请输入学制" name="eduSys">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">学院ID</label>
							<div class="col-sm-10">
								<input class="form-control" value="${college.id}" name="collegeId">
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
   	    		if (!fields['eduSys']) {
   	    		fields['eduSys'] = {validators:{}};
   	    	}
   	    		fields['eduSys'].validators['notEmpty'] = {
   	    		message: '学制不能为空'
   	    	};
   	    		if (!fields['collegeId']) {
   	    		fields['collegeId'] = {validators:{}};
   	    	}
   	    		fields['collegeId'].validators['notEmpty'] = {
   	    		message: '学院ID不能为空'
   	    	}
   	    	
   	    		   	    		   	    	
   	  		// 将验证规则应用到表单的字段中
   			$('#MajorCreateForm').bootstrapValidator({
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
   	    	$('#MajorCreateForm .input-group-btn').click (function () {
				var nameField = $(this).prev().attr ('name');
				var idField = $(this).prev().prev().attr ('name');
				$('#MajorDialog').remove();
            	$('body').append ('<div class="modal fade" id="MajorDialog" tabindex="-1" role="dialog" aria-labelledby="MajorSelectorModalLabel"></div>');
            	// 显示对话框
            	$('#MajorDialog').load ('${pageContext.request.contextPath}/' + $(this).attr('wo:url'), {
            		formId : 'MajorCreateForm',
            		idField : idField,
            		nameField : nameField,
            		singleSelect : $(this).hasClass('woSingleSelect')
            	},function () {
            		$('#MajorDialog').modal ('show');
            	});
			});
	    });
  	</script>
</div>