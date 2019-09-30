package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.CarDAO;
import db.CarListBean;

/*하나의 차량 이미지를 클릭했을 때 클라이언트의 요청을 받는 서블릿*/
@WebServlet("/CarInfoController.do")
public class CarInfoController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestpro(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestpro(request, response);
	}
	
	private void requestpro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//CarList.jsp에서 사용자가 선택한 자동차 번호전달 받기
		int carno = Integer.parseInt(request.getParameter("carno"));
		
		//DB 불러오기
		CarDAO cdao = new CarDAO();
		
		//실제 DB에 접근하여 하나의 자동차 정보를 모두 읽어
		//하나의 컬럼정보를 저정해주는 빈 객체 리턴
		//자동차번호를 메소드의 매개변수로 전달!
		CarListBean bean = cdao.getOneCar(carno);
		
		request.setAttribute("bean", bean);
		
		//CarMain.jsp페이지로 이동하면서 request영역엦 ㅓㄴ달
		RequestDispatcher dis =
				request.getRequestDispatcher("CarMain.jsp?center=CarInfo.jsp");
		
		dis.forward(request, response);
		
	}

}
