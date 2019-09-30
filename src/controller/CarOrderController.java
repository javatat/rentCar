package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.CarDAO;
import db.CarOrderBean;

/**
 * Servlet implementation class CarOrderController
 */
@WebServlet("/CarOrderController.do")
public class CarOrderController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestpro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestpro(request, response);
	}

	private void requestpro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CarOrderBean cbean = new CarOrderBean();
		cbean.setCarno(Integer.parseInt(request.getParameter("carno")));
		cbean.setCarqty(Integer.parseInt(request.getParameter("carqty")));
		cbean.setCarreserveday(Integer.parseInt(request.getParameter("carreserveday")));
		cbean.setCarbegindate(request.getParameter("carbegindate"));
		cbean.setCarins(Integer.parseInt(request.getParameter("carins")));
		cbean.setCarwifi(Integer.parseInt(request.getParameter("carwifi")));
		cbean.setCarnave(Integer.parseInt(request.getParameter("carnave")));
		cbean.setCarbabyseat(Integer.parseInt(request.getParameter("carbabyseat")));
		cbean.setMemberphone(request.getParameter("memberphone"));
		cbean.setMemberpass(request.getParameter("memberpass"));
		
		//데이터베이스 객체 생성
		CarDAO cdao = new CarDAO();
		
		cdao.insertCarOrder(cbean);
		
		RequestDispatcher dis = request.getRequestDispatcher("CarListController.do");
		dis.forward(request, response);
		
	}
}
