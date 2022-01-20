package com.iu.s1.location;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.iu.s1.util.DBConnector;

public class LocationDAO {
	//DAO : Data Access Object
	private DBConnector dbConnector;
	
	public LocationDAO() {
		dbConnector = new DBConnector();
	}
	
	public List<LocationDTO> getList() throws Exception {
		ArrayList<LocationDTO> ar = new ArrayList<>();
		
		//SELECT * FROM DEPARTMENTS;
		//1. DB 로그인
		 Connection con = dbConnector.getConnect();
		 
		//2. SQL Query 문 작성 
		//   Java에서는 ; 제외
		 String sql = "SELECT * FROM DEPARTMENTS";
		 
		//3. 작성한 SQL Query 미리 전송
		 PreparedStatement st = con.prepareStatement(sql);
		
		//4. ? 값을 세팅, 없으면 통과 
		 
		//5. 최종 전송 후 결과 처리
		 ResultSet rs =  st.executeQuery();
		 
		 //cursor가 한줄 읽는 메서드 next() 리턴은 데이터가 있으면 true, 없으면 false
		 while(rs.next()) {
			 LocationDTO locationDTO = new LocationDTO();
			 //String name = rs.getString("department_name");//administration
			 //departmentDTO.setDepartment_name(name);
			 
			 locationDTO.setLocation_id(rs.getInt("location_id"));
			 locationDTO.setStreet_address(rs.getString("street_address"));
			 locationDTO.setPostal_code(rs.getString("postal_code") );
			 locationDTO.setCity(rs.getString("City"));
			 locationDTO.setState_province(rs.getString("State_province"));
			 locationDTO.setCountry_id(rs.getString("Country_id"));
			 
			 //arryList
			 ar.add(locationDTO);
			 
		 }
		 
		 //6. 외부 연결 해제
		 //   연결된 순서의 역순
		 rs.close();
		 st.close();
		 con.close();
		 
		 return ar;
	}

}