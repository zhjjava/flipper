<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/header1.jsp"%>
<%
edu.mum.hrms.util.displaytag.CheckboxTableDecorator decorator = new edu.mum.hrms.util.displaytag.CheckboxTableDecorator();
decorator.setId("sysCodeId");
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
                    <h3>System Code list</h3>
                    <div class="resBtnSearch">
                        <a href="#"><span class="icon16 icomoon-icon-search-3"></span></a>
                    </div>
                    <div class="search">
                    </div>
                    <!-- End search -->
                </div>
                
               <div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-default gradient">
                            <div class="panel-heading">
                                <h4>
                                        <span>System Code list</span>
                                    </h4>
                            </div>
                            <div class="panel-body noPad clearfix">
                                <div tabindex="5001" style="overflow: hidden;" class="responsive">
                                    <div id="DataTables_Table_1_wrapper" class="dataTables_wrapper form-inline" role="grid">
<form:form name="dataListForm" method="post" action="listSysCode.do"  modelAttribute="queryFormData">
                                        <div class="row">
                                           <div class="col-md-1">
                                                  <spring:message code="label.sys.code.theValue"/> 
                                            </div>
                                            <div class="col-md-2">
                                               <form:input id="sysCode" type="text" path="field1" cssClass="form-control"  size="25" />
                                            </div>
                                             <div class="col-md-1">Status</div>
                                            <div class="col-md-2">
                                               <form:select path="field2" >  
										            <option value="">Please Select</option>
										            <form:options items="${statusList2}" itemValue="value" itemLabel="key"/>
										        </form:select>
                                            </div>                                            
                                            
                                            <div class="col-md-4">
                                                <button type="submit" class="btn btn-default" onclick="query(this.form);">Search</button>
                                            </div>
                                             <button type="button" class="btn btn-default" onclick="submitMultiRecords(this.form);">Select multi-records to test</button>
                                        </div>
                                        <c:if test="${pageData!=null}">
										    <display:table name="pageData" style="width:100%" id="row" pagesize="${pageSize}" decorator="checkboxDecorator" class="tableTools display table table-bordered dataTable" form="dataListForm" excludedParams="" varTotals="subTotalMap">
										      <display:column property="checkbox" media="html" title="<input type='checkbox' name='allbox' id='allbox'
										                   onclick='checkAll(this.form)'/>" class="alignCenter" style="width:24px" />
										      <display:column title="NO" style="white-space: nowrap;width:4px" headerClass="col-tb-1">${row_rowNum+pageData.pageSize*(pageData.pageNumber-1)}</display:column>    
										      <display:column title="SysCodeId" total="true" property="sysCodeId" sortProperty="sysCodeId" sortable="true" headerClass="col-tb-2"/>
										      <display:column titleKey="label.sys.code.theKey"  property="theKey" sortable="true" sortProperty="theKey" class="center"/>
										      <display:column titleKey="label.sys.code.theValue" property="theValue" sortable="true" sortProperty="theValue" class="center"/>
										      <display:column title="Operation">						       
										         <button  onClick="javascript:preEditData(${row.sysCodeId})" class="btn btn-info btn-xs" data-toggle="modal" data-target=".bs-example-modal-lg1"><span class="icon16 icomoon-icon-eye-2 white"></span>Edit</button>
										         <button  onClick="javascript:deleteRow(this.form,${row.sysCodeId})" class="btn btn-info btn-xs"><span class="icon16 icomoon-icon-eye-2 white"></span>Delete</button>
										      </display:column> 
											  <display:footer>
											    <tr>
											      <th>&nbsp;</th><th>Total:</th>
											      <th>${subTotalMap.column3}</th>
											      <th>&nbsp;</th><th>&nbsp;</th><th>&nbsp;</th>
											    <tr>
											  </display:footer>
										    </display:table>
									    </c:if>
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
                    <h4 class="modal-title">Sys Code</h4>
                </div>
                <div class="modal-body" id="dataMainPart">
                    <input type="hidden" id="sysCodeId" name="sysCodeId" value="-1">
                    <label for="">Sys Category</label>
				    <select id="categoryId" name="sysCodeCategory.categoryId" >
				     <c:forEach items="${sysCodeCategoryList}" var="item">  
				         <option value ="${item.categoryId}">${item.categoryName}</option>   
				      </c:forEach>
				     </select>
                    <label for="">Sys Locale</label>
				    <select id="localeCode" name="sysLocale.localeCode" >
				     <c:forEach items="${sysLocaleList}" var="item">  
				         <option value ="${item.key}">${item.value}</option>   
				      </c:forEach>
				     </select>
                    <label for="">The Key</label>
                    <input type="text" id="theKey"  name="theKey" class="form-control uniform-input text" value="">
                    <label for="">The Value</label>
                    <input type="text" id="theValue"  name="theValue" class="form-control uniform-input text" value="">
                    <label for="">SEQ</label>
                    <input type="text" id="seq"  name="seq" class="form-control uniform-input text" value="">
                    <label for="">Status</label>
				    <select id="status" name="status" >
				       <option value="1">Enabled</option>
                       <option value="0">Disabled</option>
				     </select>
                 
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
         //itemJSObj['sysCodeId'] = ${item.sysCodeId};
         itemJSObj['theKey'] = '${item.theKey}';
         itemJSObj['theValue'] = '${item.theValue}';
         itemJSObj['seq'] = ${item.seq};
         itemJSObj['status'] = ${item.status};
         itemJSObj['localeCode'] = '${item.sysLocale.localeCode}';
         itemJSObj['categoryId'] = ${item.sysCodeCategory.categoryId};
         dataMap['${item.sysCodeId}']=itemJSObj;
      </c:forEach>

}
initJSDataObjects();
</c:if>
function query(form) {
   //should reset pageNumber when submit a query request.
   form.pageNumber.value=1;
   form.submit();
}

