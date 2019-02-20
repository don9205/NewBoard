<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>자료 입력처리</h1>
<form method="post">
  <p>아이디 : <input type="text" name="id" /></p>
  <p>비밀번호 : <input type="password" name="pwd" /></p>
  <p><input type="submit" value="입력" /></p>
</form>
<p>가입한 아이디는 : ${id}</p>
<p>가입한 비밀번호는 : ${pwd}</p>
<hr/>
<p><a href="<%=request.getContextPath() %>/list">전체리스트</a></p>
<p><a href="<%=request.getContextPath() %>/search">개별자료검색</a></p>
<p><a href="<%=request.getContextPath() %>/update">수정하기</a></p>
<p><a href="<%=request.getContextPath() %>/delete">삭제하기</a></p>
</body>
</html>









