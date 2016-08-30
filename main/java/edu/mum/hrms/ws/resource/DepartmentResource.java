package edu.mum.hrms.ws.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.mum.core.exception.AppException;
import edu.mum.hrms.model.SysDepartment;
import edu.mum.hrms.ws.service.SysDepartmentWSService;

@Component
@Path("/departments")
public class DepartmentResource {
	
	@Autowired
	private SysDepartmentWSService sysDepartmentWSService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<SysDepartment> findDepts() throws AppException{
		List<SysDepartment> depts = sysDepartmentWSService.findDepartments();
		return depts;
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public SysDepartment findDept(@PathParam("id") long id) throws AppException{
		SysDepartment dept = sysDepartmentWSService.findDeptById(id);
		return dept;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void addDept(SysDepartment dept) throws AppException{
		sysDepartmentWSService.addDept(dept);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void updateDept(SysDepartment dept) throws AppException{
		sysDepartmentWSService.updateDept(dept);
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteDept(SysDepartment dept) throws AppException{
		sysDepartmentWSService.deleteDept(dept);
	}
	
}
