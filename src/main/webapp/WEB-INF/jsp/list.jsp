<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="title">Tasks</c:set>
<c:set var="content">
<table class="table table-hover">
	<tr><th>Title</th><th></th></tr>
	<c:forEach items="${list}" var="i">
		<tr><td><c:out value="${i.title}" /></td><td><a href="?edit=${i.id}">edit</a></td></tr>
	</c:forEach>
</table>
<a class="btn btn-primary" href="?edit"><i class="icon-plus icon-white"></i>add task</a>
</c:set>

<%@ include file="_template.jsp" %>