<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="wo.bsys.dto.DictionaryDto" %>

<%
	List<DictionaryDto> genders = (List<DictionaryDto>)request.getAttribute ("genders");

%>
<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">创建管理员用户</div>
				<div class="panel-body">
					<form role="form" id="adminUserCreateForm" class="form-horizontal"
						action="${pageContext.request.contextPath}/staff/admin/create"
						method="post" enctype="multipart/form-data">
						<div class="form-group">
							<label class="col-sm-2 control-label">工号</label>
							<div class="col-sm-10">
								<input class="form-control" placeholder="请输入工号" name="jobNo">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">姓名</label>
							<div class="col-sm-10">
								<input class="form-control" placeholder="请输入姓名" name="name">
							</div>
						</div>
						<div class="form-group">
	                            <% for (int i = 0; i < genders.size(); i ++) {
	                            	DictionaryDto dic = genders.get(i);
								%>
	                            <label class="col-sm-2 control-label"><%=(i>0?"":"性别")%></label>
	                            <div class="radio col-sm-10">
	                                <label>
	                                    <input type="radio" name="sex" value="<%=dic.getName()%>"><%=dic.getName()%>
	                                </label>
	                            </div>
	                            <% } %>
	                        </div>
						 <div class="form-group">
			                    <label class="col-sm-2 control-label">出生日期</label>
			                    <div class="col-sm-10">
			                    	<input class="form-control" placeholder="请输入生日" name="birthDay">
			                    </div>
			                </div>
						<div class="form-group">
							<label class="col-sm-2 control-label">密码</label>
							<div class="col-sm-10">
								<input class="form-control" placeholder="请输入密码" name="userPassword">
							</div>
						</div>
						<div class="form-group">
						 <label class="col-sm-2 control-label">角色</label>
							<div class="col-sm-10">
							<select name="roleId" class="form-control">
								<option value="admin">管理员</option>
							</select>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-2"></div>
							<div class="col-sm-10">
								<button type="submit" class="btn btn-primary">提交</button>
								<button type="reset" class="btn btn-default">重置</button>
								<button type="button" class="btn btn-warning"
									onclick="location.href='${pageContext.request.contextPath}/'">返回</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<!-- /.panel-body -->
	</div>
	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							// 设置各字段的验证规则
							var fields = {};
							if (!fields['id']) {
								fields['id'] = {
									validators : {}
								};
							}
							fields['id'].validators['notEmpty'] = {
								message : 'ID不能为空'
							};
							if (!fields['loginName']) {
								fields['loginName'] = {
									validators : {}
								};
							}
							if (!fields['password']) {
								fields['password'] = {
									validators : {}
								};
							}
							if (!fields['createTime']) {
								fields['createTime'] = {
									validators : {}
								};
							}
							if (!fields['passwordTime']) {
								fields['passwordTime'] = {
									validators : {}
								};
							}

							// 将验证规则应用到表单的字段中
							$('#bsysUserCreateForm').bootstrapValidator({
								// 默认错误消息
								message : '输入值不合法',
								// 设置验证成功或者失败的图标
								feedbackIcons : {
									valid : 'glyphicon glyphicon-ok',
									invalid : 'glyphicon glyphicon-remove',
									validating : 'glyphicon glyphicon-refresh'
								},
								// 设置不同字段的验证规则和错误信息
								fields : fields
							});

							// 关联对象选择器按钮点击事件
							$('#adminUserCreateForm .input-group-btn')
									.click(
											function() {
												var nameField = $(this).prev()
														.attr('name');
												var idField = $(this).prev()
														.prev().attr('name');
												$('#bsysUserDialog').remove();
												$('body')
														.append(
																'<div class="modal fade" id="bsysUserDialog" tabindex="-1" role="dialog" aria-labelledby="bsysUserSelectorModalLabel"></div>');
												// 显示对话框
												$('#bsysUserDialog')
														.load(
																'${pageContext.request.contextPath}/'
																		+ $(
																				this)
																				.attr(
																						'wo:url'),
																{
																	formId : 'bsysUserCreateForm',
																	idField : idField,
																	nameField : nameField,
																	singleSelect : $(
																			this)
																			.hasClass(
																					'woSingleSelect')
																},
																function() {
																	$(
																			'#bsysUserDialog')
																			.modal(
																					'show');
																});
											});
						});
	</script>
</div>