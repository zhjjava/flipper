package edu.mum.hrms.data;

import java.util.List;

import edu.mum.hrms.model.SysRole;
import edu.mum.hrms.model.SysUser;

public class QueryFormDataRole extends QueryFormData{

	private String localRoleName;
	private SysRole  role; //
	private SysUser   user; //
	private String operatonCode;
	private String operatonCodeName;
	private List<QueryFormDataRole> subList;
	private String isChecked="0";//代表未选中
	
	private String isAdmin;
	
	private String isSys;
	
	private String deptId;
	private String deptName;
	private String deptCode;
	private String roleType;
	private String roleId;
	private String loginWay;
	public QueryFormDataRole() {
		super();
	}
    
	
	
	
	public QueryFormDataRole(String operatonCode, String operatonCodeName,
			List<QueryFormDataRole> subList) {
		super();
		this.operatonCode = operatonCode;
		this.operatonCodeName = operatonCodeName;
		this.subList = subList;
	}

    

	public SysUser getUser() {
		return user;
	}




	public void setUser(SysUser user) {
		this.user = user;
	}




	public String getLoginWay() {
		return loginWay;
	}


	public void setLoginWay(String loginWay) {
		this.loginWay = loginWay;
	}

    


	public String getDeptCode() {
		return deptCode;
	}




	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}




	public String getRoleId() {
		return roleId;
	}




	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}




	public String getRoleType() {
		return roleType;
	}




	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}




	public String getDeptId() {
		return deptId;
	}




	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}




	public String getDeptName() {
		return deptName;
	}




	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}




	public String getIsSys() {
		return isSys;
	}

	public void setIsSys(String isSys) {
		this.isSys = isSys;
	}




	public String getIsAdmin() {
		return isAdmin;
	}




	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}




	public String getIsChecked() {
		return isChecked;
	}




	public void setIsChecked(String isChecked) {
		this.isChecked = isChecked;
	}




	public List<QueryFormDataRole> getSubList() {
		return subList;
	}

	public void setSubList(List<QueryFormDataRole> subList) {
		this.subList = subList;
	}

	public String getOperatonCode() {
		return operatonCode;
	}

	public void setOperatonCode(String operatonCode) {
		this.operatonCode = operatonCode;
	}

	public String getOperatonCodeName() {
		return operatonCodeName;
	}

	public void setOperatonCodeName(String operatonCodeName) {
		this.operatonCodeName = operatonCodeName;
	}

	public String getLocalRoleName() {
		return localRoleName;
	}

	public void setLocalRoleName(String localRoleName) {
		this.localRoleName = localRoleName;
	}

	public SysRole getRole() {
		return role;
	}

	public void setRole(SysRole role) {
		this.role = role;
	}
	
}
