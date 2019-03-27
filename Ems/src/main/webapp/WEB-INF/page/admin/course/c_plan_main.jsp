<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h4>课程安排</h4>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <!-- /.row -->
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <div id="curriculaVariable" class="col-md-offset-3">
        <div class="row">
            <div class="form-group">
                <label class="col-sm-2 control-label">学院</label>
                <div class="input-group col-sm-6">
                    <input type="hidden" name="collegeId" id="cid">
                    <input type="text" class="form-control" name="collegeName" readonly>
                    <span class="input-group-btn woSingleSelect" wo:url="collegeinfo/college/selector">
                        <button class="btn btn-default" type="button"><i class="fa fa-search"></i>
                        </button>
                    </span>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group">
                <label class="col-sm-2 control-label">专业</label>
                <div class="input-group col-sm-6">
                    <input type="hidden" name="majorId" id="mid">
                    <input type="text" class="form-control" name="majorName" readonly>
                    <span class="input-group-btn" wo:url="collegeinfo/major/selector">
                        <button class="btn btn-default" type="button"><i class="fa fa-search"></i>
                        </button>
                    </span>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group">
                <label class="col-sm-2 control-label">学期</label>
                <div class="input-group col-sm-6">
                    <input class="form-control" placeholder="请输入学期" name="semesterId" id="sid">
                </div>
            </div>
        </div>
    </div>
    <br/>
    <br/>
    <div class="row" style="text-align: center;">
        <div class="col-md-2 col-lg-2 col-md-offset-4">
            <div class="form-group">
                <input type="button" class="btn btn-primary" value="安排课程"
                       id="planCourse" name="planCourse"/>
            </div>
        </div>
        <div class="col-md-2 col-lg-2">
            <div class="form-group">
                <input type="button" class="btn btn-danger" value="重置"
                       id="reset" name="reset" onclick="location.href='${pageContext.request.contextPath}/'"/>
            </div>
        </div>
    </div>
    <script>
        $(document).ready(function () {
            $('#curriculaVariable .input-group-btn').click(function () {
                $('#courseDialog').remove();
                $('body').append('<div class="modal fade" id="courseDialog" tabindex="-1" role="dialog" aria-labelledby="courseSelectorModalLabel"></div>');
                // 2.设置模态框内容加载的参数
                var nameField = $(this).prev().attr('name');
                var idField = $(this).prev().prev().attr('name');
                var loadOpts = {
                    formId: 'curriculaVariable',
                    idField: idField,
                    nameField: nameField,
                    singleSelect: true
                };
                if (idField == 'majorId') {//
                    loadOpts.params = $('#curriculaVariable input[name=collegeId]').val();
                }
                if (idField == 'collegeId') {//
                    loadOpts.callback = "selectcourseProject";
                }
                // 3.加载模态框的内容，并显示
                $('#courseDialog').load('${pageContext.request.contextPath}/' + $(this).attr('wo:url'),
                    loadOpts, function () {
                        $('#courseDialog').modal('show');
                    });
            });

            window.selectcourseProject = function () {
                $('#curriculaVariable input[name=majorId]').val('');
                $('#curriculaVariable input[name=majorName]').val('');
            };


            $("#planCourse").click(function () {
                var collegeId = $("#cid").val();
                var majorId = $("#mid").val();
                var semesterId = $("#sid").val();
                $.ajax({
                    type: "post",
                    url: "${pageContext.request.contextPath}/collegeinfo/course/checkCourse",
                    data: "majorId=" + majorId + "&semesterId=" + semesterId,
                    dataType: "json",
                    success: function (result) {
                        if (result.code != 0) {
                        location.href = "${pageContext.request.contextPath}/collegeinfo/course/selectCourse?collegeId=" + collegeId + "&majorId=" + majorId + "&semesterId=" + semesterId;
                        } else {
                            alert(result.msg);
                        }
                    }
                })
            })
        })

    </script>
</div>