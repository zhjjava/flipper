package edu.mum.hrms.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;


/**
 * The persistent class for the department database table.
 *
 */
@Entity
@Table(name="sys_department")
//@NamedQuery(name="SysDepartment.findAll", query="SELECT e FROM Department e")
public class SysDepartment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="depart_id")
	private long departId;

	@Column(name="create_id")
	private BigInteger createId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_time")
	private Date createTime;

	@Column(name="depart_major")
	private Long departMajor;

	@NotEmpty
	@Column(name="depart_name")
	private String departName;

	@Column(name="depart_num")
	private String departNum;

	@Column(name="depart_status")
	private Integer departStatus;

	@Column(name="update_id")
	private BigInteger updateId;

	@Column(name="is_del")
	private Integer isDel;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_time")
	private Date updateTime;

	@Transient
	private SysUser major;



//	//bi-directional many-to-one association to SysUser
//	@OneToMany(mappedBy="department")
//	private List<SysUser> sysUsers;

	public SysUser getMajor() {
		return major;
	}

	public void setMajor(SysUser major) {
		this.major = major;
	}

	public SysDepartment() {
	}

	public long getDepartId() {
		return this.departId;
	}

	public void setDepartId(long departId) {
		this.departId = departId;
	}

	public BigInteger getCreateId() {
		return this.createId;
	}

	public void setCreateId(BigInteger createId) {
		this.createId = createId;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}



	public long getDepartMajor() {
		return departMajor;
	}

	public void setDepartMajor(long departMajor) {
		this.departMajor = departMajor;
	}

	public String getDepartName() {
		return this.departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName;
	}

	public String getDepartNum() {
		return this.departNum;
	}

	public void setDepartNum(String departNum) {
		this.departNum = departNum;
	}

	public Integer getDepartState() {
		return this.departStatus;
	}

	public void setDepartState(Integer departState) {
		this.departStatus = departState;
	}

	public BigInteger getUpdateId() {
		return this.updateId;
	}

	public void setUpdateId(BigInteger updateId) {
		this.updateId = updateId;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getIsDel() {
		return isDel;
	}

	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}

}