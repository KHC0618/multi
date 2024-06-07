package com.multi.spring.weather.service;

import java.util.List;

import com.multi.spring.weather.model.dto.WeatherDTO;

public interface WeatherService {
	
    void insertWeather(WeatherDTO weather);
    
    List<WeatherDTO> selectAllWeather();
    
}
