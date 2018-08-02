package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	@RequestMapping("/")
	public String gotoPage() {
		return "redirect:/login";
	}

	@RequestMapping("/login")
	public String gotoLoginPage() {
		return "jsp/login";
	}

	@RequestMapping("/index")
	public String gotoIndexPage() {
		return "redirect:/login";
	}
	
	@RequestMapping(value = "/adduser")
	public String gotoAddUserPage() {
		return "jsp/addUser";
	}
	
	
	
	// 第一种返回ModelAndView
	// //入门程序 第一 包类 + 类包 + 方法名
	@RequestMapping(value = "/login1")
	public ModelAndView itemList() {

		ModelAndView mav = new ModelAndView();
		// 数据
		mav.addObject("name", "ppppppppppppppppppppp");
		mav.setViewName("jsp/login");
		return mav;
	}

	// 第二中返回String
	// 入门程序 第一 包类 + 类包 + 方法名
	@RequestMapping(value = "/login2")
	public String itemListt() {
		return "jsp/home";
	}

	// 第二中返回void
	// 入门程序 第一 包类 + 类包 + 方法名
	@RequestMapping(value = "/login3")
	public void itemList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 从Mysql中查询
//		List<Items> list = itemService.selectItemsList();
		request.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(request, response);
	}
	
	
	
}
