<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <div class="modal-dialog modal-ms" role="document">
		<div class="modal-content">
			<div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="userModalLabel">密码修改</h4>
		    </div>
		    
   			<div class="modal-body">
   				<form role="form" id="modifyPasswordForm" class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">用户名</label>
                        <div class="col-sm-10">
                        	<input class="form-control" readonly="readonly" value="${loginName}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">原密码</label>
                        <div class="col-sm-10">
                        	<input class="form-control" placeholder="请输入原密码" name="oldPwd" type="password">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">新密码</label>
                        <div class="col-sm-10">
                        	<input class="form-control" placeholder="请输入新密码" name="newPwd01" type="password">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">确认密码</label>
                        <div class="col-sm-10">
                        <input class="form-control" placeholder="请再次输入新密码" name="newPwd02" type="password">
                        </div>
                    </div>
                </form>
   			</div>
   			<div class="modal-footer">
   				<button type="button" onclick="submitmodifyPassword ();" class="btn btn-default">提交</button>
                <button type="reset" class="btn btn-default">重置</button>
   			</div>
   		</div>
   </div>
<script type="text/javascript">
	function submitmodifyPassword(){
		$.post("${pageContext.request.contextPath}/modifyPassword",$("#modifyPasswordForm").serializeArray(),function(result){
			if (result.success) {
				$("passwordModal").modal("hide");
				location.href="${pageContext.request.contextPath}/login";
			}
			alert(result.msg);
		});
	}			
</script>
