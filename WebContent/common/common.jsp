<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>计科1701课件管理系统</title>
    <link rel="stylesheet" href="css/public.css"/>
    <link rel="stylesheet" href="css/style.css"/>
    <!-- <script language="javascript" type="text/javascript" src="${pageContext.request.contextPath }D:\\javahome\\classDemoTimeControl\\js"></script> -->
</head>
<body>
<!--头部-->
<header class="publicHeader">
    <h1>计科1701课件管理系统</h1>

    <div class="publicHeaderR">
        <p><span>下午好！</span><span style="color: #fff21b"> ${user.realName }</span> , 欢迎你！</p>
        <a href="login.html">退出</a>
    </div>
</header>
<!--时间-->
<section class="publicTime">
    <span id="time">2015年1月1日 11:11  星期一</span>
    <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
</section>
<!--主体内容-->
<section class="publicMian">
    <div class="left">
        <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
        <nav>
            <ul class="list">
                <li ><a href="subject?method=subjectList">科目管理</a></li>
                <li><a href="studyList.html">课件管理</a></li>
                <li><a href="user?method=userList">用户管理</a></li>
                <li><a href="password.html">密码修改</a></li>
                <li><a href="loginOut.jsp">退出系统</a></li>
            </ul>
        </nav>
    </div>