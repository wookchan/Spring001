package com.hanul.iot;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NoticeController  {
		
	//공지 글 목록화면 요청
	@RequestMapping("/list.no")
	public String list(HttpServletRequest session) {
		session.setAttribute("category", "no");
		return "notice/list";
	}
	

}
