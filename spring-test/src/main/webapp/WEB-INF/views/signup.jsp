<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>회원가입</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/bootstrap.css">
<script src="//code.jquery.com/jquery-3.3.1.js"></script>
</head>
<body>
	<h1>회원가입</h1>
	<form method="post" action="<%=request.getContextPath()%>/signup"
		id="form">
		<div class="form-group">
			<input type="text" name="id" id="id" class="form-control" placeholder="아이디">
			<button id="dup" type="button" class="btn btn-outline-primary">중복체크</button>
		</div>
		<div class="form-group">
			<input type="password" name="pw" class="form-control" placeholder="비밀번호">
		</div>
		<div class="form-group">
			<input type="email" name="email" class="form-control" placeholder="이메일">
		</div>
		<div class="form-group">
			<input type="radio" value="male" name="gender" id="male" checked>
			<label for="male">남성</label> <input type="radio" value="female"
				name="gender" id="female"> <label for="female">여성</label>
		</div>
		<button type="button" id="btnOk" class="btn btn-outline-primary">회원가입</button>
	</form>
	<script type="text/javascript">
		var dup = 0;
		$('#dup').click(function() {
			var id = "";
			id = $('#id').val();
			$.ajax({
				async : true,
				type : 'POST',
				data : id,
				url : "/springtest/signup/dup",
				dataType : "json",
				contentType : "application/json; charset=UTF-8",
				success : function(data) {
					if (data.dup) {
						dup = 1;
						alert('이미 사용중인 아이디입니다.');
					} else {
						dup = -1;
						alert('사용 가능한 아이디입니다.');
					}
				}
			});
		})
		$("#btnOk").click(function() {
			if (dup == 0) {
				alert("아이디 중복 체크를 하세요");
				return false;
			}
			if (dup == 1) {
				alert("중복된 아이디입니다. 다른 아이디를 입력하세요.");
				return false;
			}
			$('#form').submit();
			return true;
		})
	</script>
</body>
</html>