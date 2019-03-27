<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.dream.ems.dto.StudentDto" %>
	<%
	StudentDto studentDto =  (StudentDto)session.getAttribute("studentDto");
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div id="page-wrapper">
			<div class="row">
                <div class="col-lg-12">
                    <h4>学生信息</h4>
                </div>
                <!-- /.col-lg-12 -->
			</div>
			
			<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-body">
					<table width="80%"
						class="table table-striped table-bordered table-hover"
						id="teacherTable">
						<thead>
							<tr>
								<th style="width: 20%">学号</th>
								<td style="width: 80%">
									<%=studentDto.getStuNo() %>
								</td>
							</tr>
							<tr>
								<th>姓名</th>
								<td>
									<%=studentDto.getName() %>
								</td>
							</tr>
							<tr><th>性别</th>
							
								<td>
									<%=studentDto.getSex() %>
								</td>
							</tr>
							<tr>
								<th>出生日期</th>
								<td>
								<%=studentDto.getBirthday() %>
								</td>
							</tr>
							<tr>
								<th>入学时间</th>
								<td>
									<%=studentDto.getGrade() %>
								</td>
							</tr>
							<tr>
								<th>院系</th>
								<td>
									<%=studentDto.getCollegeName() %>
								</td>
							</tr>
							<tr>
								<th>专业</th>
								<td>
									<%=studentDto.getMajorName() %>
								</td>
							</tr>
							<tr>
								<th>操作</th>
								<td><button type="button" class="btn btn-warning"
									onclick="location.href='${pageContext.request.contextPath}/'">返回</button></td>
							</tr>

						</thead>
					</table>
				</div>
			</div>
			<!-- /.panel -->
		</div>
		<!-- /.col-lg-12 -->
	</div>
</div>