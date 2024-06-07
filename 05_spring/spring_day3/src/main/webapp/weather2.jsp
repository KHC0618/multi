<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Insert title here</title>
<meta
	content='width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no'
	name='viewport'>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.min.js"></script>
    <style>
        #weatherImage {
            width: 100px;
            height: 100px;
        }
        #temperatureImage {
            width: 100px;
            height: 100px;
        }
    </style>
</head>
<body>
    <h1>Weather Information</h1>
    <div>
        <p>Current Weather: <span id="weatherCondition"></span></p>
        <img id="weatherImage" src="" alt="Weather Image">
        <p>Current Temperature: <span id="temperature"></span></p>
        <img id="temperatureImage" src="" alt="Temperature Image">
        <br>
        <button id="insertButton">Insert Weather Data</button>
    </div>
    
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        $(document).ready(function() {
            // Example API endpoint, replace with actual weather API
            const apiEndpoint = 'https://api.openweathermap.org/data/2.5/weather?q=Seoul&appid=';

            $.ajax({
                url: apiEndpoint,
                method: 'GET',
                dataType: 'json',
                success: function(response) {
                    const weatherCondition = response.weather[0].main.toLowerCase();
                    const temperature = response.main.temp;
                    $('#weatherCondition').text(weatherCondition);
                    $('#temperature').text(temperature);

                    let weatherImage = '';
                    if (weatherCondition.includes('clouds')) {
                        weatherImage = 'clouds.jpg';
                    } else if (weatherCondition.includes('rain')) {
                        weatherImage = 'rain.jpg';
                    } else {
                        weatherImage = 'sun.jpg';
                    }

                    if (temperature >= 300) {
                    	temperatureImage = 'hot_weather.jpg';
                    } else if (temperature >= 200) {
                    	temperatureImage = 'normal_weather.jpg';
                    } else {
                    	temperatureImage = 'cold_weather.jpg';
                    }

                    $('#weatherImage').attr('src', '${pageContext.request.contextPath}/resources/img/' + weatherImage);
                    $('#temperatureImage').attr('src', '${pageContext.request.contextPath}/resources/img/' + temperatureImage);
                },
                error: function(error) {
                    console.error('Error fetching weather data:', error);
                }
            });
            
            $('#insertButton').on('click', function() {
            	window.location.href = '${pageContext.request.contextPath}/weather/insert';
            });
            
        });
    </script>
</body>
</html>