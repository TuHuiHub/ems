<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="wo.bsys.util.BSysConstant" %>
<%@page import="wo.bsys.vo.WoUser" %>
<%
	WoUser u = (WoUser) session.getAttribute(BSysConstant.SESSION_USER);
%>
<script type="text/javascript">
	var loge=false;
	$(function(){
		$("#password").blur(function(){
			$.get("${pageContext.request.contextPath}/staff/student/staff/verifypassword",
				{"password":$(this).val()},
				function(data){
					alert(data);
					if (data!="1") {
						$("#span").html("输入错误");
						loge=false;
					} else{
						$("span").html("");
						loge=true;
					}
				}
			)
		})
		$("#newpassword").blur(function(){
			if ($(this).val()=="") {
				$("#span2").html("密码不能为空");
				loge=false;
			} else{
				$("span").html("");
				loge=true;
			}
		})
		$("#realpassword").blur(function(){
			if ($(this).val()!=$("#newpassword").val()) {
				$("#span3").html("两次密码不同");
				loge=false;
			} else{
				$("span").html("");
				loge=true;
			}
		})
	})
	function getloge(){
		return loge;
	}
</script>
<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">修改密码</div>
				<div class="panel-body">
					<form role="form" id="updatestudentinfo" class="form-horizontal"
						action="${pageContext.request.contextPath}/staff/student/staff/updatepassword"
						method="post" enctype="multipart/form-data" onsubmit="return getloge()">
						<div class="form-group">
							<label class="col-sm-2 control-label">原密码</label>
							<div class="col-sm-10">
								<input type="password" class="form-control" name="password" id="password" >
								<span id="span" style="color: red;"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">新密码</label>
							<div class="col-sm-10">
								<input type="password" class="form-control" name="newpassword" id="newpassword">
								<span id="span2" style="color: red;"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">确认密码</label>
							<div class="col-sm-10">
								<input type="password" class="form-control" name="realpassword" id="realpassword">
								<span id="span3" style="color: red;"></span>
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
	
</div>
