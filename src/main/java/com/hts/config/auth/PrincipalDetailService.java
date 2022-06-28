package com.hts.config.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hts.cus.model.mapper.UserMapper;
import com.hts.cus.model.vo.CusMbVo;
import com.hts.cus.model.vo.CusParamVo;
import com.hts.cus.sv.SvCusA001;

@Service // Bean등록
public class PrincipalDetailService implements UserDetailsService{

	 private static final Logger logger = LoggerFactory.getLogger(SvCusA001.class);
	
	@Autowired
	private UserMapper cusMbMapper;
	
	
	// 스피링이 로그인 요청을 가로챌때 , username , password 변수를 가로챔
	// password부분 처리는 알아서 함
	// 해당 유저name이 db에 있는지만 확인해주면 됨.
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		CusParamVo paramVo = new CusParamVo();
		
		logger.info("loadUserByUsername=[{}]", username);
		
		paramVo.setMbEmail(username);
		
		CusMbVo cusMbVo  = cusMbMapper.getByMbEmail(paramVo);
		
		if( cusMbVo == null )
		{
			logger.info("cusMbVo == null ");
			throw new UsernameNotFoundException("해당 사용자를 찾을수 없습니다." + username );
		}
		
		return new PrincipalDetail(cusMbVo); // 시큐리티 세션에 유저정보가 저장됨 
	}
	
	

}
