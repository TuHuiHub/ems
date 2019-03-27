<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<style type="text/css">
    td {
        width: 100px;
        height: 60px;
    }

    th {
        width: 100px;
        height: 60px;
    }

</style>
<script type="text/javascript">

    $.ajax({
        type: "get",
        url: "${pageContext.request.contextPath}/staff/teacher/teachercourse/list",
        async: true,
        success: function (result) {
            var data = result;
            $("#sel").change(function () {

                $("#courseinfoTable td").html("");
                for (var i = 0; data.length > i; i++) {
                    if (data[i].startWeek * 10 - 1 < $(this).val() * 10 && data[i].endWeek * 10 > $(this).val() * 10) {
                        var lesson = data[i].lesson;
                        var weekDay = data[i].weekDay;
                        if (lesson == "1" && weekDay == "1") {
                            $("#o1").html(data[i].courseName + '</br>' + '教室：' + data[i].classRoomName + '</br>' + "<a class='btn btn-primary btn-xs' onclick='studentInfo(" + data[i].clazzId + ");'>查看学生</a>");
                        }
                        if (lesson == "2" && weekDay == "1") {
                            $("#r1").html(data[i].courseName + '</br>' + '教室：' + data[i].classRoomName + '</br>' + "<a class='btn btn-primary btn-xs' onclick='studentInfo(" + data[i].clazzId + ");'>查看学生</a>");
                        }
                        if (lesson == "3" && weekDay == "1") {
                            $("#s1").html(data[i].courseName + '</br>' + '教室：' + data[i].classRoomName + '</br>' + "<a class='btn btn-primary btn-xs' onclick='studentInfo(" + data[i].clazzId + ");'>查看学生</a>");
                        }
                        if (lesson == "4" && weekDay == "1") {
                            $("#si1").html(data[i].courseName + '</br>' + '教室：' + data[i].classRoomName + '</br>' + "<a class='btn btn-primary btn-xs' onclick='studentInfo(" + data[i].clazzId + ");'>查看学生</a>");
                        }
                        if (lesson == "5" && weekDay == "1") {
                            $("#w1").html(data[i].courseName + '</br>' + '教室：' + data[i].classRoomName + '</br>' + "<a class='btn btn-primary btn-xs' onclick='studentInfo(" + data[i].clazzId + ");'>查看学生</a>");
                        }

                        if (lesson == "1" && weekDay == "2") {
                            $("#o2").html(data[i].courseName + '</br>' + '教室：' + data[i].classRoomName + '</br>' + "<a class='btn btn-primary btn-xs' onclick='studentInfo(" + data[i].clazzId + ");'>查看学生</a>");
                        }
                        if (lesson == "2" && weekDay == "2") {
                            $("#r2").html(data[i].courseName + '</br>' + '教室：' + data[i].classRoomName + '</br>' + "<a class='btn btn-primary btn-xs' onclick='studentInfo(" + data[i].clazzId + ");'>查看学生</a>");
                        }
                        if (lesson == "3" && weekDay == "2") {
                            $("#s2").html(data[i].courseName + '</br>' + '教室：' + data[i].classRoomName + '</br>' + "<a class='btn btn-primary btn-xs' onclick='studentInfo(" + data[i].clazzId + ");'>查看学生</a>");
                        }
                        if (lesson == "4" && weekDay == "2") {
                            $("#si2").html(data[i].courseName + '</br>' + '教室：' + data[i].classRoomName + '</br>' + "<a class='btn btn-primary btn-xs' onclick='studentInfo(" + data[i].clazzId + ");'>查看学生</a>");
                        }
                        if (lesson == "5" && weekDay == "2") {
                            $("#w2").html(data[i].courseName + '</br>' + '教室：' + data[i].classRoomName + '</br>' + "<a class='btn btn-primary btn-xs' onclick='studentInfo(" + data[i].clazzId + ");'>查看学生</a>");
                        }
                        if (lesson == "1" && weekDay == "3") {
                            $("#o3").html(data[i].courseName + '</br>' + '教室：' + data[i].classRoomName + '</br>' + "<a class='btn btn-primary btn-xs' onclick='studentInfo(" + data[i].clazzId + ");'>查看学生</a>");
                        }
                        if (lesson == "2" && weekDay == "3") {
                            $("#r3").html(data[i].courseName + '</br>' + '教室：' + data[i].classRoomName + '</br>' + "<a class='btn btn-primary btn-xs' onclick='studentInfo(" + data[i].clazzId + ");'>查看学生</a>");
                        }
                        if (lesson == "3" && weekDay == "3") {
                            $("#s3").html(data[i].courseName + '</br>' + '教室：' + data[i].classRoomName + '</br>' + "<a class='btn btn-primary btn-xs' onclick='studentInfo(" + data[i].clazzId + ");'>查看学生</a>");
                        }
                        if (lesson == "4" && weekDay == "3") {
                            $("#si3").html(data[i].courseName + '</br>' + '教室：' + data[i].classRoomName + '</br>' + "<a class='btn btn-primary btn-xs' onclick='studentInfo(" + data[i].clazzId + ");'>查看学生</a>");
                        }
                        if (lesson == "5" && weekDay == "3") {
                            $("#w3").html(data[i].courseName + '</br>' + '教室：' + data[i].classRoomName + '</br>' + "<a class='btn btn-primary btn-xs' onclick='studentInfo(" + data[i].clazzId + ");'>查看学生</a>");
                        }
                        if (lesson == "1" && weekDay == "4") {
                            $("#o4").html(data[i].courseName + '</br>' + '教室：' + data[i].classRoomName + '</br>' + "<a class='btn btn-primary btn-xs' onclick='studentInfo(" + data[i].clazzId + ");'>查看学生</a>");
                        }
                        if (lesson == "2" && weekDay == "4") {
                            $("#r4").html(data[i].courseName + '</br>' + '教室：' + data[i].classRoomName + '</br>' + "<a class='btn btn-primary btn-xs' onclick='studentInfo(" + data[i].clazzId + ");'>查看学生</a>");
                        }
                        if (lesson == "3" && weekDay == "4") {
                            $("#s4").html(data[i].courseName + '</br>' + '教室：' + data[i].classRoomName + '</br>' + "<a class='btn btn-primary btn-xs' onclick='studentInfo(" + data[i].clazzId + ");'>查看学生</a>");
                        }
                        if (lesson == "4" && weekDay == "4") {
                            $("#si4").html(data[i].courseName + '</br>' + '教室：' + data[i].classRoomName + '</br>' + "<a class='btn btn-primary btn-xs' onclick='studentInfo(" + data[i].clazzId + ");'>查看学生</a>");
                        }
                        if (lesson == "5" && weekDay == "4") {
                            $("#w4").html(data[i].courseName + '</br>' + '教室：' + data[i].classRoomName + '</br>' + "<a class='btn btn-primary btn-xs' onclick='studentInfo(" + data[i].clazzId + ");'>查看学生</a>");
                        }
                        if (lesson == "1" && weekDay == "5") {
                            $("#o5").html(data[i].courseName + '</br>' + '教室：' + data[i].classRoomName + '</br>' + "<a class='btn btn-primary btn-xs' onclick='studentInfo(" + data[i].clazzId + ");'>查看学生</a>");
                        }
                        if (lesson == "2" && weekDay == "5") {
                            $("#r5").html(data[i].courseName + '</br>' + '教室：' + data[i].classRoomName + '</br>' + "<a class='btn btn-primary btn-xs' onclick='studentInfo(" + data[i].clazzId + ");'>查看学生</a>");
                        }
                        if (lesson == "3" && weekDay == "5") {
                            $("#s5").html(data[i].courseName + '</br>' + '教室：' + data[i].classRoomName + '</br>' + "<a class='btn btn-primary btn-xs' onclick='studentInfo(" + data[i].clazzId + ");'>查看学生</a>");
                        }
                        if (lesson == "4" && weekDay == "5") {
                            $("#si5").html(data[i].courseName + '</br>' + '教室：' + data[i].classRoomName + '</br>' + "<a class='btn btn-primary btn-xs' onclick='studentInfo(" + data[i].clazzId + ");'>查看学生</a>");
                        }
                        if (lesson == "5" && weekDay == "5") {
                            $("#w5").html(data[i].courseName + '</br>' + '教室：' + data[i].classRoomName + '</br>' + "<a class='btn btn-primary btn-xs' onclick='studentInfo(" + data[i].clazzId + ");'>查看学生</a>");
                        }
                    }
                }

            })

        }
    })

    function studentInfo(id) {
        location.href = "${pageContext.request.contextPath}/staff/teacher/student/info?clazzId=" + id;
    }
