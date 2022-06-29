package com.hanul.iot;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.tiles.request.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import employee.DepartmentVO;
import employee.EmployeeServiceImpl;
import employee.EmployeeVO;
import employee.JobVO;

@Controller
public class EmployeeController {
	
	@Autowired private EmployeeServiceImpl service;
	
	//신규사원등록 처리 요청
	@RequestMapping("/insert.hr")
	public String insert(EmployeeVO vo) {
		//화면에서 입력한 사원정보를 DB에 저장한 후(비지니스로직)
		service.employee_insert(vo);
		//응답화면연결: 목록화면
		return "redirect:list.hr";
	}
	
	@RequestMapping("/new.hr")
	public String new_employee(Model model) {
		// 전체 부서 목록,전체 업무 목록, 전체 매니저 모음을 조회해와
		List<DepartmentVO> departments= service.department_list();
		List<JobVO> jobs= service.job_list();
		List<EmployeeVO> managers = service.employee_list("name");
		// 화면에 출력할 수 있또록 Model에 attribute로 데이터를 담아둔다
		model.addAttribute("departments",departments);
		model.addAttribute("jobs",jobs);
		model.addAttribute("managers",managers);
		// 응답화면 연결 : 신규사원 등록
		return "employee/new";
	}
	
	//사원정보 삭제 처리 요청
	@RequestMapping("/delete.hr")
	public String delete(int emp_id) {
		service.employee_delete(emp_id);
		// 선택한 사원정보를 DB에서 삭제한 후
		// 응답화면 연결
		return "redirect:list.hr";
	}
	
	@RequestMapping("/update.hr")
	public String update(EmployeeVO vo) {
		// 화면에서 수정 입력한 정보를 DB에 변경 저장 처리한 후
		// 응답할 화면 연결 : 상세 화면
		service.employee_update(vo);
		return "redirect:detail.hr?id="+vo.getEmployee_id();
	}
	
	@RequestMapping("/modify.hr")
	public String modify(int emp_id,Model model) {
		EmployeeVO vo = service.employee_detail(emp_id);
		//부서 목록 및 업무 목록을 조회 해와야함
		List<DepartmentVO> departments = service.department_list();
		List<JobVO> jobs =service.job_list();
		model.addAttribute("vo",vo);
		model.addAttribute("departments",departments);
		model.addAttribute("jobs",jobs);
		return "employee/modify";
	}

	// 사번의 사원 상세 정보화며 요청
	@RequestMapping("/detail.hr")
	public String detail(int id,Model model) {
		EmployeeVO vo = service.employee_detail(id);
		// DB에서 선택한 사원의 정보를 조회해와 
		// 상세 정보 화면에 출력할 수 있도록 model에 attribute로 데이터로 담는다
		model.addAttribute("vo",vo);
		// 응답 화면 연결
		return "employee/detail";
	}
	
	// 사원목록화면 요청
	@RequestMapping("/list.hr")							// int id 의 기본값을 -1로 지정한다
	public String list(HttpSession session,Model model,@RequestParam(defaultValue = "-1") int id) {
		// String param = Request.getParameter("id");
		// id=null id라는 파라미터가 존재하나 데이터값이 없을 시 ""
		session.setAttribute("category", "hr");
		// db에서 사원목록을 조회해서
		
		List<EmployeeVO> list = null;
		
		if(id == -1) {
			list = service.employee_list("employee_id");
		}
		else {
			list = service.employee_list(id);
		}
		// 사원목록화면에서 출력할 수 있도록
		List<DepartmentVO> departments = service.employee_department_list();
		// 부서목록 저장
		
		model.addAttribute("list", list);
		// Model 내에 attribute로 데이터를 담음
		model.addAttribute("departments",departments);
		model.addAttribute("id",id);
		return "employee/list";
	}
}
