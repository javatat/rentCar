package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class CarDAO {

	//필수 세가지
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	//커넥션풀을 얻고 커넥션풀로부터 커넥션 객체를 얻는 메소드
	public void getCon(){
		try{
			//1.WAS서버와 읽어들일 CarProject의 모든 정보를 지니고 있는 컨텍스트 객체 생성
			Context init = new InitialContext();
			
			//2.커넥션풀 얻기
			DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/jspbeginner");
			
			//3.커넥션풀로부터 커넥션 객체 얻기
			con = ds.getConnection();
		
		}catch (Exception err){
			err.printStackTrace();
		}
	}//getCon()==
	
	/* DB에 존재하는 전체차량 검색을 위한 메소드 */
	public Vector<CarListBean> getAllCarlist(){
		Vector<CarListBean> v = new Vector<CarListBean>();
		
		//검색한 한 개의 차 정보를 저장할 용도의 CarListBean객체를 저장할 변수 선언
		CarListBean bean = null;
		
		try{
			//커넥션풀로부터 커넥션 얻기(DB접속)
			getCon();
			
			//전체차량을 검색할 SQL문
			String sql = "select * from carlist";
			//SQL문을 실행할 pstmt객체 얻기
			pstmt = con.prepareStatement(sql);
			
			//SQL문(select)을 실행한 후 검색한 정보 얻기
			rs = pstmt.executeQuery();
			
			//while문을 이용하여 각각의 CarListBean객체에 검색한 차량정보를 저장
			while (rs.next()){
				bean = new CarListBean();
				bean.setCarno(rs.getInt(1)); //차번호 담기
				bean.setCarname(rs.getString(2));//차량명 담기
				bean.setCarcompany(rs.getString(3));//차제조사
				bean.setCarprice(rs.getInt(4));//차 한대당 가격 담기
				bean.setCarusepeople(rs.getInt(5));//차인승 정보 담기
				bean.setCarinfo(rs.getString(6));//차정보 담기
				bean.setCarimg(rs.getString(7));//차이미지명 담기
				bean.setCarcategory(rs.getString(8));//차유형(소형,중형,대형)중 하나 담기 
				
				//벡터에 CarListBean 추가
				v.add(bean);
			}
			
				//Connection객체 종료
				con.close();
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
		return v;
	}

	/* 카테고리별 자동차레코드 데이터 검색 */
	public Vector<CarListBean> getCategoryCarList(String carcategory) {
		
		//리턴할 Vector객체를 선언
		Vector<CarListBean> v = new Vector<CarListBean>();
		
		//하나의 레코드를 저장할 객체 선언
		CarListBean bean = null;
		
		try{
			//커넥션 메소드를 호출하여 DB연결 객체 얻기
			getCon(); //DB연결
			
			String sql = "select * from carlist where carcategory=?";
			
			//쿼리 실행
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, carcategory);
			
			//쿼리 실행 후 결과 리턴
			rs = pstmt.executeQuery();
			
			//빈클래스에 컬럼데이터 저장
			while(rs.next()){
				bean = new CarListBean();
				bean.setCarno(rs.getInt(1));
				bean.setCarname(rs.getString(2));
				bean.setCarcompany(rs.getString(3));
				bean.setCarprice(rs.getInt(4));
				bean.setCarusepeople(rs.getInt(5));
				bean.setCarinfo(rs.getString(6));
				bean.setCarimg(rs.getString(7));
				bean.setCarcategory(rs.getString(8));
				
				// 다 저장된 빈객체를 백터에 저장
				v.add(bean);
			}
			
			con.close();
		}catch (Exception e){
			e.printStackTrace();
		}
		return v;
		
	}//getCategoryCarList()==

	public CarListBean getOneCar(int carno) {
		//리턴할 하나의 레코드를 저장할 객체
		CarListBean bean = null;
		
		try{
			//DB연결
			getCon();
			
			String sql = "select * from carlist where carno=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, carno);
			
			//결과 리턴
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				bean = new CarListBean();
				bean.setCarno(rs.getInt(1));
				bean.setCarname(rs.getString(2));
				bean.setCarcompany(rs.getString(3));
				bean.setCarprice(rs.getInt(4));
				bean.setCarusepeople(rs.getInt(5));
				bean.setCarinfo(rs.getString(6));
				bean.setCarimg(rs.getString(7));
				bean.setCarcategory(rs.getString(8));
			}
			con.close();
			
		}catch (Exception e){
			e.printStackTrace();
		}
		return bean;
	
	}//getOneCar()==

	public void insertCarOrder(CarOrderBean cbean) {
		try{
			//DB연결
			getCon();
			
			String sql = "insert into carorder(carno, carqty, carreserveday,"
					+"carbegindate,carins,carwifi,carnave,carbabyseat,memberphone,memberpass)"
					+"values(?,?,?,?,?,?,?,?,?,?)";
			//쿼리 실행 객체 선언
			pstmt = con.prepareStatement(sql);
			
			//?에 값 대입
			pstmt.setInt(1, cbean.getCarno());
			pstmt.setInt(2, cbean.getCarqty());
			pstmt.setInt(3, cbean.getCarreserveday());
			pstmt.setString(4, cbean.getCarbegindate());
			pstmt.setInt(5, cbean.getCarins());
			pstmt.setInt(6, cbean.getCarwifi());
			pstmt.setInt(7, cbean.getCarnave());
			pstmt.setInt(8, cbean.getCarbabyseat());
			pstmt.setString(9, cbean.getMemberphone());
			pstmt.setString(10, cbean.getMemberpass());
			
			pstmt.executeUpdate();
			
			con.close();
		}catch (Exception e){
			e.printStackTrace();
		}
		
	}//insertCarOrder()==

	public Vector<CarConfirmBean> getAllCarOrder(String memberphone, String memberpass) {
		
		Vector<CarConfirmBean> v = new Vector<CarConfirmBean>();
		//DB에서 검색한 렌트예약 정보 객체(CarConfirmBean객체)를 저장할 참조변수 선언 
		CarConfirmBean bean = null;
		
		try{
			getCon();
			
			//예약한 날짜가 현재날짜 보다 크고
			//렌트예약시 작성한 비회원 전화번호와 패스워드에 해당하는 렌트 예약정보를 검색
			//carorder테이블과 carorder테이블을 natural 조인하여 검색
			
			//String타입을 Date타입으로 변경함
			String sql = "select * from carorder natural join carlist "
					+ "where now()<str_to_date(carbegindate, '%Y-%m-%d') and memberphone=? and memberpass=?";
			
			//SELECT문에 별도의 컬럼순서를 지정하지 않으면
			//NATURAL JOIN의 기준이 되는 컬럼들이 다른 컬럼보다 먼저 출력된다
			//이때 JOIN에서 사용된 같은 이름의 컬럼을 중복출력하지 않고 하나로 출력된다
			
			//?를 제외한 SELECT구문을 담은 쿼리실행 객체 반환
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberphone);
			pstmt.setString(2, memberpass);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				bean = new CarConfirmBean();
				bean.setOrderid(rs.getInt(2));
				bean.setCarqty(rs.getInt(3));
				bean.setCarreserveday(rs.getInt(4));
				bean.setCarbegindate(rs.getString(5));
				bean.setCarins(rs.getInt(6));
				bean.setCarwifi(rs.getInt(7));
				bean.setCarnave(rs.getInt(8)); 
				bean.setCarbabyseat(rs.getInt(9));
				bean.setCarname(rs.getString(12));
				bean.setCarprice(rs.getInt(14));
				bean.setCarimg(rs.getString(17));
				v.add(bean);//백터에 담기
			}
			con.close();
			
		}catch(Exception e){
			System.out.println("getAllCarOrder() 오류" + e);
		}
		
		return v;
	}

	public CarConfirmBean getOneOrder(int orderid) {
		//리턴타입 선언
		CarConfirmBean cbean = null;
		try{
			getCon();
			
			String sql = "select * from carorder where orderid=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, orderid);
			
			//결과 리턴
			rs = pstmt.executeQuery();
			if(rs.next()){
				cbean = new CarConfirmBean();
				cbean.setOrderid(orderid);
				cbean.setCarbegindate(rs.getString(5));
				cbean.setCarreserveday(rs.getInt(4));
				cbean.setCarins(rs.getInt(6));
				cbean.setCarwifi(rs.getInt(7));
				cbean.setCarnave(rs.getInt(8));
				cbean.setCarbabyseat(rs.getInt(9));
			}
			
			con.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		return cbean;	
	}//getOneOrder()==
	
	
	
	
}
