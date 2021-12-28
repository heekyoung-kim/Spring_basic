package com.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	/*
	 * "http://localhost/home.do" URL요청이 오면 실행되는 요청핸들러 메소드다.
	 * 요청핸들러 메소드가 반환하는 문자열은 보통 뷰페이지(jsp 페이지)의 이름이다.
	 * 실제 home.jsp 페이지의 실제 경로는 /WEB-INF/jsp/home.jsp 이지만, home.jsp만 적어도 된다.
	 * 		context-web.xml에서
				<mvc:view-resolvers>
					<mvc:jsp prefix="/WEB-INF/jsp/"/>
				</mvc:view-resolvers>설정을 했기 때문.
	 */
	@RequestMapping(path = "/home.do")
	public String home() {
		return "home.jsp";
	}
}
