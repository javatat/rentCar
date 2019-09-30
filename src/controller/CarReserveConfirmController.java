package controller;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.CarConfirmBean;
import db.CarDAO;

/*
 CarReserveConfirm.jsp <예약확인> 페이지에서 렌트가 예약확인을 하는 서블릿
 */
@WebServlet("/CarReserveConfirmController.do")
public class CarReserveConfirmController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestpro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestpro(request, response);
	}
	
	private void requestpro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//CarReservationConfirm.jsp <예약확인> 페이지에서 사용자로부터 넘어온 전화번호와 비밀번호를 읽어들임
		String memberphone = request.getParameter("memberphone");
		String memberpass = request.getParameter("memberpass");
		
		//데이터베이스 객체 생성
		CarDAO cdao = new CarDAO();
		
		//예약확인을 위해 렌트예약시 입력했던
		//비회원 전화번호와, 페스워드를 전달
		//조건1) 전화번호와 비밀번호를 기준으로 하여 검색
		//조건2) 지금 날짜보다 이전 예약 현황은 보여주지 않는다
		//carconfirmbean 렌트 예약정보 객체를 담고 있는 벡터 객체 리턴
		Vector<CarConfirmBean> v = cdao.getAllCarOrder(memberphone,memberpass);
		
		//CarReserveResult.jsp로 데이터 넘기기
		request.setAttribute("v", v);
		RequestDispatcher dis = request.getRequestDispatcher("CarMain.jsp?center=CarReserveResult.jsp");
		dis.forward(request, response);
	}

}
