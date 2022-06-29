package employee;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAO implements EmployeeService{
	

	@Autowired @Qualifier("hr") private SqlSession sql;

	@Override
	public void employee_insert(EmployeeVO vo) {
		sql.insert("employee.mapper.insert", vo);
	}
	
	@Override
	public List<EmployeeVO> employee_list() {
		return sql.selectList("employee.mapper.list");
	}
	
	@Override
	public EmployeeVO employee_detail(int id) {
		return sql.selectOne("employee.mapper.detail",id);
	}
	
	@Override
	public void employee_update(EmployeeVO vo) {
		sql.update("employee.mapper.update",vo);
		
	}
	
	@Override
	public void employee_delete(int emp_id) {
		sql.delete("employee.mapper.delete",emp_id);
		
	}
	
	// 특정 부서에 소속된 사원 목록 조회
	@Override
	public List<EmployeeVO> employee_list(int department_id) {
		return sql.selectList("employee.mapper.department_list",department_id);
	}
	
	@Override
	public List<DepartmentVO> department_list() {
		return sql.selectList("employee.mapper.departments");
	}

	@Override
	public List<DepartmentVO> employee_department_list() {
		return sql.selectList("employee.mapper.employee_departments");
	}

	@Override
	public List<JobVO> job_list() {
		return sql.selectList("employee.mapper.jobs");
	}

	@Override
	public List<EmployeeVO> employee_list(String order) {
		return sql.selectList("employee.mapper.list",order);
	}
	


	
}
