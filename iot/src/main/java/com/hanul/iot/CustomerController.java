package com.hanul.iot;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import customer.CustomerServiceImpl;
import customer.CustomerVO;

@Controller
public class CustomerController {
	//1번 또는
	@Autowired private CustomerServiceImpl service;
	//Autowried = 에노테이션 선언
	
	
	@RequestMapping("/delete.cu")
	public String delete(int id) {
		// 선택한 고객정보를 DB에서 삭제한 후
		// 응답할 화면 연결
		service.customer_delete(id);
		// 고객 목록화면으로 연결
		return "redirect:list.cu";
	}
	
	@RequestMapping("/update.cu")
	public String update(CustomerVO vo) {
		service.customer_update(vo);
		// 화면에서 수정 입력한 정보를 DB에 변경 저장한다
		// 응답할 화면을 연결한다
		return "redirect:detail.cu?id=" + vo.getId();
	}
	
	//고객정보수정화면 요청
	@RequestMapping("/modify.cu")
	public String modify(int id,Model model) {
		CustomerVO vo= service.customer_detail(id);
		model.addAttribute("vo",vo);
	
		return "customer/modify";
	}
	
	//신규고객저장처리 요청
	@RequestMapping("/insert.cu")
	public String insert(CustomerVO vo) {
		//화면에서 입력한 신규고객정보를 DB에 저장(비지니스로직)
		service.customer_insert(vo);
		
		//고객목록화면으로 연결
		return "redirect:list.cu";
	}
	
	
	
	@RequestMapping("/new.cu")
	public String newcustomer() {
		//신규 고객 입력화면
		return "customer/new";
	}
	
	
	// 두개이상일경우 '오브젝트'
	//@RequestParam은 생략해도됨, 전송시 값이 '하나'일경우 문자열
	// 고객 상세정보화면 요청
	@RequestMapping("/detail.cu")
	public String detail(@RequestParam int id,Model model) {
		//선택한 고객의 정보 DB에서 조회해와
		CustomerVO vo= service.customer_detail(id);
		//상세화면에 출력할 수 있도록 Model에 담는다
		model.addAttribute("vo",vo);
		//상세화면으로 연결함
		return "customer/detail";
		
	}
	
	
	//고객목록화면 요청
	@RequestMapping("/list.cu")
	public String list(Model model,HttpSession session) {
		//DB에서 고객목록을 조회해(비지니스로직)와 목록화면에 출력한다
		//응답할 화면 지정
		session.setAttribute("category", "cu");
		// 2번 
		// CustomerServiceImpl service = new CustomerServiceImpl();
		
		List<CustomerVO>list =  service.customer_list();
		model.addAttribute("list",list);
		return "customer/list";
	}
	
}
