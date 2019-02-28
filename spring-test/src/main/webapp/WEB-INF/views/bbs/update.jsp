<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게 시 물 수 정</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/bootstrap.css">
</head>
<body>
	<h1>게 시 글 수정</h1>
	<form action="<%=request.getContextPath()%>/bbs/update" method="post">
		<input type="hidden" value="${board.id}" name="id">
		<div class="form-group">
			<label for="title">제목:</label> <input type="text"
				class="form-control" id="title" name="title" value="${board.title}">
		</div>
		<div class="form-group">
			<label for="writer">작성자:</label> <input type="text"
				class="form-control" id="writer" name="writer" value="${board.writer}"
				readonly>
		</div>
		<div class="form-group">
			<label for="content">내용:</label>
			<textarea class="form-control" id="content" name="content">${board.content}</textarea>
		</div>
		<a href="<%= request.getContextPath()%>/bbs/list">
			<button class="btn btn-primary">게시글로 돌아가기</button>
		</a>
		<button class="btn btn-outline-primary">수 정</button>

	</form>


</body>
</html>