<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<center>
	<%-- <결제하기> 이미지  --%>
	<img alt="" src="img/haki.jpg" border="0">
	
	<%--결제하기 버튼 눌렀을때 렌트정보들 전달 --%> 
	<form action="CarOrderController.do" method="post">
	 <p>
	 	<font size="13" color="blue">차량 렌트 비용 : ￦${requestScope.totalreserve }원</font>
	 </p>
	 <p>
	 	<font size="13" color="blue">차량 옵션 비용 : ￦${requestScope.totaloption }원</font>
	 </p>
	 <p>
	 	<font size="13" color="blue">총 비용 : ￦${totalreserve + totaloption }원</font>
	 </p>
	  <%--실제 예약 정보를 CarOrderController 로 넘겨줌 --%>
	  <input type="hidden" name="carno" value="${requestScope.cbean.carno}">
	  <input type="hidden" name="carqty" value="${requestScope.cbean.carqty}">
	  <input type="hidden" name="carreserveday" value="${requestScope.cbean.carreserveday}">
	  <input type="hidden" name="carins" value="${requestScope.cbean.carins}">
	  <input type="hidden" name="carwifi" value="${requestScope.cbean.carwifi}">
	  <input type="hidden" name="carnave" value="${requestScope.cbean.carnave}">
	  <input type="hidden" name="carbabyseat" value="${requestScope.cbean.carbabyseat}">
	  <input type="hidden" name="carbegindate" value="${requestScope.cbean.carbegindate}">
	 <p>
	  비회원 전화번호 예약 :
	  <input type="text" name="memberphone" size="10">&nbsp;&nbsp;&nbsp;
	  비밀번호:
	  <input type="password" name="memberpass" size="10">
	  <input type="submit" value="결제하기"> 
	 </p> 	  
	</form>	
</center>
</body>
</html>