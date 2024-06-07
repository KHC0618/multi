package com.multi.spring.weather.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.multi.spring.weather.model.dto.WeatherDTO;
import com.multi.spring.weather.service.WeatherService;

@Controller
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/insert")
    public String insertForm() {
        return "weather_insert";
    }

    @PostMapping("/insert")
    public String insertWeather(Model model) throws Exception {
    	
        String apiEndpoint = "https://api.openweathermap.org/data/2.5/weather?q=Seoul&appid=0daa9daf7246ebe05361fba71c734e7e";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(apiEndpoint, String.class);
        
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode root = objectMapper.readTree(response);
        WeatherDTO weather = new WeatherDTO();
        weather.setTemperature(root.path("main").path("temp").floatValue());
        weather.setWeatherCondition(root.path("weather").get(0).path("main").textValue());
        weather.setHumidity(root.path("main").path("humidity").intValue());

        // 데이터베이스에 WeatherDTO 객체 삽입
        weatherService.insertWeather(weather);

        model.addAttribute("response", response);
        
        return "weather_insert";
    }

    @GetMapping("/list")
    public String listWeather(Model model) {
        List<WeatherDTO> weatherList = weatherService.selectAllWeather();
        model.addAttribute("weatherList", weatherList);
        return "weather_list";
    }
}