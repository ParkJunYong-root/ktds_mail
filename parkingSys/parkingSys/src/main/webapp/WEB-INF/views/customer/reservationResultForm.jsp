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
<style>
	table,tr,td{
		border: solid 1px black;
		border-collapse: collapse;;
	}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>"[${customer.carNum}]" 차량 주차장 예약 내역</h1>
<table border="1"  align="center" >
    <tr align="center"   bgcolor="lightgreen">
      <td ><b>예약번호</b></td>
      <td><b>주차장</b></td>
      <td><b>입차일시</b></td>
      <td><b>출차일시</b></td>
      <td><b>차량종류</b></td>
      <td><b>차량번호</b></td>
      <td><b>핸드폰번호</b></td>
      <td><b>이메일</b></td>
      <td><b>예약날짜</b></td>
   </tr>
  
   <tr align="center">
      <td>${customer.bookNum}</td>
      <td>${customer.park}</td>
      <td>${customer.entryDate}</td>
      <td>${customer.exitDate}</td>
      <td>${customer.carType}</td>
      <td>${customer.carNum}</td>
      <td>${customer.cellNum}</td>
      <td>${customer.email}</td>
      <td>${customer.joinDate}</td>
    </tr>
  
</table>
<br/>
	<button><a href="${contextPath}/customer/reservationCheckForm.do">예약수정</a></button>
		ㅣ
	<button><a href="${contextPath}/customer/reservationCheckForm.do">예약취소</a></button>
</body>
</html>