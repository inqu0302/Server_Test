<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	form.v1 {
		width: 60%;
		margin:10px auto;
	}
	
	form.v1 fieldset {
		border:1px solid blue;
		border-radius: 10px;
		padding:5px
	}
	
	/* label과 input 공통 속성을 한번에 지정하기 */
	form.v1 label, form.v1 input form.v1 textarea{
		display: inline-block;
		padding: 5px;
		margin: 10px;
	}
	
	form.v1 label {
		width:150px;
		text-align: right;
	}
	
	form.v1 input {
		width: 300px;
		border: 1px solid green;
		border-radius: 5px;
	}
	
	form.v1 textarea{
		width: 300px;
		border: 1px solid green;
		broder-radius: 5px;
	}
	
	form.v1 button {
		outline: 0;
		border:0;
		width: 100px;
		color:white;
		padding: 5px;
	}
	
	form.v1 button:nth-child(2) {
		background-color: green;
	}
	
	form.v1 button:nth-child(3) {
		background-color: orange;
	}
	
	form.v1 button:nth-child(4) {
		background-color: red;
	}
	
	form.v1 button:hover {
		box-shadow: 2px 2px 2px rgba(0,0,0,0.3);
	}
	
</style>
<script>
	document.addEventListener("DOMContentLoaded", function(){
		
		document.querySelector("button.btn_save")
		.addEventListener("click", function(ev){
			
			let dom = document;
			
			let td_todo = dom.querySelector("input[name='td_todo']");
			let td_date = dom.querySelector("input[name='td_date']");
			let td_time = dom.querySelector("input[name='td_time']");
			let td_place = dom.querySelector("input[name='td_place']");
		
		
		if(td_todo.value == ""){
			alert("해야할일은 반드시 입력해야 합니다");
			
			td_todo.focus();

			return false;
		}
		
		dom.querySelector("form.v1").submit();
		})
		
		document.querySelector("button.btn_home")
		.addEventListener("click", function(ev){
			let url = "/todo/"
			document.location.href = url;
		})
		
	})
</script>
</head>
<body>
	<%@ include file="/WEB-INF/views/include_nav.jsp" %>
	<form class="v1" method="POST">
		<fieldset>
		<legend>할일 작성하기</legend>
		<div>
			<label>해야 할일</label>
			<input name="td_todo" value="${TD.td_todo}">
		</div>
		
		<div>
			<label>작성일자</label>
			<input name="td_date" type="date" value="${TD.td_date}">
		</div>

		<div>
			<label>작성시각</label>
			<input name="td_time" type="time" value="${TD.td_time}">
		</div>
		
		<div>
			<label>장소</label>
			<input name="td_place" value="${TD.td_place}">
		</div>
		<div>
			<label></label>
			<button class="btn_save" type="button">저장</button>
			<button type="reset">다시작성</button>
			<button class="btn_home" type="button">처음으로</button>		
		</div>
		</fieldset>
	</form>

</body>
</html>