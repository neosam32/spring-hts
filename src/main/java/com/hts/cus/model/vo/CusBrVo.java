package com.hts.cus.model.vo;

import com.hts.framework.annotation.LocalName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


/**
 * 지점 Vo"
 *
 * <pre>
 * 지점 Vo"
 * </pre>
 * v0.1 YS 2022.06.25
 */

@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@LocalName("지점 Vo")
public class CusBrVo {
	   @LocalName("지점Id")
	    private String brId;

	   @LocalName("업무분류코드")
	    private String bsnsCsfcd;

	   @LocalName("우편번호")
	    private String zipcd;
}
