package com.hts.cus.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.hts.cus.model.vo.CusBrVo;
import com.hts.cus.model.vo.CusParamVo;

@Mapper
public interface CusMapper {

//	List<CusBrVo> getAll( CusParamVo cusParamVo );
	@Select(" select br_id , bsns_csfcd , zipcd from cus_br  ")
	@Results( id = "cusBrMapper" , value = { 
		@Result( property="brId", column="br_id" ),
		@Result( property="bsnsCsfcd", column="bsns_csfcd" ),
		@Result( property="zipcd", column="zipcd" )	} )
	List<CusBrVo> getAll( );
	
	@Select(" select br_id , bsns_csfcd , zipcd from cus_br where br_id =#{cusParamVo.brId} ")
	@ResultMap("cusBrMapper")
	CusBrVo getCusBrInfo(@Param("cusParamVo") CusParamVo cusParamVo );
	
}
