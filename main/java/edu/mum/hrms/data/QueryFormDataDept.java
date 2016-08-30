package edu.mum.hrms.data;

public class QueryFormDataDept {
	private long deptId; //
	private String localeDeptName;
	
	public long getDeptId() {
		return deptId;
	}
	public void setDeptId(long deptId) {
		this.deptId = deptId;
	}
	public String getLocaleDeptName() {
		return localeDeptName;
	}
	public void setLocaleDeptName(String localeDeptName) {
		this.localeDeptName = localeDeptName;
	}
	public QueryFormDataDept(long deptId, String localeDeptName,Long isChecked) {
		super();
		this.deptId = deptId;
		this.localeDeptName = localeDeptName;
		this.isChecked=isChecked;
	} 
	
	private Long isChecked;

	public Long getIsChecked() {
		return isChecked;
	}
	public void setIsChecked(Long isChecked) {
		this.isChecked = isChecked;
	}
	
	
}
