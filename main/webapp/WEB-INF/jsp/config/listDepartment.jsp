<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/header1.jsp"%>
<%
edu.mum.hrms.util.displaytag.CheckboxTableDecorator decorator = new edu.mum.hrms.util.displaytag.CheckboxTableDecorator();
decorator.setId("departId");
decorator.setFieldName("checkboxValues");
pageContext.setAttribute("checkboxDecorator", decorator);
%>
    <!-- End #header -->
    <div id="wrapper">
        <!--Body content-->
        <div id="content" class="clearfix">
            <div class="contentwrapper">
                <!--Content wrapper-->
                <div class="heading">
                    <h3>Department List</h3>
                    <div class="resBtnSearch">
                        <a href="#"><span class="icon16 icomoon-icon-search-3"></span></a>
                    </div>
                    <div class="search">
                    </div>
                    <!-- End search -->
                </div>
                <!-- End .heading-->
                <!-- Build page from here: Usual with <div class="row-fluid"></div> -->
                <div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-default gradient">
                            <div class="panel-heading">
                                <h4>
                                        <span>Department List</span>
                                    </h4>
                            </div>
<form:form name="dataListForm" method="post" action="listDepartment.do"  modelAttribute="queryFormData">      
                            <div class="panel-body noPad clearfix">
                                <div tabindex="5001" style="overflow: hidden;" class="responsive">
                                    <div id="DataTables_Table_1_wrapper" class="dataTables_wrapper form-inline" role="grid">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <button class="btn btn-info btn-xs" type="button" data-toggle="modal" data-target=".bs-example-modal-lg1"><span class="icon16 icomoon-icon-pen-3 white"></span>Add a New Department</button>
                                            </div>
                                            <div class="col-md-6">
                                                <div id="DataTables_Table_1_filter" class="dataTables_filter">
                                                    <label><span></span>
                                                    	<div class="col-md-4">
                                               				<form:input id="departmentName" type="text" path="field1" cssClass="form-control"  size="25" />
                                          			    </div>
                                          			    <div class="col-md-4">
                                                   			 <button type="submit" class="btn btn-default" onclick="query(this.form);">Search</button>
                                          			    </div>
                                                    </label>
                                                </div>
                                            </div>
                                        </div>

									    <display:table name="pageData" style="width:100%" id="row" pagesize="${pageSize}" decorator="checkboxDecorator" class="tableTools display table table-bordered dataTable" form="dataListForm" excludedParams="" varTotals="subTotalMap">
									      <display:column title="NO" style="white-space: nowrap;width:4px" headerClass="col-tb-1">${row_rowNum+pageSize*(pageNumber-1)}</display:column>
									      <display:column title="departNum"  property="departNum" sortProperty="departNum" sortable="true" headerClass="col-tb-2"/>									          
									      <display:column title="departName"  property="departName" sortProperty="departName" sortable="true" headerClass="col-tb-2"/>
										  <display:column title="departMajor"   sortProperty="departMajor" sortable="true" headerClass="col-tb-2">${row.major.firstName} ${row.major.lastName}</display:column>
										  <display:column title="Operation">
										  <button onClick="javascript:preEditData(${row.departId})" class="btn btn-info btn-xs" data-toggle="modal" data-target=".bs-example-modal-lg1"><span class="icon16 icomoon-icon-pen-2 white"></span> Edit</button>
                                          <button onClick="javascript:deleteRow(this.form,${row.departId})" class="btn btn-info btn-xs" ><span class="icon16 icomoon-icon-remove white"></span> Delete</button></display:column> 
									    </display:table> 	
</form:form>								   
                                    </div>
                                </div>
                            </div>

                        </div>
                        <!-- End .panel -->
                    </div>
                    <!-- End .span12 -->
                </div>
                <!-- End .row -->
                <!-- Page end here -->
            </div>
            <!-- End contentwrapper -->
        </div>
        <!-- End #content -->
    </div>
        <!--start modal-->
    <form id="editForm" name="editForm" method="post" action="" class="form-horizontal"> 
    <div id="modalDiv" class="modal fade bs-example-modal-lg1" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">Edit Department</h4>
                </div>
                <div class="modal-body">
                    <input type="hidden" id="departId" name="departId"  value="">
                    <label for="">Department Name</label>
                    <input type="text" id="departName" name="departName" class="form-control uniform-input text" value="">
                    <label for="">Department SN</label>
                    <input type="text" id="departNum" name="departNum" class="form-control uniform-input text" value="">
                     <label for="">Major</label>
                    <input type="text" readonly="true" id="departMajorStr" name="departMajorStr" class="form-control uniform-input text" value="">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="button" onClick="javascript:editData()" class="btn btn-info">Save</button>
                </div>
            </div>
        </div>
    </div>
    </form> 
    <!--end modal-->
    

<script language="javascript">
//focusElement(getEl("theValue"));
//convert back end data objects to js objects
//or convert the whole back end objects to js objects in the controller.
var dataMap ={};
<c:if test="${pageData!=null}">
function initJSDataObjects(){
	  <c:forEach items="${pageData.list}" var="item">  
         var itemJSObj = {};
         itemJSObj['departId'] = '${item.departId}';
         itemJSObj['departName'] = '${item.departName}';
         itemJSObj['departNum'] = '${item.departNum}';
         itemJSObj['departMajor'] = '${item.major.firstName} ${item.major.lastName}';
         dataMap['${item.departId}']=itemJSObj;
 //        alert(itemJSOBJ);
      </c:forEach>
}
initJSDataObjects();
</c:if>

function query(form) {
   //should reset pageNumber when submit a query request.
   form.pageNumber.value=1;
   form.submit();
}

$("#modalDiv").on("hidden.bs.modal", function() {  
    $(this).removeData("bs.modal");  
});

function preEditData(rowId){
	//alert(rowId);
	//$('#modalDiv').modal();
	var rowData = dataMap[rowId];
	//alert(rowData['theKey']);
	$('#departId').val(rowData['departId']);
	$('#departNum').val(rowData['departNum']);
	$('#departName').val(rowData['departName']);
	$('#departMajor').val(rowData['departMajor']);


}

function editData() {  
	var jsonReqInfo = $('#editForm').serialize(); 	                    
   // alert($('#editForm').serialize());  
    jQuery.ajax( {  
      type : 'POST',  
      //contentType : 'application/text',  
      url : '${ctx}/ajax/sysCode/editDepartmentAjax.do',  
      data : jsonReqInfo,  
      dataType : 'json',  
      success : function(respObj) {
    	if(respObj.isSuccess=='true'){
    		alert('Succeeded to save the data.');
    		window.location.href="${ctx}/config/listDepartment.do";
    	}else{
    		alert('Failed to save the data.');
    		//reset the error tips
    		restoreAllFormElements(originalStyleOfFormEls);
        	if(respObj.actionErrorMsgList!=null||respObj.fieldsErrorMsgMap!=null){
                handleAjaxRespError(document.editForm,respObj.actionErrorMsgList,respObj.fieldsErrorMsgMap);
            }
        }
      },  
      error : function(respObj) {  
    		alert('Something went wrong, please contact administrator.');
      }  
    });
}

function deleteRow(form,rid) {
	var cfn = window.confirm("<spring:message code="warning.delete.message"/>");
    if (!cfn){
         return;
    }
	form.action="deleteDepartment.do?rId=" + rid;
	form.submit();
}

</script>
<%@ include file="/common/footer1.jsp"%>