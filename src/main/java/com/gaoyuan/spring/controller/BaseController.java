package com.gaoyuan.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/base")
@Controller
public class BaseController {

	@RequestMapping("/init")
	public ModelAndView init() {
		ModelAndView mView = new ModelAndView();
		
		mView.setViewName("hello");
		
		return mView;
	}
}
