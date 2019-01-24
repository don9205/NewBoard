<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/bootstrap.css">
</head>
<body>
	<%-- 	<table class="table table-bordered">
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>내용</td>
			<td>작성자</td>
			<td>작성일</td>
		</tr>
		<c:forEach items="${board}" var="board">
			<tr>
				<td>${board.id}</td>
				<td>${board.title}</td>
				<td>${board.content}</td>
				<td>${board.writer}</td>
				<td>${board.registered_date}</td>
			</tr>
		</c:forEach>
	</table> --%>

	<div class="form-group">
		<label for="title">제목:</label> <input type="text" class="form-control"
			id="title" name="title" readonly value="${board.title}">
	</div>
	<div class="form-group">
		<label for="writer">작성자:</label> <input type="text"
			class="form-control" id="writer" name="writer" readonly
			value="${board.writer}">
	</div>
	<div class="form-group">
		<label for="content">내용:</label>
		<textarea class="form-control" id="content" name="content" readonly>${board.content}</textarea>
	</div>

	<a href="<%=request.getContextPath()%>/bbs/list">
		<button class="btn btn-primary">목록으로 돌아가기</button>
	</a>
	<c:if test="${user.id == board.writer}">
		<a href="<%= request.getContextPath()%>/bbs/delete?id=${board.id}">
			<button class="btn btn-primary">글 삭제하기</button>
		</a>
	</c:if>
	<c:if test="${user.id == board.writer}">
		<a href="<%= request.getContextPath()%>/bbs/update?id=${board.id}">
			<button class="btn btn-primary">글 수정하기</button>
		</a>
	</c:if>
</body>
</html>