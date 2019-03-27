<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
		<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="collegeSelectorModalLabel">选择学院</h4>
		    </div>
            <!-- /.row -->
            <div class="modal-body">
                <table width="100%" class="table table-striped table-bordered table-hover" id="collegeSelectorTable">
                    <thead>
                        <tr>
                            <th>ID</th>
                             <th>学院名</th>
                                </tr>
                    </thead>
                </table>
            </div>
            </div>
            <script>
            $(document).ready(function() {
            	var opts = ${selectorParams};
              	opts.selectedIds = $('#' + opts.formId + ' input[name=' + opts.idField + ']').val();
              	opts.selectedNames = $('#' + opts.formId + ' input[name=' + opts.nameField + ']').val();
            	var tableId = 'collegeSelectorTable';
            	var cols = [];
            	cols.push ({ "data": "id" , "orderable" : true});
            	            	cols.push ({ "data": "name" , "orderable" : false});
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
                    "rowId" : 'id',// 设置列为id
                    "ajax": {
                        "url": "${pageContext.request.contextPath}/collegeinfo/college/list", // 请求列表数据的url
                        "type": "GET"
                    },
                    "order": [ [ orderIndex, "${entity.orderableField.order}" ] ] , // 排序
                    "columns": cols
                });
            	// 设置选中行样式
            	table.on( 'draw', function () {
            		$('#' + tableId + ' tbody tr').each (function () {
                    	var data = table.row($(this)).data();
                    	if (data) {
                        	if (Wo.contains (opts.selectedIds, data.id)) {
                        		$(this).addClass('info');
                        	}
                    	}
                    });
				} );
             	// 设置列表行点击事件
                $('#' + tableId + ' tbody').on( 'click', 'tr', function () {
                	var data = table.row($(this)).data();
                	var id = data.id;
                	var name = data.name;
                	console.log (data);
                	if (opts.singleSelect) {
                		// 如果有info样式则删除，没有则添加
                    	if ($(this).hasClass('info')) {
                    		$(this).removeClass('info');
                    		opts.selectedIds = '';
                    		opts.selectedNames = '';
                    	} else {
                    		$(this).siblings().removeClass('info');
                    		$(this).addClass('info');
                    		opts.selectedIds = id;
                    		opts.selectedNames = name;
                    	}
                	} else {
                		if ($(this).hasClass('info')) {
                    		opts.selectedIds = Wo.removeValue(opts.selectedIds, id);
                    		opts.selectedNames = Wo.removeValue(opts.selectedNames, name);
                    	} else {
                    		opts.selectedIds = Wo.addValue(opts.selectedIds ,id);
                    		opts.selectedNames = Wo.addValue(opts.selectedNames ,name);
                    	}
                		$(this).toggleClass('info');
                	}
                } );
                // 添加工具栏按钮，找到设置分页的div，并添加创建和批量删除按钮的a标签
                $('#' + tableId + '_length').append (" <a class='btn btn-primary btn-sm' onclick='selectCollegeOK();'>确定</a> <a class='btn btn-primary btn-warning btn-sm' onclick='closeCollegeSelector();'>取消</a>");
                
                // 确定按钮点击事件
                window.selectCollegeOK = function () {
                	$('#' + opts.formId + ' input[name=' + opts.idField + ']').val(opts.selectedIds);
                  	$('#' + opts.formId + ' input[name=' + opts.nameField + ']').val(opts.selectedNames);
                  	$('#' + tableId).parents ('.modal').modal('hide');
                  	if (opts.callback) {
                  		// 动态执行js代码
                  		eval (opts.callback + '()');
                  	}
                }
                
             	// 确定按钮点击事件
                window.closeCollegeSelector = function () {
                	$('#' + tableId).parents ('.modal').modal('hide');
                }
            });

		    </script>
		</div>