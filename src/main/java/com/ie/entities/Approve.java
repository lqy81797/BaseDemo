/**
 * 
 */
package com.ie.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * @author lvqingyang
 * @Description: 考试审批实体类
 * @date: 2018年5月25日 上午11:10:24 
 */
@Entity
@DynamicInsert(true)
@DynamicUpdate(true)
@Table(name="Approve", schema = "")
public class Approve implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String subject;//申请科目
	
	private String remark;
	
	private int status;
	
	private String userId;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createTime;

	/**
	 * @return id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id 要设置的 id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return subject
	 */
	public String getSubject() {
		return subject;
	}
	/**
	 * @param subject 要设置的 subject
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	/**
	 * @return remark
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * @param remark 要设置的 remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * @return status
	 */
	public int getStatus() {
		return status;
	}
	/**
	 * @param status 要设置的 status
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	/**
	 * @return userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId 要设置的 userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * @param createTime 要设置的 createTime
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
