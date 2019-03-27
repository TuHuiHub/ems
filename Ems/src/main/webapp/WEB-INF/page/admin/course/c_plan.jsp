<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.List" %>
<%@ page import="com.dream.ems.po.*" %>
<%@ page import="com.dream.ems.dto.CourseTableDto" %>
<%@ page import="wo.bsys.po.Dictionary" %>
<%
    List<Course> courses = (List<Course>) request.getAttribute("courses");
    List<Teacher> teachers = (List<Teacher>) request.getAttribute("teachers");
    List<ClassRoom> classRooms = (List<ClassRoom>) request.getAttribute("classRooms");
    List<Clazz> clazzes = (List<Clazz>) request.getAttribute("clazzes");
    List<CourseTableDto> ctList = (List<CourseTableDto>) request.getAttribute("courseTableList");
    String semesterId = (String) request.getAttribute("semesterId");
%>
<div id="page-wrapper">
    <div class="col-lg-12">
        <h4>排课系统</h4>
    </div>
    <div class="row">
        <div class="col-md-4">
            <div class="form-group">
                <input type="hidden" id="startWeek" value="<%=courses.get(0).getStartWeek()%>">
                <input type="hidden" id="endWeek" value="<%=courses.get(0).getEndWeek()%>">
                <label>课程</label>
                <select class="form-control" name="courseId" id="courseSelect">
                    <%for (Course c : courses) {%>
                    <option value="<%=c.getId()%>"><%=c.getName()%>
                    </option>
                    <%} %>
                </select>
            </div>
        </div>
        <div class="col-md-4">
            <div class="form-group">
                <label>教师</label>
                <select class="form-control" name="teacherJobNo" id="teacherSelect">
                    <%for (Teacher t : teachers) {%>
                    <option value="<%=t.getJobNo()%>"><%=t.getName()%>
                    </option>
                    <%} %>
                </select>
            </div>
        </div>
        <div class="col-md-4">
            <div class="form-group">
                <label>班级</label>
                <select class="form-control" name="clazzId" id="clazzSelect">
                    <%for (Clazz c : clazzes) {%>
                    <option value="<%=c.getId()%>"><%=c.getClazzName()%>
                    </option>
                    <%} %>
                </select>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-4">
            <div class="form-group">
                <label>星期</label>
                <select class="form-control" id="weekdaySelect" name="weekDay">
                    <option value="1">周一</option>
                    <option value="2">周二</option>
                    <option value="3">周三</option>
                    <option value="4">周四</option>
                    <option value="5">周五</option>
                </select>
            </div>
        </div>
        <div class="col-md-4">
            <div class="form-group">
                <label>上课时间</label>
                <select class="form-control" id="lessonSelect" name="lesson">
                    <option value="1">第一节课</option>
                    <option value="2">第二节课</option>
                    <option value="3">第三节课</option>
                    <option value="4">第四节课</option>
                    <option value="5">第五节课</option>
                </select>
            </div>
        </div>
        <div class="col-md-4">
            <div class="form-group">
                <label>教室</label>
                <select class="form-control" name="classRoomId" id="classRoomSelect">
                    <%for (ClassRoom c : classRooms) {%>
                    <option value="<%=c.getId()%>"><%=c.getRoomName()%>
                    </option>
                    <%} %>
                </select>
            </div>
        </div>

    </div>
    <div class="row">
        <div class="col-md-3 col-lg-3">
            <div class="form-group">
                <input type="button" class="btn btn-primary" value="添加课程" id="addLesson" name="addLesson"/>
            </div>
        </div>
        <div class="col-md-3 col-lg-3">
            <div class="form-group">
                <input type="button" class="btn btn-warning" value="清空课程" id="emptyLesson" name="emptyLesson"/>
            </div>
        </div>
        <div class="col-md-3 col-lg-3">
            <div class="form-group">
                <input type="button" class="btn btn-danger" value="全部清空" id="allemptyLesson" name="allemptyLesson"/>
            </div>
        </div>
        <div class="col-md-3 col-lg-3">
            <div class="form-group">
                <input type="button" class="btn btn-success" value="提交课程" id="commitLesson" name="commitLesson"/>
            </div>
        </div>
    </div>
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading" style="text-align: center">课程表</div>
            <!-- /.panel-heading -->
            <div class="panel-body">
                <div class="table-responsive">
                    <table class="table table-striped table-bordered table-hover">
                        <thead>
                        <tr>
                            <th></th>
                            <th>星期一</th>
                            <th>星期二</th>
                            <th>星期三</th>
                            <th>星期四</th>
                            <th>星期五</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <th height="100px"
                                style="text-align: center; vertical-align: middle;">第一节课
                            </th>
                            <td height="100px"
                                style="text-align: center; vertical-align: middle;" id="table_1_1">#
                            </td>
                            <td height="100px"
                                style="text-align: center; vertical-align: middle;" id="table_2_1">#
                            </td>
                            <td height="100px"
                                style="text-align: center; vertical-align: middle;" id="table_3_1">#
                            </td>
                            <td height="100px"
                                style="text-align: center; vertical-align: middle;" id="table_4_1">#
                            </td>
                            <td height="100px"
                                style="text-align: center; vertical-align: middle;" id="table_5_1">#
                            </td>
                        </tr>
                        <tr>
                            <th height="100px"
                                style="text-align: center; vertical-align: middle;">第二节课
                            </th>
                            <td height="100px"
                                style="text-align: center; vertical-align: middle;" id="table_1_2">#
                            </td>
                            <td height="100px"
                                style="text-align: center; vertical-align: middle;" id="table_2_2">#
                            </td>
                            <td height="100px"
                                style="text-align: center; vertical-align: middle;" id="table_3_2">#
                            </td>
                            <td height="100px"
                                style="text-align: center; vertical-align: middle;" id="table_4_2">#
                            </td>
                            <td height="100px"
                                style="text-align: center; vertical-align: middle;" id="table_5_2">#
                            </td>
                        </tr>
                        <tr>
                            <th height="100px"
                                style="text-align: center; vertical-align: middle;">第三节课
                            </th>
                            <td height="100px"
                                style="text-align: center; vertical-align: middle;" id="table_1_3">#
                            </td>
                            <td height="100px"
                                style="text-align: center; vertical-align: middle;" id="table_2_3">#
                            </td>
                            <td height="100px"
                                style="text-align: center; vertical-align: middle;" id="table_3_3">#
                            </td>
                            <td height="100px"
                                style="text-align: center; vertical-align: middle;" id="table_4_3">#
                            </td>
                            <td height="100px"
                                style="text-align: center; vertical-align: middle;" id="table_5_3">#
                            </td>
                        </tr>
                        <tr>
                            <th height="100px"
                                style="text-align: center; vertical-align: middle;">第四节课
                            </th>
                            <td height="100px"
                                style="text-align: center; vertical-align: middle;" id="table_1_4">#
                            </td>
                            <td height="100px"
                                style="text-align: center; vertical-align: middle;" id="table_2_4">#
                            </td>
                            <td height="100px"
                                style="text-align: center; vertical-align: middle;" id="table_3_4">#
                            </td>
                            <td height="100px"
                                style="text-align: center; vertical-align: middle;" id="table_4_4">#
                            </td>
                            <td height="100px"
                                style="text-align: center; vertical-align: middle;" id="table_5_4">#
                            </td>
                        </tr>
                        <tr>
                            <th height="100px"
                                style="text-align: center; vertical-align: middle;">第五节课
                            </th>
                            <td height="100px"
                                style="text-align: center; vertical-align: middle;" id="table_1_5">#
                            </td>
                            <td height="100px"
                                style="text-align: center; vertical-align: middle;" id="table_2_5">#
                            </td>
                            <td height="100px"
                                style="text-align: center; vertical-align: middle;" id="table_3_5">#
                            </td>
                            <td height="100px"
                                style="text-align: center; vertical-align: middle;" id="table_4_5">#
                            </td>
                            <td height="100px"
                                style="text-align: center; vertical-align: middle;" id="table_5_5">#
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <!-- /.table-responsive -->
            </div>
            <!-- /.panel-body -->
        </div>
        <!-- /.panel -->
    </div>
    <script>

        $(document).ready(function () {
            // 课表回显
            <% for (CourseTableDto ct : ctList) { %>
            $("#table_<%=ct.getWeekDay()%>_<%=ct.getLesson()%>").html(
                "<%=ct.getCourseName()%><p hidden><%=ct.getCourseId()%></p>"
                + "<br/><%=ct.getTeacherName()%><p hidden><%=ct.getTeacherJobNo()%></p>"
                + "<br/><%=ct.getClassRoomName()%><br/><%=ct.getStartWeek()%>-<%=ct.getEndWeek()%>周"
            );
            <% } %>

            var college = $("#collegeSelect option:selected");
            var major = $("#majorSelect option:selected");

            // 添加课程事件
            $("#addLesson").click(function () {
                var week = $("#weekdaySelect option:selected");
                var lesson = $("#lessonSelect option:selected");
                var course = $("#courseSelect option:selected");
                var teacher = $("#teacherSelect option:selected");
                var startweek = $("#startWeek");
                var endweek = $("#endWeek");
                var classRoom = $("#classRoomSelect option:selected");
                var clazz = $("#clazzSelect option:selected");
                var collegeId = ${college.id};
                var majorId = ${major.id};
                $.ajax({
                    type: 'post',
                    url: '${pageContext.request.contextPath}/collegeinfo/course/selectCourse',
                    data: "weekDay=" + week.val() + "&lesson=" + lesson.val() + "&courseId=" + course.val() + "&teacherJobNo=" + teacher.val() + "&classRoomId=" + classRoom.val()
                        + "&startWeek=" + startweek.val() + "&endWeek=" + endweek.val() + "&clazzId=" + clazz.val() + "&collegeId=" + collegeId + "&majorId=" + majorId + "&semesterId=" + <%=semesterId%>,
                    dataType: 'json',
                    success: function (result) {
                        if (result.code == 1) {
                            // 课程表添加课程
                            $("#table_" + week.val() + "_" + lesson.val()).html(course.text() + "<p hidden>" + course.val() + "</p>"
                                + "<br/>" + teacher.text() + "<p hidden>" + teacher.val() + "</p>"
                                + "<br/>" + classRoom.text() + "<br/>" + startweek.val() + "-" + endweek.val() + "周");
                            // 重新生成班级列表
                            $("#clazzSelect").html("");
                            var clazzes = result.content.clazzes;
                            for (var i in clazzes) {
                                $("#clazzSelect").append("<option value='" + clazzes[i].id + "'>" + clazzes[i].clazzName + "</option>")
                            }
                            // 重新生成教室
                            $("#classRoomSelect").html("");
                            var classRooms = result.content.classRooms;
                            for (var j in classRooms) {
                                $("#classRoomSelect").append("<option value='" + classRooms[j].id + "'>" + classRooms[j].roomName + "</option>")
                            }
                        } else {
                            alert(result.msg);
                        }
                    }
                });
            });

            // 课程改变事件
            $("#courseSelect").change(function () {
                var courseId = $("#courseSelect option:selected").val();
                $.ajax({
                    type: 'post',
                    url: '${pageContext.request.contextPath}/collegeinfo/course/changeCourse',
                    data: "courseId=" + courseId,
                    dataType: 'json',
                    success: function (result) {
                        var clazzes = result.content.clazzes;
                        if (clazzes == null || clazzes == "") {
                            $("#clazzSelect").html("");
                        } else {
                            for (var i in clazzes) {
                                $("#clazzSelect").append("<option value='" + clazzes[i].id + "'>" + clazzes[i].clazzName + "</option>")
                            }
                        }
                        $("#startWeek").html(result.content.startWeek);
                        $("#endWeek").html(result.content.endWeek);
                    }
                });
            });

            // 教师改变事件
            $("#teacherSelect").change(function () {
                var teacherId = $("#teacherSelect option:selected").val();
                var courseId = $("#courseSelect option:selected").val();
                $.ajax({
                    type: 'post',
                    url: '${pageContext.request.contextPath}/collegeinfo/course/changeTeacher',
                    data: "courseId=" + courseId + "&teacherId=" + teacherId,
                    dataType: 'json',
                    success: function (result) {
                        var ct = result.content;
                        if (ct == null || ct == "") {
                            $("tbody tr td").each(function () {
                                $(this).html("#");
                            });
                        } else {
                            for (var i in ct) {
                                $("#table_" + ct[i].weekDay + "_" + ct[i].lesson).html(ct[i].courseName + "<p hidden>" + ct[i].courseId + "</p>"
                                    + "<br/>" + ct[i].teacherName + "<p hidden>" + ct[i].teacherJobNo + "</p>"
                                    + "<br/>" + ct[i].classRoomName + "<br/>" + ct[i].startWeek + "-" + ct[i].endWeek + "周");
                            }
                        }
                    }
                });
            });

            $("#commitLesson").click(function () {
                var courseArray = new Array();
                var selectCourseData = new Object();
                for (var i = 1; i < 6; i++) {
                    for (var j = 1; j < 6; j++) {
                        var str = $("#table_" + i + "_" + j).html();
                        if (str != "#") {
                            var arry = str.split("<br>");
                            coureseStartIndex = arry[0].indexOf("<p hidden=") + 13;
                            coureseEndIndex = arry[0].indexOf("</p>");
                            teacherStartIndex = arry[1].indexOf("<p hidden=") + 13;
                            teacherEndIndex = arry[1].indexOf("</p>");
                            var param = {
                                collegeId: college.val(),
                                majorId: major.val(),
                                courseId: arry[0].substring(coureseStartIndex, coureseEndIndex),
                                teacherJobNo: arry[1].substring(teacherStartIndex, teacherEndIndex),
                                classRoom: arry[2],
                                startWeek: arry[3].split("-")[0],
                                endWeek: arry[3].split("-")[1].split("周")[0],
                                weekDay: i,
                                lesson: j,
                                collegeId: collegeId,
                                majorId: majorId
                            };
                            courseArray.push(param);
                        }

                    }
                }

                $.ajax({
                    type: 'post',
                    url: '${pageContext.request.contextPath}/collegeinfo/course/selectCourse',
                    contentType: "application/json",
                    data: JSON.stringify(courseArray),
                    dataType: 'json',
                    success: function (result) {
                        if (result.success) {
                            alert(result.message);
                            location.href = "${pageContext.request.contextPath}/";
                        } else {
                            alert("添加课程失败！");
                        }
                    }
                });
            });


            $("tbody tr td").each(function () {
                $(this).click(function () {
                    $(this).toggleClass("info");
                })
            })
            $("#emptyLesson").click(function () {
                $(".info").each(function () {
                    $(this).html("#");
                    $(this).removeClass("info");
                })
            })
            $("#allemptyLesson").click(function () {
                $("tbody tr td").each(function () {
                    $(this).html("#");
                })
            })
        })
    </script>
</div>