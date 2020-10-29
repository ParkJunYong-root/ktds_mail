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
<title>주차 예약</title>
<script type="text/javascript">
	function formCheck(){
		var reservation = document.reservation;
		var carNum = reservation.carNum.value;
		var cellNum = reservation.cellNum.value;
		var pwd = reservation.pwd.value;
		var name = reservation.name.value;
		var email = reservation.email.value;
		var pw = reservation.pw.value;
		if(reservation.park.value==""){
			alert("주차장을 선택해주세요.");
			reservation.park.focus();
			return false;
		}else if(reservation.entryDate.value==""){
			alert("입차 일시를 선택해주세요");
			reservation.entryDate.focus();
			return false;
		}else if(reservation.exitDate.value==""){
			alert("출차 일시를 선택해주세요");
			reservation.exitDate.focus();
			return false;
		}else if(reservation.carType.value==""){
			alert("차량 종류를 선택해주세요.");
			reservation.exitDate.focus();
			return false;
		}else if(carNum.length ==0 || carNum==""){
			alert("차량 번호를 입력해주세요.");
			return false;
		}else if(cellNum.length ==0 || cellNum==""){
			alert("핸드폰 번호를 입력해주세요.");
			return false;
		}else if(email.length ==0 || email==""){
			alert("이메일을 입력해주세요.");
			return false;
		}else if(pwd.length == 0 || pwd ==""){
			alert("비밀번호를 입력해주세요.");
			return false;
		}else if(pwd != pw){
			alert("비밀번호가 다릅니다.");
			return false;
		}
		return true;
	}
	
</script>
</head>
<body>
	<form name="reservation"  method="post"  action="${contextPath}/customer/addCustomer.do" onsubmit="return formCheck();">
		<table align=center>
		<center>
			<h3>예약 신청</h3>
		</center>
			<tr>
			<th>주차장 선택</th>
			<td>
			<select name="park">
				<option value="">주차장 선택</option>
				<option value="1주차장">1주차장</option>
				<option value="2주차장">2주차장</option>
				<option value="3주차장">3주차장</option>
			</select>
			</td>
			</tr>
			<tr>
				<th>예약 입차 일시</th>
				<td>
					<input type = "datetime-local"  name="entryDate"  >
				</td>
			</tr>
			<tr>
				<th>예약 출차 일시</th>
				<td>
					<input type = "datetime-local"  name="exitDate"  >
				</td>
			</tr>
			<tr>
				<th>차량 종류</th>
				<td>
				<select name="carType">
				<option value="">차량 선택</option>
				<option value="일반">일반</option>
				<option value="장애인">장애인</option>
				</select>
				</td>
			</tr>
			<tr>
				<th>차량번호</th>
				<td><input type="text"  name="carNum"  placeholder="예) 00가 0000"></td>
			</tr>
			<tr>
				<th>핸드폰 번호</th>
				<td>
					<input type="text"  name="cellNum"  placeholder="예)000-0000-0000">
				</td>
			</tr>
			<tr>
				<th>이메일 주소</th>
				<td>
				<input type="text"  name="email"  placeholder="예)email@email.com">
				</td>	
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>
				<input type="password"  name="pwd"  placeholder="예)4자리(숫자, 문자 가능)" id="pwd1" class="form-control" />
				</td>
			</tr>
			<tr>
				<th>비밀번호 확인</th>
				<td>
				<input type="password" name="pw" placeholder="예)4자리(숫자, 문자 가능)" id="pwd2" class="form-control" />
				<td>
			</tr>
		</table>
			<center>
				<input type="submit" value="예약하기" >
				<input type="reset" value="다시입력">
			</center>
	</form>
	
</body>
</html>