/**
 * 사용자 관리 
*/
 
 let index = {

	init: function(){
		$("#btn-join").on("click",()=>{
			this.userJoin();
		});
	},
	
	/* 회원가입 */
	userJoin : function(){
		
		let data = {
			
			mbNm : $("#mbNm").val(),
			mbEmail : $("#mbEmail").val(),
			password : $("#password").val(),
			tlno1 : $("#tlno1").val(),
			tlno2 : $("#tlno2").val(),
			tlno3 : $("#tlno3").val()
		};
		
		// alert( data.password + ":" + $("#password1").val()  );
		
		if( data.password != $("#password1").val() )
		{
			alert("비밀번호가 다릅니다.");
			$("#password").val("");
			$("#password1").val("");
			return false;
		}
		
		// return false;
		
		//alert(data.);
	    // ajax 요청시 기본이 비동기 호출
	    $.ajax( {
		   // 회원조회 수행 요청 실행 성공 done / 실패 fail
		   type : "POST",
		   url: "/auth/joinProc",
		   data: JSON.stringify(data ),  // http body data
		   contentType : "application/json; charset=utf-8" , // body 데이터가 어떤 타입인지 (MIME)
		   dataType : "json" // 요청을 서버로 해서 응답이 왔을때 기보넞긍로 모든것이 문자열 ( 생긴게 json ) ==> javascript object 
		    
	    } ).done( function( resp ){
		
		   alert("회원가입이 완료되었습니다.");
		   console.log( resp );
		   location.href = "/"
		
	    } ).fail( function(error){
		   alert(JSON.stringify(error.responseText));
		
	    } ); // ajax 통신을 이용해서 파라미터를 데이틀 json으로 변경하여 회원조회 요청
	},
	
}

index.init();
