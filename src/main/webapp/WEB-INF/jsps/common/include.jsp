<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>



<c:url value="/?language=en" var="en_locale" />
<c:url value="/?language=zh_CN" var="zh_CN_locale" />


<c:url value="/j_spring_security_check" var="j_spring_security_check_url" />
<c:url value="/login" var="login_url" />
<c:url value="/j_spring_security_logout" var="logout_url" />


<c:url value="/addactor" var="addactor_url" />
<c:url value="/actors" var="actors_url" />


<c:url value="/adduser" var="adduser_url" />

<c:url value="/jquery" var="jquery_url" />
