<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>选课结果信息</title>
    <link rel="stylesheet" type="text/css" href="../easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="../easyui/css/demo.css">
    <script type="text/javascript" src="../easyui/jquery.min.js"></script>
    <script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../easyui/js/validateExtends.js"></script>
    <script type="text/javascript">
        $(function () {
            //判断用户是否已选方向，已选则显示信息
            <%--var SelectedCourseName = '${student.getSelectedCourseName()}'--%>
            <%--if(SelectedCourseName != ''){--%>
                //datagrid初始化
                $('#dataList').datagrid({
                    title: '选报信息',
                    iconCls: 'icon-more',//图标
                    border: true,
                    collapsible: false,//是否可折叠的
                    fit: true,//自动大小
                    method: "post",
                    url: "get_list?t=" + new Date().getTime(),
                    idField: 'sid',
                    singleSelect: true,//是否单选
                    pagination: true,//分页控件
                    rownumbers: true,//行号
                    sortName: 'sid',
                    sortOrder: 'DESC',
                    columns: [[
                        {field:'sid',title:'学号',width:120},
                        {field:'name',title:'姓名',width:80},
                        {field:'gender',title:'性别',width:50},
                        {field:'profession',title:'专业',width:80},
                        {field:'branch',
                            formatter : function(value,row,index){
                                if (row.branch){
                                    return row.branch.name;
                                } else {
                                    return value;
                                }},
                            title:'方向名称',width:80},
                        {field:'clazz',title:'班级',width:80},
                        // {field:'email',title:'邮箱',width:80},
                        {
                            field: 'operate', title: '操作', width: 80,
                            formatter: function () {
                                return '<a href="/direction_selection_system_war_exploded/selectInformation/quit" >退选</a>'
                            }
                        }
                    ]],

                });
            // }



        });
    </script>
</head>
<body>
<!-- 数据列表 -->
<table id="dataList" cellspacing="0" cellpadding="0">

</table>


</body>
</html>