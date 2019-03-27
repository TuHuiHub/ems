<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">创建教室</div>
				<div class="panel-body">
					<form role="form" id="emsClassRoomCreateForm"
						class="form-horizontal"
						action="${pageContext.request.contextPath}/ems/classRoom/create"
						method="post" enctype="multipart/form-data">
						<div class="form-group">
							<label class="col-sm-2 control-label">id</label>
							<div class="col-sm-10">
								<input class="form-control" placeholder="请输入id" name="id">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">roomName</label>
							<div class="col-sm-10">
								<input class="form-control" placeholder="请输入roomName"
									name="roomName">
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
	   	    		message: 'id不能为空'
	   	    	};
	   	    		   	    		   	    	if (!fields['roomName']) {
	   	    		fields['roomName'] = {validators:{}};
	   	    	}
	   	    		   	    		   	    	
	   	  		// 将验证规则应用到表单的字段中
	   			$('#emsClassRoomCreateForm').bootstrapValidator({
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
	   	    	$('#emsClassRoomCreateForm .input-group-btn').click (function () {
					var nameField = $(this).prev().attr ('name');
					var idField = $(this).prev().prev().attr ('name');
					$('#emsClassRoomDialog').remove();
	            	$('body').append ('<div class="modal fade" id="emsClassRoomDialog" tabindex="-1" role="dialog" aria-labelledby="emsClassRoomSelectorModalLabel"></div>');
	            	// 显示对话框
	            	$('#emsClassRoomDialog').load ('${pageContext.request.contextPath}/' + $(this).attr('wo:url'), {
	            		formId : 'emsClassRoomCreateForm',
	            		idField : idField,
	            		nameField : nameField,
	            		singleSelect : $(this).hasClass('woSingleSelect')
	            	},function () {
	            		$('#emsClassRoomDialog').modal ('show');
	            	});
				});
		    });
   			</script>
</div>