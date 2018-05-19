package org.zerock.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.zerock.service.BoardServiceImpl;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board/*")
@Log4j
public class BoardController {

	@Setter(onMethod_= {@Autowired})
	private BoardServiceImpl service;
	
	@GetMapping("/register")
	public void registerGET() {
		
	}
	
	@PostMapping("/register")
	public ModelAndView registerPOST(HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("redirect:/board/register");

		service.insertFile(request);
		
		return mv;
	}
	
}
