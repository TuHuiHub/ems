<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
			<div id="page-wrapper">
            <div class="row">
            <div class="col-lg-12">
				<div class="panel panel-default">
                	<div class="panel-heading">
                                                          创建班级
                    </div>
	                <div class="panel-body">
	                	<form role="form" id="emsClazzCreateForm" class="form-horizontal" 
							action="${pageContext.request.contextPath}/ems/clazz/create"
							method="post" enctype="multipart/form-data">
										                <div class="form-group">
			                    <label class="col-sm-2 control-label">id</label>
			                    <div class="col-sm-10">
			                    	<input class="form-control" placeholder="请输入id" name="id">
			                    </div>
			                </div>
			                			                			                <div class="form-group">
			                    <label class="col-sm-2 control-label">clazzName</label>
			                    <div class="col-sm-10">
			                    	<input class="form-control" placeholder="请输入clazzName" name="clazzName">
			                    </div>
			                </div>
			                			                			                			                <div class="form-group">
								<label class="col-sm-2 control-label">major</label>
								<div class="input-group">
									<input type="hidden" name="majorId">
		                            <input type="text" class="form-control" name="majorName" readonly>
		                            <span class="input-group-btn woSingleSelect" wo:url="ems/major/selector">
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
	   	    		message: 'id不能为空'
	   	    	};
	   	    		   	    		   	    	if (!fields['clazzName']) {
	   	    		fields['clazzName'] = {validators:{}};
	   	    	}
	   	    		   	    		   	    	
	   	  		// 将验证规则应用到表单的字段中
	   			$('#emsClazzCreateForm').bootstrapValidator({
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
	   	    	$('#emsClazzCreateForm .input-group-btn').click (function () {
					var nameField = $(this).prev().attr ('name');
					var idField = $(this).prev().prev().attr ('name');
					$('#emsClazzDialog').remove();
	            	$('body').append ('<div class="modal fade" id="emsClazzDialog" tabindex="-1" role="dialog" aria-labelledby="emsClazzSelectorModalLabel"></div>');
	            	// 显示对话框
	            	$('#emsClazzDialog').load ('${pageContext.request.contextPath}/' + $(this).attr('wo:url'), {
	            		formId : 'emsClazzCreateForm',
	            		idField : idField,
	            		nameField : nameField,
	            		singleSelect : $(this).hasClass('woSingleSelect')
	            	},function () {
	            		$('#emsClazzDialog').modal ('show');
	            	});
				});
		    });
   			</script>
		</div>