<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<rapid:override name="frame-content">
    <blockquote class="layui-elem-quote">
								<span class="layui-breadcrumb" lay-separator="/"> <a
                                        href="../index.jsp">首页</a> <a><cite>文章列表</cite></a>
								</span>
    </blockquote>

    <div class="layui-tab layui-tab-card">
        <form id="articleForm" method="post">
            <input type="hidden" name="currentUrl" id="currentUrl" value="">
            <table class="layui-table">
                <colgroup>
                    <col width="300">
                    <col width="150">
                    <col width="100">
                    <col width="150">
                    <col width="100">
                    <col width="50">
                </colgroup>
                <thead>
                <tr>
                    <th>标题</th>
                    <th>所属分类</th>
                    <th>状态</th>
                    <th>发布时间</th>
                    <th>操作</th>
                    <th>id</th>
                </tr>
                </thead>
                <tbody>
                <%--<tr>
                    <td><a href="/article/33" target="_blank"> MySQL常用命令语句</a></td>
                    <td><a href="/category/10" target="_blank">计算机科学</a>
                        &nbsp; <a href="/category/13" target="_blank">数据库</a> &nbsp;</td>
                    <td><a href="/admin/article?status=1"> <span
                            style="color: #5FB878;">已发布</span>
                    </a></td>
                    <td>2018-11-25 21:06:52</td>
                    <td><a href="/admin/article/edit/33"
                           class="layui-btn layui-btn-mini">编辑</a> <a
                            href="javascript:void(0)" onclick="deleteArticle(33)"
                            class="layui-btn layui-btn-danger layui-btn-mini">删除</a></td>
                    <td>33</td>
                </tr>--%>
                <c:forEach var="a" items="${pageInfo.list}">
                    <tr>
                        <td><a href="article/showArticle/${a.articleId}" target="_blank"> ${a.articleTitle}</a></td>
                        <td><a href="/category/10" target="_blank">
                                ${a.categoryList[0].categoryName}
                            <c:if test="${a.categoryList[0].categoryName==null&&a.categoryList[1].categoryName==null}">未分类</c:if>
                        </a>
                            &nbsp; <a href="/category/13" target="_blank">${a.categoryList[1].categoryName}</a> &nbsp;</td>
                        <td><a href="/admin/article?status=1">
                            <span style="color: #5FB878;">
                                <c:choose>
                                    <c:when test="${a.articleStatus=='1'}">已发布</c:when>
                                    <c:when test="${a.articleStatus=='0'}">草稿</c:when>
                                </c:choose>

                            </span>
                        </a></td>
                        <td><fmt:formatDate value="${a.articleCreateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td><a href="/admin/article/edit/33"
                               class="layui-btn layui-btn-mini">编辑</a> <a
                                href="javascript:void(0)" onclick="deleteArticle(33)"
                                class="layui-btn layui-btn-danger layui-btn-mini">删除</a></td>
                        <td><a href="article/showArticle/${a.articleId}" />${a.articleId}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </form>
        <%@ include file="../page.jsp"%>
    </div>
</rapid:override>
<%@ include file="../framework.jsp" %>
