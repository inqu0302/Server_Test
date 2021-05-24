<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table id="tdList"> 
		<tr>
			<th>글번호</th>
			<th>해야할일</th>
			<th>작성일자</th>
			<th>작성시간</th>
			<th>장소</th> 
		<tr>
		<c:forEach items="${TDLIST}" var="TD" varStatus="status">
			<tr>
				<td>${status.count}</td>
				<td>${TD.td_todo}</td>
				<td>${TD.td_date}</td>
				<td>${TD.td_time}</td>
				<td>${TD.td_place}</td>
			</tr>				
		</c:forEach>
	</table>
	<form>
	<button>작성하기</button>
	</form>
</body>
</html>