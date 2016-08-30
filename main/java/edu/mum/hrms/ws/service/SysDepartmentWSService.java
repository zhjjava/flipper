package edu.mum.hrms.ws.service;

import java.util.List;

import edu.mum.core.exception.AppException;
import edu.mum.hrms.model.SysDepartment;
import edu.mum.hrms.ws.model.SimpleSysUser;

public interface SysDepartmentWSService {
	public List<SysDepartment> findDepartments() throws AppException;
	public SysDepartment findDeptById(long id) throws AppException;
	public void addDept(SysDepartment sysDepartment) throws AppException;
	public void updateDept(SysDepartment dept) throws AppException;
	public void deleteDept(SysDepartment dept) throws AppException;
}
