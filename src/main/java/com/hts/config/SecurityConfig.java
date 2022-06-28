package com.hts.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.hts.config.auth.PrincipalDetailService;


@Configuration        // 빈등록
@EnableWebSecurity // 시큐리티 필터 추가 , 스프링 시큐리티가 활성화가 되어 있는데 어떤 설정을 해당파일에서 하겠다.
/* @EnableGlobalMethodSecurity( prePostEnabled = true )  // 특정 주소로 접근을하면 권한 및 인증을 미리 체크 함. */
public class SecurityConfig extends WebSecurityConfigurerAdapter  {

	@Autowired
	private PrincipalDetailService principalDetialService; 
 
    @Bean // Ioc가 됨.
    public BCryptPasswordEncoder encodePWD() {
        return new BCryptPasswordEncoder();
    }
    
    // 시큐리티가 대신 로그인해주는데 뭘로 해쉬가 되어 회원가입이 되었는지 알아야 같은 해쉬로 
    // 암호화 해서 db에 있는 해쉬랑 비교할 수 있음.
    @Override
    protected void configure( AuthenticationManagerBuilder auth ) throws Exception{
    	auth.userDetailsService(principalDetialService).passwordEncoder(encodePWD());
    }
    
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	
        http .csrf().disable()  // csrf 토큰 비활성화
             .authorizeRequests().antMatchers("/","/auth/**","/images/**","/js/**","/css/**")
             .permitAll()
             .anyRequest()
             .authenticated()
          .and()
             .formLogin()
             .loginPage("/auth/loginForm")
             .loginProcessingUrl("/auth/loginProc") // 스피링 시큐리티가 해당 주소의 로그인을 가로채서 대신 로그인 한다.
             .defaultSuccessUrl("/") // 정상 인증 로그인을 수행후 리턴 할 주소
             
             ;
 

    }
    
	
}
