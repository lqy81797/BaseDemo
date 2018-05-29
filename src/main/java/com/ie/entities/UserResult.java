/**
 * 
 */
package com.ie.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * @author lvqingyang
 * @Description: 用户作答实体
 * @date: 2018年5月26日 上午10:33:52 
 */
@Entity
@Table(name = "UserResult", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
public class UserResult implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer userId;
	
	private Integer itemBankId;
	
	private String result;

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
	 * @return result
	 */
	public String getResult() {
		return result;
	}

	/**
	 * @param result 要设置的 result
	 */
	public void setResult(String result) {
		this.result = result;
	}

	/**
	 * @return userId
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @param userId 要设置的 userId
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @return itemBankId
	 */
	public Integer getItemBankId() {
		return itemBankId;
	}

	/**
	 * @param itemBankId 要设置的 itemBankId
	 */
	public void setItemBankId(Integer itemBankId) {
		this.itemBankId = itemBankId;
	}
	
}
