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
 * @Description: 题库实体类
 * @date: 2018年5月25日 上午11:28:34 
 */
@Entity
@DynamicInsert(true)
@DynamicUpdate(true)
@Table(name = "ItemBank", schema = "")
public class ItemBank implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String question;
	
	private String optionA;
	
	private String optionB;
	
	private String optionC;
	
	private String optionD;
	
	private String answer;
	
	private String createUser;
	
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
	 * @return question
	 */
	public String getQuestion() {
		return question;
	}

	/**
	 * @param question 要设置的 question
	 */
	public void setQuestion(String question) {
		this.question = question;
	}

	/**
	 * @return optionA
	 */
	public String getOptionA() {
		return optionA;
	}

	/**
	 * @param optionA 要设置的 optionA
	 */
	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}

	/**
	 * @return optionB
	 */
	public String getOptionB() {
		return optionB;
	}

	/**
	 * @param optionB 要设置的 optionB
	 */
	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}

	/**
	 * @return optionC
	 */
	public String getOptionC() {
		return optionC;
	}

	/**
	 * @param optionC 要设置的 optionC
	 */
	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}

	/**
	 * @return optionD
	 */
	public String getOptionD() {
		return optionD;
	}

	/**
	 * @param optionD 要设置的 optionD
	 */
	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}

	/**
	 * @return answer
	 */
	public String getAnswer() {
		return answer;
	}

	/**
	 * @param answer 要设置的 answer
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	/**
	 * @return createUser
	 */
	public String getCreateUser() {
		return createUser;
	}

	/**
	 * @param createUser 要设置的 createUser
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
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
