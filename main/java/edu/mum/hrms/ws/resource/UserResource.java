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
import edu.mum.hrms.ws.model.SimpleSysUser;
import edu.mum.hrms.ws.service.SysUserWSService;

@Component
@Path("/users")
public class UserResource {
	
	@Autowired
	private SysUserWSService sysUserWSService; 
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<SimpleSysUser> getAllUsers() throws AppException{
		return sysUserWSService.getAllUsers();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public SimpleSysUser getUser(@PathParam("id") long id) throws AppException{
		return sysUserWSService.findUserById(id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void addUser(SimpleSysUser user) throws AppException{
		sysUserWSService.addUser(user);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateUser(SimpleSysUser user) throws AppException{
		sysUserWSService.updateUser(user);
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteUser(SimpleSysUser user) throws AppException{
		sysUserWSService.deleteUser(user);
	}
}
