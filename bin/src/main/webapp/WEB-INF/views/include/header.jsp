<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

   <header>
       <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
           <div class="container">
               <div class="collapse navbar-collapse justify-content-end">
                   <ul class="navbar-nav">
                       <c:if test="${ empty loginUser }">
	                       <li class="nav-item"><a href="/user/registerForm" class="nav-link bg-secondary text-dark mr-2 rounded"><i class="fa-solid fa-user before"></i> Sign Up</a></li>
	                       <li class="nav-item" id="btn_login"><button data-toggle="modal" data-target="#loginModal" class="nav-link btn btn-secondary bg-secondary text-dark mr-2 rounded"><i class="fa-solid fa-lock "></i> Login</button></li>
                       </c:if>
                       <c:if test="${ !empty loginUser }">
	                       <li class="nav-item" id="btn_logout"><a href="/user/logout" class="nav-link bg-secondary text-dark mr-2 rounded"><i class="fa-solid fa-lock"></i> Logout</a></li>
	                       <li class="nav-item"><a href="/user/info" class="nav-link bg-secondary text-dark mr-2 rounded"><i class="fa-solid fa-user "></i> 회원정보</a></li>
                   	   </c:if>
                   </ul>
               </div>
           </div>
       </nav>
       <nav class="navbar navbar-expand-sm bg-light sticky-top navbar-dark shadow">
           <div class="container">
               <a href="/" class="navbar-brand col-3">
                   <img src="/img/logo.jpg" alt="" class="col-9">
               </a>
               <div class="collapse navbar-collapse justify-content-end">
                   <ul class="navbar-nav">
                       <li class="nav-item"><a href="#" class="nav-link text-dark">공지 사항</a></li>
                       <li class="nav-item"><a href="#" class="nav-link text-dark">오늘의 뉴스</a></li>
                       <li class="nav-item"><a href="#" class="nav-link text-dark">주변 탐방</a></li>
                       <c:if test="${ !empty loginUser }">
	                       <li class="nav-item"><a href="#" class="nav-link text-dark">관심 지역 설정</a></li>
	                       <li class="nav-item"><a href="#" class="nav-link text-dark">관심 지역 둘러보기</a></li>
                       </c:if>
                       <li class="nav-item"><a href="#" class="nav-link text-dark"><i class="fa-solid fa-magnifying-glass"></i></a></li>
                   </ul>
               </div>
           </div>
       </nav>
   
       <div class="banner">
           <div class="container">
               <h2>HAPPY HOUSE</h2>
               <div class="banner_line"></div>
               <h3>행복한 우리 집</h3>
           </div>
       </div>
   </header>
   
   <!-- login Modal -->
	<div class="modal" id="loginModal">
	    <div class="modal-dialog">
	        <div class="modal-content">
	
	            <!-- Modal Header -->
	            <div class="modal-header">
	                <h4 class="modal-title">로그인</h4>
	                <button type="button" class="close" data-dismiss="modal">&times;</button>
	            </div>
	
	            <!-- Modal body -->
	            <div class="modal-body">
	                <form method="post" action="/user/login" >
	                    <div class="form-group">
	                        <label for="usr">ID:</label>
	                        <input type="text" class="form-control" id="loginID" name="id">
	                    </div>
	                    <div class="form-group">
	                        <label for="pwd">Password:</label>
	                        <input type="password" class="form-control" placeholder="Enter password" id="pwd" name="pw">
	                    </div>
	                 
	                    <div class="form-group form-check">
	                        <label class="form-check-label">
	                            <input class="form-check-input" type="checkbox"> Remember me
	                        </label>
	                    </div>
						<c:if test="${ !empty msg }">
							<div class="alert alert-danger">
								<strong>${ msg }</strong>
							</div>
						</c:if>
	                    <input type="submit" class="btn btn-primary" id="login_button" value="로그인">
	                    <button type="button" class="btn btn-primary" id="findPw"><a href="/login?action=findPw" class="text-white">비밀번호찾기</a></button>
	                 </form>
	            </div>
	
	            <!-- Modal footer -->
	            <div class="modal-footer">
	                <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
	            </div>
	        </div>
	    </div>
	</div>
<script>
	let msg="${msg}"
	if(msg){
		alert(msg);
	}
</script>