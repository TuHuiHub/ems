<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
		<div id="page-wrapper">
			<div class="row">
                <div class="col-lg-12">
                    <h4>角色管理</h4>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="bsysRoleTable">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                                                                <th>名称</th>
                                                                                <th>描述</th>
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
            	var tableId = 'bsysRoleTable';
            	var cols = [
                	{ "data": "id" , "orderable" : false},
                	                	{ "data": "name" , "orderable" : false},
                	                	{ "data": "description" , "orderable" : false},
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
                    "rowId" : 'id',// 设置主键字段名称
                    "ajax": {
                        "url": "${pageContext.request.contextPath}/bsys/role/list", // 请求列表数据的url
                        "type": "GET" // http方法
                    },
                    "order": [ [ orderIndex, "${entity.orderableField.order}" ] ] , // 排序
                    "columns": cols
                });
                // 设置列表中按钮的事件
                $('#' + tableId + ' tbody').on( 'click', 'a', function () {
                	// this表示a标签对应dom，$(this)将其转为jQuery对象，获取按钮所在行的json对象:RoleDto
                    var data = table.row( $(this).parents('tr') ).data();
                	// 调用修改方法
                	if ($(this).attr('name') == 'update') {
                		updateBsysRole(data.id);
                	}
                	// 调用删除方法
					if ($(this).attr('name') == 'delete') {
						deleteBsysRole (data.id);
                	}
                } );
             	// 设置列表多选
                $('#' + tableId + ' tbody').on( 'click', 'tr', function () {
                	// 如果有info样式则删除，没有则添加
                	$(this).toggleClass('info');
                } );
             	
                // 添加工具栏按钮，找到设置分页的div，并添加创建和批量删除按钮的a标签
                $('#' + tableId + '_length').append (" <a class='btn btn-primary btn-sm' onclick='createBsysRole();'>创建</a> <a class='btn btn-primary btn-warning btn-sm' onclick='deleteBsysRoles();'>批量删除</a>");
            });

            function createBsysRole () {
            	location.href = "${pageContext.request.contextPath}/bsys/role/create";
            }
            
            function updateBsysRole (id) {
            	location.href = "${pageContext.request.contextPath}/bsys/role/update?id=" + id;
            }
            
            function deleteBsysRole (id) {
            	if (!confirm ('确定要删除选定的角色吗？')) {
            		return;
            	}
            	$.post ('${pageContext.request.contextPath}/bsys/role/delete', {id : id}, function (result) {
		    		if (result.success) {
		    			var tableId = 'bsysRoleTable';
				    	var table = $('#' + tableId).DataTable();
				    	// 删除选中的行
		    			table.rows('.info').remove().draw(false);
		    		} 
		    		alert (result.message);
		    	});
            }
            
            function deleteBsysRoles () {
            	// 获取DataTable
		    	var tableId = 'bsysRoleTable';
		    	var table = $('#' + tableId).DataTable();
		    	// 查找样式为info的行，包含所有RoleDto属性
		    	var rows = table.rows('.info').data();
		    	// 判断角色是否有选择
		    	if (rows.length == 0) {
		    		alert ('请选择至少一个角色！');
		    		return;
		    	}
		    	// 让角色确认删除
		    	if (!confirm ('是否删除选中的角色？')) {
		    		return;
		    	}
		    	// 拼接id字符串，多个id逗号隔开
		    	var ids = '';
		    	for (var i = 0; i < rows.length; i ++) {
		    		if (ids != '') {
		    			ids += ',';
		    		}
		    		ids += rows[i].id;
		    	}
		    	// 发送ajax请求，如果成功刷新本页面，否则提示角色操作失败
		    	deleteBsysRole(ids);
		    }
		    </script>
		</div>