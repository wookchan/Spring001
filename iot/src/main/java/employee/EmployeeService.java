package employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;



public interface EmployeeService {
	
	//LIST = 다건 메소드(단건)

	//CRUD(Create Read Update Delete)
	// 신규 사원 등록
	void employee_insert(EmployeeVO vo);
	
	// 사원 목록 조회
	List<EmployeeVO> employee_list();
	
	//사원의 목록 조회
	List<EmployeeVO> employee_list(int department_id);
	
	//정렬(order by)한 사원목록조회(전체)
	List<EmployeeVO> employee_list(String order);
	
	// 사원 정보 상세 조회
	EmployeeVO employee_detail(int id);
	
	// 사원 정보 저장(변경)
	void employee_update(EmployeeVO vo);
	
	// 사원의 정보 삭제
	void employee_delete(int id);
	
	// 부서 목록 조회(조회시 employees의 department_id를 조회)
	List<DepartmentVO> department_list();
	
	// 조회 후 사원의 부서 이동을위한 모든 부서조회(department_name 조회)
	List<DepartmentVO> employee_department_list();
	
	//회사 전체 업무목록 조회
	List<JobVO> job_list();

	
}
