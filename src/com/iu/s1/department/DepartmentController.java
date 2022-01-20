package com.iu.s1.department;

import java.util.List;
import java.util.Scanner;

public class DepartmentController {
	
	private DepartmentDAO departmentDAO;
	private DepartmentView departmentView;
	private Scanner sc;
	
	public DepartmentController() {
		
		departmentDAO = new DepartmentDAO();
		departmentView = new DepartmentView();
		sc = new Scanner(System.in);
		
	}
	
	public void start() throws Exception { //예외가 발생하면 호출한 쪽으로 던지겠다
		boolean flag = true;
		
		while(flag) { //flag가 true라면 무한반복
			System.out.println("1. 부서 리스트 출력");
			System.out.println("2. 부서 번호 검색");
			System.out.println("3. 나가기");
			int select = sc.nextInt();
			
			switch(select) {
			case 1:
				List<DepartmentDTO> ar = departmentDAO.getList();
				departmentView.view(ar);
				break;
			case 2:
				System.out.println("검색할 부서 번호를 입력");
				DepartmentDTO departmentDTO = new DepartmentDTO();
				departmentDTO.setDepartment_id(sc.nextInt());
				departmentDTO = departmentDAO.getOne(departmentDTO);
				break;
			default:
				flag = false;
			}
			
			
		}
		
		
		
	}
}
