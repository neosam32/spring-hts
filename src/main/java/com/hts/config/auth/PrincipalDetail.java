package com.hts.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.hts.cus.model.vo.CusMbVo;

import lombok.Getter;

// 스프링 시큐리티가 로그인 요청을 가로채서 로그인을 진행하고 완료가 되면 UserDetails 타입의 오브젝트를
// 스프링 시큐리티으 고유한 세션 저장소에 저장을 해준다.
// getter는 세션에서 나중에 user정보를 꺼내서 쓸때 사용한다.
@Getter
public class PrincipalDetail implements UserDetails {
	
	
	private CusMbVo user; // 콤포지션

	public PrincipalDetail (CusMbVo user )
	{
		this.user = user;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		// 실제 email로 로그인한다.
		return user.getUsername();
	}

	// 계정이 만료되지 않았는지를 리턴한다.( true : 만료안됨 )
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	// 계정이 잠겨있지 않았는지 리턴한다 ( true : 잠기지 않음 )
	@Override
	public boolean isAccountNonLocked() {

		return true;
	}
	
    // 비밀번호가 만료되지 않았는지 리턴한다. ( true : 만료되지 않음 )
	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}

	// 계정이 활성화인지 리턴한다. ( true : 활성화 )
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
	
	// 계정이 가지고 있는 권한 목록을 리턴한다.
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		Collection <GrantedAuthority> collocter = new ArrayList<>();
		
		// 람다식 표현
		collocter.add( ()->{
			return "ROLE_USER";
			}
		);
		
		return collocter;
	}

}
