package employee;

import java.sql.Date;

public class EmployeeVO {
	
	private int employee_id,department_id,salary,manager_id;
	private String last_name,first_name,name,department_name,job_id,job_title,email,phone_number,order;
	private Date hire_date;
	
	public EmployeeVO() {}
	

	public EmployeeVO(int manager_id,int employee_id, int department_id, int salary, String last_name, String first_name, String name,
			String department_name, String job_id, String job_title, String email, String phone_number,
			Date hire_date,String order) {
		super();
		this.order = order;
		this.manager_id = manager_id;
		this.employee_id = employee_id;
		this.department_id = department_id;
		this.salary = salary;
		this.last_name = last_name;
		this.first_name = first_name;
		this.name = name;
		this.department_name = department_name;
		this.job_id = job_id;
		this.job_title = job_title;
		this.email = email;
		this.phone_number = phone_number;
		this.hire_date = hire_date;
	}
	
	
	
	public int getManager_id() {
		return manager_id;
	}


	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}


	public String getOrder() {
		return order;
	}


	public void setOrder(String order) {
		this.order = order;
	}


	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public int getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	public String getJob_id() {
		return job_id;
	}

	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}

	public String getJob_title() {
		return job_title;
	}

	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}

	public Date getHire_date() {
		return hire_date;
	}

	public void setHire_date(Date hire_date) {
		this.hire_date = hire_date;
	}
	
	
	
	
}
