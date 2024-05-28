package com.multi.shop.product.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.multi.shop.product.model.dto.AttachmentDTO;
import com.multi.shop.product.model.dto.CompanyDTO;
import com.multi.shop.product.model.dto.ProductDTO;

public class ProductDAO {
	public ProductDAO() {
		
	}
	
	public ArrayList<ProductDTO> selectList(SqlSession sqlSession) throws Exception {
		return (ArrayList) sqlSession.selectList("productMapper.selectList");
	}

	public ProductDTO selectProduct(SqlSession sqlSession, int pno) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("productMapper.selectProduct", pno);
	}

	public ArrayList<CompanyDTO> selectCompanyList(SqlSession sqlSession) {
		// TODO Auto-generated method stub
		return (ArrayList) sqlSession.selectList("productMapper.selectCompanyList");
	}

	public int insertProduct(SqlSession sqlSession, ProductDTO newProduct) {
		// TODO Auto-generated method stub
		return sqlSession.insert("productMapper.insertProduct", newProduct);
	}

	public int insertAttachment(SqlSession sqlSession, AttachmentDTO fileList) {
		// TODO Auto-generated method stub
		
		return sqlSession.insert("productMapper.insertAttachment", fileList);
	}
	
	public int updateProduct(SqlSession sqlSession, ProductDTO updatedProduct) {
		// TODO Auto-generated method stub
		
	    return sqlSession.update("productMapper.updateProduct", updatedProduct);
	}
}
