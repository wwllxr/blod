<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<rapid:override name="frame-content">
    <blockquote class="layui-elem-quote">
					<span class="layui-breadcrumb" lay-separator="/"> <a
                            href="../index.jsp">首页</a> <a href="article/1">文章列表</a> <a><cite>文章显示</cite></a>
					</span>
    </blockquote>
    <label>文章标题：${article.articleTitle}</label><br>
    <label>文章作者：${article.articleUserId}</label>
    <hr>
    <label>文章内容：${article.articleContent}</label>


</rapid:override>
<%@ include file="../framework.jsp" %>
