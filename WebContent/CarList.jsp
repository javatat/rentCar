<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<img alt="" src="img/cis.jpg" border="0"> <!-- <차량정보 보기> 이미지 -->
		
		<table width="1000" border="0" height="470">
			<c:set var="j" value="0"/>
		
		<!-- CarListController서블릿에서 넘겨받아
			 request내장객체 영역안에 들어있는 벡터를 사이즈 만큼 반복 -->
		<c:forEach var="carlistbean" items="${requestScope.v}">
			<!-- 4열씩 자동차 이미지, 내용을 뿌려주기 위해 4번마다 tr을 열어준다 -->
			<c:if test="${j % 4 == 0 }">
				<tr align="center">
			</c:if>
				<td><!-- 선택한 차량 정보를 요청시 컨트롤러로 차량번호를 전달한다  -->
					<a href="CarInfoController.do?carno=${carlistbean.carno}">
						<img src="img/${carlistbean.carimg}" width="220" height="180">
					</a>
					<br>
					차량명 : ${carlistbean.carname}<br>
					대여금액 : ${carlistbean.carprice}<br>
				</td>
			<!-- j변수 값 1씩 증가 -->
			<c:set var="j" value="${j+1}"/>		
		</c:forEach>
		<!-- 소,중,대형 중 하나를 선택해 선택한 유형의 차량 검색을 요청! -->
		<form action="CarcategoryController.do" method="post">
			<tr height="70">
				<td colspan="4" align="center">
					차량검색:
					<select name="carcategory">
						<option value="Small">소형</option>
						<option value="Mid">중형</option>
						<option value="Big">대형</option>
					</select>
					&nbsp;&nbsp;&nbsp;
					<input type="submit" value="차량검색">
				</td>
			</tr>		
		</form>		
		</table>
			
	</center>

</body>
</html>