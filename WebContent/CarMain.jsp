<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
	<%//센터 영역의 페이지명을 request내장객체 영역에서 얻어온다
	  //-> 센터영역은 사용자의 요청에 따라 화면이 계속 바뀌는 부분이기 때문에 해당 센터 영역의 페이지명을 받아온다
	  //=> String center = request.getParameter("center")%>

	<%-- JSTL태그 사용 --%>
	<%-- 센터 공간은 사용자로부터 상위의 메뉴를 클릭할 때 마다 계속해서 바뀌는 페이지이기 때문에
		 센터영역의 페이지명을 받아온다 --%>
	
	<c:set var="center" value="${param.center}"/>
	<c:out value="${center}"/>
	
	<%-- 처음 실행 했을 때 CarMain.jsp 페이지 설정 --%>
	<c:if test="${center == null}">
		<c:set var="center" value="Center.jsp"/>	
	</c:if>
	
	<center>
		<table width="1000" height="700">
			<tr align="center">
				<td>
					<jsp:include page="Top.jsp"/>
				</td>	
			</tr>
			<tr>
				<td height="500">
					<jsp:include page="${center}"/>
				</td>
			</tr>
			<tr>
				<td>
					<jsp:include page="Bottom.jsp"/>
				</td>
			</tr>
		</table>
	</center>




</body>
</html>