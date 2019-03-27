<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.dream.ems.dto.StudentDto" %>
<%
	StudentDto s = (StudentDto) session.getAttribute("studentInfo");
%>
<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">修改个人信息</div>
				<div class="panel-body">
					<form role="form" id="updatestudentinfo" class="form-horizontal"
						action="${pageContext.request.contextPath}/staff/student/staff/updateinfo"
						method="post" enctype="multipart/form-data">
						<input type="hidden" value="<%=s.getUserId()%>" name="userId"> 
						<input type="hidden" value="<%=s.getLoginName()%>" name="loginName"> 
						<div class="form-group">
							<label class="col-sm-2 control-label">学号</label>
							<div class="col-sm-10">
								<input class="form-control" value="<%=s.getStuNo() %>" name="stuNo" readonly="readonly">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">名字</label>
							<div class="col-sm-10">
								<input class="form-control" value="<%=s.getName() %>" name="name">
							</div>
						</div>
						
						<div class="form-group">
                             <label class="col-sm-2 control-label">性别</label>
                             <div class="radio">
                                 <label >
                                     <input type="radio" name="sex" value="男" checked="<%=(s.getSex().equals("男")?"checked":"") %>">男
                                 </label>
                                 <label >
                                     <input type="radio" name="sex" value="女" checked="<%=(s.getSex().equals("女")?"checked":"") %>">女
                                 </label>
                             </div>
                        </div>
						<div class="form-group">
							<label class="col-sm-2 control-label">生日</label>
							<div class="col-sm-10">
								<input type="date" class="form-control" name="birthday" value="<%=s.getBirthday()%>">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">入学时间</label>
							<div class="col-sm-10">
								<input type="date" class="form-control" name="grade" value="<%=s.getGrade()%>" readonly="readonly">
							</div>
						</div>
						<input type="hidden" value="<%=s.getCollegeId()%>" name="collegeId"> 
						<div class="form-group">
							<label class="col-sm-2 control-label">所属学院</label>
							<div class="col-sm-10">
								<input class="form-control" value="<%=s.getCollegeName()%>" name="collegeName" readonly="readonly">
							</div>
						</div>
						<input type="hidden" value="<%=s.getMajorId()%>" name="majorId"> 
						<div class="form-group">
							<label class="col-sm-2 control-label">所属专业</label>
							<div class="col-sm-10">
								<input class="form-control" value="<%=s.getMajorName() %>" name="majorName" readonly="readonly">
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
	    	if (!fields['name']) {
   	    		fields['name'] = {validators:{}};
   	    	}
   	    	fields['name'].validators['notEmpty'] = {
   	    		message: '姓名不能为空'
   	    	};
   	    	if (!fields['birthdy']) {
   	    		fields['birthdy'] = {validators:{}};
   	    	}
   	    	fields['birthdy'].validators['notEmpty'] = {
   	    		message: '生日不能为空'
   	    	};
	   		
	    	// 将验证规则应用到表单的字段中
			$('#updatestudentinfo').bootstrapValidator({
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
	    });
	</script>
</div>