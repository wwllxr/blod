<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>
<%@ page language="java" import="java.util.*"
         contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<rapid:override name="frame-header-script">
    <style>
        /*覆盖 layui*/

        .layui-table {
            margin-top: 0;
        }

        .layui-btn {
            margin: 2px 0!important;
        }
        tbody td{
            vertical-align: middle!important;  /*设置文字垂直居中*/
        }
    </style>
</rapid:override>
<rapid:override name="frame-content">
    <blockquote class="layui-elem-quote">
         <span class="layui-breadcrumb" lay-separator="/">
              <a href="/admin">首页</a>
              <a><cite>用户列表</cite></a>
        </span>
    </blockquote>

    <table class="layui-table" lay-even lay-skin="nob" >
        <colgroup>
            <col width="100">
            <col width=100">
            <col width="100">
            <col width="50">
            <col width="50">
            <col width="100">
            <col width="50">
        </colgroup>
        <thead>
        <tr>
            <th>用户名</th>
            <th>昵称</th>
            <th>电子邮件</th>
            <th>文章</th>
            <th>状态</th>
            <th>操作</th>
            <th>ID</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="u" items="${pageInfo.list}">
        <tr>
            <td>
                <img src="${u.userAvatar}" width="48" height="48">
                <strong><a href="/admin/user/edit/1">${u.userName}</a></strong>
            </td>
            <td>
                ${u.userNickname}
                </td>
            <td >
                ${u.userEmail}</td>
            <td>
                ${u.userArticleCount}</td>
            <td>
                <c:choose>
                    <c:when test="${u.userStatus==1}">正常</c:when>
                    <c:otherwise>冻结</c:otherwise>
                </c:choose>

            </td>
            <td>
                <a href="/admin/user/edit/1" class="layui-btn layui-btn-mini">编辑</a>
                <a href="/admin/user/delete/1" class="layui-btn layui-btn-danger layui-btn-mini" onclick="return confirmDelete()">删除</a>
            </td>
            <td>
                ${u.userId}
            </td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
    <%@ include file="../page.jsp"%>
</rapid:override>
<%@ include file="../framework.jsp"%>