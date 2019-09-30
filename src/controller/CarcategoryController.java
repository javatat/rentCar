package controller;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import db.CarDAO;
import db.CarListBean;

/**
 *** 카테고리별 차 검색 ***
 */
@WebServlet("/CarcategoryController.do")
public class CarcategoryController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
												throws ServletException, IOException {
		requestPro(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
												throws ServletException, IOException {
		requestPro(request,response);
	}
	
	//doGet, doPost 방식으로 데이터가 넘어오면 requestPro메소드에서 처리
	private void requestPro (HttpServletRequest request, HttpServletResponse reponse)
												throws ServletException, IOException {

		//1. 소,중,대형 중 선택한 하나의 값 얻기
		String carcategory = request.getParameter("carcategory");
		
		//2. 자바빈의 종류인 CarDAO클래스의 객체를 생성하여 응답값을 마련
		CarDAO cdao = new CarDAO();
		//DB SELECT검색 작업
		Vector<CarListBean> v = cdao.getCategoryCarList(carcategory);
		
		//3.DB로부터 소,중,대형 중 선택한 하나의 값을 이용하여 검색한 CarListBean객체들의 정보들은
		//Vector에 저장되어 있으므로 응답결과물이 된다
		//이 응답결과물을 View로 전달하여 출력해주기 위해서는 request 내장객체 영역에 저장 후 전달해야 함
		request.setAttribute("v", v);
		
		//4.View페이지(JSP페이지)로 응답데이터를 전달하여 클라이언트의 웹브라우저로 응답
		RequestDispatcher dis = request.getRequestDispatcher("CarMain.jsp?center=CarList.jsp");
		
		//실제 재요청시 req, res 객체 전달
		dis.forward(request, reponse);		
	}

}
