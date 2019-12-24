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
                title: '专业方向选择',
                iconCls: 'icon-more',//图标
                border: true,
                collapsible: false,//是否可折叠的
                fit: true,//自动大小
                method: "post",
                url: "get_list?t=" + new Date().getTime(),
                idField: 'branchid',
                singleSelect: true,//是否单选
                pagination: true,//分页控件
                rownumbers: true,//行号
                sortName: 'branchid',
                sortOrder: 'DESC',
                //field内一定要小写开头
                columns: [[
                    {field:'chk',checkbox: true,width:50},
                    {field: 'branchid', title: '方向编号', width: 80, sortable: true},
                    {field: 'name', title: '方向名称', width: 80},
                    {field:'course',
                        formatter : function(value,row,index){
                            if (row.course){
                                return row.course.name;
                            } else {
                                return value;
                            }},
                        title:'对应课程名称',width:80},
                    {field: 'selected', title: '已选人数', width: 80},
                    {field: 'limited', title: '限选人数', width: 80},
                ]],
                toolbar: "#toolbar"
            });

            //提交
            $("#submit").click(function () {
                var selectRow = $("#dataList").datagrid("getSelected");
                if (selectRow == null) {
                    $.messager.alert("消息提醒", "请选择课程后再进行提交!", "warning");
                } else {
                    var branchid = selectRow.branchid;
                    $.messager.confirm("消息提醒", "将提交已勾选的相关课程，确认继续？", function (r) {
                        if (r) {
                            $.ajax({
                                type: "post",
                                url: "submit",
                                data: {branchid: branchid},
                                dataType: "json",
                                success: function (data) {
                                    if (data.type == "success") {
                                        $.messager.alert("消息提醒", data.msg, "info");
                                        //刷新表格
                                        $("#dataList").datagrid("reload");
                                    } else {
                                        $.messager.alert("消息提醒", data.msg, "warning");
                                        return;
                                    }
                                }
                            });
                        }
                    });
                }
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
    <div><a id="submit" href="javascript:;" class="easyui-linkbutton"
            data-options="iconCls:'icon-some-delete',plain:true">提交</a></div>
</div>

</table>


</body>
</html>
