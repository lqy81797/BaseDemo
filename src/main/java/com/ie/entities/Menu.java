/**
 * 
 */
package com.ie.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
/**
 * @author lvqingyang
 * @Description: 系统菜单实体
 * @date: 2018年5月26日 下午3:57:40 
 */
@Entity
@DynamicInsert(true)
@DynamicUpdate(true)
@Table(name="Menu", schema = "")
public class Menu {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;//主键
	
	private String name;//菜单名称
	
	private String url;//菜单地址
	
	private String parentId;//父级id
	
	private Integer seq;//菜单排序
	
	private Integer viewtype;//菜单权限

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
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name 要设置的 name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url 要设置的 url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return parentId
	 */
	public String getParentId() {
		return parentId;
	}

	/**
	 * @param parentId 要设置的 parentId
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	/**
	 * @return seq
	 */
	public Integer getSeq() {
		return seq;
	}

	/**
	 * @param seq 要设置的 seq
	 */
	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	/**
	 * @return viewtype
	 */
	public Integer getViewtype() {
		return viewtype;
	}

	/**
	 * @param viewtype 要设置的 viewtype
	 */
	public void setViewtype(Integer viewtype) {
		this.viewtype = viewtype;
	}
	
}
