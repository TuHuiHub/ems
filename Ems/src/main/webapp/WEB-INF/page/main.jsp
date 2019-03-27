<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="wo.bsys.vo.WoMenu" %>
<%@ page import="wo.bsys.vo.WoUser" %>
<%@ page import="wo.bsys.util.BSysConstant" %>
<%
	WoUser u = (WoUser)session.getAttribute(BSysConstant.SESSION_USER);
	List<WoMenu> menus = u.getMenus(); 
	String url = (String) request.getAttribute("url");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教务排课系统</title>

    <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/sb-admin2/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="${pageContext.request.contextPath}/sb-admin2/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- DataTables CSS -->
    <link href="${pageContext.request.contextPath}/sb-admin2/vendor/datatables-plugins/dataTables.bootstrap.css" rel="stylesheet">

    <!-- DataTables Responsive CSS -->
    <link href="${pageContext.request.contextPath}/sb-admin2/vendor/datatables-responsive/dataTables.responsive.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/sb-admin2/dist/css/sb-admin-2.min.css" rel="stylesheet">

	<!-- bootstrap validator -->
    <link href="${pageContext.request.contextPath}/sb-admin2/vendor/bootstrap-validator/css/bootstrapValidator.min.css" rel="stylesheet">
    
    <!-- Custom Fonts -->
    <link href="${pageContext.request.contextPath}/sb-admin2/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
	<!-- jQuery -->
    <script src="${pageContext.request.contextPath}/sb-admin2/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${pageContext.request.contextPath}/sb-admin2/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="${pageContext.request.contextPath}/sb-admin2/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- DataTables JavaScript -->
    <script src="${pageContext.request.contextPath}/sb-admin2/vendor/datatables/js/jquery.dataTables.min.js"></script>
    <script src="${pageContext.request.contextPath}/sb-admin2/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/sb-admin2/vendor/datatables-responsive/dataTables.responsive.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="${pageContext.request.contextPath}/sb-admin2/dist/js/sb-admin-2.min.js"></script>

	<!-- bootstrap validator -->
    <script src="${pageContext.request.contextPath}/sb-admin2/vendor/bootstrap-validator/js/bootstrapValidator.min.js"></script>
    <script src="${pageContext.request.contextPath}/sb-admin2/bsys.js"></script>
    
     <script src="${pageContext.request.contextPath}/sb-admin2/echarts.min.js"></script>
</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">教务排课系统</a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href='javascript:void(0)'>
                        <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="${pageContext.request.contextPath}/logout"><i class="fa fa-sign-out fa-fw"></i> 退出</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li class="sidebar-search">
                            <div class="input-group custom-search-form">
                                <input type="text" class="form-control input-sm" placeholder="菜单查询">
                                <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    <i class="fa fa-search"></i>
                                </button>
                            </span>
                            </div>
                            <!-- /input-group -->
                        </li>
                        <!-- 删除菜单创建jsp代码 -->
                        <% for (WoMenu m : menus) { %>
                        <li class="<%=m.getActiveCls()%>">
                            <a href='javascript:void(0)' class="<%=m.getActiveCls()%>"><i class="fa <%=m.getIcon()%> fa-fw"></i> <%=m.getName()%><span class="fa arrow"></span></a>
                            <% if (m.getChildren().size() > 0) { %>
                            <ul class="nav nav-second-level">
                            	<% for (WoMenu c : m.getChildren()) { if (c.getActive() && url == null) { url = c.getPage();}%>
                                <li>
                                    <a href='${pageContext.request.contextPath}/?menu=<%=c.getId()%>' class="<%=c.getActiveCls()%>"><i class="fa <%=c.getIcon()%> fa-fw"></i> <%=c.getName()%></a>
                                </li>
                                <% } %>
                            </ul>
                            <% } %>
                        </li>
                        <% } %>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>
		
		<!-- /#page-wrapper -->
		<jsp:include page="<%=url%>" />
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

</body>
</html>