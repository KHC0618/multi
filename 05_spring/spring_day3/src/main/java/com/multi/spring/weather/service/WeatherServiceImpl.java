package com.multi.spring.weather.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.spring.weather.model.dao.WeatherDAO;
import com.multi.spring.weather.model.dto.WeatherDTO;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    private WeatherDAO weatherDAO;

    @Override
    public void insertWeather(WeatherDTO weather) {
        weatherDAO.insertWeather(weather);
    }

    @Override
    public List<WeatherDTO> selectAllWeather() {
        return weatherDAO.selectAllWeather();
    }
}
