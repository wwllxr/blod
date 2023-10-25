<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<c:if test="${pageInfo.pageCount > 1}">
    <nav class="navigation pagination" role="navigation">
        <div class="nav-links">
            <c:choose>
                <c:when test="${pageInfo.pageCount <= 3 }">
                    <c:set var="begin" value="1"/>
                    <c:set var="end" value="${pageInfo.pageCount }"/>
                </c:when>
                <c:otherwise>
                    <c:set var="begin" value="${pageInfo.pageIndex-1 }"/>
                    <c:set var="end" value="${pageInfo.pageIndex + 2}"/>
                    <c:if test="${begin < 2 }">
                        <c:set var="begin" value="1"/>
                        <c:set var="end" value="3"/>
                    </c:if>
                    <c:if test="${end > pageInfo.pageCount }">
                        <c:set var="begin" value="${pageInfo.pageCount-2 }"/>
                        <c:set var="end" value="${pageInfo.pageCount }"/>
                    </c:if>
                </c:otherwise>
            </c:choose>
                <%--上一页 --%>
            <c:choose>
                <c:when test="${pageInfo.pageIndex eq 1 }">
                    <%--当前页为第一页，隐藏上一页按钮--%>
                </c:when>
                <c:otherwise>
                    <a class="page-numbers" href="${pageUrlPrefix}/${pageInfo.pageIndex-1}">
                        <i class="layui-icon">&#xe603;</i>
                    </a>
                </c:otherwise>
            </c:choose>
                <%--显示第一页的页码--%>
            <c:if test="${begin >= 2 }">
                <a class="page-numbers" href="${pageUrlPrefix}/1">1</a>
            </c:if>
                <%--显示点点点--%>
            <c:if test="${begin  > 2 }">
                <span class="page-numbers dots">…</span>
            </c:if>
                <%--打印 页码--%>
            <c:forEach begin="${begin }" end="${end }" var="i">
                <c:choose>
                    <c:when test="${i eq pageInfo.pageIndex }">
                        <a class="page-numbers current">${i}</a>
                    </c:when>
                    <c:otherwise>
                        <a class="page-numbers" href="${pageUrlPrefix}/${i}">${i}</a>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
                <%-- 显示点点点 --%>
            <c:if test="${end < pageInfo.pageCount-1 }">
                <span class="page-numbers dots">…</span>
            </c:if>
                <%-- 显示最后一页的数字 --%>
            <c:if test="${end < pageInfo.pageCount }">
                <a href="${pageUrlPrefix}/${pageInfo.pageCount}">   ${pageInfo.pageCount}</a>
            </c:if>
                <%--下一页 --%>
            <c:choose>
                <c:when test="${pageInfo.pageIndex eq pageInfo.pageCount }">
                    <%--到了尾页隐藏，下一页按钮--%>
                </c:when>
                <c:otherwise>
                    <a class="page-numbers"  href="${pageUrlPrefix}/${pageInfo.pageIndex+1}"> <i class="layui-icon">&#xe602;</i>  </a>
                </c:otherwise>
            </c:choose>
        </div>
    </nav>
</c:if>