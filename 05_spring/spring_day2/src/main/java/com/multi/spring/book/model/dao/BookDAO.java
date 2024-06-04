package com.multi.spring.book.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.multi.spring.book.model.dto.BookDTO;

@Repository
public class BookDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;

	public List<BookDTO> list() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("bookMapper.selectList");
	}

	public BookDTO one(String id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("bookMapper.selectOne", id);
	}

	public int insert(BookDTO book) {
		// TODO Auto-generated method stub
		return sqlSession.insert("bookMapper.insert", book);
	}

	public int delete(String id) {
		// TODO Auto-generated method stub
		return sqlSession.delete("bookMapper.delete", id);
	}
}
