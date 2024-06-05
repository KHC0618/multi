package com.multi.spring.file.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.spring.file.model.dao.FileDAO;
import com.multi.spring.file.model.dto.MovieDTO;

@Service
public class FileServiceImpl implements FileService {
	
	@Autowired
	private FileDAO fileDAO;
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public void insertMovie(MovieDTO movieDTO) throws Exception {
		// TODO Auto-generated method stub
		int result = fileDAO.insertMovie(sqlSession, movieDTO);
		
		if (result < 0) {
			throw new Exception("등록에 실패하였습니다.");
		}
	}

}
