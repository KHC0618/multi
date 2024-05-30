package com.multi.section02.mapperscan.model.dao;

import java.util.List;

import com.multi.section02.mapperscan.model.dto.ProductDTO;

public interface ProductDAO {

	// DAO interface 이름이 mapper.xml의 namespace와 일치, method 이름이 query의 ID와 동일
	List<ProductDTO> selectProductList();

}
