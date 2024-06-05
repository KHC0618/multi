package com.multi.spring.page.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.spring.page.model.dao.BbsDAO;
import com.multi.spring.page.model.dto.BbsDTO;
import com.multi.spring.page.model.dto.PageDTO;

@Service
public class BbsServiceImpl implements BbsService {

	@Autowired
	BbsDAO bbsDAO;
	
	@Autowired
	SqlSessionTemplate sqlSession;
	
	@Override
	public List<BbsDTO> selectAll(PageDTO pageDTO) {
		// TODO Auto-generated method stub
		return bbsDAO.selectAll(sqlSession, pageDTO);
	}

	@Override
	public int selectCount() {
		// TODO Auto-generated method stub
		return bbsDAO.selectCount(sqlSession);
	}


}
