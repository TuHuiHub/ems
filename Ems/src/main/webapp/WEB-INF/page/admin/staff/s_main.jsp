<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
		<div id="page-wrapper">
			<div class="row">
                <div class="col-lg-12">
                    <h4>学生用户管理</h4>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="studentUserTable">
                                <thead>
                                    <tr>
                                        <th>学号</th>
                                                                                <th>姓名</th>
                                                                                <th>性别</th>
                                                                                <th>出生日期</th>
                                                                                <th>入学时间</th>
                                                                                <th>所属学院</th>
                                                                                <th>所属专业</th>
                                                                                                                        <th>操作</th>
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
            <script>
            $(document).ready(function() {
            	var tableId = 'studentUserTable';
            	var cols = [
                	{ "data": "stuNo" , "orderable" : true},
                	                	{ "data": "name" , "orderable" : false},
                	                	{ "data": "sex" , "orderable" : false},
                	                	{ "data": "birthday" , "orderable" : false},
                	                	{ "data": "grade" , "orderable" : false},
                	                	{ "data": "collegeName" , "orderable" : false},
                	                	{ "data": "majorName" , "orderable" : false},
                	                	                    // 下面在操作列中添加了修改和删除按钮
                    { "data": null , "orderable" : false, "defaultContent": "<a class='btn btn-primary btn-xs' name='update'>修改</a> <a class='btn btn-primary btn-warning btn-xs' name='delete'>删除</a>"}
                ];
            	var orderIndex = 0;
            	for (var i = 0; i < cols.length; i ++) {
            		if (cols[i].orderable == true) {
            			orderIndex = i;
            		}
            	}
            	// 初始化列表，并触发后台的json数据获取
                var table = $('#' + tableId).DataTable({
                	"processing": true, // 显示处理进度
                    "serverSide": true, // 从服务端获取数据
                    "rowId" : 'stuNo',// 设置主键字段名称
                    "ajax": {
                        "url": "${pageContext.request.contextPath}/staff/student/list", // 请求列表数据的url
                        "type": "GET" // http方法
                    },
                    "order": [ [ orderIndex, "${entity.orderableField.order}" ] ] , // 排序
                    "columns": cols
                });
                // 设置列表中按钮的事件
                $('#' + tableId + ' tbody').on( 'click', 'a', function () {
                	// this表示a标签对应dom，$(this)将其转为jQuery对象，获取按钮所在行的json对象:UserDto
                    var data = table.row( $(this).parents('tr') ).data();
                	// 调用修改方法
                	if ($(this).attr('name') == 'update') {
                		updateStudentUser(data.stuNo);
                	}
                	// 调用删除方法
					if ($(this).attr('name') == 'delete') {
						deleteStudentUser (data.stuNo);
                	}
                } );
             	// 设置列表多选
                $('#' + tableId + ' tbody').on( 'click', 'tr', function () {
                	// 如果有info样式则删除，没有则添加
                	$(this).toggleClass('info');
                } );
             	
                // 添加工具栏按钮，找到设置分页的div，并添加创建和批量删除按钮的a标签
                $('#' + tableId + '_length').append (" <a class='btn btn-primary btn-sm' onclick='createStudentUser();'>创建</a> <a class='btn btn-primary btn-warning btn-sm' onclick='deleteStudentUsers();'>批量删除</a> <a class='btn btn-primary btn-warning btn-sm' onclick='exportStudents();'>导出</a>" );
            });

            function createStudentUser () {
            	location.href = "${pageContext.request.contextPath}/staff/student/create";
            }
            
            function updateStudentUser (id) {
            	location.href = "${pageContext.request.contextPath}/staff/student/update?id=" + id;
            }
            
            function deleteStudentUser (id) {
            	if (!confirm ('确定要删除选定的学生用户吗？')) {
            		return;
            	}
            	$.post ('${pageContext.request.contextPath}/staff/student/delete', {id : id}, function (result) {
		    		if (result.success) {
		    			var tableId = 'studentUserTable';
				    	var table = $('#' + tableId).DataTable();
				    	// 删除选中的行
		    			table.rows('.info').remove().draw(false);
		    		} 
		    		alert (result.message);
		    	});
            }
            
            function deleteStudentUsers () {
            	// 获取DataTable
		    	var tableId = 'studentUserTable';
		    	var table = $('#' + tableId).DataTable();
		    	// 查找样式为info的行，包含所有UserDto属性
		    	var rows = table.rows('.info').data();
		    	// 判断用户是否有选择
		    	if (rows.length == 0) {
		    		alert ('请选择至少一个学生用户！');
		    		return;
		    	}
		    	// 让用户确认删除
		    	if (!confirm ('是否删除选中的学生用户？')) {
		    		return;
		    	}
		    	// 拼接id字符串，多个id逗号隔开
		    	var ids = '';
		    	for (var i = 0; i < rows.length; i ++) {
		    		if (ids != '') {
		    			ids += ',';
		    		}
		    		ids += rows[i].stuNo;
		    	}
		    	// 发送ajax请求，如果成功刷新本页面，否则提示用户操作失败
		    	deleteStudentUser(ids);
		    }
            function exportStudents(){
            	location.href = "${pageContext.request.contextPath}/staff/student/export";
            }
		    </script>
		</div>