<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ include file="/common/include.jsp"%>
<html>
<head>
<title>Success!</title>
<%@ include file="/common/meta.jsp"%>
</head>
<body>
<div id="reSetMenu" onclick="switchBar(imgOC)">
<img id="imgOC" src="${ctx }/images/close.gif" title="hide menu" /></div>
<div id="contentsbg">
<div id="sortout">
  <div id="latitle" align="center"><s:actionmessage/></div>
  <div id="sptit" align="center"><c:url value="${returnURL}" id="latitle" >返回</c:url></div>
</div>
</div>
</body>
</html>