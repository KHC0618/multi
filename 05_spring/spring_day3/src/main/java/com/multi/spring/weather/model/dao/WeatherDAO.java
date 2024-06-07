package com.multi.spring.weather.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.multi.spring.weather.model.dto.WeatherDTO;

@Repository
public class WeatherDAO {

    @Autowired
    private SqlSession sqlSession;

    public void insertWeather(WeatherDTO weatherDTO) {
        sqlSession.insert("weatherMapper.insertWeather", weatherDTO);
    }

    public List<WeatherDTO> selectAllWeather() {
        return sqlSession.selectList("weatherMapper.selectAllWeather");
    }
}
