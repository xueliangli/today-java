package com.taotao.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 展示首页
 * @title PageController.java
 * <p>description</p>
 * <p>company: www.itheima.com</p>
 * @author ljh 
 * @version 1.0
 */
@Controller
public class PageController {
	/**
	 * 展示首页
	 */
	//接收URL的请求http://localhost:8082/index.html
	@RequestMapping("/index")
	public String showIndex(){
		return "index";    //响应jsp
	}
}
