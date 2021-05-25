<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${rootPath}/static/css/home.css"  rel="stylesheet" />
</head>
<style>
	

	table tr:hover {
		cursor: pointer;
		background-color: #ddd;
	}
	
	button {
		outline: 0;
		border:0;
		width: 100px;
		color:white;
		padding: 5px;
		background-color: blue;
	}
	
	button:hover {
		box-shadow: 2px 2px 2px rgba(0,0,0,0.3);
	}
	
</style>
<script>
	document.addEventListener("DOMContentLoaded",function(){
		document.querySelector("table")
		.addEventListener("click",function(ev){
			
			let tag_name = ev.target.tagName;
			if(tag_name == "TD") {
				let td_seq = ev.target.closest("TR").dataset.seq
				
				document.location.href ="${rootPath}/list/view?td_seq=" + td_seq
			}
		}) 
		
		document.querySelector("button")
		.addEventListener("click", function(ev){
			
			document.location.href = "${rootPath}/list/insert"
			
		})
	})
</script>

<body>
	<%@ include file="/WEB-INF/views/include_nav.jsp" %>
	<table id="tdList"> 
		<tr>
			<th>글번호</th>
			<th>해야할일</th>
			<th>작성일자</th>
			<th>작성시간</th>
			<th>장소</th>      
		<tr>
		<c:forEach items="${TDLIST}" var="TD" varStatus="status">
			<tr data-seq="${TD.td_seq}">
				<td>${status.count}</td>
				<td>${TD.td_todo}</td>
				<td>${TD.td_date}</td>
				<td>${TD.td_time}</td>
				<td>${TD.td_place}</td>
			</tr>				
		</c:forEach>
	</table>
	<button >작성하기</button>
</body>
</html>