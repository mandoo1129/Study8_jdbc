package com.iu.s1.start;

import java.util.List;

//import com.iu.s1.department.DepartmentDAO;
//import com.iu.s1.department.DepartmentDTO;
//import com.iu.s1.department.DepartmentView;
import com.iu.s1.location.LocationDAO;
import com.iu.s1.location.LocationDTO;
import com.iu.s1.location.LocationView;
import com.iu.s1.util.DBConnector;

public class StartMain {

	public static void main(String[] args) {
		System.out.println("DB 연동 테스트 시작");
		
		LocationDAO locationDAO = new LocationDAO();
		LocationView locationView = new LocationView();
		try {
			List<LocationDTO> ar = locationDAO.getList();
			locationView.view(ar);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
//		DepartmentDAO departmentDAO = new DepartmentDAO();
//		DepartmentView departmentView = new DepartmentView();
//		try {
//			List<DepartmentDTO> ar = departmentDAO.getList();
//			departmentView.view(ar);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		System.out.println("DB 연동 테스트 끝");
	}

}