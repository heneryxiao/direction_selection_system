<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="../utils/css/flat-ui.css"></script>
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	<link rel="shortcut icon" href="../utils/image/favicon.ico" type="image/x-icon"/>
	<meta charset="UTF-8">
	<title>学生信息管理系统</title>

	<!-- Loading Bootstrap -->
	<%--    <link href="../utils/css/vendor/bootstrap.min.css" rel="stylesheet">--%>
	<!-- Loading Flat UI Pro -->
	<link href="../utils/css/flat-ui.css" rel="stylesheet">
	<!-- Loading animate -->
	<link href="../utils/css/animate.css" rel="stylesheet">


	<script type='text/javascript' src='../utils/scripts/particles.js'></script>
	<link href="../utils/css/animate.css" rel="stylesheet">
</head>

<body>
<div title="欢迎使用" style="padding:20px;overflow:hidden;  "id="particles-js" >
	<canvas class="particles-js-canvas-el" width="1322" height="774" style="width: 100%; height: 100%;"></canvas>
	<div class="main1">
		<div style="margin-top: 10rem;">
			<h3 class="text-center bounceIn animated">欢迎 ${userWithType.name}
				<c:if test="${user.type == 1}">
					管理员&nbsp;
				</c:if>
				<c:if test="${user.type == 2}">
					专业负责人&nbsp;
				</c:if>
				<c:if test="${user.type == 3}">
					方向负责人&nbsp;
				</c:if>
				<c:if test="${user.type == 4}">
					课程主任&nbsp;
				</c:if>
				<c:if test="${user.type == 5}">
					老师&nbsp;
				</c:if>
				<c:if test="${user.type == 6}">
					学生&nbsp;
				</c:if>
			</h3>
			<h3 class="text-center flipInX animated" style="transition: all 1s;cursor:pointer;"
				onmouseover="javascript:this.style.fontSize='6rem';" onmouseout="javascript:this.style.fontSize='5rem';"
				id="timer"></h3>
		</div>
	</div>
</div>
<script src="../utils/js/timer.js"></script>
<script type="text/javascript" src="../utils/scripts/flat-ui.js"></script>
<script src="../utils/scripts/bganimation.js"></script>
</body>
</html>
