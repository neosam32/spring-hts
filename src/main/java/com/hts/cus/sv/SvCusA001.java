package com.hts.cus.sv;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hts.cus.model.mapper.CusMapper;
import com.hts.cus.model.mapper.UserMapper;
import com.hts.cus.model.vo.CusBrVo;
import com.hts.cus.model.vo.CusMbVo;
import com.hts.cus.model.vo.CusParamVo;

/**
 * 고객관리
 * @author youngsoo
 *
 */
@Service("SvCusA001")
public class SvCusA001  {

	    private static final Logger logger = LoggerFactory.getLogger(SvCusA001.class);

	    /* 고객기본
	     *
	     */
		
		@Autowired
		private CusMapper cusMapper;
		
		@Autowired
		private UserMapper cusMbMapper; 

		
		@Autowired
		private BCryptPasswordEncoder encoder;
		
		/* 회원가입 */
		@Transactional
		public int insertCusMb( CusMbVo cusMbVo  )  throws Exception 
		{
		
			String rawPassword = cusMbVo.getPassword();
			String encPw = encoder.encode(rawPassword);
			
			cusMbVo.setPassword( encPw );
			
			cusMbVo.setMbId( cusMbMapper.getMakeMbId() );
			int rstInt = 0;
			logger.debug("insertCusMb = [{}]",cusMbVo.getMbId() );
			try {
				rstInt = cusMbMapper.insert(cusMbVo);
			}catch( Exception e )
			{
				throw new Exception("중복된 이메일 입니다.");
			}
			
			return rstInt;
		}
		
		
		public List< CusBrVo > getAll ()
	    {
	    	logger.info(" SvCusA001 START");
	    	List< CusBrVo > cuBrList = cusMapper.getAll();
	    	// CusBrVo rtn = new CusBrVo();
	    	return cuBrList;
	    }
		
		/* 지점 Id 로 지점 정보 조회 */
		public CusBrVo getCusBrInfo( CusParamVo cusParamVo ) 
		{
			logger.info(" getCusBrInfo START");
			
			CusBrVo cusBrVo = cusMapper.getCusBrInfo( cusParamVo );
			if(  cusBrVo == null )
			{
				throw new RuntimeException("해당 지점이 없습니다." );
			}
			return cusBrVo;
			
		}
		
		public String getMakeMbId()
		{
			logger.info(" getCusBrInfo START");
			return cusMbMapper.getMakeMbId();
		}
	    
}
