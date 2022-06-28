package com.hts.cus.ct.api;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hts.cus.model.vo.CusBrVo;
import com.hts.cus.model.vo.CusMbVo;
import com.hts.cus.model.vo.CusParamVo;
import com.hts.cus.sv.SvCusA001;
import com.hts.framework.dto.ResponseDto;

@RestController
@RequestMapping("/")
public class CusUserRestController  {
    
	private static final Logger logger = LoggerFactory.getLogger(CusUserRestController.class);


	
	@Autowired
	private SvCusA001 svCusA001;
	
	@PostMapping("/auth/joinProc")
	public ResponseDto<Integer> insertUser(@RequestBody CusMbVo cusMbVo ) throws Exception
	{
		// 회원등록하는 메소드 
		logger.error(" insertUser START");
		logger.error("cusMbVo=[{}]",cusMbVo);
		
		int rtnInt = 0;
		try {
			rtnInt = svCusA001.insertCusMb(cusMbVo);
		}catch( Exception e )
		{
			throw e;
		}
		
		return new ResponseDto<Integer>( HttpStatus.OK.value() ,rtnInt) ; // Jackson이 json으로 파싱해서 던짐.
	}
	
	
	
}
