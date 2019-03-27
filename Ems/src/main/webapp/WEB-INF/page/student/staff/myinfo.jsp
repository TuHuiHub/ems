<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<script>
		$.get(
			"${pageContext.request.contextPath}/staff/student/staff/list",
			function(data){
				var student = eval(data);
				
				var str ="";
				str+="<th>"+student.stuNo+"</th>"
				str+="<th>"+student.name+"</th>"
				str+="<th>"+student.sex+"</th>"
				str+="<th>"+student.birthday+"</th>"
				str+="<th>"+student.grade+"</th>"
				str+="<th>"+student.collegeName+"</th>"
				str+="<th>"+student.majorName+"</th>"
				
				$("#info").append(str);
			}
		)	    
	
	</script>
	
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
                            <table width="100%" class="table table-striped table-bordered table-hover" id="studentMyInfoTable">
                                <thead>
                                    <tr>
                                        <th>学号</th>
                                        <th>姓名</th>
                                        <th>性别</th>
                                        <th>生日</th>
                                        <th>入学时间</th>
                                        <th>所属学院</th>
                                        <th>所属专业</th>
                                    </tr>
                                    <tr id="info">
                                    </tr>
                                </thead>
                            </table>
                            <!-- /.table-responsive -->
                        </div>
                        <div class="col-sm-12">
                        	<div style="margin-left: 950px" >
                        		<ul class="pagination">
                        			<li class="paginate_button "  tabindex="0">
                        				<a href="${pageContext.request.contextPath}/staff/student/staff/updateinfo">修改个人资料</a>
                        			</li>
                        			<li class="paginate_button "  tabindex="0">
                        				<a href="${pageContext.request.contextPath}/staff/student/staff/updatepassword">修改密码</a>
                        			</li>
                        		</ul>
                        	</div>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
		</div>