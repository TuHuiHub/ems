<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
		<div id="page-wrapper">
			<div class="row">
                <div class="col-lg-12">
                    <h4>日志管理</h4>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                        	<table width="100%" class="table table-striped table-bordered table-hover" id="semLogTable">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>类</th>
                                        <th>方法</th>
                                        <th>参数</th>
                                        <th>创建时间</th>
                                        <th>操作</th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <script type="text/javascript">
            	// 页面加载完成之后调用的方法
            	$(function () {
            		// 初始化列表，并触发后台的json数据获取
                    var table = $('#semLogTable').DataTable({
                    	"processing": true, // 显示处理进度
                        "serverSide": true, // 从服务端获取数据
                        "rowId" : 'id',// 设置主键字段名称
                        "ajax": {
                            "url": "${pageContext.request.contextPath}/operationLog/list", // 请求列表数据的url
                            "type": "GET" // http方法
                        },
                        "order": [ [ 4, "desc" ] ] , // 默认排序
                        "columns": [{
							"data": "id" , "orderable" : false
						},{
							"data": "clazz" , "orderable" : false
						},{
							"data": "method" , "orderable" : false
						},{
							"data": "args" , "orderable" : false
						},{
							"data": "createTime" , "orderable" : true
						},{
							"data": null , "orderable" : false, "defaultContent": "<a class='btn btn-primary btn-xs'>XX</a>"
						}]
                    });
            	});
            </script>
		</div>