package com.hts.framework.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hts.framework.dto.ResponseDto;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler 
{
//	@ExceptionHandler( value= IllegalAccessException.class )
//     public String handleArgumentException( IllegalAccessException  e ) {
//    	 
//    	 return "<h1> " + e.getMessage() + "</h1>";
//     }
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	 public ResponseDto<String> handleArgumentException( Exception  e ) {
   	 
	// log.warn("handleException START "  );
		
   	 return new ResponseDto<String>( HttpStatus.INTERNAL_SERVER_ERROR.value() , e.getMessage() ) ;
    }
}
