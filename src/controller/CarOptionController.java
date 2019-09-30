package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.CarOrderBean;

/**
 * Servlet implementation class CarOptionController
 */
@WebServlet("/CarOptionController.do")
public class CarOptionController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestpro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestpro(request, response);
	}

	private void requestpro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//CarOption.jsp에서 전달한 금액 연산을 위하여 데이터를 받아야함
		int carqty = Integer.parseInt(request.getParameter("carqty"));
		int carprice = Integer.parseInt(request.getParameter("carprice"));//대여금액 받기
		int carreserveday = Integer.parseInt(request.getParameter("carreserveday"));//대여날짜 받기
		//적용=1 , 미적용=0
		int carins = Integer.parseInt(request.getParameter("carins"));
		int carwifi = Integer.parseInt(request.getParameter("carwifi"));
		int carnave = Integer.parseInt(request.getParameter("carnave"));       
		int carbabyseat = Integer.parseInt(request.getParameter("carbabyseat"));
		
		//차량가액 = 수량 * 대여기간 * 차량가격
		int totalreserve = carqty * carreserveday * carprice;
		//옵션금액 = 각종 옵션에 대여기간과 수량을 곱해서 리턴
		int totaloption =
				((carins * carreserveday) + (carwifi * carreserveday) + (carbabyseat*carreserveday)) * 10000 * carqty;
	
		//CarOrder.jsp쪽으로 데이터를 넘겨주어야함
		//데이터를 담을 자바빈클래스를 만들기
		
		CarOrderBean cbean = new CarOrderBean();
		cbean.setCarno(Integer.parseInt(request.getParameter("carno")));
		cbean.setCarqty(carqty);
		cbean.setCarreserveday(carreserveday);
		cbean.setCarins(carins);
		cbean.setCarnave(carnave);
		cbean.setCarbabyseat(carbabyseat);
		cbean.setCarbegindate(request.getParameter("carbegindate"));
		
		//CarOrder.jsp로 데이터를 넘기기 위해 request영역에 저장하기
		request.setAttribute("cbean", cbean);
		request.setAttribute("totalreserve", totalreserve);
		request.setAttribute("totaloption", totaloption);
		
		//실제 CarOrder.jsp로 이동
		//request영역 전달
		RequestDispatcher dis = request.getRequestDispatcher("CarMain.jsp?center=CarOrder.jsp");
		dis.forward(request, response);
	}
	
	
	
	
	
	
	
	
	
}
