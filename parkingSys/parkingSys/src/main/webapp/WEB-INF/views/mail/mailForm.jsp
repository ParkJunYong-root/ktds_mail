<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
* 이메일 보내기 *
<form action="${contextPath}/sucess.do" method="post">
<table>
<tr>이메일 : <td><input type="email" name="receiver" placeholder="abc@abc.com"></td></tr><br>
글제목 : <input type="text" name="subject"><br>
글 내용 : <textarea rows="5" cols="30" name="content"></textarea>
<tr>
				<th>차량번호</th>
				<td><input type="text" name="carGum" placeholder="예) 00가 0000"></td>
			</tr>
</table>
<p>
<input type="submit" value="메일 보내기">
</form>
</body>
</html>