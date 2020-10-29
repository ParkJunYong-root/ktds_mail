<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  request.setCharacterEncoding("UTF-8");
%> 
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />


<style>
	table,tr,td{
		border: solid 1px black;
		border-collapse: collapse;;
	}
	a{
		text-decoration: none;
	}
</style>
<body>
<table width="100%">
  <tr>
     <td>
		 <a href="${contextPath}/main.do">
		 <h3>주차 예약 시스템 홈페이지</h3>
		 </a>
</tr>
</table>   
