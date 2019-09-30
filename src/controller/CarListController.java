package controller;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.CarDAO;
import db.CarListBean;

/**
 *** 전체 차량보기 버튼을 클릭했을 때 클라이언트의 요청을 받는 서블릿 클래스***
 */
@WebServlet("/CarListController.do")
public class CarListController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
										throws ServletException, IOException {
		requestpro(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
										throws ServletException, IOException {
		requestpro(request,response);
	}

	//어떤 방식으로 데이터가 넘어와도 requestpro메소드에서 처리됨
	private void requestpro(HttpServletRequest request, HttpServletResponse response)
										throws ServletException, IOException {
		/* DB에서 전체차량 검색*/
		//데이터 베이스에 접근해서 작업할 자바빈 역할을 하는 CarDAO객체 생성
		CarDAO cdao = new CarDAO();
		
		//실제 DB에 접근하여 자동차 정보를 모두 검색해서 얻기
		Vector<CarListBean> v = cdao.getAllCarlist();
		
		//전체차량을 검색한 정보가 벡터에 저장되어 있으므로
		//View페이지로 벡터를 전달하기 위해 request내장객체 영역에 저장
		request.setAttribute("v", v);
		
		//CarMain.jsp로 포워딩(재요청)시 request영역에 전달
		RequestDispatcher dis =
					request.getRequestDispatcher("CarMain.jsp?center=CarList.jsp");
		
		//실제 재요청
		dis.forward(request, response);
		
	}
}