function submitMultiRecords(form){
	var formDataInfo = $(form).serialize();
	alert(formDataInfo);
	return;
	//dataListForm
}

$("#modalDiv").on("hidden.bs.modal", function() {  
    $(this).removeData("bs.modal");  
});        

function preEditData(rowId){
	//alert(rowId);
   // $('#modalDivEdit').modal();
	var rowData = dataMap[rowId];
	//alert(rowData['theKey']);
	$('#sysCodeId').val(rowId);
	$('#theKey').val(rowData['theKey']);
	$('#theValue').val(rowData['theValue']);
	$('#seq').val(rowData['seq']);
	//for select element, we also should set the value of the span element generated by bootstrap with the text of selected option of current select.
	$('#status').val(rowData['status']);
	$('#status').parent().find("span").html($("#status").find("option:selected").text());
	
	$('#localeCode').val(rowData['localeCode']);
	$('#localeCode').parent().find("span").html($("#localeCode").find("option:selected").text());
	
	$('#categoryId').val(rowData['categoryId']);
	$('#categoryId').parent().find("span").html($("#categoryId").find("option:selected").text());
}

function editData() {  
	var jsonReqInfo = $('#editForm').serialize(); 	                    
    //alert($('#editForm').serialize());  
    jQuery.ajax( {  
      type : 'POST',  
      //contentType : 'application/text',  
      url : '${ctx}/ajax/sysCode/editSysCodeAjax.do',  
      data : jsonReqInfo,  
      dataType : 'json',  
      success : function(respObj) {
    	if(respObj.isSuccess=='true'){
    		alert('Success.');
    		window.location.href="${ctx}/config/listSysCode.do";
    	}else{
    		///alert('Failed');
    		if(respObj.opReturnMsg!=undefined && respObj.opReturnMsg!=""&&respObj.opReturnMsg!=null){
    			alert(respObj.opReturnMsg);
    		}
        	if(respObj.actionErrorMsgList!=null||respObj.fieldsErrorMsgMap!=null){
        		//alert(document.editForm);
        		handleAjaxRespError(document.editForm,respObj.actionErrorMsgList,respObj.fieldsErrorMsgMap);
            }
        }
      },  
      error : function(respObj) {  
    		alert('Something went wrong, please contact administrator.');
      }  
    });
}

function deleteRow(form,rId) {
	var cfn = window.confirm("<spring:message code="warning.delete.message"/>");
    if (!cfn){
         return;
    }
	form.action="deleteSysCode.do?rId=" + rId;
	form.submit();
}
function viewRow(form,rId) {
	   form.action="viewSysCode.do?rid=" + rId;
	   form.submit();
}
</script>
<%@ include file="/common/footer1.jsp"%>