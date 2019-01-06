<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:message code="error.errorPage" /></title>
</head>
<body>

	<%@include file="/WEB-INF/incl/menu.app"%>

	<img src="/resources/images/stamperror.jpg">
	<h2>
		<s:message code="error.defaultErrorMessage" />

	</h2>

</body>
</html>