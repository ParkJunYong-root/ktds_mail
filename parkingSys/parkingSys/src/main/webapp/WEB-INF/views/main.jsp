<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"   isELIgnored="false"  %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<%
  request.setCharacterEncoding("UTF-8");
%>    

<body>
	<div>
<center>
		<button><a href="${contextPath}/customer/reservationForm.do">예약하기</a></button>
		l
		<button><a href="${contextPath}/customer/reservationCheckForm.do">예약조회</a></button>
</center>
	</div>
</body>
   