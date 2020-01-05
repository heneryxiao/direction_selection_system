<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title> 学生专业选报系统</title>
    <link rel="shortcut icon" href="../favicon.ico"/>
    <link rel="bookmark" href="../favicon.ico"/>
    <link rel="stylesheet" type="text/css" href="../easyui/css/default.css"/>
    <link rel="stylesheet" type="text/css" href="../easyui/themes/default/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css"/>
    <script type="text/javascript" src="../easyui/jquery.min.js"></script>
    <script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src='../easyui/js/outlook2.js'></script>
    <script type="text/javascript">
        var _menus = {
            "menus": [
                <c:if test="${user.type == 1}">
                {
                    "menuid": "4", "icon": "", "menuname": "后台管理",
                    "menus": [

                        {"menuid": "41", "menuname": "用户列表", "icon": "icon-exam", "url": "../user/list"},
                        {"menuid": "42", "menuname": "负责人列表", "icon": "icon-exam", "url": "../leader/list"},
                        {"menuid": "43", "menuname": "课程主任列表", "icon": "icon-exam", "url": "../courseLeader/list"},
                        {"menuid": "44", "menuname": "老师列表", "icon": "icon-exam", "url": "../teacher/list"},
                        {"menuid": "45", "menuname": "学生列表", "icon": "icon-exam", "url": "../student/list"},
                    ]
                },
                </c:if>
                <c:if test="${user.type != 6}">
                {
                    "menuid": "1", "icon": "", "menuname": "用户信息",
                    "menus": [
                        <c:if test="${user.type == 1}">
                        // {"menuid": "11", "menuname": "用户列表", "icon": "icon-exam", "url": "../user/list"},
                        // {"menuid": "12", "menuname": "系主任列表", "icon": "icon-exam", "url": ""},
                        </c:if>
                        <c:if test="${user.type == 2 || user.type == 3 || user.type == 4 }">
                        <c:if test="${user.type == 2}">
                        // {"menuid": "13", "menuname": "专业负责人列表", "icon": "icon-exam", "url": ""},
                        </c:if>
                        <c:if test="${user.type == 2 || user.type == 3}">
                        // {"menuid": "14", "menuname": "方向负责人列表", "icon": "icon-exam", "url": ""},
                        </c:if>
                        {"menuid": "15", "menuname": "老师列表", "icon": "icon-exam", "url": "../teacherList/list"},
                        {"menuid": "16", "menuname": "学生列表", "icon": "icon-exam", "url": "../studentList/list"},
                        </c:if>


                    ]
                },
                </c:if>
                <c:if test="${user.type != 1}">
                {
                    "menuid": "2", "icon": "", "menuname": "选报信息",
                    "menus": [
                        <c:if test="${user.type == 1}">
                        // {"menuid": "21", "menuname": "系", "icon": "icon-exam", "url": ""},
                        </c:if>
                        <c:if test="${user.type == 2}">
                        // {"menuid": "22", "menuname": "专业", "icon": "icon-exam", "url": ""},
                        </c:if>
                        <c:if test="${user.type == 2 || user.type == 3}">
                        {"menuid": "23", "menuname": "方向", "icon": "icon-exam", "url": "../BranchList/list"},
                        </c:if>
                        <c:if test="${user.type == 4|| user.type == 5}">
                        {"menuid": "23", "menuname": "课程列表", "icon": "icon-exam", "url": "../CourseList/list"}
                        </c:if>
                        <c:if test="${user.type == 6}">
                        {"menuid": "26", "menuname": "方向介绍", "icon": "icon-exam", "url": "../BranchIntroduce/introduce"},
                        {"menuid": "24", "menuname": "方向选报", "icon": "icon-exam", "url": "../BranchSelection/select"},
                        {"menuid": "25", "menuname": "课程信息", "icon": "icon-exam", "url": "../CourseIntroduce/select"}
                        </c:if>
                    ]
                },

                {
                    "menuid": "3", "icon": "", "menuname": "个人信息",
                    "menus": [
                        {"menuid": "32", "menuname": "个人信息", "icon": "icon-exam", "url": "../SelfInformation/introduce"},
                        <c:if test="${user.type == 5}">
                        {"menuid": "31", "menuname": "授课学生列表", "icon": "icon-exam", "url": "../selectedStudentList/list"},
                        </c:if>
                        <c:if test="${user.type == 6}">
                        {"menuid": "33", "menuname": "选报信息", "icon": "icon-exam", "url": "../selectInformation/select"},
                        </c:if>

                    ]
                }
                </c:if>
            ]
        };


    </script>

</head>
<body class="easyui-layout" style="overflow-y: hidden" scroll="no">
<noscript>
    <div style=" position:absolute; z-index:100000; height:2046px;top:0px;left:0px; width:100%; background:white; text-align:center;">
        <img src="images/noscript.gif" alt='抱歉，请开启脚本支持！'/>
    </div>
</noscript>
<div region="north" split="true" border="false" style="overflow: hidden; height: 30px;
        background: #7f99be ;
        line-height: 20px;color: #fff; font-family: Verdana, 微软雅黑,黑体">
    <span style="float:right; padding-right:20px;" class="head"><span
            style="color:red; font-weight:bold;">
        <c:if test="${user.type == 1}">
            尊敬的管理员&nbsp;
        </c:if>
        <c:if test="${user.type == 2}">
            尊敬的专业负责人&nbsp;
        </c:if>
        <c:if test="${user.type == 3}">
            尊敬的方向负责人&nbsp;
        </c:if>
        <c:if test="${user.type == 4}">
            尊敬的课程主任&nbsp;
        </c:if>
        <c:if test="${user.type == 5}">
            尊敬的老师&nbsp;
        </c:if>
        <c:if test="${user.type == 6}">
            尊敬的学生&nbsp;
        </c:if>

        ${userWithType.name}&nbsp;

    </span>您好&nbsp;&nbsp;&nbsp;<a
            href="login_out" id="loginOut">安全退出</a></span>
    <span style="padding-left:10px; font-size: 16px; "> 学生专业方向选择系统</span>
</div>
<div region="south" split="true" style="height: 30px; background: #D2E0F2; ">
    <div class="footer">Copyright &copy; 肖智海</div>
</div>
<div region="west" hide="true" split="true" title="导航菜单" style="width:180px;" id="west">
    <div id="nav" class="easyui-accordion" fit="true" border="false">
        <!--  导航内容 -->
    </div>

</div>
<div id="mainPanle" region="center" style="background: #eee; overflow-y:hidden">
    <div id="tabs" class="easyui-tabs" fit="true" border="false">
        <jsp:include page="welcome.jsp"/>
    </div>
</div>


</body>
</html>