</script>
<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h4>课程信息</h4>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <!-- /.row -->
    <div class="row">
        <div class="col-md-3">
            <div class="form-group">
                <label>学期</label>
                <select id="semesterId">
                    <option value="6">2018-2019-1</option>
                </select>
            </div>
        </div>
        <div class="col-md-2">
            <div class="form-group">
                <label>周次</label>
                <select id="sel">
                    <option>请选择</option>
                    <option value="1">第一周</option>
                    <option value="2">第二周</option>
                    <option value="3">第三周</option>
                    <option value="4">第四周</option>
                    <option value="5">第五周</option>
                    <option value="6">第六周</option>
                    <option value="7">第七周</option>
                    <option value="8">第八周</option>
                    <option value="9">第九周</option>
                    <option value="10">第十周</option>
                    <option value="11">第十一周</option>
                    <option value="12">第十二周</option>
                    <option value="13">第十三周</option>
                    <option value="14">第十四周</option>
                    <option value="15">第十五周</option>
                    <option value="16">第十六周</option>
                    <option value="17">第十七周</option>
                    <option value="18">第十八周</option>
                    <option value="19">第十九周</option>
                    <option value="20">第二十周</option>
                </select>
            </div>
        </div>

        <!-- /.col-lg-12 -->
    </div>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <!-- /.panel-heading -->

                <div class="panel-body">
                    <table width="100%" class="table table-striped table-bordered table-hover" id="courseinfoTable">
                        <thead>
                        <tr>
                            <th>节\周</th>
                            <th>星期一</th>
                            <th>星期二</th>
                            <th>星期三</th>
                            <th>星期四</th>
                            <th>星期五</th>
                        </tr>
                        <tr>
                            <th>第一节</th>
                            <td id="o1"></td>
                            <td id="o2"></td>
                            <td id="o3"></td>
                            <td id="o4"></td>
                            <td id="o5"></td>
                        </tr>
                        <tr>
                            <th>第二节</th>
                            <td id="r1"></td>
                            <td id="r2"></td>
                            <td id="r3"></td>
                            <td id="r4"></td>
                            <td id="r5"></td>
                        </tr>
                        <tr>
                            <th>第三节</th>
                            <td id="s1"></td>
                            <td id="s2"></td>
                            <td id="s3"></td>
                            <td id="s4"></td>
                            <td id="s5"></td>
                        </tr>
                        <tr>
                            <th>第四节</th>
                            <td id="si1"></td>
                            <td id="si2"></td>
                            <td id="si3"></td>
                            <td id="si4"></td>
                            <td id="si5"></td>
                        </tr>
                        <tr>
                            <th>晚自习</th>
                            <td id="w1"></td>
                            <td id="w2"></td>
                            <td id="w3"></td>
                            <td id="w4"></td>
                            <td id="w5"></td>
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
</div>