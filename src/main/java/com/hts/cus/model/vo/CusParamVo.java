package com.hts.cus.model.vo;

import com.hts.framework.annotation.LocalName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 고객Param Vo
 *
 * <pre>
 * 고객Param Vo
 * </pre>
 * v0.1 YS 2022.06.24
 */

@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@LocalName("고객Param Vo")
public class CusParamVo {
	
    @LocalName("지점Id")
    private String brId;
    
    @LocalName("회원Id")
    private String mbId;
    
    @LocalName("회원email")
    private String mbEmail;
    
    @LocalName("요청분류")
    private String reqCsf;

}
