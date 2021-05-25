<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${rootPath}/static/css/home.css?ver2021-05-25-002" rel="stylesheet" />
</head>
</head>
<style>
	
	div.view_btn {
		width: 80%;
		margin: 10px auto;
		text-align: right;
	}
	
	div.view_btn button {
		margin: 5px;
		padding: 8px;
		outline: none;
		border: none;
		color: white;
	}
	
	div.view_btn button:nth-child(1) {
		background-color: blue;
	}
	
	div.view_btn button:nth-child(2) {
		background-color: green;
	}
	
	div.view_btn button:nth-child(3) {
		background-color: red;
	}
	
	div.view_btn button:hover {
		box-shadow: 2px 2px 2px 2px rgba(0, 0, 0, 0.3);
	}
</style>
<script>
	document.addEventListener("DOMContentLoaded", function(ev){
		document.querySelector("div.view_btn").addEventListener("click",function(ev){
			
	let className = ev.target.className
			
			if(className == "btn_home"){
				
				let url = "/todo/"
					document.location.href = url;
				
			} else if (className == "btn_update"){
				
				document.location.href ="${rootPath}/list/update?td_seq="+${TD.td_seq}
				
			} else if (className == "btn_delete"){
				
				if(confirm("방명록을 삭제합니다!")){
					
					document.location.replace( "${rootPath}/list/delete?td_seq="
							+${TD.td_seq} );
				}
			}
		})
	})
</script>

<body>
	<%@ include file="/WEB-INF/views/include_nav.jsp"%>
	<table>
		<tr>
			<th>작성일자</th>
			<th>작성시각</th>
			<th>해야할일</th>
			<th>장소</th>
		</tr>
		<tr>
			<td>${TD.td_date}</td>
			<td>${TD.td_time}</td>
			<td>${TD.td_todo}</td>
			<td>${TD.td_place}</td>
		</tr>
	</table>

	<div class="view_btn">
		<button class="btn_home">처음으로</button>
		<button class="btn_update">수정하기</button>
		<button class="btn_delete">삭제하기</button>
	</div>
</body>
</html>