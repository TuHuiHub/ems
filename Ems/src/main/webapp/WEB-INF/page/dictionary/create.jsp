<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
		<div id="page-wrapper">
            <div class="row">
            <div class="col-lg-12">
				<div class="panel panel-default">
                	<div class="panel-heading">
                        创建数据字典
                    </div>
	                <div class="panel-body">
	                	<form role="form" id="bsysDictionaryCreateForm" class="form-horizontal" 
							action="${pageContext.request.contextPath}/bsys/dictionary/create"
							method="post" enctype="multipart/form-data">
										                <div class="form-group">
			                    <label class="col-sm-2 control-label">ID</label>
			                    <div class="col-sm-10">
			                    	<input class="form-control" placeholder="请输入ID" name="id">
			                    </div>
			                </div>
			                			                			                <div class="form-group">
			                    <label class="col-sm-2 control-label">类型</label>
			                    <div class="col-sm-10">
			                    	<input class="form-control" placeholder="请输入类型" name="dicType">
			                    </div>
			                </div>
			                			                <div class="form-group">
			                    <label class="col-sm-2 control-label">值</label>
			                    <div class="col-sm-10">
			                    	<input class="form-control" placeholder="请输入值" name="val">
			                    </div>
			                </div>
			                			                <div class="form-group">
			                    <label class="col-sm-2 control-label">键</label>
			                    <div class="col-sm-10">
			                    	<input class="form-control" placeholder="请输入键" name="name">
			                    </div>
			                </div>
			                			                <div class="form-group">
			                    <label class="col-sm-2 control-label">描述</label>
			                    <div class="col-sm-10">
			                    	<input class="form-control" placeholder="请输入描述" name="description">
			                    </div>
			                </div>
			                			                <div class="form-group">
			                    <label class="col-sm-2 control-label">参数</label>
			                    <div class="col-sm-10">
			                    	<input class="form-control" placeholder="请输入参数" name="params">
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
	   	    		   	    		   	    	if (!fields['dicType']) {
	   	    		fields['dicType'] = {validators:{}};
	   	    	}
	   	    		   	    	fields['dicType'].validators['notEmpty'] = {
	   	    		message: '类型不能为空'
	   	    	};
	   	    		   	    		   	    	if (!fields['val']) {
	   	    		fields['val'] = {validators:{}};
	   	    	}
	   	    		   	    	fields['val'].validators['notEmpty'] = {
	   	    		message: '值不能为空'
	   	    	};
	   	    		   	    		   	    	if (!fields['name']) {
	   	    		fields['name'] = {validators:{}};
	   	    	}
	   	    		   	    	fields['name'].validators['notEmpty'] = {
	   	    		message: '键不能为空'
	   	    	};
	   	    		   	    		   	    	if (!fields['description']) {
	   	    		fields['description'] = {validators:{}};
	   	    	}
	   	    		   	    		   	    	if (!fields['params']) {
	   	    		fields['params'] = {validators:{}};
	   	    	}
	   	    		   	    		   	    	
	   	  		// 将验证规则应用到表单的字段中
	   			$('#bsysDictionaryCreateForm').bootstrapValidator({
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
	   	    	$('#bsysDictionaryCreateForm .input-group-btn').click (function () {
					var nameField = $(this).prev().attr ('name');
					var idField = $(this).prev().prev().attr ('name');
					$('#bsysDictionaryDialog').remove();
	            	$('body').append ('<div class="modal fade" id="bsysDictionaryDialog" tabindex="-1" role="dialog" aria-labelledby="bsysDictionarySelectorModalLabel"></div>');
	            	// 显示对话框
	            	$('#bsysDictionaryDialog').load ('${pageContext.request.contextPath}/' + $(this).attr('wo:url'), {
	            		formId : 'bsysDictionaryCreateForm',
	            		idField : idField,
	            		nameField : nameField,
	            		singleSelect : $(this).hasClass('woSingleSelect')
	            	},function () {
	            		$('#bsysDictionaryDialog').modal ('show');
	            	});
				});
		    });
   			</script>
		</div>