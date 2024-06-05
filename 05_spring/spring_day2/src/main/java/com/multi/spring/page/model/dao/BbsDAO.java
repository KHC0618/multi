package com.multi.spring.page.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.multi.spring.page.model.dto.BbsDTO;
import com.multi.spring.page.model.dto.PageDTO;

@Repository
public class BbsDAO {

	public List<BbsDTO> selectAll(SqlSessionTemplate sqlSession, PageDTO pageDTO) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("bbsMapper.selectAll", pageDTO);
	}

	public int selectCount(SqlSessionTemplate sqlSession) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("bbsMapper.selectCount");	
	}

}
