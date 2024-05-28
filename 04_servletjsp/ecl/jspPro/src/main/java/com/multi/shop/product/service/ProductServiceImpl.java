package com.multi.shop.product.service;

import static com.multi.shop.common.Template.getSqlSession;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.multi.shop.product.model.dao.ProductDAO;
import com.multi.shop.product.model.dto.AttachmentDTO;
import com.multi.shop.product.model.dto.CompanyDTO;
import com.multi.shop.product.model.dto.ProductDTO;

public class ProductServiceImpl implements ProductService {
	private ProductDAO productDAO = new ProductDAO();

	@Override
	public ArrayList<ProductDTO> selectList() throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlSession = getSqlSession();
		
		ArrayList<ProductDTO> list = productDAO.selectList(sqlSession);
		sqlSession.close();
		
		return list;
	}
	
	@Override
	public ArrayList<ProductDTO> selectList(String search) throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlSession = getSqlSession();
		
		ArrayList<ProductDTO> list = productDAO.selectList(sqlSession, search);
		sqlSession.close();

		return list;
	}

	@Override
	public ProductDTO selectProduct(int pno) throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlSession = getSqlSession();
		
        ProductDTO product = productDAO.selectProduct(sqlSession, pno);
        sqlSession.close();
        
        return product;
	}

	@Override
	public ArrayList<CompanyDTO> selectCompanyList() throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlSession = getSqlSession();
		
		ArrayList<CompanyDTO> list = productDAO.selectCompanyList(sqlSession);
		sqlSession.close();
		
		return list;
	}

	@Override
	public int insertProduct(ProductDTO newProduct) throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlSession = getSqlSession();
		int result = 0;
		int productResult = productDAO.insertProduct(sqlSession, newProduct);
		
		List<AttachmentDTO> fileList = newProduct.getAttachments();
		
		int productId = newProduct.getId();
		
		int attachmentResult = 0;
		
		for(int i = 0; i < fileList.size(); i++) {
			fileList.get(i).setRefProductNo(productId);
			attachmentResult += productDAO.insertAttachment(sqlSession, fileList.get(i));
		}
		
		/* 모든 결과가 성공이면 트랜젝션을 완료한다. */
		if(productResult > 0 && attachmentResult == fileList.size()) {
			sqlSession.commit();
			result = 1;
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}
	
	@Override
	public int updateProduct(ProductDTO updatedProduct) throws Exception {
	    SqlSession sqlSession = getSqlSession();
	    int result = 0;
	    
	    int productResult = productDAO.updateProduct(sqlSession, updatedProduct);
	    
	    List<AttachmentDTO> fileList = updatedProduct.getAttachments();
	    int productId = updatedProduct.getId();
	    
	    int attachmentResult = 0;
	    for (AttachmentDTO file : fileList) {
	        file.setRefProductNo(productId);
	        attachmentResult += productDAO.insertAttachment(sqlSession, file);
	    }

	    if (productResult > 0 && attachmentResult == fileList.size()) {
	        sqlSession.commit();
	        result = 1;
	    } else {
	        sqlSession.rollback();
	    }
	    
	    sqlSession.close();
	    return result;
	}

}
