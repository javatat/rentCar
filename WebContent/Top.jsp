<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">
		/*a태그의 하이퍼링크 밑줄 없애기 , 글자색 #333*/
		#login a{ text-decoration: none; color: #333}
		
		/*a태그에 마우스를 올렸을떄.. 글자색#F90*/
		#login a:HOVER {color: #F90}
	
		/*정렬 */
		#logo{
			float: left;
			width: 265px;
			margin: 60px 0 0 40px;
		}	
</style>

</head>
<body>
		<div id="logo">
			<!-- 메인 로고를 누르면 메인페이지로 이동 -->
			<a href="CarMain.jsp">
				<img src="img/RENT.jpg" width="300" height="80">
			</a>
		</div>
		
		<!-- 로그인 | 회원가입 링크 -->
		<table width="1000" height="5">
			<tr>
				<td align="right" colspan="5">
					<%
						//로그인 처리시 세션 영역값 이동 경로
						//login.jsp-> MemberFrontController.java->
						//CarMain.jsp-> Top.jsp
					
						//세션 id값 전달받기
						String id=(String)session.getAttribute("id");
						
						//세션id값 없음 -> 로그인 | 회원가입 링크 나타내기
						if(id==null){
					%>
						<div id="login">
							<a href="./MemberLogin.me">LOGIN</a> |
							<a href="./MemberJoin.me">JOIN</a>
						</div>
					<%
						}else{ //세션id값 있음 -> 로그아웃 링크 나타내기, 접속 표시
					%>	
						<div id="login">
							<%=id%>님 접속 중!
							<a href="./MemerLogout.me">LOGOUT</a>
						</div>>
					<%}
					%>
				</td>
			</tr>		
		</table>
		
		<!-- 메뉴 만들기 -->
		<table width="1000" background="img/aa.jsp" height="5">
			
			<tr>
				<td align="center" bgcolor="red">
					<a href="CarMain.jsp?center=CarReservation.jsp">
						<img src="img/bb.jpg"> <!-- 예약하기 -->
					</a>
				</td>
				<td align="center" bgcolor="red">
					<a href="CarMain.jsp?center=CarReserveConfirm.jsp">
						<img src="img/cc.jpg"> <!-- 예약 확인 -->
					</a>
				</td>
				<td align="center" bgcolor="red">
												<!-- 자유게시판 관련 컨트롤러 서블릿 요청 -->
					<a href="CarMain.jsp?center=BoardListController.do">
						<img src="img/dd.jpg"> <!-- 자유게시판 -->
					</a>
				</td>
				<td align="center" bgcolor="red">
					<a href="CarMain.jsp?center=CarEvent.jsp">
						<img src="img/even.jpg"> <!-- 이벤트 메뉴 -->
					</a>
				</td>
				<td align="center" bgcolor="red">
												<!-- 공지사항 관련 게시판 컨트롤러 요청 -->
					<a href="CarMain.jsp?center=AdminBoardListController.do">
						<img src="img/ee.jpg"> <!-- 고객센터 메뉴 -->
					</a>
				</td>
			</tr>
		
		
		</table>
</body>
</html>