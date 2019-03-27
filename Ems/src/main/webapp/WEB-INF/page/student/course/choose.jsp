<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>选课</title>
</head>
<body>
<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h4>选课</h4>
        </div>
    </div>
    <!-- /.row -->
    <div class="row">
        <div class="col-lg-3">
            <div class="form-group">
                <label>学期</label>
                <select id="semesterId" class="form-control">
                    <option value="6">2018-2019-1</option>
                </select>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <table width="100%" class="table table-striped table-bordered table-hover" id="chooseCourseTable">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>名称</th>
                            <th>教师</th>
                            <th>教室</th>
                            <th>开始周数</th>
                            <th>结束周数</th>
                            <th>星期</th>
                            <th>节数</th>
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
        $(document).ready(function () {
            var tableId = 'chooseCourseTable';
            var cols = [
                {"data": "id", "orderable": true},
                {"data": "courseName", "orderable": false},
                {"data": "teacherName", "orderable": false},
                {"data": "classRoomName", "orderable": false},
                {"data": "startWeek", "orderable": false},
                {"data": "endWeek", "orderable": false},
                {"data": "weekDay", "orderable": false},
                {"data": "lesson", "orderable": false}
            ];
            var orderIndex = 0;
            for (var i = 0; i < cols.length; i++) {
                if (cols[i].orderable == true) {
                    orderIndex = i;
                }
            }
            // 初始化列表，并触发后台的json数据获取
            var table = $('#' + tableId).DataTable({
                "processing": true, // 显示处理进度
                "serverSide": true, // 从服务端获取数据
                "rowId": 'id',// 设置主键字段名称
                "ajax": {
                    "url": "${pageContext.request.contextPath}/coursetable/course/list", // 请求列表数据的url
                    "type": "GET" // http方法
                },
                "order": [[0, "asc"]], // 排序
                "columns": cols
            });
            // 设置列表多选
            $('#' + tableId + ' tbody').on('click', 'tr', function () {
                // 如果有info样式则删除，没有则添加
                $(this).toggleClass('info');
            });

            // 添加工具栏按钮，找到设置分页的div，并添加创建和批量删除按钮的a标签
            $('#' + tableId + '_length').append(" <a class='btn btn-primary btn-warning btn-sm' onclick='chooseChooseCourses();'>选择</a>");
        });

        function chooseChooseCourse(id) {
            if (!confirm('确定要选择该课程吗？')) {
                return;
            }
            $.post('${pageContext.request.contextPath}/coursetable/course/choose', {id: id}, function (result) {
                if (result.success) {
                    var tableId = 'chooseCourseTable';
                    var table = $('#' + tableId).DataTable();
                    // 删除选中的行的样式
                    $('#' + tableId + ' tbody tr').removeClass('info');
                    alert(result.message);
                } else {
                    alert('选课失败，已选该课程或课表上该节次已有课');
                }

            });
        }

        function chooseChooseCourses() {
            // 获取DataTable
            var tableId = 'chooseCourseTable';
            var table = $('#' + tableId).DataTable();
            // 查找样式为info的行，包含所有MenuDto属性
            var rows = table.rows('.info').data();
            // 判断菜单是否有选择
            if (rows.length == 0) {
                alert('请选择至少一个课程！');
                return;
            }
            // 让菜单确认删除
            if (!confirm('是否确定选中的课程？')) {
                return;
            }
            // 拼接id字符串，多个id逗号隔开
            var ids = '';
            for (var i = 0; i < rows.length; i++) {
                if (ids != '') {
                    ids += ',';
                }
                ids += rows[i].id;
            }
            // 发送ajax请求，如果成功刷新本页面，否则提示菜单操作失败
            chooseChooseCourse(ids);
        }
    </script>
</div>

</body>
</html>