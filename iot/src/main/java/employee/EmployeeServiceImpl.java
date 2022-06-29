package employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired private EmployeeDAO dao;
	
	


	@Override
	public void employee_insert(EmployeeVO vo) {
		dao.employee_insert(vo);

	}
	
	@Override
	public List<EmployeeVO> employee_list() {
		return dao.employee_list();
	}
	

	@Override
	public EmployeeVO employee_detail(int id) {
		return dao.employee_detail(id);
	}

	@Override
	public void employee_update(EmployeeVO vo) {
		dao.employee_update(vo);

	}

	@Override
	public void employee_delete(int emp_id) {
			dao.employee_delete(emp_id);

	}
	
	@Override
	public List<DepartmentVO> employee_department_list() {
		return dao.employee_department_list();
	}

	@Override
	public List<DepartmentVO> department_list() {
		// TODO Auto-generated method stub
		return dao.department_list();
	}

	@Override
	public List<EmployeeVO> employee_list(int department_id) {
		return dao.employee_list(department_id);
	}

	@Override
	public List<JobVO> job_list() {
		return dao.job_list();
	}

	@Override
	public List<EmployeeVO> employee_list(String order) {
		// TODO Auto-generated method stub
		return dao.employee_list(order);
	}

}
