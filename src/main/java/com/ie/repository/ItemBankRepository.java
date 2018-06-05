/**
 * 
 */
package com.ie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.ie.entities.ItemBank;
import com.ie.entities.Menu;

/**
 * @author lvqingyang
 * @Description: 该类的功能描述
 * @date: 2018年5月28日 下午6:09:46 
 */
public interface ItemBankRepository extends JpaRepository<ItemBank, Integer>, JpaSpecificationExecutor<ItemBank> {
	@Query(value="from ItemBank i where question like ?1")
	public List<ItemBank> searchItem(String str);

}
