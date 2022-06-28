package com.hts.cus.ct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.hts.cus.sv.SvCusA001;

// 인증이 안된 사용자들이 출입할 수 있는 경로 /auth 로 설정
// 주소가 / 허용 
// static 이하에 있는 

@Controller
public class CusUserController {
	
	
	private static final Logger logger = LoggerFactory.getLogger(CusUserController.class);
	
	//@AuthenticationPrincipal PrincipalDetail principal
	
	@GetMapping({"","/"})
	public String index() {
		// 시큐리티 리턴후 세션은 어떻게 찾지?
		logger.error("index START" );
		// /WEB-INF/views/index.jsp
		return "index";
	}
	
	
	@GetMapping({"/auth/loginForm"})
	public String loginForm() {
		
		logger.error("joinForm START" );
		
		return "auth/loginForm";
		
	}
	
	@GetMapping({"/auth/joinForm"})
	public String joinForm() {
		
		logger.error("joinForm START" );
		
		return "auth/joinForm";
		
	}
	

}
