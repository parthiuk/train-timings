<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>

<title> Train Schedule @ Great Portland Street Underground Station</title>
<link href="/bootstrap.min.css" rel="stylesheet">
    <script src="/jquery-2.2.1.min.js"></script>
    <script src="/bootstrap.min.js"></script>
    
</head>
<body>
<%
response.setIntHeader("Refresh", 10);
%>
<H1>Great Portland Street Underground Station</H1>

<H3>Westbound - Platform 1</H3>
	<table>
		<tr bgcolor="#6c7ae0"> 
		<th width="40%">DestinationName</th>
		<th width="30%">Towards</th>
		<th width="30%">ArrivalTime(Expt.)</th> </tr>
		<c:forEach var="schedule" items="${p1schedules}" varStatus="i">
			${((i.index % 2) == 0) ? '<tr bgcolor="#b8d1f3">' : '<tr bgcolor="#dae5f4">'}
				<td>${schedule.destinationName}</td>
				<td>${schedule.towards}</td>
				<td><fmt:formatDate type = "time" value = "${schedule.expectedArrivalTime}"/></td>
			</tr>
	    </c:forEach>
	</table>

<H3>Eastbound - Platform 2</H3>
	<table>
		<tr bgcolor="#6c7ae0"> 
		<th width="40%">DestinationName</th>
		<th width="30%">Towards</th>
		<th width="30%">ArrivalTime(Expt.)</th> </tr>
		<c:forEach var="schedule" items="${p2schedules}" varStatus="i">
			${((i.index % 2) == 0) ? '<tr bgcolor="#b8d1f3">' : '<tr bgcolor="#dae5f4">'}
				<td>${schedule.destinationName}</td>
				<td>${schedule.towards}</td>
				<td><fmt:formatDate type = "time" value = "${schedule.expectedArrivalTime}"/></td>
			</tr>
	    </c:forEach>
	</table>

</body>

</html>