<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/header1.jsp"%>
    <!-- End #header -->
    <div id="wrapper">
        <!--Responsive navigation button-->
        <!-- <div class="resBtn">
            <a href="#"><span class="icon16 minia-icon-list-3"></span></a>            
        </div>-->
        <!--Sidebar collapse button-->
        <div class="collapseBtn leftbar">
            <a href="#" class="tipR" title="Hide sidebar"><span class="icon12 minia-icon-layout"></span></a>
        </div>
        <!--Sidebar background-->
        <div id="sidebarbg" class="offCanvas"></div>
        <!--Sidebar content-->
        <div id="sidebar" class="offCanvas">
            <!-- End search -->
            <div class="sidenav">
                <div class="sidebar-widget" style="margin: -1px 0 0 0;">
                    <h5 class="title" style="margin-bottom:0">Navigator</h5>
                </div>
                <!-- End .sidenav-widget -->
                 <div class="mainnav">
                    <ul>
						<c:forEach items="${menuList}" var="menu" varStatus="status">
							<c:if test="${!empty menu.menu}">
							<li> 
							  <a href="#"><span class="icon16 icomoon-icon-support"></span>${menu.name}</a> 
							  <ul class="sub">
							  
							  <c:forEach items="${menu.menu}" var="subMenu">
							  <li><a href="${subMenu.link}" target="${subMenu.target}"><span class="icon16 icomoon-icon-rocket"></span>${subMenu.name}</a></li>
							  </c:forEach>
							 							  
							  </ul> 
							 
							</li>
							
							</c:if>
						</c:forEach>
                    </ul>
                </div>
            </div>
            <!-- End sidenav -->
        </div>
        <!-- End #sidebar -->
        
<%@ include file="/common/footer1.jsp"%>