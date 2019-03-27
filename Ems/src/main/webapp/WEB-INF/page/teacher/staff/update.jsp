<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">修改密码</div>
				<div class="panel-body">
					<form role="form" id="teacherInfoUpdate"
						class="form-horizontal"
						action="${pageContext.request.contextPath}/staff/teacher/info/update"
						method="post" >
						<div class="form-group">
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">新密码</label>
							<div class="col-sm-10">
								<input class="form-control" placeholder="请输入密码" name="password" id="password"><span id="ps"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">确认密码</label>
							<div class="col-sm-10">
								<input class="form-control" placeholder="请确认密码"
									name="repassword" id="repassword"><span id="rps"></span>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-2"></div>
							<div class="col-sm-10">
								<button type="submit" class="btn btn-primary" onsubmit="return getPost()">提交</button>
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
		var flag = false;
		var reflag = false;
    		$(function(){
				
				$("#password").blur(function(){
						if($.trim($(this).val())==""){
							$("#ps").html("密码不能为空");
							flag =false;
						}else{
							$("#ps").html("");
							flag =true;
						}
				})
				
				$("#repassword").blur(function(){
						if($.trim($(this).val())==""){
							$("#rps").html("密码不能为空");
								reflag = false;
						}else{
								if($("#password").val()==$("#repassword").val()){
									reflag = true;
								}else{
									$("#rps").html("两次密码不一致");
									reflag = false;
								}
						}
				})
    		})
    		
    		function getPost(){
				if(flag&&reflag){
					return true;
				}
				return false;
			}
 </script>
</div>