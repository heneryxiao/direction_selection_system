<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<title>授课学生列表</title>
	<link rel="stylesheet" type="text/css" href="../easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="../easyui/css/demo.css">
	<script type="text/javascript" src="../easyui/jquery.min.js"></script>
	<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="../easyui/js/validateExtends.js"></script>
	<script type="text/javascript">
	$(function() {
		var table;
		//datagrid初始化 
	    $('#dataList').datagrid({ 
	        title:'授课学生列表',
	        iconCls:'icon-more',//图标 
	        border: true, 
	        collapsible:false,//是否可折叠的 
	        fit: true,//自动大小 
	        method: "post",
	        url:"get_list?t="+new Date().getTime(),
	        idField:'sid',
	        singleSelect:false,//是否单选 
	        pagination:true,//分页控件 
	        rownumbers:true,//行号 
	        sortName:'sid',
	        sortOrder:'DESC', 
	        remoteSort: false,
	        columns: [[
				{field:'chk',checkbox: true,width:50},
				{field:'sid',title:'用户名',sortable: true,width:120},
				{field:'name',title:'姓名',width:60},
				{field:'gender',title:'性别',width:60},
				{field:'profession',title:'所属专业',width:120},
				{field:'clazz',title:'班级',width:120},
				{field:'branch',
					formatter : function(value,row,index){
						if (row.branch){
							return row.branch.name;
						} else {
							return value;
						}},
					title:'所选方向',width:120},
				{field:'email',title:'邮箱',width:150},
	 		]], 
	        toolbar: "#toolbar"
	    }); 
	    //设置分页控件 
	    var p = $('#dataList').datagrid('getPager'); 
	    $(p).pagination({ 
	        pageSize: 10,//每页显示的记录条数，默认为10 
	        pageList: [10,20,30,50,100],//可以设置每页记录条数的列表 
	        beforePageText: '第',//页数文本框前显示的汉字 
	        afterPageText: '页    共 {pages} 页', 
	        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录', 
	    }); 

	    
		// //搜索按钮
		// $("#search-btn").click(function(){
		// 	 $('#dataList').datagrid('reload',{
		// 		 sid:$("#search-username").searchbox('getValue')
		// 	 });
		//
		// });
	});
	
	</script>
</head>
<body>
	<!-- 数据列表 -->
	<table id="dataList" cellspacing="0" cellpadding="0"> 
	    
	</table> 
	<!-- 工具栏 -->
<%--	<div id="toolbar">--%>

<%--		用户名:<input id="search-username" class="easyui-textbox"/>	--%>
<%--		<a id="search-btn" href="javascript:;" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true">搜索</a>--%>
<%--		</div>--%>
<%--	</div>--%>
	
</body>
</html>