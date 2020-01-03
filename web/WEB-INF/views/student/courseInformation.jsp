<%--
  Created by IntelliJ IDEA.
  User: 15219
  Date: 2019/11/15
  Time: 9:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>课程列表</title>
    <link rel="stylesheet" type="text/css" href="../easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="../easyui/css/demo.css">
    <script type="text/javascript" src="../easyui/jquery.min.js"></script>
    <script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../easyui/js/validateExtends.js"></script>
    <script type="text/javascript">
        $(function () {
            //datagrid初始化
            $('#dataList').datagrid({
                title: '课程信息',
                iconCls: 'icon-more',//图标
                border: true,
                collapsible: false,//是否可折叠的
                fit: true,//自动大小
                method: "post",
                url: "get_list?t=" + new Date().getTime(),
                singleSelect: true,//是否单选
                pagination: true,//分页控件
                rownumbers: true,//行号
                sortOrder: 'DESC',
                //field内一定要小写开头
                columns: [[
                    // {field: 'chk', checkbox: true, width: 50},
                    {field: 'course',
                        formatter: function (value, row, index) {
                            if (row.course) {
                                return row.course.name;
                            } else {
                                return value;
                            }
                        },
                        title: '课程名称', width: 120,
                    },
                    {field: 'branchName',
                        formatter: function (value, row, index) {
                            if (row.branch) {
                                return row.branch.name;
                            }
                        },
                        title: '所属方向', width: 100,
                    },
                    {field: 'branchSelected',
                        formatter: function (value, row, index) {
                            if (row.branch) {
                                return row.branch.selected;
                            }
                        },
                        title: '已选人数', width: 80,
                    },
                    {field: 'branchLimited',
                        formatter: function (value, row, index) {
                            if (row.branch) {
                                return row.branch.limited;
                            }
                        },
                        title: '限制人数', width: 80,
                    },
                    {field: 'introduce', title: '课程简介', width: 400, sortable: true},
                    {field: 'teacherName',
                        formatter: function (value, row, index) {
                            if (row.teacher) {
                                return row.teacher.name;
                            }
                        },
                        title: '老师姓名', width: 80
                    },
                    {field: 'teacherIntroduce',
                        formatter: function (value, row, index) {
                            if (row.teacher) {
                                return row.teacher.introduce;
                            }
                        },
                        title: '老师介绍', width: 400
                    },


                ]],
                toolbar: "#toolbar"
            });
        });
    </script>
</head>
<body>
<!-- 数据列表 -->
<table id="dataList" cellspacing="0" cellpadding="0">
</table>
<!-- 工具栏 -->
<div id="toolbar">

</div>

</table>


</body>
</html>
