package com.multi.shop.product.service;

import java.util.ArrayList;

import com.multi.shop.product.model.dto.CompanyDTO;
import com.multi.shop.product.model.dto.ProductDTO;

public interface ProductService {
	ArrayList<ProductDTO> selectList() throws Exception ;
	
	ArrayList<ProductDTO> selectList(String search) throws Exception ;

	ProductDTO selectProduct(int pno) throws Exception ;

	ArrayList<CompanyDTO> selectCompanyList() throws Exception ;

	int insertProduct(ProductDTO newProduct) throws Exception ;
	
	int updateProduct(ProductDTO updatedProduct) throws Exception ;
}
