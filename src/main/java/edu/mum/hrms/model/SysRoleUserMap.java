package edu.mum.hrms.model;

// Generated 2015-6-21 18:21:45 by Hibernate Tools 3.2.4.GA

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * SysRoleUserMap generated by hbm2java
 */
@Entity
@Table(name = "sys_role_user_map")
public class SysRoleUserMap implements java.io.Serializable {

	private long id;

	private SysUser sysUser;

	private SysRole sysRole;

	public SysRoleUserMap() {
	}

	public SysRoleUserMap(long id) {
		this.id = id;
	}

	public SysRoleUserMap(long id, SysUser sysUser, SysRole sysRole) {
		this.id = id;
		this.sysUser = sysUser;
		this.sysRole = sysRole;
	}

	
	@Id
	@Column(name = "ID", unique = true)
//	@SequenceGenerator(name = "SEQ_SYS_ROLE_USER_MAP", sequenceName = "SEQ_SYS_ROLE_USER_MAP",allocationSize = 1)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SYS_ROLE_USER_MAP")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_ID")
	public SysUser getSysUser() {
		return this.sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ROLE_ID")
	public SysRole getSysRole() {
		return this.sysRole;
	}

	public void setSysRole(SysRole sysRole) {
		this.sysRole = sysRole;
	}

}
