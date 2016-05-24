package edu.mum.hrms.model;

// Generated 2015-6-25 10:57:41 by Hibernate Tools 3.2.4.GA

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import edu.mum.hrms.util.AppConstants;

/**
 * SysCode generated by hbm2java
 */
@Entity
@Table(name = "sys_locale")
public class SysLocale implements java.io.Serializable {

	private String localeCode;
	
	private String localeName;

	private Integer status = AppConstants.STATUS_VALID_1;
	
	private Integer seq;

	public SysLocale() {
	}

	public SysLocale(String localeCode) {
		this.localeCode = localeCode;
	}

	@Id
	@Column(name = "LOCALE_CODE", unique = true)
	public String getLocaleCode() {
		return localeCode;
	}

	/**
	 * @param localeCode localeCode 设定。
	 */
	public void setLocaleCode(String localeCode) {
		this.localeCode = localeCode;
	}

	/**
	 * @return localeName 取值。
	 */
	@Column(name = "LOCALE_NAME")
	public String getLocaleName() {
		return localeName;
	}

	/**
	 * @param localeName localeName 设定。
	 */
	public void setLocaleName(String localeName) {
		this.localeName = localeName;
	}

	@Column(name = "STATUS")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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
}