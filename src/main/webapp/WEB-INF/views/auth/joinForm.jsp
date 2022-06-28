<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>
<div class="container">
        <div class="form-group">
          <label for="email">Email:</label>
          <input type="email" class="form-control" placeholder="email" id="mbEmail"/>
        </div>
        <div class="form-group">
          <label for="email">회원명:</label>
          <input type="email" class="form-control" placeholder="name"  id="mbNm"/>
        </div>
        <div class="form-group">
          <label for="pwd">비밀번호:</label>
          <input type="password" class="form-control" placeholder="password" id="password"/>
        </div>
        <div class="form-group">
          <label for="pwd">비밀번호 확인: ( 비밀번호는 잊어 버리면 초기화 하셔야 합니다.)</label>
          <input type="password" class="form-control" placeholder="confirm password" id="password1"/>
        </div>
         <div class="input-group mb-3">
		    <div class="input-group-prepend">
		      <span class="input-group-text">휴대폰번호</span>
		    </div>
		    <input type="text" class="form-control"  id="tlno1" />
		    <input type="text" class="form-control"  id="tlno2" />
		    <input type="text" class="form-control"  id="tlno3" />
		  </div>
      <button id="btn-join" class="btn btn-primary">회원가입</button>
</div>
<script src="../js/user.js"></script>
<%@ include file="../layout/footer.jsp" %>

