<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.dream.ems.dto.TeacherDto" %>
	<%
	TeacherDto teacher =  (TeacherDto)session.getAttribute("teacherDto");
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h4>个人信息</h4>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<!-- /.panel-heading -->
				<div class="panel-body">
					<table width="80%"
						class="table table-striped table-bordered table-hover"
						id="teacherTable">
						<thead>
							<tr>
								<th style="width: 20%">工号</th>
								<td style="width: 80%">
									<%=teacher.getJobNo() %>
								</td>
							</tr>
							<tr>
								<th>姓名</th>
								<td>
									<%=teacher.getName() %>
								</td>
							</tr>
							<tr><th>性别</th>
							
								<td>
									<%=teacher.getSex() %>
								</td>
							</tr>
							<tr>
								<th>出生日期</th>
								<td>
								<%=teacher.getBirthday() %>
								</td>
							</tr>
							<tr>
								<th>学位</th>
								<td>
									<%=teacher.getDegree() %>
								</td>
							</tr>
							<tr>
								<th>教师级别</th>
								<td>
									<%=teacher.getTitle() %>
								</td>
							</tr>
							<tr>
								<th>操作</th>
								<td><a class='btn btn-primary btn-sm' onclick='updateTeacher();'>修改密码</a></td>
							</tr>

						</thead>
					</table>
					<!-- /.table-responsive -->
				</div>
				<!-- /.panel-body -->
			</div>
			<!-- /.panel -->
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<script type="text/javascript">
	function updateTeacher(id) {
		location.href = "${pageContext.request.contextPath}/staff/teacher/info/update";
	}
	</script>
</div>