<%@ page import="com.dream.ems.po.ClassRoom" %>
<%@ page import="java.util.List" %>
<%@ page import="com.dream.ems.po.Course" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
    List<ClassRoom> classRooms = (List<ClassRoom>) request.getAttribute("classRooms");
%>
<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">选修课次添加</div>
                <div class="panel-body">
                    <form role="form" id="electiveCoursePlanForm"
                          class="form-horizontal"
                          action="${pageContext.request.contextPath}/coursetable/electiveCourse/create"
                          method="post">
                        <input type="hidden" name="startWeek" value="${course.startWeek}">
                        <input type="hidden" name="endWeek" value="${course.endWeek}">
                        <input type="hidden" name="semesterId" value="${course.semesterId}">
                        <input type="hidden" name="majorId" value="${course.majorId}">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">ID</label>
                            <div class="col-sm-10">
                                <input class="form-control" value="${course.id }" id="idInput" name="courseId"
                                       readonly="readonly">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">课程名</label>
                            <div class="col-sm-10">
                                <input class="form-control" value="${course.name }" id="nameInput" name="courseName"
                                       readonly="readonly">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">上课时间</label>
                            <div class="col-sm-10">
                                <select class="form-control" id="weekDaySelect" name="weekDay">
                                    <option value="1">周一</option>
                                    <option value="2">周二</option>
                                    <option value="3">周三</option>
                                    <option value="4">周四</option>
                                    <option value="5">周五</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label"></label>
                            <div class="col-sm-10">
                                <select class="form-control" id="lessonSelect" name="lesson">
                                    <option value="1">第一节课</option>
                                    <option value="2">第二节课</option>
                                    <option value="3">第三节课</option>
                                    <option value="4">第四节课</option>
                                    <option value="5">第五节课</option>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">教室</label>
                            <div class="col-sm-10">
                                <select class="form-control" name="classRoomId" id="classRoomSelect">
                                    <%for (ClassRoom c : classRooms) {%>
                                    <option value="<%=c.getId()%>"><%=c.getRoomName()%>
                                    </option>
                                    <%} %>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">任课教师</label>
                            <div class="input-group">
                                <input type="hidden" name="teacherJobNo">
                                <input type="text" class="form-control" name="teacherName" readonly>
                                <span class="input-group-btn woSingleSelect" wo:url="staff/teacher/selector">
		                                <button class="btn btn-default" type="button"><i class="fa fa-search"></i>
		                                </button>
		                            </span>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-2"></div>
                            <div class="col-sm-10">
                                <button type="submit" class="btn btn-primary">提交</button>
                                <button type="reset" class="btn btn-default">重置</button>
                                <button type="button" class="btn btn-warning"
                                        onclick="location.href='${pageContext.request.contextPath}/'">返回
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- /.panel-body -->
    </div>
    <script>
        $('#electiveCoursePlanForm .input-group-btn').click(function () {
            var nameField = $(this).prev().attr('name');
            var idField = $(this).prev().prev().attr('name');
            $('#teacherUserDialog').remove();
            $('body').append('<div class="modal fade" id="teacherUserDialog" tabindex="-1" role="dialog" aria-labelledby="teacherUserSelectorModalLabel"></div>');
            // 显示对话框
            $('#teacherUserDialog').load('${pageContext.request.contextPath}/' + $(this).attr('wo:url'), {
                formId: 'electiveCoursePlanForm',
                idField: idField,
                nameField: nameField,
                singleSelect: $(this).hasClass('woSingleSelect')
            }, function () {
                $('#teacherUserDialog').modal('show');
            });
        });
    </script>
</div>