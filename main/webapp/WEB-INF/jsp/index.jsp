<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<head>
<c:if test="${sessionSysUser == null}">
	<c:redirect url="login.do" />
</c:if>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>HRMS</title>
<meta name="author" content="SuggeElson" />
<meta name="description"
	content="Supr admin template - new premium responsive admin template. This template is designed to help you build the site administration without losing valuable time.Template contains all the important functions which must have one backend system.Build on great twitter boostrap framework" />
<meta name="keywords"
	content="admin, admin template, admin theme, responsive, responsive admin, responsive admin template, responsive theme, themeforest, 960 grid system, grid, grid theme, liquid, masonry, jquery, administration, administration template, administration theme, mobile, touch , responsive layout, boostrap, twitter boostrap" />
<meta name="application-name" content="Supr admin template" />
<!-- Mobile Specific Metas -->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<!-- Force IE9 to render in normla mode -->
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<!-- Le styles -->
<!-- Use new way for google web fonts 
    http://www.smashingmagazine.com/2012/07/11/avoiding-faux-weights-styles-google-web-fonts -->
</head>

<frameset rows="73,*" cols="*" frameborder="no" border="0"
	framespacing="0">
	 <frame	src="${ctx}/layout/loadTopPageAction.do" name="topFrame" scrolling="No"	noresize="noresize" id="topFrame" /> 
	 <frameset cols="210,*"	frameborder="no" border="0" framespacing="0"> 
	    <frame src="${ctx}/layout/loadMenuPageAction.do" scrolling="No"	noresize="noresize" border="1" id="leftFrame" />
	    <frame src="${ctx}/layout/loadMainPageAction.do" name="mainFrame" border="0"	id="mainFrame" /> 
	 </frameset> 
</frameset>
<noframes>
	<body>
	</body>
</noframes>
</html>
