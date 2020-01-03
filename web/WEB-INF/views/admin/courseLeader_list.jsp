<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>课程负责人列表</title>
    <link rel="stylesheet" type="text/css" href="../easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="../easyui/css/demo.css">
    <script type="text/javascript" src="../easyui/jquery.min.js"></script>
    <script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../easyui/js/validateExtends.js"></script>
    <script type="text/javascript">
        $(function () {
            var table;
            //datagrid初始化
            $('#dataList').datagrid({
                title: '课程负责人列表',
                iconCls: 'icon-more',//图标
                border: true,
                collapsible: false,//是否可折叠的
                fit: true,//自动大小
                method: "post",
                url: "get_list?t=" + new Date().getTime(),
                idField: 'cid',
                singleSelect: false,//是否单选
                pagination: true,//分页控件
                rownumbers: true,//行号
                sortName: 'cid',
                sortOrder: 'DESC',
                remoteSort: false,
                columns: [[
                    {field: 'chk', checkbox: true, width: 50},
                    {field: 'cid', title: '用户名', sortable: true, width: 80},
                    {field: 'name', title: '姓名', width: 80},
                    {field: 'gender', title: '性别', width: 50},
                    {field: 'tid', title: '授课老师ID', width: 80, sortable: true},
                    {field: 'courseid', title: '授课课程ID', width: 80, sortable: true},
                    {field: 'email', title: '邮箱', width: 150},
                    {field: 'introduce', title: '课程简介', width: 400},
                ]],
                toolbar: "#toolbar"
            });
            //设置分页控件
            var p = $('#dataList').datagrid('getPager');
            $(p).pagination({
                pageSize: 10,//每页显示的记录条数，默认为10
                pageList: [10, 20, 30, 50, 100],//可以设置每页记录条数的列表
                beforePageText: '第',//页数文本框前显示的汉字
                afterPageText: '页    共 {pages} 页',
                displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录',
            });
            //添加
            $("#add").click(function () {
                table = $("#addTable");
                $("#addDialog").dialog("open");
            });
            //修改
            $("#edit").click(function () {
                table = $("#editTable");
                var selectRows = $("#dataList").datagrid("getSelections");
                if (selectRows.length != 1) {
                    $.messager.alert("消息提醒", "请选择一条数据进行操作!", "warning");
                } else {
                    $("#editDialog").dialog("open");
                }
            });


            //删除
            $("#delete").click(function () {
                var selectRows = $("#dataList").datagrid("getSelections");
                var selectLength = selectRows.length;
                if (selectLength == 0) {
                    $.messager.alert("消息提醒", "请选择数据进行删除!", "warning");
                } else {
                    var ids = [];
                    //console.log(selectRows);
                    for (var i = 0; i < selectLength; i++) {
                        ids[i] = selectRows[i].lid
                    }
                    $.messager.confirm("消息提醒", "将删除与用户相关的所有数据，确认继续？", function (r) {
                        if (r) {
                            $.ajax({
                                type: "post",
                                url: "delete",
                                data: {ids: ids},
                                dataType: 'json',//不加的话后台会识别成字符串
                                success: function (data) {
                                    if (data.type == "success") {
                                        $.messager.alert("消息提醒", "删除成功!", "info");
                                        //刷新表格
                                        $("#dataList").datagrid("reload");
                                        $("#dataList").datagrid("uncheckAll");
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

            //设置添加窗口
            $("#addDialog").dialog({
                title: "添加用户",
                width: 400,
                height: 350,
                iconCls: "icon-add",
                modal: true,
                collapsible: false,
                minimizable: false,
                maximizable: false,
                draggable: true,
                closed: true,
                buttons: [
                    {
                        text: '添加',
                        plain: true,
                        iconCls: 'icon-add',
                        handler: function () {
                            // var validate = $("#addForm").form("validate");
                            var data = $("#addForm").serialize();
                            $.ajax({
                                type: "post",
                                url: "add",
                                data: data,
                                dataType: 'json',
                                success: function (data) {
                                    if (data.type == "success") {
                                        $.messager.alert("消息提醒", "添加成功!", "info");
                                        //关闭窗口
                                        $("#addDialog").dialog("close");
                                        //重新刷新页面数据
                                        $('#dataList').datagrid("reload");

                                    } else {
                                        $.messager.alert("消息提醒", data.msg, "warning");
                                        return;
                                    }
                                }
                            });
                        }

                    },
                ],
                onClose: function () {
                    $("#add_lid").textbox('setValue', "");
                    $("#add_name").textbox('setValue', "");
                    $("#add_gender").textbox('setValue', "");
                    $("#add_tid").textbox('setValue', "");
                    $("#add_courseid").textbox('setValue', "");
                }
            });

            //编辑用户信息
            $("#editDialog").dialog({
                title: "修改用户信息",
                width: 350,
                height: 300,
                iconCls: "icon-edit",
                modal: true,
                collapsible: false,
                minimizable: false,
                maximizable: false,
                draggable: true,
                closed: true,
                buttons: [
                    {
                        text: '提交',
                        plain: true,
                        iconCls: 'icon-edit',
                        handler: function () {
                            // var validate = $("#editForm").form("validate");
                            var data = $("#editForm").serialize();
                            console.log(data);
                            $.ajax({
                                type: "post",
                                url: "edit",
                                data: data,
                                dataType: 'json',
                                success: function (data) {
                                    if (data.type == "success") {
                                        $.messager.alert("消息提醒", "修改成功!", "info");
                                        //关闭窗口
                                        $("#editDialog").dialog("close");
                                        $('#dataList').datagrid("reload");
                                        $('#dataList').datagrid("uncheckAll");

                                    } else {
                                        $.messager.alert("消息提醒", data.msg, "warning");
                                        return;
                                    }
                                }
                            });
                        }

                    },
                ],

                onBeforeOpen: function () {
                    var selectRow = $("#dataList").datagrid("getSelected");
                    //设置值
                    $("#edit_lid").val(selectRow.lid);
                    $("#edit_name").textbox('setValue', selectRow.name);
                    $("#edit_gender").textbox('setValue', selectRow.gender);
                    $("#edit_profession").textbox('setValue', selectRow.profession);
                    $("#edit_branchid").textbox('setValue', selectRow.branchid);
                }
            });


            //搜索按钮
            $("#search-btn").click(function () {
                $('#dataList').datagrid('reload', {
                    lid: $("#search-username").searchbox('getValue')
                });

            });
        })
        ;

    </script>
</head>
<body>
<!-- 数据列表 -->
<table id="dataList" cellspacing="0" cellpadding="0">

</table>
<!-- 工具栏 -->
<div id="toolbar">
    <div style="float: left;"><a id="add" href="javascript:;" class="easyui-linkbutton"
                                 data-options="iconCls:'icon-add',plain:true">添加</a></div>
    <div style="float: left;" class="datagrid-btn-separator"></div>
    <div style="float: left;"><a id="edit" href="javascript:;" class="easyui-linkbutton"
                                 data-options="iconCls:'icon-edit',plain:true">修改</a></div>
    <div style="float: left;" class="datagrid-btn-separator"></div>
    <div>
        <a id="delete" href="javascript:;" class="easyui-linkbutton"
           data-options="iconCls:'icon-some-delete',plain:true">删除</a>
        用户名:<input id="search-username" class="easyui-textbox"/>
        <a id="search-btn" href="javascript:;" class="easyui-linkbutton"
           data-options="iconCls:'icon-search',plain:true">搜索</a>
        <%--			上传       --%>
        <%--		<tr>--%>
        <%--		    <td><input type="file" id="upload" name="upload" value="" /></td>--%>
        <%--		    <td><button οnclick="uploadFile()">上传</button></td>--%>
        <%--		    <td><button οnclick="OutputExce()">导出</button></td>--%>
        <%--		</tr>--%>
    </div>
</div>

<!-- 添加窗口 -->
<div id="addDialog" style="padding: 10px;">
    <!--
    <div style=" position: absolute; margin-left: 560px; width: 250px; height: 300px; border: 1px solid #EEF4FF" id="photo">
     <img alt="照片" style="max-width: 250px; max-height: 300px;" title="照片" src="photo/teacher.jpg" />

 </div>
     -->
    <form id="addForm" method="post">
        <table id="addTable" cellpadding="6">
            <tr>
                <td>用户名 :</td>
                <td><input id="add_lid" class="easyui-textbox" style="width: 200px; height: 30px;" type="text"
                           name="lid" data-options="required:true, validType:'repeat', missingMessage:'请填写用户名'"/></td>
            </tr>
            <tr>
                <td>姓名:</td>
                <td><input id="add_name" class="easyui-textbox" style="width: 200px; height: 30px;" type="text"
                           name="name" data-options="required:true, validType:'repeat', missingMessage:'请填写姓名'"/></td>
            </tr>
            <tr>
                <td>性别:</td>
                <td><input id="add_gender" style="width: 200px; height: 30px;" class="easyui-textbox" type="text"
                           name="gender" data-options="required:true, missingMessage:'请填写性别'"/></td>
            </tr>
            <tr>
                <td>授课老师ID:</td>
                <td><input id="add_tid" style="width: 200px; height: 30px;" class="easyui-textbox" type="text"
                           name="tid" data-options="required:true, missingMessage:'请填写授课老师ID'"/></td>
            </tr>
            <tr>
                <td>授课课程ID:</td>
                <td><input id="add_courseid" style="width: 200px; height: 30px;" class="easyui-textbox" type="text"
                           name="courseid" data-options="required:true, missingMessage:'请填写授课课程ID'"/></td>
            </tr>
        </table>
    </form>
</div>

<!-- 设置课程 -->
<div id="chooseCourseDialog" style="padding: 10px">
    <table cellpadding="8">
        <tr>
            <td>年级：</td>
            <td><input id="add_gradeList" style="width: 200px; height: 30px;" class="easyui-combobox" name="gradeid"/>
            </td>
        </tr>
        <tr>
            <td>班级：</td>
            <td><input id="add_clazzList" style="width: 200px; height: 30px;" class="easyui-combobox" name="clazzid"/>
            </td>
        </tr>
        <tr>
            <td>课程：</td>
            <td><input id="add_courseList" style="width: 200px; height: 30px;" class="easyui-combobox" name="courseid"/>
            </td>
        </tr>
    </table>
</div>

<!-- 修改窗口 -->
<div id="editDialog" style="padding: 10px">
    <form id="editForm" method="post">
        <input type="hidden" name="lid" id="edit_lid">
        <table id="editTable" border=0 cellpadding="8">
            <tr>
                <td>姓名:</td>
                <td><input id="edit_name" class="easyui-textbox" style="width: 200px; height: 30px;" type="text"
                           name="name" data-options="required:true, validType:'repeat', missingMessage:'请填写姓名'"/></td>
            </tr>
            <tr>
                <td>性别:</td>
                <td><input id="edit_gender" style="width: 200px; height: 30px;" class="easyui-textbox" type="text"
                           name="gender" data-options="required:true, missingMessage:'请填写性别'"/></td>
            </tr>
            <tr>
                <td>专业:</td>
                <td><input id="edit_profession" style="width: 200px; height: 30px;" class="easyui-textbox" type="text"
                           name="profession" data-options="required:true, missingMessage:'请填写所属专业'"/></td>
            </tr>
            <tr>
                <td>方向ID:</td>
                <td><input id="edit_branchid" style="width: 200px; height: 30px;" class="easyui-textbox" type="text"
                           name="branchid" data-options="required:true, missingMessage:'请填写所属对应方向ID'"/></td>
            </tr>
        </table>
    </form>
</div>


</body>
</html>