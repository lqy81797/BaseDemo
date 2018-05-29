/**
 * 
 */
package com.ie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ie.entities.ItemBank;

/**
 * @author lvqingyang
 * @Description: 该类的功能描述
 * @date: 2018年5月28日 下午6:09:46 
 */
public interface ItemBankRepository extends JpaRepository<ItemBank, String>, JpaSpecificationExecutor<ItemBank> {

}
