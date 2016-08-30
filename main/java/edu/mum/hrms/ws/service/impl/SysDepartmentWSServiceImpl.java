package edu.mum.hrms.ws.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.core.exception.AppException;
import edu.mum.hrms.dao.DepartmentDao;
import edu.mum.hrms.model.SysDepartment;
import edu.mum.hrms.ws.service.SysDepartmentWSService;

@Transactional
@Service
public class SysDepartmentWSServiceImpl implements SysDepartmentWSService {
	
	@Autowired
	private DepartmentDao departmentDao;

	@Override
	public List<SysDepartment> findDepartments() throws AppException {
		List<SysDepartment> depts = departmentDao.findDepartments();
		return depts;
	}

	@Override
	public SysDepartment findDeptById(long id) throws AppException {
		return departmentDao.get(id);
	}

	@Override
	public void addDept(SysDepartment sysDepartment) throws AppException {
		departmentDao.save(sysDepartment);
	}

	@Override
	public void updateDept(SysDepartment dept) throws AppException {
		departmentDao.update(dept);
	}

	@Override
	public void deleteDept(SysDepartment dept) throws AppException {
		departmentDao.remove(dept);
	}
	
	
}
