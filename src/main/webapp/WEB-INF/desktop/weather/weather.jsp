<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
<meta charset=UTF-8">
<title>weather.jsp</title>
</head>
<body>
<hr>
<h1>날씨 정보 조회 결과</h1>
<hr>
	low[0] : ${requestScope.weather.forecasts[0].low} <br>
	high[0] : ${requestScope.weather.forecasts[0].high} <br>
	skycodeday[0] : ${requestScope.weather.forecasts[0].skycodeday} <br>
	skytextday[0] : ${requestScope.weather.forecasts[0].skytextday} <br>
	date[0] : ${requestScope.weather.forecasts[0].date} <br>
	day[0] : ${requestScope.weather.forecasts[0].day} <br>
	shortday[0] : ${requestScope.weather.forecasts[0].shortday} <br>
	precip[0] : ${requestScope.weather.forecasts[0].precip}<br>
<%-- <c:forEach var="w" items="${requestScope.weather}" varStatus="status"> --%>
<%-- 	${pageScope.w.forecasts[status.index].low} --%>
<%-- </c:forEach> --%>
	 
<hr>
	
</body>
</html>