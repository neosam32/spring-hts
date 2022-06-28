package com.hts.cus.model.vo;

import com.hts.framework.annotation.LocalName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 회원 Vo
 *
 * <pre>
 * 회원 Vo
 * </pre>
 * v0.1 YS 2022.06.25
 */

@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@LocalName("회원 Vo")
public class CusMbVo {
	
	@LocalName("회원ID")
	 private String mbId;
	
	@LocalName("username")
	 private String username;
	
	@LocalName("회원명")
	 private String mbNm;

	@LocalName("비밀번호암호화")
	 private String password;
	
	@LocalName("role")
	private String role;
	
	@LocalName("전화번호1")
	 private String tlno1;
	
	@LocalName("전화번호2")
	 private String tlno2;
	
	@LocalName("전화번호3")
	 private String tlno3;
	
	@LocalName("지점id")
	 private String brId;
	
	@LocalName("삭제여부")
	 private String delYn;
	
	@LocalName("수정일시")
	private String mdfDthms;
	
	@LocalName("입력일시")
	private String inpDthms;
	
	@LocalName("수정자ID")
	private String mdfId;
	
}
