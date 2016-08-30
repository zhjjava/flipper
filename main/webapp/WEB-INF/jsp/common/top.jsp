<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/header1.jsp"%>
    <!-- loading animation -->
    <div id="qLoverlay"></div>
    <div id="qLbar"></div>
    <div id="header">
        <nav class="navbar navbar-default" role="navigation" style="height: 100%;">
            <div class="navbar-header">
                <a class="navbar-brand" href="dashboard.html">Human Resource Management System<span class="slogan">&nbsp;By Flipper Team</span></a>
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon16 icomoon-icon-arrow-4"></span>
                </button>
            </div>
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav">
                    <li>
                    </li>
                    <li class="dropdown">
                    </li>
                    <li class="dropdown">
                    </li>
                </ul>
                <ul class="nav navbar-right usernav">
                    <li class="dropdown">
                        <ul class="dropdown-menu">
                            <li class="menu">
                            </li>
                        </ul>
                    </li>
                <c:if test="${sessionSysUser != null}">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle">
                            <span class="txt">${sessionSysUser.userName}</span>
                        </a>
                    </li>
                    <li><a href="${ctx}/logout.do" target="_parent"><span class="icon16 icomoon-icon-exit"></span><span class="txt">Logout</span></a></li>
                </c:if>
                </ul>
            </div>
            <!-- /.nav-collapse -->
        </nav>
        <!-- /navbar -->
    </div>
    <!-- End #header -->
<%@ include file="/common/footer1.jsp"%>