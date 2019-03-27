<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="java.util.List" %>
<%@page import="wo.bsys.dto.DictionaryDto" %>
<%@page import="com.dream.ems.dto.TeacherDto" %>
<%@page import="com.dream.ems.po.College" %>
<%
	List<DictionaryDto> genders = (List<DictionaryDto>)request.getAttribute ("genders");
	TeacherDto dto =  (TeacherDto)request.getAttribute ("formData");
%>
			<div id="page-wrapper">
            <div class="row">
            <div class="col-lg-12">
				<div class="panel panel-default">
                	<div class="panel-heading">
                        修改教师用户
                    </div>
	                <div class="panel-body">
	                	<form role="form" id="teacherUserUpdateForm" class="form-horizontal" 
							action="${pageContext.request.contextPath}/staff/teacher/update"
							method="post" enctype="multipart/form-data">
										              <div class="form-group">
			                    <label class="col-sm-2 control-label">工号</label>
			                    <div class="col-sm-10">
			                    	<input class="form-control" placeholder="请输入工号" name="jobNo" value="${formData.jobNo}" readonly>
			                    </div>
			                </div>
			                			                			                <div class="form-group">
			                    <label class="col-sm-2 control-label">姓名</label>
			                    <div class="col-sm-10">
			                    	<input class="form-control" placeholder="请输入姓名" name="name" value="${formData.name}">
			                    </div>
			                </div>
			                <div class="form-group">
	                            <% for (int i = 0; i < genders.size(); i ++) {
	                            	DictionaryDto dic = genders.get(i);
								%>
	                            <label class="col-sm-2 control-label"><%=(i>0?"":"性别")%></label>
	                            <div class="radio col-sm-10">
	                                <label>
	                                <%if(dic.getName().equals(dto.getSex())) {%>
	                                    <input type="radio" checked="checked" name="sex" value="<%=dic.getName()%>"><%=dic.getName()%>
	                                    <%}else{ %>
	                                      <input type="radio"  name="sex" value="<%=dic.getName()%>"><%=dic.getName()%>
	                                      <%} %>
	                                </label>
	                            </div>
	                            <% } %>
	                        </div>
						 <div class="form-group">
			                    <label class="col-sm-2 control-label">出生日期</label>
			                    <div class="col-sm-10">
			                    	<input class="form-control" placeholder="请输入出生日期" name="birthday" value="${formData.birthday }">
			                    </div>
			                </div>
						
			                			             <div class="form-group">
								<label class="col-sm-2 control-label">所属学院</label>
								<div class="input-group">
									<input type="hidden" name="collegeId" value="${formData.collegeId}">
		                            <input type="text" class="form-control" name="collegeName" value="${formData.collegeName }" readonly>
		                            <span class="input-group-btn woSingleSelect" wo:url="collegeinfo/college/selector">
		                                <button class="btn btn-default" type="button"><i class="fa fa-search"></i>
		                                </button>
		                            </span>
	                            </div>
	                        </div>
			                 <div class="form-group">
			                    <label class="col-sm-2 control-label">学历</label>
			                    <div class="col-sm-10">
			                    	<input class="form-control" placeholder="请输入学历" name="degree" value="${formData.degree}">
			                    </div>
			                </div>
			                 <div class="form-group">
			                    <label class="col-sm-2 control-label">头衔</label>
			                    <div class="col-sm-10">
			                    	<input class="form-control" placeholder="请输入教学头衔" name="title" value="${formData.title}">
			                    </div>
			                </div>
			                <div class="form-group">
							<label class="col-sm-2 control-label">密码</label>
							<div class="col-sm-10">
								<input class="form-control" placeholder="请输入密码" name="userPassword" value="${formData.userPassword }">
							</div>
			                	</div>
								<div class="form-group">
						 <label class="col-sm-2 control-label">角色</label>
							<div class="col-sm-10">
							<select name="roleId" class="form-control">
								<option value="teacher">教师用户</option>
							</select>
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
	   	    		   	    		   	    	if (!fields['loginName']) {
	   	    		fields['loginName'] = {validators:{}};
	   	    	}
	   	    		   	    		   	    	if (!fields['password']) {
	   	    		fields['password'] = {validators:{}};
	   	    	}
	   	    		   	    		   	    	if (!fields['createTime']) {
	   	    		fields['createTime'] = {validators:{}};
	   	    	}
	   	    		   	    		   	    	if (!fields['passwordTime']) {
	   	    		fields['passwordTime'] = {validators:{}};
	   	    	}
	   	    		   	    		   	  		// 将验证规则应用到表单的字段中
	   			$('#teacherUserUpdateForm').bootstrapValidator({
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
	   	    	$('#teacherUserUpdateForm .input-group-btn').click (function () {
					var nameField = $(this).prev().attr ('name');
					var idField = $(this).prev().prev().attr ('name');
					$('#teacherUserDialog').remove();
	            	$('body').append ('<div class="modal fade" id="teacherUserDialog" tabindex="-1" role="dialog" aria-labelledby="teacherUserSelectorModalLabel"></div>');
	            	// 显示对话框
	            	$('#teacherUserDialog').load ('${pageContext.request.contextPath}/' + $(this).attr('wo:url'), {
	            		formId : 'teacherUserUpdateForm',
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