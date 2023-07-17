<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script src="/js/jquery-3.6.4.min.js"></script>
<link rel="stylesheet" href="/css/reset.css">
</head>

<body>
<div id="weather" style="position: fixed; top:2%; right : 2%;">
<img src="https://openweathermap.org/img/w/01d.png">
</div>
<div style="background-color : rgb(101, 178, 255); padding : 40px;color : #fff; height : 220px">
    <div style="float : left;">
        <div class="weather_icon"></div>
    </div><br>

    <div style="float : right; margin : -5px 0px 0px 60px; font-size : 11pt">
            <div class="temp_min"></div>
            <div class="temp_max"></div>
            <div class="humidity"></div>
            <div class="wind"></div>
            <div class="cloud"></div>
    </div>
    <div style="float : right; margin-top : -45px;">
        <div class="current_temp" style="font-size : 50pt"></div>
        <div class="weather_description" style="font-size : 20pt"></div>
        <div class="city" style="font-size : 13pt"></div>
    </div>
</div>

<script>

navigator.geolocation.getCurrentPosition(function(pos) {
    console.log(pos);
    var latitude = pos.coords.latitude;//위도
    var longitude = pos.coords.longitude;//경도
    alert("현재 위치는 : " + latitude + ", "+ longitude);
    var apiURI = "http://api.openweathermap.org/data/2.5/weather?lat="+latitude+"&lon="+longitude+"&appid="+"487c6b16cacfbb98c9f1f5b9790f3b71";
    $.ajax({
        url: apiURI,
        dataType: "json",
        type: "GET",
        async: "false",
        success: function(resp) {
        	var weatherIcon = {
        		    '01' : 'fas fa-sun',
        		    '02' : 'fas fa-cloud-sun',
        		    '03' : 'fas fa-cloud',
        		    '04' : 'fas fa-cloud-meatball',
        		    '09' : 'fas fa-cloud-sun-rain',
        		    '10' : 'fas fa-cloud-showers-heavy',
        		    '11' : 'fas fa-poo-storm',
        		    '13' : 'far fa-snowflake',
        		    '50' : 'fas fa-smog'
        		};
            
            var imgURL = "http://openweathermap.org/img/w/" + resp.weather[0].icon + ".png";
            $("html컴포넌트").attr("src", imgURL);
            var $Icon = (resp.weather[0].icon).substr(0,2);
            var $Icon = (imgURL);
            var $weather_description = resp.weather[0].main;
            var $Temp = Math.floor(resp.main.temp- 273.15) + 'º';
            var $humidity = '습도&nbsp;&nbsp;&nbsp;&nbsp;' + resp.main.humidity+ ' %';
            var $wind = '바람&nbsp;&nbsp;&nbsp;&nbsp;' +resp.wind.speed + ' m/s';
            var $city = resp.name;
            var $cloud = '구름&nbsp;&nbsp;&nbsp;&nbsp;' + resp.clouds.all +"%";
            var $temp_min = '최저 온도&nbsp;&nbsp;&nbsp;&nbsp;' + Math.floor(resp.main.temp_min- 273.15) + 'º';
            var $temp_max = '최고 온도&nbsp;&nbsp;&nbsp;&nbsp;' + Math.floor(resp.main.temp_max- 273.15) + 'º';
            
			
            $('.weather_icon').append('<i class="' + weatherIcon[$Icon] +' fa-5x" style="height : 150px; width : 150px;"></i>');
            $('.weather_description').prepend($weather_description);
            $('.current_temp').prepend($Temp);
            $('.humidity').prepend($humidity);
            $('.wind').prepend($wind);
            $('.city').append($city);
            $('.cloud').append($cloud);
            $('.temp_min').append($temp_min);
            $('.temp_max').append($temp_max);
        }
    });
});
</script>

</body>
</html>