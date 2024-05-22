<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.BufferedReader, java.io.InputStreamReader, java.net.HttpURLConnection, java.net.URL" %>
<%@ page import="org.json.JSONObject" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Current Weather</title>
    <style>
        .weather {
            border: 1px solid #ddd;
            padding: 10px;
            margin: 10px 0;
            text-align: center;
        }
    </style>
</head>
<body>

<h1>Current Weather</h1>

<%
    // OpenWeatherMap API 키 및 도시 이름 설정
    String apiKey = "0daa9daf7246ebe05361fba71c734e7e";
    String cityName = "Seoul";

    // API 요청 URL
    String apiURL = "http://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&appid=" + apiKey + "&units=metric";

    try {
        URL url = new URL(apiURL);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        int responseCode = con.getResponseCode();
        if (responseCode == 200) { // 정상 호출
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder responseBody = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                responseBody.append(line);
            }
            br.close();

            // JSON 파싱
            JSONObject jsonResponse = new JSONObject(responseBody.toString());
            JSONObject main = jsonResponse.getJSONObject("main");
            JSONObject weather = jsonResponse.getJSONArray("weather").getJSONObject(0);

            // 날씨 정보 출력
            double temperature = main.getDouble("temp"); // 값이 숫자일 경우 getDouble() 사용
            String description = weather.getString("description");
%>
            <div class="weather">
                <h2>Temperature: <%= temperature %>°C</h2>
                <p>Weather: <%= description %></p>
            </div>
<%
        } else { // 오류 발생
            out.println("API 요청 오류: " + responseCode);
        }
    } catch (Exception e) {
        e.printStackTrace();
        out.println("예외 발생: " + e.getMessage());
    }
%>

</body>
</html>