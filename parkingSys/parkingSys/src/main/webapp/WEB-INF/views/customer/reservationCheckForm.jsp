<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
   request.setCharacterEncoding("UTF-8");
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약 조회</title>
<c:choose>
	<c:when test="${result=='loginFailed' }">
	  <script>
	    window.onload=function(){
	      alert("아이디나 비밀번호가 틀립니다.다시 로그인 하세요!");
	    }
	  </script>
	</c:when>
</c:choose>  
</head>
<body>
<form name="reservation" method="post"  action="${contextPath}/customer/checkin.do">
		<center>
			<h3>예약 조회</h3>
		</center>
		<table align=center>
			<tr>
				<th>차량번호</th>
				<td><input type="text" name="carNum" placeholder="예) 00가 0000"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>
				<input type="password" name="pwd" placeholder="예)4자리(숫자, 문자 가능)">
				</td>
			</tr>
		</table>
		<center>
			<input type="submit" value="예약조회" >
		</center>
</body>
</html>