package edu.mum.hrms.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ArrayUtils;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;


/**
 * The persistent class for the sys_user database table.
 * 
 */
@Entity
@Table(name="sys_user")
@NamedQuery(name="SysUser.findAll", query="SELECT s FROM SysUser s")
public class SysUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="USER_ID")
	private long userId;

	@Column(name="BANK_ACCOUNT")
	private String bankAccount;

	@Column(name="BANK_NAME")
	private String bankName;


	//@Column(name="BIRTH_DATE")
	//private Date birthDate;
	
	@DateTimeFormat(pattern="yyyy-MM-dd") 
	@Temporal(TemporalType.DATE)
	@Column(name="BIRTH_DATE")
	private Date birthDate;

	@Column(name="CELL_PHONE")
	private String cellPhone;

	@Column(name="CREATE_ID")
	private BigInteger createId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATE_TIME")
	private Date createTime;

	@Column(name="EDU_DEGREE")
	private String eduDegree;

	@Column(name="EDU_MAJOR")
	private String eduMajor;

	@Column(name="EDU_SCHOOL")
	private String eduSchool;

	@Column(name="EMP_STATUS")
	private Integer empStatus;

	
	
	@Column(name="ENTRY_DATE")
	@DateTimeFormat(pattern="yyyy-MM-dd")
//	@NotEmpty
	private Date entryDate;

	@Column(name="FIRST_NAME")
	private String firstName;

	private String gender;

	@Column(name="HOME_ADDR")
	private String homeAddr;

	@Column(name="ID_NUMBER")
	private String idNumber;

	@Column(name="LAST_NAME")
	private String lastName;

	@Column(name="LOGIN_NAME")
	@NotEmpty
	private String loginName;

	private String notes;
	
    //@Size(min=3,max=60, message="{password.length.range}")
	private String password;

	@Transient
	private String verifyPassword;

	@Column(name="PERSONAL_EMAIL")
	@NotEmpty
	@Pattern(regexp="^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$", message="{email.format}")
	private String personalEmail;

	@Column(name="POSITION_ID")
	private BigInteger positionId;

	//@Temporal(TemporalType.DATE)
	//@Column(name="QUIT_DATE")
	//private Date quitDate;

	@Column(name="QUIT_DATE")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date quitDate;
	
	private Integer seq;

	private String sid;

	private Integer status;

	@Column(name="SUPERIOR_USER_ID")
	private BigInteger superiorUserId;

	@Column(name="UPDATE_ID")
	private BigInteger updateId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="UPDATE_TIME")
	private Date updateTime;

	@Column(name="USER_TYPE")
	private String userType;

	//bi-directional many-to-one association to Department
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="DEPART_ID")
	private SysDepartment department;
	
	@OneToOne(fetch=FetchType.EAGER,  cascade = CascadeType.ALL) 
 	@JoinColumn(name="memberId") 
 	UserCredentials userCredentials;
	
	@Transient
	private List<SysRole> roleList;
	@Transient
	private List<String> operationItemList;	
	
	public SysUser() {
	}
	

	public long getUserId() {
		return this.userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getBankAccount() {
		return this.bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getBankName() {
		return this.bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getCellPhone() {
		return this.cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
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

	public String getEduDegree() {
		return this.eduDegree;
	}

	public void setEduDegree(String eduDegree) {
		this.eduDegree = eduDegree;
	}

	public String getEduMajor() {
		return this.eduMajor;
	}

	public void setEduMajor(String eduMajor) {
		this.eduMajor = eduMajor;
	}

	public String getEduSchool() {
		return this.eduSchool;
	}

	public void setEduSchool(String eduSchool) {
		this.eduSchool = eduSchool;
	}

	public Integer getEmpStatus() {
		return this.empStatus;
	}

	public void setEmpStatus(Integer empStatus) {
		this.empStatus = empStatus;
	}

	public Date getEntryDate() {
		return this.entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHomeAddr() {
		return this.homeAddr;
	}

	public void setHomeAddr(String homeAddr) {
		this.homeAddr = homeAddr;
	}

	public String getIdNumber() {
		return this.idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPersonalEmail() {
		return this.personalEmail;
	}

	public void setPersonalEmail(String personalEmail) {
		this.personalEmail = personalEmail;
	}

	public BigInteger getPositionId() {
		return this.positionId;
	}

	public void setPositionId(BigInteger positionId) {
		this.positionId = positionId;
	}

	public Date getQuitDate() {
		return this.quitDate;
	}

	public void setQuitDate(Date quitDate) {
		this.quitDate = quitDate;
	}

	public Integer getSeq() {
		return this.seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public String getSid() {
		return this.sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public BigInteger getSuperiorUserId() {
		return this.superiorUserId;
	}

	public void setSuperiorUserId(BigInteger superiorUserId) {
		this.superiorUserId = superiorUserId;
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

	public String getUserType() {
		return this.userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public SysDepartment getDepartment() {
		return this.department;
	}

	public void setDepartment(SysDepartment department) {
		this.department = department;
	}

	
	public UserCredentials getUserCredentials() {
		return userCredentials;
	}


	public void setUserCredentials(UserCredentials userCredentials) {
		this.userCredentials = userCredentials;
	}


	@Transient
	public String getUserName() {
		return this.lastName +","+ this.firstName;
	}
	
	@Transient
	public List<SysRole> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<SysRole> roleList) {
		this.roleList = roleList;
	}

	@Transient
	public List<String> getOperationItemList() {
		return operationItemList;
	}

	public void setOperationItemList(List<String> operationItemList) {
		this.operationItemList = operationItemList;
	}	
	
	//if the current use has a sys role with the roleId
	@Transient
	public boolean isSpecifiedRole(Long roleId){
		try {
			if(roleId==null){
				return false;
			}
			if(getRoleList()==null){
				return false;
			}
			for(SysRole sysRole : getRoleList()){
				if(sysRole.getRoleId()==roleId){
					return true;
				}
			}
		}
		catch (Exception e) {
			// TODO 
			e.printStackTrace();
			return false;
		}
		return false;
	}
	
	@Transient
	public boolean isOwnPrivilege(String ... operationCodes){
		if(ArrayUtils.isEmpty(operationCodes)){
			return false;
		}
		if(CollectionUtils.isEmpty(getOperationItemList())){
			return false;
		}
		for(String opCode : operationCodes){
            if(getOperationItemList().contains(opCode)){
            	return true;
            }
		}
		return false;
	}
	
	public String getVerifyPassword() {
		return verifyPassword;
	}


	public void setVerifyPassword(String verifyPassword) {
		this.verifyPassword = verifyPassword;
	}

}