<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
		<div id="page-wrapper">
            <div class="row">
            <div class="col-lg-12">
				<div class="panel panel-default">
                	<div class="panel-heading">
                        创建角色
                    </div>
	                <div class="panel-body">
	                	<form role="form" id="bsysRoleCreateForm" class="form-horizontal" 
							action="${pageContext.request.contextPath}/bsys/role/create"
							method="post" enctype="multipart/form-data">
										                <div class="form-group">
			                    <label class="col-sm-2 control-label">ID</label>
			                    <div class="col-sm-10">
			                    	<input class="form-control" placeholder="请输入ID" name="id">
			                    </div>
			                </div>
			                			                			                <div class="form-group">
			                    <label class="col-sm-2 control-label">名称</label>
			                    <div class="col-sm-10">
			                    	<input class="form-control" placeholder="请输入名称" name="name">
			                    </div>
			                </div>
			                			                <div class="form-group">
			                    <label class="col-sm-2 control-label">描述</label>
			                    <div class="col-sm-10">
			                    	<input class="form-control" placeholder="请输入描述" name="description">
			                    </div>
			                </div>
			                			                			                			                <div class="form-group">
								<label class="col-sm-2 control-label">菜单</label>
								<div class="input-group">
									<input type="hidden" name="menusId">
		                            <input type="text" class="form-control" name="menusName" readonly>
		                            <span class="input-group-btn" wo:url="bsys/menu/selector">
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
			                <button type="button" class="btn btn-warning" onclick="location.href='${pageContext.request.contextPath}/'">返回</button>
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
	   	    		   	    		   	    	if (!fields['description']) {
	   	    		fields['description'] = {validators:{}};
	   	    	}
	   	    		   	    		   	    	
	   	  		// 将验证规则应用到表单的字段中
	   			$('#bsysRoleCreateForm').bootstrapValidator({
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
	   	    	$('#bsysRoleCreateForm .input-group-btn').click (function () {
					var nameField = $(this).prev().attr ('name');
					var idField = $(this).prev().prev().attr ('name');
					$('#bsysRoleDialog').remove();
	            	$('body').append ('<div class="modal fade" id="bsysRoleDialog" tabindex="-1" role="dialog" aria-labelledby="bsysRoleSelectorModalLabel"></div>');
	            	// 显示对话框
	            	$('#bsysRoleDialog').load ('${pageContext.request.contextPath}/' + $(this).attr('wo:url'), {
	            		formId : 'bsysRoleCreateForm',
	            		idField : idField,
	            		nameField : nameField,
	            		singleSelect : $(this).hasClass('woSingleSelect')
	            	},function () {
	            		$('#bsysRoleDialog').modal ('show');
	            	});
				});
		    });
   			</script>
		</div>