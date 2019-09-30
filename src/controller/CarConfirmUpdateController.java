package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.CarConfirmBean;
import db.CarDAO;

/**
 * Servlet implementation class CarConfirmUpdateController
 */
@WebServlet("/CarConfirmUpdateController.do")
public class CarConfirmUpdateController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestdo(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestdo(request,response);
	}
	
	private void requestdo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String carimg = request.getParameter("carimg");
		int orderid = Integer.parseInt(request.getParameter("orderid"));
		
		CarDAO cdao = new CarDAO();
		
		//렌트예약한 id를 전달하여 하나의 주문정보를 얻어오는 메소드 호출
		CarConfirmBean cbean = cdao.getOneOrder(orderid);
		
		cbean.setCarimg(carimg);
		
		//차량주문정보 수정 페이지로 전달
		request.setAttribute("cbean", cbean);
		
		//view로 전달
		RequestDispatcher dis = 
				request.getRequestDispatcher("CarMain.jsp?center=CarConfirmUpdate.jsp");
		// 데이터를 넘겨 주시오
		dis.forward(request, response);	
	}

}
