<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>
<div class="container">
    <form action="/auth/loginProc" method="post">
        <div class="form-group">
          <label for="email">Email:</label>
          <input type="email" class="form-control" placeholder="Enter email" id="username" name="username"  />
        </div>
        <div class="form-group">
          <label for="pwd">비밀번호:</label>
          <input type="password" class="form-control" placeholder="Enter password" id="password" name="password"   />
        </div>
        
        <button id="btn-save" class="btn btn-primary">로그인</button>
      </form>
</div>
<script src="../js/user.js"></script>
<%@ include file="../layout/footer.jsp" %>


