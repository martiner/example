<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="title">Tasks</c:set>
<c:set var="content">
<form:form modelAttribute="task" action="task.go" cssClass="form-horizontal">
	<form:hidden path="id"/>
	<legend>Form</legend>

	<div class="control-group">
		<label class="control-label">Title</label>
		<div class="controls">
			<form:input path="title" />
			<form:errors path="title" cssClass="label label-important" />
		</div>
	</div>

	<div class="control-group">
		<label class="control-label">Description</label>
		<div class="controls">
			<form:textarea path="desc" />
			<form:errors path="desc" cssClass="label label-important" />
		</div>
	</div>

	<div class="form-actions">
		<input type="submit" class="btn btn-primary" value="Save changes"/>
	</div>
</form:form>

	<a class="btn" href="?">back</a>
</c:set>

<%@ include file="_template.jsp" %>