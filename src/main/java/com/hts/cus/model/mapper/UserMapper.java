package com.hts.cus.model.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.hts.cus.model.vo.CusMbVo;
import com.hts.cus.model.vo.CusParamVo;

/**
 * 회원 Mapper
 * @author youngsoo
 *
 */

@Mapper
public interface UserMapper {
	
	final String getByMbId= "select * from user where mb_id = #{cusParamVo.mbId}";
	
	/*  회원정보등록  */
	final String insert=" INSERT INTO hts.user " +
	                       " (mb_id, mb_nm, username, password, tlno1, tlno2, tlno3, br_id, del_yn, mdf_dthms, inp_dthms, mdf_id) " +
			               " VALUES( " +
	                       " #{cusMbVo.mbId} , "
			               + "#{cusMbVo.mbNm} , "
			               + "#{cusMbVo.username} , "
	                       + "#{cusMbVo.password} , "
	                       + "#{cusMbVo.tlno1} , "
	                       + "#{cusMbVo.tlno2} , "
	                       + "#{cusMbVo.tlno3} , "
	                       + "' ' , "
	                       + "'0' , "
	                       + "now()  , "
	                       + "now() , "
	                       + " 'S000000000' " +  ");";
	/*  회원ID 채번 */
     final String maxMbId = "select concat('M', lpad(cast( cm.mcnt as char ),9, '0' ) ) as mbId"
					     		+ "  from ("
					     		+ "select count(1) + 1 as mCnt"
					     		+ "  from user t1"
					     		+ " where t1.mb_id like 'M%' ) cm";
	
     /* 시큐리티 코딩의 이름을 e-mail로 쓰기위해서 alias 처리 */
//     final String getUserEmail = " select mb_email from cus_mb where mb_email = #{cusParamVo.mb.mbEmail}  ";
     final String getByMbEmail = "select * from user where username = #{cusParamVo.username}";
     
	/* 
	 * 회원정보조회
	 */
	@Select(getByMbId)
	@Results( id = "userMapper" , value = { 
		@Result( property="mbId", column="mb_id" ),
		@Result( property="username", column="username" ),
		@Result( property="password", column="password" ),
		@Result( property="role", column="role" ),
		@Result( property="tlno1", column="tlno1" ),
		@Result( property="tlno2", column="tlno2" ),
		@Result( property="tlno3", column="tlno3" ),
		@Result( property="brId", column="br_id" ),
		@Result( property="delYn", column="del_yn" ),
		@Result( property="mdfDthms", column="mdf_dthms" ),
		@Result( property="inpDthms", column="inp_dthms" ),
		@Result( property="mdfId" , column="mdf_id" )
		} )
	CusMbVo getByMbId( @Param("cusParamVo") CusParamVo cusParamVo );
	
	/*
	 * 회원정보등록
	 */
	@Insert(insert)
	@ResultMap("userMapper")
	int insert(@Param("cusMbVo") CusMbVo cusMbVo );
	
	/*
	 * 회원ID채번
	 */
	@Select( maxMbId )
   String getMakeMbId();
	
	/*
	 * 회원 email조회
	 */
	@Select( getByMbEmail )
	@ResultMap("userMapper")
	CusMbVo getByMbEmail( @Param("cusParamVo") CusParamVo cusParamVo );
}
