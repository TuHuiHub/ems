<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h4>排课信息</h4>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<!-- /.panel-heading -->
				<div class="panel-body">
					<table width="100%"
						class="table table-striped table-bordered table-hover"
						id="courseSelectTable">
						<thead>
							<tr>
								<th>ID</th>
								<th>学院</th>
								<th>专业</th>
								<th>是否排课</th>
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
            	var tableId = 'courseSelectTable';
            	var cols = [
                	{ "data": "id" , "orderable" : false},
                	{ "data": "collegeName" , "orderable" : false},
                	{ "data": "name" , "orderable" : false},
                	{ "data": "isCourseSelected" , "orderable" : true},
                	// 下面在操作列中添加了修改和删除按钮
                    { "data": null , "orderable" : false, "defaultContent": "<a class='btn btn-primary btn-xs' name='readCourseTable'>查看课程表</a> <a class='btn btn-primary btn-warning btn-xs' name='courseSelected'>前往排课</a>"},
                    { "data": "collegeId" , "visible" : false}
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
                        "url": "${pageContext.request.contextPath}/coursetable/majorList", // 请求列表数据的url
                        "type": "GET" // http方法
                    },
                    "order": [ [ orderIndex, "${entity.orderableField.order}" ] ] , // 排序
                    "columns": cols
                });
                // 设置列表中按钮的事件
                $('#' + tableId + ' tbody').on( 'click', 'a', function () {
                	// this表示a标签对应dom，$(this)将其转为jQuery对象，获取按钮所在行的json对象:DictionaryDto
                    var data = table.row( $(this).parents('tr') ).data();
                	
                	// 查看课程表
                	if ($(this).attr('name') == 'readCourseTable') {
						if(data.isCourseSelected=="否"){
							if(confirm("该专业还未排课，是否前往排课？")){
							location.href = "${pageContext.request.contextPath}/collegeinfo/course/selectCourse?collegeId="+data.collegeId+"&majorId="+data.id;
							}
						}else{
							location.href = "${pageContext.request.contextPath}/coursetable/coursetable?collegeId="+data.collegeId+"&majorId="+data.id;
						}
						
                	}
                	// 前往排课
					if ($(this).attr('name') == 'courseSelected') {
						if(data.isCourseSelected=="是"){
							if(confirm("该专业已经排课，是否查看课程表？")){
								location.href = "${pageContext.request.contextPath}/coursetable/coursetable?collegeId="+data.collegeId+"&majorId="+data.id;
							}
						}else{
							location.href = "${pageContext.request.contextPath}/collegeinfo/course/selectCourse?collegeId="+data.collegeId+"&majorId="+data.id;
						}
					}
                } );
             	// 设置列表多选
             	
            });

            function readCourseTable () {
            	location.href = "${pageContext.request.contextPath}/collegeinfo/course/publicCreate";
            }

            function courseSelected (id) {
            	location.href = "${pageContext.request.contextPath}/collegeinfo/course/publicUpdate?id=" + id;
            }
            
            
	</script>
</div>