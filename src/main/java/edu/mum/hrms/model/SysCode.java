package edu.mum.hrms.model;

// Generated 2015-6-25 10:57:41 by Hibernate Tools 3.2.4.GA

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
 * SysCode generated by hbm2java
 */
@Entity
@Table(name = "sys_code")
public class SysCode implements java.io.Serializable {

	private long sysCodeId;

	private SysCodeCategory sysCodeCategory;

	private SysLocale sysLocale;

	private String theKey;

	private String theValue;

	private Integer seq;

	private int status;

	public SysCode() {
	}
	public SysCode(long sysCodeId) {
		this.sysCodeId= sysCodeId;
	}

	@Id
	@Column(name = "SYS_CODE_ID", unique = true)
//	@SequenceGenerator(name = "SEQ_SYS_CODE", sequenceName = "SEQ_SYS_CODE" ,allocationSize = 1)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SYS_CODE")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getSysCodeId() {
		return this.sysCodeId;
	}

	public void setSysCodeId(long sysCodeId) {
		this.sysCodeId = sysCodeId;
	}

	/**
	 * @return sysCodeCategory 取值。
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CATEGORY_ID")
	public SysCodeCategory getSysCodeCategory() {
		return sysCodeCategory;
	}

	/**
	 * @param sysCodeCategory sysCodeCategory 设定。
	 */
	public void setSysCodeCategory(SysCodeCategory sysCodeCategory) {
		this.sysCodeCategory = sysCodeCategory;
	}

	/**
	 * @return sysLocale 取值。
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "LOCALE_CODE")
	public SysLocale getSysLocale() {
		return sysLocale;
	}

	/**
	 * @param sysLocale sysLocale 设定。
	 */
	public void setSysLocale(SysLocale sysLocale) {
		this.sysLocale = sysLocale;
	}

	/**
	 * @return theKey 取值。
	 */
	@Column(name = "THE_KEY")
	public String getTheKey() {
		return theKey;
	}

	/**
	 * @param theKey theKey 设定。
	 */
	public void setTheKey(String theKey) {
		this.theKey = theKey;
	}

	/**
	 * @return theValue 取值。
	 */
	@Column(name = "THE_VALUE")
	public String getTheValue() {
		return theValue;
	}

	/**
	 * @param theValue theValue 设定。
	 */
	public void setTheValue(String theValue) {
		this.theValue = theValue;
	}

	/**
	 * @return seq 取值。
	 */
	@Column(name = "SEQ")
	public Integer getSeq() {
		return seq;
	}

	/**
	 * @param seq seq 设定。
	 */
	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	@Column(name = "STATUS")
	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
